
import java.util.List;
import java.util.Scanner;

public class StudentMain {

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        OUTER:
        while (true) {
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.View Students(sortedynames)");
            System.out.println("4.Search student By Id");
            System.out.println("5.Delete student By Id");
            System.out.println("6. Update Student (optional)");
            System.out.println("7.Loading data form student.csv.");
            System.out.println("8.Count how many student are older than 20.");
            System.out.println("9.Students sorted by age (asc):");
            System.out.println("10.Students sorted by age (dsc):");
            System.out.println("11. Exit");
            System.out.println("Enter your choice:");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number between 1-7");
                continue;
            }
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter id:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter age:");
                        int age = sc.nextInt();
                        Student s = new Student(id, name, age);
                        service.addStudent(s);

                    } catch (Exception e) {
                        System.out.println("Invalid input. Student not added");
                    }
                    break;
                case 2:
                    service.printAllStudents();
                    break;
                case 3:
                    List<Student> sorted = service.getStudentSortedByName();
                    System.out.println("Students sorted By names:");
                    service.printStudents(sorted);
                    break;
                case 4:
                    try {
                        System.out.println("Enter Id to search:");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        Student found = service.searchStudent(id);
                        if (found != null) {
                            System.out.println("found: " + found);
                        } else {
                            System.out.println("No student found with id:" + id);
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input.");
                    }

                    break;
                case 5:
                    try {
                        System.out.println("Enter id to delete:");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        boolean ok = service.deleteStudent(id);
                        if (ok) {
                            System.out.println("Deleted Student with ID:" + id);
                        } else {
                            System.out.println("No student found with ID:" + id);
                        }
                    } catch (Exception e) {
                        System.out.println("Inavlid Input.");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Enter id:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter newName:");
                        String newName = sc.nextLine();
                        System.out.println("Enter newAge:");
                        int newAge = sc.nextInt();
                        boolean updated = service.updateStudent(id, newName, newAge);
                        if (updated) {
                            System.out.println("Student updated");
                        } else {
                            System.out.println("No student found with ID:" + id);
                        }
                    } catch (Exception e) {
                    }
                    System.out.println("Invalid Input.");
                    break;
                case 7:
                    service.loadFromFile("students.csv");
                    break;
                case 8:
                    System.out.println(service.countStudentsAbove20() + " are above age 20.");
                    break;
                case 9:
                    List<Student> asc = service.getStudentsSortedByAgeAsc();
                    System.out.println("Students sorted by age (asc):");
                    service.printStudents(asc);
                    break;
                case 10:
                    List<Student> dsc = service.getStudentsSortedByAgeDesc();
                    System.out.println("Students sorted by age (dsc):");
                    service.printStudents(dsc);
                    break;
                case 11:
                    service.saveToFile("students.csv");
                    System.out.println("Saved to students.csv Exiting.GoodBye");
                    sc.close();
                    return;

                default:
                    System.out.println("Enter a valid option (1-7).");
            }
        }
    }
}
