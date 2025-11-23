
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public List<Student> getStudentSortedByName() {
        return students.stream()
                .sorted(Comparator.comparing(st -> st.name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.id == id);
    }

    public boolean updateStudent(int id, String newName, int newAge) {
        Student s = searchStudent(id);
        if (s == null) {
            return false;
        }
        s.name = newName;
        s.age = newAge;
        return true;
    }

    public void printStudents(List<Student> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No students records.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void saveToFile(String path) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            for (Student s : students) {
                String nameEscaped = s.name.replace("\"", "\"\"");

                if (nameEscaped.contains(",") || nameEscaped.contains("\"")) {
                    nameEscaped = "\"" + nameEscaped + "\"";

                }
                bw.write(s.id + "," + nameEscaped + "," + s.age);
                bw.newLine();

            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public void loadFromFile(String path) {
        students.clear();
        Path p = Paths.get(path);
        if (!Files.exists(p)) {
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> parts = parseCsvLine(line);
                if (parts.size() >= 3) {
                    try {
                        int id = Integer.parseInt(parts.get(0).trim());
                        String name = parts.get(1);
                        int age = Integer.parseInt(parts.get(2).trim());

                        students.add(new Student(id, name, age));
                    } catch (NumberFormatException e) {

                    }
                }
            }
            System.out.println("Loaded " + students.size() + " students form " + path);

        } catch (IOException e) {
            System.out.println("Error loading stuident: " + e.getMessage());
        }
    }

    private List<String> parseCsvLine(String line) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    cur.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                out.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        out.add(cur.toString());
        return out;
    }

    public long countStudentsAbove20() {
        return students.stream()
                .filter(s -> s.age > 20)
                .count();
    }

    public List<Student> getStudentsSortedByAgeAsc() {
        return students.stream()
                .sorted(Comparator.comparingInt(s -> s.age))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByAgeDesc() {
        return students.stream()
                .sorted(Comparator.comparingInt((Student s) -> s.age).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> searchByName(String nameFragment) {
        String q = nameFragment.toLowerCase();

        return students.stream()
                .filter(s -> s.name.toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public void exportSortedByName(String path)
    {
        List<Student> sorted =getStudentSortedByName();
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path)))
        {
            for(Student s:sorted)
            {
                String nameEscaped=s.name.replace("\"","\"\"");
                if(nameEscaped.contains(",") || nameEscaped.contains("\""))
                {
                      nameEscaped= "\"" + nameEscaped + "\"";
                }
                bw.write(s.id+ ","+ nameEscaped +","+s.age);
                bw.newLine();
            }
            System.out.println("Export successfully -> " + path);
        }
        catch(Exception e)
        {
            System.out.println("Eror exporting: "+e.getMessage());
        }
    }
}
