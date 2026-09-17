import studentpkg.Student;
import coursepkg.Course;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Arun", "Computer Science");
        Course c1 = new Course("CS301", "Data Structures", 4);

        System.out.println("===== Student Details =====");
        s1.displayStudentDetails();

        System.out.println("\n===== Course Details =====");
        c1.displayCourseDetails();
    }
}
