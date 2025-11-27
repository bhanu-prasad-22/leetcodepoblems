
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        if (args.length > 0 && args[0].equalsIgnoreCase("api")) {
            StudentApi api = new StudentApi(service);
            File req = new File("api_requests.txt");
            if (!req.exists()) {
                System.out.println("api_requests.txt not found - create it in project folder and run again.");
                return;
            }
            try {
                api.runBatch(req);
            } catch (IOException e) {
                System.out.println("APi run error: " + e.getMessage());
            }
            return;
        }

        // Auto-load on start
        service.loadFromFile("students.csv");
        System.out.println("Loaded existing data (if available)");

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. View Students (sorted by name)");
            System.out.println("4. Search student by ID");
            System.out.println("5. Delete student by ID");
            System.out.println("6. Update Student");
            System.out.println("7. Reload data from students.csv");
            System.out.println("8. Count how many students are older than 20");
            System.out.println("9. Students sorted by age (asc)");
            System.out.println("10. Students sorted by age (desc)");
            System.out.println("11. Search student by name (partial match)");
            System.out.println("12. Save & Exit");
            System.out.println("13. Export students (sorted by name) to students_sorted.csv");
            System.out.println("14. Export students as JSON to students.json");
            System.out.print("Enter your choice (1-14): ");

            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 and 14.");
                continue;
            }

            switch (choice) {
                case 1: // Add Student
                    try {
                        System.out.print("Enter id: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (service.searchStudent(id) != null) {
                            System.out.println("A student with this ID already exists. Choose a different ID.");
                            break;
                        }
                        System.out.print("Enter name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(sc.nextLine().trim());

                        Student s = new Student(id, name, age);
                        service.addStudent(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Student not added.");
                    }
                    break;

                case 2:
                    service.printAllStudents();
                    break;

                case 3:
                    List<Student> sorted = service.getStudentSortedByName();
                    System.out.println("Students sorted by name:");
                    service.printStudents(sorted);
                    break;

                case 4:
                    try {
                        System.out.print("Enter ID to search: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        Student found = service.searchStudent(id);
                        if (found != null) {
                            System.out.println("Found: " + found); 
                        }else {
                            System.out.println("No student found with ID: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        boolean ok = service.deleteStudent(id);
                        if (ok) {
                            System.out.println("Deleted student with ID: " + id); 
                        }else {
                            System.out.println("No student found with ID: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter ID to update: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine().trim();
                        System.out.print("Enter new age: ");
                        int newAge = Integer.parseInt(sc.nextLine().trim());
                        boolean updated = service.updateStudent(id, newName, newAge);
                        if (updated) {
                            System.out.println("Student updated."); 
                        }else {
                            System.out.println("No student found with ID: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 7:
                    service.loadFromFile("students.csv");
                    break;

                case 8:
                    System.out.println(service.countStudentsAbove20() + " students are older than 20.");
                    break;

                case 9:
                    List<Student> asc = service.getStudentsSortedByAgeAsc();
                    System.out.println("Students sorted by age (asc):");
                    service.printStudents(asc);
                    break;

                case 10:
                    List<Student> dsc = service.getStudentsSortedByAgeDesc();
                    System.out.println("Students sorted by age (desc):");
                    service.printStudents(dsc);
                    break;

                case 11:
                    System.out.print("Enter name fragment to search: ");
                    String q = sc.nextLine().trim();
                    List<Student> results = service.searchByName(q);
                    if (results.isEmpty()) {
                        System.out.println("No students found."); 
                    }else {
                        service.printStudents(results);
                    }
                    break;

                case 12:
                    service.saveToFile("students.csv");
                    System.out.println("Saved to students.csv. Exiting. Goodbye!");
                    sc.close();
                    return;

                case 13:
                    service.exportSortedByName("students_sorted.csv");
                    break;

                case 14:
                    service.exportJson("students.json");
                    break;

                default:
                    System.out.println("Enter a valid option (1-14).");
            }
        }
    }
}
