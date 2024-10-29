package com.mycompany.heloo.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookupFace extends JFrame {
    private JTextField atomicNumberField;
    private JTextArea resultArea;
    private ElementData elementData;  // Sử dụng ElementData để quản lý danh sách nguyên tố

    public LookupFace() {
        setTitle("Element Lookup");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Khởi tạo dữ liệu nguyên tố
        elementData = new ElementData();

        // Tạo layout
        setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel atomicNumberLabel = new JLabel("Enter Atomic Number (1-89):");
        atomicNumberField = new JTextField(10);
        JButton lookupButton = new JButton("Lookup");

        inputPanel.add(atomicNumberLabel);
        inputPanel.add(atomicNumberField);
        inputPanel.add(lookupButton);

        // Khu vực hiển thị kết quả
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Thêm panel và kết quả vào JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Xử lý khi nhấn nút Lookup
        lookupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lookupElement();
            }
        });
    }

    private void lookupElement() {
        try {
            int atomicNumber = Integer.parseInt(atomicNumberField.getText());

            Element element = elementData.getElementByAtomicNumber(atomicNumber);
            if (element == null) {
                resultArea.setText("Invalid input. Please enter a number between 1 and 89.");
            } else {
                resultArea.setText("STT: " + element.getAtomicNumber() + "\n" +
                        "Name: " + element.getName() + "\n" +
                        "Symbol: " + element.getSymbol() + "\n" +
                        "Molar Mass: " + element.getMolarMass() + " g/mol");
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LookupFace frame = new LookupFace();
            frame.setVisible(true);
        });
    }
}
