package Level;

import Data.Question;
import Data.QuestionRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Level extends JFrame {
    // Constants
    private static final int QUESTION_TIME_LIMIT = 30; // seconds
    private static final int QUESTIONS_PER_LEVEL = 10;
    private static final String BACKGROUND_IMAGE_PATH = "/com/mycompany/heloo/Element/levelFace1.PNG";
    private static final Dimension WINDOW_SIZE = new Dimension(550,350);
    
    // Game state
    private final List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int timeRemaining;
    private Timer questionTimer;
    
    // UI Components
    private final JLabel questionLabel;
    private final JLabel timerLabel;
    private final JLabel scoreLabel;
    private final JButton[] answerButtons;
    private final JProgressBar progressBar;
    
    public Level(int startId) {
        super("Level 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize components
        questionLabel = createStyledLabel();
        timerLabel = createStyledLabel();
        scoreLabel = createStyledLabel();
        answerButtons = new JButton[4];
        progressBar = new JProgressBar(0, QUESTIONS_PER_LEVEL);
        
        // Load questions
        try {
            try (QuestionRepository questionRepository = new QuestionRepository()) {
                questions = questionRepository.getQuestions(startId, 10);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load questions", e);
        }
        
        initializeUI();
        startGame();
    }
    
    private void initializeUI() {
        // Main panel with background
        JPanel mainPanel = new BackgroundPanel(BACKGROUND_IMAGE_PATH);
        mainPanel.setLayout(new BorderLayout(10, 10));
        
        // Top panel for status (timer, score, progress)
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        statusPanel.setOpaque(false);
        statusPanel.add(timerLabel);
        statusPanel.add(scoreLabel);
        statusPanel.add(progressBar);
        
        // Center panel for question
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setOpaque(false);
        questionPanel.add(questionLabel, BorderLayout.CENTER);
        
        // Bottom panel for answer buttons
        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        answersPanel.setOpaque(false);
        
        // Initialize answer buttons
        ActionListener answerListener = e -> handleAnswerSelected((JButton) e.getSource());
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = createStyledButton();
            answerButtons[i].addActionListener(answerListener);
            answersPanel.add(answerButtons[i]);
        }
        
        // Add all panels to main panel
        mainPanel.add(statusPanel, BorderLayout.NORTH);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(answersPanel, BorderLayout.SOUTH);
        
        // Add padding
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
    
    private JLabel createStyledLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 26));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
    
    private JButton createStyledButton() {
        JButton button = new JButton();
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(240, 240, 240));
        return button;
    }
    
    private void startGame() {
        currentQuestionIndex = 0;
        score = 0;
        updateScore();
        displayQuestion();
    }
    
    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText("<html><center>" + currentQuestion.getQuestionText() + "</center></html>");
            
            // Update progress
            progressBar.setValue(currentQuestionIndex + 1);
            
            // Shuffle and display answers
            List<String> answers = new ArrayList<>();
            answers.add(currentQuestion.getCorrectAnswer());
            answers.addAll(currentQuestion.getWrongAnswers());
            Collections.shuffle(answers);
            
            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setText(answers.get(i));
                answerButtons[i].setEnabled(true);
                answerButtons[i].setBackground(new Color(240, 240, 240));
            }
            
            startQuestionTimer();
        } else {
            showGameComplete();
        }
    }
    
    private void startQuestionTimer() {
        if (questionTimer != null) {
            questionTimer.cancel();
        }
        
        timeRemaining = QUESTION_TIME_LIMIT;
        updateTimerLabel();
        
        questionTimer = new Timer();
        questionTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeRemaining--;
                SwingUtilities.invokeLater(() -> {
                    updateTimerLabel();
                    if (timeRemaining <= 0) {
                        handleTimeout();
                    }
                });
            }
        }, 1000, 1000);
    }
    
    private void updateTimerLabel() {
        timerLabel.setText(String.format("Time: %02d", timeRemaining));
    }
    
    private void updateScore() {
        scoreLabel.setText(String.format("Score: %d/%d", score, QUESTIONS_PER_LEVEL));
    }
    
    private void handleAnswerSelected(JButton selectedButton) {
        questionTimer.cancel();
        
        Question currentQuestion = questions.get(currentQuestionIndex);
        boolean correct = selectedButton.getText().equals(currentQuestion.getCorrectAnswer());
        
        // Visual feedback
        selectedButton.setBackground(correct ? new Color(144, 238, 144) : new Color(255, 182, 193));
        
        // Disable all buttons
        for (JButton button : answerButtons) {
            button.setEnabled(false);
        }
        
        // Show correct answer
        if (!correct) {
            for (JButton button : answerButtons) {
                if (button.getText().equals(currentQuestion.getCorrectAnswer())) {
                    button.setBackground(new Color(144, 238, 144));
                    break;
                }
            }
        }
        
        // Update score
        if (correct) {
            score++;
            updateScore();
        }
        
        // Schedule next question
        Timer feedbackTimer = new Timer();
        feedbackTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    currentQuestionIndex++;
                    displayQuestion();
                });
            }
        }, 1500);
    }
    
    private void handleTimeout() {
        questionTimer.cancel();
        JOptionPane.showMessageDialog(this, "Hết thời gian!", "Time's Up", JOptionPane.WARNING_MESSAGE);
        currentQuestionIndex++;
        displayQuestion();
    }
    
    private void showGameComplete() {
        questionTimer.cancel();
        String message = String.format("Chúc mừng! Bạn đã hoàn thành Level 1!\nĐiểm số: %d/%d", score, QUESTIONS_PER_LEVEL);
        JOptionPane.showMessageDialog(this, message, "Level Complete", JOptionPane.INFORMATION_MESSAGE);
        if(score>=7){
            LevelPart1_2 pass1 = new LevelPart1_2();
            pass1.setVisible(true);
        }
        else{
            LevelPart1 LevelPart1 = new LevelPart1();
            LevelPart1.setVisible(true);
        }
        dispose();
    }
    
    // BackgroundPanel class
    private static class BackgroundPanel extends JPanel {
        private final Image backgroundImage;
        
        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
            setPreferredSize(new Dimension(800, 600));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    public static void display() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new Level(1).setVisible(true);
        });
    }
}
