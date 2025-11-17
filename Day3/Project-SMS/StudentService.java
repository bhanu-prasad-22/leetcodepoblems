
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
}
