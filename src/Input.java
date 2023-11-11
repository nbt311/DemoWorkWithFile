package src;

import java.util.Scanner;

public class Input {
    public static Student createStudentFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập thông tin sinh viên:");
        System.out.print("Tên: ");
        String name = scanner.nextLine();

        System.out.print("Tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới sau nextInt()

        System.out.print("Mã sinh viên: ");
        String studentId = scanner.nextLine();

        return new Student(name, age, studentId);
    }
}
