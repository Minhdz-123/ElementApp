package Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements AutoCloseable {
    private Connection conn;

    public QuestionRepository() {
        try {
            conn = DatabaseConnector.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy 10 câu hỏi theo ID (giả sử lấy từ id 1 đến 10)
    public List<Question> getQuestions(int startId, int limit) {
        List<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT * FROM questions WHERE id >= ? LIMIT ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, startId);  // Bắt đầu từ ID
            stmt.setInt(2, limit);    // Giới hạn số câu hỏi (10 câu)
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String questionText = rs.getString("question");
                String correctAnswer = rs.getString("correct_answer");
                String wrongAnswer1 = rs.getString("wrong_answer_1");
                String wrongAnswer2 = rs.getString("wrong_answer_2");
                String wrongAnswer3 = rs.getString("wrong_answer_3");
                String element = rs.getString("element");

                // Thêm câu hỏi vào danh sách
                questions.add(new Question(id, questionText, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, element));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
    @Override
    public void close() { // Phương thức đóng kết nối
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Đóng kết nối
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

