import java.util.Scanner;

public class StudentMain
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentService service=new StudentService();

        OUTER: 
        while (true) {
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter id:");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter age:");
                    int age=sc.nextInt();
                    Student s=new Student(id,name,age);
                    service.addStudent(s);
                    break;
                case 2:
                    service.printAllStudents();
                    break;
                default:
                    break OUTER;
            }
        }
    }
}