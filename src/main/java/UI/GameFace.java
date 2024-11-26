package UI;

import Data.Element;
import Data.ElementData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameFace extends JFrame {
    private JTextArea questionArea;
    private JTextField answerField;
    private JButton submitButton;
    private JLabel scoreLabel;
    private int score = 0;
    private int questionCount = 0;
    private final int numberOfQuestions = 30;
    private ElementData elementData;
    private Element currentElement;

    public GameFace() {
        setTitle("Element Hunt Game");
        setSize(550, 350);  // Set kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        elementData = new ElementData();

        // Tạo JTextArea để hiển thị câu hỏi
        questionArea = new JTextArea();
        questionArea.setFont(new Font("Serif", Font.PLAIN, 14));  // Đặt kích thước chữ là 14
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        add(new JScrollPane(questionArea), BorderLayout.CENTER);

        // Tạo JTextField để nhập câu trả lời
        answerField = new JTextField();
        answerField.setFont(new Font("Serif", Font.PLAIN, 14));  // Đặt kích thước chữ là 14
        add(answerField, BorderLayout.SOUTH);

        // Thêm ActionListener vào answerField để xử lý khi nhấn Enter
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();  // Hàm này sẽ kiểm tra đáp án khi người dùng nhấn Enter
            }
        });

        // Tạo JLabel để hiển thị điểm số
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(scoreLabel, BorderLayout.NORTH);

        // Tạo JButton để nộp câu trả lời
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.PLAIN, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();  // Hàm này kiểm tra đáp án khi người dùng nhấn nút
            }
        });
        add(submitButton, BorderLayout.EAST);

        nextQuestion();  // Hiển thị câu hỏi đầu tiên
    }

    private void nextQuestion() {
        if (questionCount >= numberOfQuestions) {
            questionArea.setText("Game Over! Your final score is: " + score);
            submitButton.setEnabled(false);
            answerField.setEnabled(false);  // Disable answerField when game is over
            return;
        }
        Random random = new Random();
        int atomicNumber = random.nextInt(89) + 1;  // Từ 1 đến 89
        currentElement = elementData.getElementByAtomicNumber(atomicNumber);
        questionArea.setText("Question " + (questionCount + 1) + ": What is the name of the element with symbol: " + currentElement.getSymbol() + "?");
        answerField.setText("");  // Xóa nội dung trong JTextField
        questionCount++;
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        if (userAnswer.equalsIgnoreCase(currentElement.getName())) {
            score++;
            scoreLabel.setText("Score: " + score);
            JOptionPane.showMessageDialog(this, "Good job! +1 point", "Correct!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Wrong! The correct answer is: " + currentElement.getName(), "Incorrect!", JOptionPane.ERROR_MESSAGE);
        }
        answerField.setText("");  // Xóa nội dung trong JTextField để chuẩn bị cho câu hỏi tiếp theo
        nextQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFace().setVisible(true);
        });
    }
}
