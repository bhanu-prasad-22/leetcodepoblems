import java.io.*;
import java.util.*;

public class StudentApi {
    private final StudentService service;

    public StudentApi(StudentService service) {
        this.service = service;
    }

    // Process a single command line and return a JSON-ish string response
    public String process(String line) {
        if (line == null || line.isBlank()) return "{}";
        String[] parts = line.trim().split(" ", 2);
        String cmd = parts[0].trim().toUpperCase();
        String arg = parts.length > 1 ? parts[1].trim() : "";

        try {
            switch (cmd) {
                case "ADD": {
                    // format: ADD id|name|age
                    String[] f = arg.split("\\|", 3);
                    if (f.length < 3) return "{\"error\":\"bad_add_format\"}";
                    int id = Integer.parseInt(f[0].trim());
                    String name = f[1].trim();
                    int age = Integer.parseInt(f[2].trim());
                    if (service.searchStudent(id) != null) {
                        return "{\"status\":\"error\",\"reason\":\"id_exists\",\"id\":" + id + "}";
                    }
                    service.addStudent(new Student(id, name, age));
                    return "{\"status\":\"ok\",\"cmd\":\"ADD\",\"id\":" + id + "}";
                }
                case "GET_ALL": {
                    List<Student> all = service.getAllStudents();
                    return toJsonArray(all);
                }
                case "GET": {
                    int id = Integer.parseInt(arg);
                    Student s = service.searchStudent(id);
                    if (s == null) return "{\"status\":\"not_found\",\"id\":" + id + "}";
                    return toJson(s);
                }
                case "DELETE": {
                    int id = Integer.parseInt(arg);
                    boolean ok = service.deleteStudent(id);
                    return "{\"status\":\"" + (ok ? "deleted" : "not_found") + "\",\"id\":" + id + "}";
                }
                case "SEARCH_NAME": {
                    List<Student> res = service.searchByName(arg);
                    return toJsonArray(res);
                }
                case "EXPORT_JSON": {
                    String path = arg.isEmpty() ? "students.json" : arg;
                    service.exportJson(path);
                    return "{\"status\":\"exported\",\"path\":\"" + path + "\"}";
                }
                case "EXPORT_SORTED": {
                    String path = arg.isEmpty() ? "students_sorted.csv" : arg;
                    service.exportSortedByName(path);
                    return "{\"status\":\"exported_sorted\",\"path\":\"" + path + "\"}";
                }
                default:
                    return "{\"error\":\"unknown_command\",\"cmd\":\"" + escape(cmd) + "\"}";
            }
        } catch (NumberFormatException nfe) {
            return "{\"error\":\"bad_number_format\",\"msg\":\"" + escape(nfe.getMessage()) + "\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + escape(e.getMessage()) + "\"}";
        }
    }

    private String toJson(Student s) {
        return "{\"id\":" + s.id
                + ",\"name\":\"" + escape(s.name) + "\""
                + ",\"age\":" + s.age + "}";
    }

    private String toJsonArray(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(toJson(list.get(i)));
            if (i < list.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // Run batch commands from file and write responses to students_api_responses.json
    public void runBatch(File file) throws IOException {
        List<String> responses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String resp = process(line);
                System.out.println(resp);
                responses.add(resp);
            }
        }
        // write responses as a JSON array
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students_api_responses.json"))) {
            bw.write("[\n");
            for (int i = 0; i < responses.size(); i++) {
                bw.write("  " + responses.get(i));
                if (i < responses.size() - 1) bw.write(",");
                bw.write("\n");
            }
            bw.write("]\n");
        }
    }
}