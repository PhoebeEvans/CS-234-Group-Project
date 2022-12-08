/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cs234project;

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
public class removeLoanWindow extends javax.swing.JFrame {
    private int num;
    private String loanLine;
    
    private String[] arrLine;
    private String[] arrLine2;
    private String material;
    private String outDate;
    private String inDate;
    private int materialtype;
    private String materialName;
    private String materialDate;
    private String materialId;
    private int loan = 0;
    private String employeename = "Bob";
    private String patronname = "";
    private String employeeId = "001";
    private String patronId;
    private String patronDOB;
    private String mediaFile = "";
    private String patronFile = "";
    
    
    /**
     * Creates new form removeLoanWindow
     */
    public removeLoanWindow(int number) throws FileNotFoundException {
        initComponents();
        num = number;
        num--;
        
        
        
        findLoan();
        removingLoanInstruc.setText("You are removing " + loanLine + ".");
        
        
        
    }

    public void findLoan() throws FileNotFoundException{
        File inputFile = new File("Loans.txt");
        Scanner in = new Scanner(inputFile);
        
        int count = 0;
        
        while(in.hasNextLine()){
            //System.out.println(count);
            String lineChange = in.nextLine();
            //System.out.println(lineChange);
            if(count == num){
                loanLine = lineChange;
            }
                 
            
            count++;
        }
        in.close();
        
        arrLine = loanLine.split("~");
                
                
        materialName = arrLine[0];
        materialDate = arrLine[1];
        materialId = arrLine[2];
        patronname = arrLine[3];
        patronDOB = arrLine[4];
        patronId = arrLine[5];
        inDate = arrLine[6];
        outDate = arrLine[7];
        employeename = arrLine[8];
        employeeId = arrLine[9];

        //patronFile is deduced
        patronFile = patronname + patronDOB + "Id" + patronId;
        patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = patronFile + ".txt";

        //patronName for search purposes is made
        String patronName = patronname.replaceAll("[^a-z0-9]", "");

        //mediaFile is deduced
        mediaFile = materialName + materialDate + "Id" + materialId;
        mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = mediaFile + ".txt";

        //materialname for search purposes is made
        String materialname = materialName.replaceAll("[^a-z0-9]", "");
        
    }
    
    public void removeLoans() throws FileNotFoundException{
        File view = new File("Loans.txt");
        Scanner in = new Scanner(view);
        PrintWriter out = new PrintWriter("temp2.txt");
        int iterator = 0;
        //read the input and write the output
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            if(iterator == num){
                
                System.out.println(lineChange+" is being removed. \n");
                
            
                //arrLine is an array of lineChange split at ~
                arrLine = lineChange.split("~");
                
                
                materialName = arrLine[0];
                materialDate = arrLine[1];
                materialId = arrLine[2];
                patronname = arrLine[3];
                patronDOB = arrLine[4];
                patronId = arrLine[5];
                inDate = arrLine[6];
                outDate = arrLine[7];
                employeename = arrLine[8];
                employeeId = arrLine[9];
                
                //patronFile is deduced
                patronFile = patronname + patronDOB + "Id" + patronId;
                patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
                patronFile = patronFile + ".txt";
                
                //System.out.println(patronFile);
                //patronName for search purposes is made
                String patronName = patronname.toLowerCase();
                patronName = patronName.replaceAll("[^a-z0-9]", "");
                System.out.println("patronname " + patronName);
                //mediaFile is deduced
                mediaFile = materialName + materialDate + "Id" + materialId;
                mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
                mediaFile = mediaFile + ".txt";
                
                //System.out.println(mediaFile);
                //materialname for search purposes is made
                String materialname = materialName.toLowerCase();
                materialname = materialname.replaceAll("[^a-z0-9]", "");
                System.out.println("materialname" + materialname);
                
                //mediaFile update
                File inputMediaFile = new File(mediaFile);
                Scanner inMedia = new Scanner(inputMediaFile);
                PrintWriter outMedia = new PrintWriter("temp.txt");
                while(inMedia.hasNextLine()){
                    String nextline = inMedia.nextLine();
                    arrLine2 = nextline.split("~");
                    String person = arrLine2[2];
                    String [] spliter = person.split("#");
                    String name = spliter[0];
                    name = name.toLowerCase();
                     

                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    System.out.println("media file name " + name);
                    if(name == null ? patronName == null : name.equals(patronName)){
                        
                    }
                    else{
                        outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    }
                }
                
                //files closed and replaced
                inMedia.close();
                outMedia.close();
                Files loans = new Files("temp.txt", mediaFile);
                loans.fileReplace();
                    
                //patronFile is opened    
                File inputpatronFile = new File(patronFile);
                Scanner inPatron = new Scanner(inputpatronFile);
                PrintWriter outPatron = new PrintWriter("temp.txt");

                while(inPatron.hasNextLine()){
                    String nextline = inPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];
                    
                    String name = title.toLowerCase();
                     
                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    System.out.println("patron file name" + name);
                    
                    if(name == null ? materialname == null : name.equals(materialname)){
                       
                    }
                    //outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    else{
                        outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                    }
                }
                
                inPatron.close();
                outPatron.close();
                Files patron = new Files("temp.txt",patronFile);
                patron.fileReplace();    
            }
            
            else{
                out.println(lineChange);
            }
            iterator++;
        }
            
        in.close();
        out.close();
        
        Files replace = new Files( "temp2.txt" , "Loans.txt");
        replace.fileReplace();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        removingLoanInstruc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Removing Loans");

        removingLoanInstruc.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        removingLoanInstruc.setText("You are removing ????.");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Click the remove button to remove the loan.");

        removeButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        removeButton.setText("remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(removeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(removingLoanInstruc)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(86, 86, 86)
                .addComponent(removingLoanInstruc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        try {
            // TODO add your handling code here:
            removeLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(removeLoanWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public void removeLwindow(int number) {
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
            java.util.logging.Logger.getLogger(removeLoanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeLoanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeLoanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeLoanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new removeLoanWindow(number).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(removeLoanWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel removingLoanInstruc;
    // End of variables declaration//GEN-END:variables
}
