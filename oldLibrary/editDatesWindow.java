/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oldLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phoeb
 */
public class editDatesWindow extends javax.swing.JFrame {
    private int response;
    private String oldDate;
    private int returnDate;
    private String newDate;
    private String currentDate;
    
    private String material;
    private String outDate;
    private String inDate;
    private int materialtype;
    private String materialName;
    private String materialDate;
    private String materialId;
    private int loan = 0;
    
    private String[] arrLine;
    private String[] arrLine2;
    
    private String[] materialArr;
    private String[] mDateArr;
    private String[] materialIdArr;
    private String[] patronArr;
    private String[] dobArr; 
    private String[] patronidArr;
    private String[] indateArr;
    private String[] outdateArr;
    private String[] employeeArr;
    private String[] employeeidArr;
    
    private String employeename = "Bob";
    private String patronname = "";
    private String employeeId = "001";
    private String patronId;
    private String patronDOB;
    private int rnum = 1;
    private String mediaFile = "";
    private String patronFile = "";
    /**
     * Creates new form editDatesWindow
     */
    public editDatesWindow(int numb, String selection) {
        initComponents();
        changePanel.setVisible(false);
        response = numb -1;
        oldDate = selection;
        
        instruct.setText("The current due date is " + oldDate + ".");
        
        Age loandate = new Age();
        currentDate = loandate.getcurrentDate();
        
        int value = 100; 
        
        
        materialArr = new String[value];
        mDateArr = new String[value];
        materialIdArr = new String[value];
        patronArr = new String[value];
        dobArr = new String[value]; 
        patronidArr = new String[value];
        indateArr = new String[value];
        arrLine = new String[10];
        outdateArr = new String[value];
        employeeArr = new String[value];
        employeeidArr = new String[value];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        instruct = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        returnButton = new javax.swing.JRadioButton();
        changeButton = new javax.swing.JRadioButton();
        saveButton = new javax.swing.JButton();
        changePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel1.setText("Editing and Returning");

        instruct.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        instruct.setText("The current due date is ?????.");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Click return to return the material. Click change due date to change the due date.");

        buttonGroup.add(returnButton);
        returnButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(changeButton);
        changeButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        changeButton.setText("Change date");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Please type the new due date in MM/DD/YYYY format.");

        dateField.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        javax.swing.GroupLayout changePanelLayout = new javax.swing.GroupLayout(changePanel);
        changePanel.setLayout(changePanelLayout);
        changePanelLayout.setHorizontalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateField))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        changePanelLayout.setVerticalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(instruct)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(returnButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeButton)
                                .addGap(77, 77, 77)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instruct)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton)
                    .addComponent(changeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(changePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        changePanel.setVisible(false);
        returnDate = 1;
    }//GEN-LAST:event_returnButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        changePanel.setVisible(true);
        returnDate = 0;
        
    }//GEN-LAST:event_changeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if(returnDate == 1){
            //return
            newDate = "returned " + currentDate;
        }
        
        else if(returnDate == 0){
            newDate = dateField.getText();
        }
        
        try {
            editLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(editDatesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    public void editLoans() throws FileNotFoundException{
        patronname = "";
        materialName = "";
        
        //Loans.txt is opened
        File viewFile = new File("Loans.txt");
        Scanner in = new Scanner(viewFile);
        PrintWriter out = new PrintWriter("temp2.txt");
        
        int count = 1;
        rnum = 0;
        
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            System.out.println(count + " " + lineChange);
            count++;
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            outdateArr[rnum] = arrLine[6];
            indateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        count = 0;
        
        indateArr[response] = newDate;
        
        //patronFile name is deduced 
        patronFile = patronArr[response] + dobArr[response] + "Id" + patronidArr[response];
        patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = patronFile + ".txt";
        
        //patronName for searching is made
        String patronName = patronArr[response].toLowerCase();
        patronName = patronName.replaceAll("[^a-z]", "");
        
        //mediaFile name is deduced
        mediaFile = materialArr[response] + mDateArr[response] + "Id" + materialIdArr[response];
        mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = mediaFile + ".txt";
        
        //materialname for searching is made
        String materialname = materialArr[response].toLowerCase();
        materialname = materialname.replaceAll("[^a-z]", "");
        
        File inputMediaFile = new File(mediaFile);
            Scanner inMedia = new Scanner(inputMediaFile);
            PrintWriter outMedia = new PrintWriter("temp.txt");
            while(inMedia.hasNextLine()){
                
                String nextline = inMedia.nextLine();
                arrLine2 = nextline.split("~");
                String person = arrLine2[2];
                String [] spliter = person.split("#");
                String name = spliter[0];
                name = person.toLowerCase();


                name = name.replaceAll("[^a-z]", "");
                
                if(name == null ? patronName == null : name.equals(patronName)){
                    arrLine2[2] = patronArr[response] + "#" + dobArr[response] + "#" + patronidArr[response]+ "#" + outdateArr[response] + "#" + indateArr[response];
                    if(returnDate == 1){
                        arrLine2[2] = "avalible";
                        arrLine2[1] = " 0 ";
                    }
                }
                outMedia.println(mediaFile + "~" + arrLine2[1] + "~" + arrLine2[2]);
            }

        inMedia.close();
        outMedia.close();
        Files loans = new Files("temp.txt", mediaFile);
        loans.fileReplace();
        
        while(count < rnum){
            out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                        outdateArr[count] + "~" + indateArr[count] + "~" + employeeArr[count] + "~" + employeeidArr[count]);
            count++;
        }

        in.close();
        out.close();
        Files Loans = new Files("temp2.txt", "Loans.txt");
        Loans.fileReplace();
            
        File inputpatronFile = new File(patronFile);
        Scanner inPatron = new Scanner(inputpatronFile);
        PrintWriter outPatron = new PrintWriter("temp.txt");    
        
        while(inPatron.hasNextLine()){
            String nextline = inPatron.nextLine();
            arrLine2 = nextline.split("~");
            String title = arrLine2[3];

            String name = title.toLowerCase();

            name = name.replaceAll("[^a-z0-9]", "");

            if(name == null ? materialname == null : name.equals(materialname)){
                arrLine2[1] = outdateArr[response];
                arrLine2[3] = materialArr[response];
                arrLine2[5] = indateArr[response];
                outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
            }

            else{
                outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
            }
        }

        inPatron.close();
        outPatron.close();
        Files patron = new Files("temp.txt",patronFile);
        patron.fileReplace();
        
        
            
            
    }
    /**
     * @param args the command line arguments
     */
    public void editLwindow(int numb, String selection) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editDatesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editDatesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editDatesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editDatesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editDatesWindow(numb, selection).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton changeButton;
    private javax.swing.JPanel changePanel;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel instruct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton returnButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
