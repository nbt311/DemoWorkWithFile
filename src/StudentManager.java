package src;
import Write.StudentWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

    public class StudentManager {
        private List<Student> studentList;
        private String fileName;
        private StudentWriter studentWriter;

        public StudentManager(String fileName) {
            this.fileName = fileName;
            this.studentList = new ArrayList<>();
            this.studentWriter = new StudentWriter(fileName);
        }

        public void addStudent(Student student) {
            studentList.add(student);
            studentWriter.writeToFile(studentList);
        }

        public void removeStudent(String studentId) {
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getStudentId().equals(studentId)) {
                    iterator.remove();
                    studentWriter.writeToFile(studentList);
                    System.out.println("Đã xóa sinh viên có mã số " + studentId);
                    return;
                }
            }
            System.out.println("Không tìm thấy sinh viên có mã số " + studentId);
        }
        public List<Student> readFromFile() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                studentList = (List<Student>) ois.readObject();
                System.out.println("Danh sách sinh viên từ file:");
                for (Student student : studentList) {
                    System.out.println(student);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return studentList;
        }

        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\n----- MENU -----");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Xóa sinh viên");
                System.out.println("3. Hiển thị danh sách sinh viên trong file");
                System.out.println("4. Thoát");
                System.out.print("Chọn một số: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Nhập thông tin sinh viên:");
                        Student newStudent = Input.createStudentFromInput();
                        addStudent(newStudent);
                        break;
                    case 2:
                        System.out.print("Nhập mã số sinh viên cần xóa: ");
                        String studentIdToRemove = scanner.nextLine();
                        removeStudent(studentIdToRemove);
                        break;
                    case 3:
                        readFromFile();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
            scanner.close();
            System.out.println("Chương trình đã kết thúc.");
        }
        public static void main(String[] args) {
            StudentManager studentManager = new StudentManager("students.ser");
            studentManager.displayMenu();
        }
}
