package Write;
import src.Student;

import java.io.*;
import java.util.List;

public class StudentWriter {
    private String fileName;

    public StudentWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<Student> studentList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(studentList);
            System.out.println("Danh sách sinh viên đã được lưu trữ vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
