package com.mycompany.heloo.Element;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentData {
    // Thông tin kết nối đến cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/EStu"; // Thay bằng tên cơ sở dữ liệu của bạn
    private static final String USER = "root";  // Thay bằng tên người dùng MySQL
    private static final String PASSWORD = "16092004";  // Thay bằng mật khẩu MySQL

    // Phương thức lấy kết nối đến cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Phương thức chèn sinh viên vào cơ sở dữ liệu
    public static void insertStudent(Student student) {
        String query = "INSERT INTO students (name, birthday, lop, score) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Thiết lập giá trị cho các tham số trong câu lệnh SQL
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getBirthday());
            pstmt.setString(3, student.getLop());
            pstmt.setInt(4, student.getScore());

            // Thực thi câu lệnh SQL
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
