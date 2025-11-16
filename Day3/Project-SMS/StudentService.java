import java.util.ArrayList;
import java.util.List;

public class StudentService
{
    @SuppressWarnings("FieldMayBeFinal")
    private List<Student> students=new ArrayList<>();

    public void addStudent(Student s)
    {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void printAllStudents()
    {
        for(Student s:students)
        {
            System.out.println(s);
        }
    }
}