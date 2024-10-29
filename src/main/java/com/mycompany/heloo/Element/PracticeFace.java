package com.mycompany.heloo.Element;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author HP
 */
public class PracticeFace extends javax.swing.JFrame {
    private ElementData elementData;
    public PracticeFace() {
        initComponents();
        elementData = new ElementData();
        setResizable(false); // Ngăn không cho thay đổi kích thước cửa sổ        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PGround = new BackgroundPanel("/com/mycompany/heloo/Element/PracticeGround.PNG");
        lookup = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        atomicNumberField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lookup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/heloo/Element/LookUp.PNG"))); // NOI18N
        lookup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PracticeFace.this.actionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/heloo/Element/Back.PNG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PracticeFace.this.actionPerformed(evt);
                actionBack(evt);
            }
        });

        atomicNumberField.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N

        resultArea.setColumns(20);
        resultArea.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        resultArea.setRows(5);
        resultArea.setEditable(false);
        jScrollPane1.setViewportView(resultArea);

        javax.swing.GroupLayout PGroundLayout = new javax.swing.GroupLayout(PGround);
        PGround.setLayout(PGroundLayout);
        PGroundLayout.setHorizontalGroup(
            PGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PGroundLayout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(23, 23, 23)
                .addGroup(PGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PGroundLayout.createSequentialGroup()
                        .addComponent(atomicNumberField)
                        .addGap(23, 23, 23)
                        .addComponent(lookup))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addGap(110, 110, 110))
        );
        PGroundLayout.setVerticalGroup(
            PGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PGroundLayout.createSequentialGroup()
                .addGroup(PGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(PGroundLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lookup))
                    .addGroup(PGroundLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(atomicNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed

        lookupElement();  // Gọi phương thức xử lý tìm kiếm khi nhấn nút
            
    }//GEN-LAST:event_actionPerformed

    private void actionBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBack
        ElementFace3 ElementFace3 = new ElementFace3();
        ElementFace3.setVisible(true);
        dispose();
    }//GEN-LAST:event_actionBack

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

    // Class để vẽ hình nền cho JPanel
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String fileName) {
            backgroundImage = new ImageIcon(getClass().getResource("/com/mycompany/heloo/Element/PracticeGround.PNG")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Phương thức main
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PracticeFace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PGround;
    private javax.swing.JTextField atomicNumberField;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lookup;
    private javax.swing.JTextArea resultArea;
    // End of variables declaration//GEN-END:variables
}
