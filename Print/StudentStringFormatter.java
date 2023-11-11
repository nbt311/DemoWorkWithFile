package Print;

import src.Student;

public class StudentStringFormatter {
    public static String format(Student student) {
        return "Student{" +
                "name='" + student.getName() + '\'' +
                ", age=" + student.getAge() +
                ", studentId='" + student.getStudentId() + '\'' +
                '}';
    }
}
