/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cs234project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author phoeb
 */
public class editLoansWindow extends javax.swing.JFrame {

    private String oldPatron;
    private int row;
    private String patronReply;
    private int response;
    private String patron;
    private String patronFile;
    
    private String[] nameArr;
    private String[] idArr;
    private String[] ageArr;
    private String[] ageGroupArr;
    private String[] dobArr;
    private String[] addressArr;
    private String[] phoneArr;
    private String[] tempArr;
    private String[] arrLine;
    private String[] arrLine2;
    
    private String[] materialArr;
    private String[] mDateArr;
    private String[] materialIdArr;
    private String[] patronArr;
   
    private String[] patronidArr;
    private String[] indateArr;
    private String[] outdateArr;
    private String[] employeeArr;
    private String[] employeeidArr;
    
    private String patronname;
    private String patronDOB;
    private String patronId;
    
    private DefaultListModel dm = new DefaultListModel();
    
    /**
     * Creates new form editLoansWindow
     */
    public editLoansWindow(String selection, int number) {
        initComponents();
        
        oldPatron = selection;
        row = number;
        row--;
        oldPatronName.setText("Your current patron is " + oldPatron);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patronButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patronList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        namesButton = new javax.swing.JRadioButton();
        agesButton = new javax.swing.JRadioButton();
        ageGroupButton = new javax.swing.JRadioButton();
        dobButton = new javax.swing.JRadioButton();
        searchField = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        newPatronName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        oldPatronName = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel1.setText("Editing Loans");

        patronList.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        patronList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        patronList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patronListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patronList);

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("You are editing the patron. Click on the patron's name to select them.");

        patronButtonGroup.add(namesButton);
        namesButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        namesButton.setText("Names");
        namesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesButtonActionPerformed(evt);
            }
        });

        patronButtonGroup.add(agesButton);
        agesButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        agesButton.setText("Ages");
        agesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agesButtonActionPerformed(evt);
            }
        });

        patronButtonGroup.add(ageGroupButton);
        ageGroupButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        ageGroupButton.setText("Age Group");
        ageGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageGroupButtonActionPerformed(evt);
            }
        });

        patronButtonGroup.add(dobButton);
        dobButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        dobButton.setText("DOB");
        dobButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        goButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        goButton.setText("GO");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        newPatronName.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        newPatronName.setText("Your patron is ????");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Click the save button to save your edit.");

        save.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        oldPatronName.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        oldPatronName.setText("The current patron is ????");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(oldPatronName))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(namesButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(agesButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(ageGroupButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(dobButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(goButton))
                                .addComponent(newPatronName)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(oldPatronName)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namesButton)
                    .addComponent(agesButton)
                    .addComponent(ageGroupButton)
                    .addComponent(dobButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newPatronName)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        patronReply = searchField.getText();
        
        try {
            searchPatron();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(editLoansWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_goButtonActionPerformed

    private void namesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesButtonActionPerformed
        // TODO add your handling code here:
        response = 1;
    }//GEN-LAST:event_namesButtonActionPerformed

    private void agesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agesButtonActionPerformed
        // TODO add your handling code here:
        response = 2;
    }//GEN-LAST:event_agesButtonActionPerformed

    private void ageGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageGroupButtonActionPerformed
        // TODO add your handling code here:
        response = 3;
    }//GEN-LAST:event_ageGroupButtonActionPerformed

    private void dobButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobButtonActionPerformed
        // TODO add your handling code here:
        response = 4;
    }//GEN-LAST:event_dobButtonActionPerformed

    private void patronListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patronListMouseClicked
        // TODO add your handling code here:
        DefaultListModel listModel = (DefaultListModel) patronList.getModel();
        int patronValue = patronList.getSelectedIndex();
        
        String patronResponse = patronList.getSelectedValue();
        
        System.out.println(patronResponse);
        arrLine = patronResponse.split("_");
        
        patronFile = arrLine[1] + arrLine[4] + "Id" + arrLine[7]; 
        String rePlace = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = rePlace;
        String temp1 = patronFile +".txt";
        patronFile = temp1; 
        patronname = arrLine[1];
        patronId = arrLine[7];
        patronDOB = arrLine[4];
        
        newPatronName.setText("Your patron is " + patronname);
    }//GEN-LAST:event_patronListMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            // TODO add your handling code here:
            editLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(editLoansWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    public void searchPatron() throws FileNotFoundException{
        int rnum = 0;
        
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        
        int value = 100; 
        
        
        nameArr = new String[value];
        idArr = new String[value];
        ageArr = new String[value];
        ageGroupArr = new String[value];
        dobArr = new String[value]; 
        addressArr = new String[value];
        phoneArr = new String[value];
        arrLine = new String[8];
        tempArr = new String[1];
        idArr = new String[value];
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("_");
            //System.out.println(arrLine[0]);
            
            nameArr[rnum] = arrLine[1];
            ageArr[rnum] = arrLine[2];
            ageGroupArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            addressArr[rnum] = arrLine[5];
            phoneArr[rnum] = arrLine[6];
            idArr[rnum] = arrLine[7];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
          
        }
        
        patronList.setModel(dm);
        
        //director searcher
        if(response == 1){


            String split[] = patronReply.split(" ", 0);
            for(String resp1: split){

                String temp1 = resp1.toLowerCase();
                resp1 = temp1;

                temp1 = resp1.replaceAll("^a-z0-9", "");
                resp1 = temp1; 

                //System.out.println("in " + resp2);


                int count = 0;
                int num = 1;
                while(count < rnum){

                    tempArr[0] = nameArr[count];

                    String directorNew = Arrays.toString(tempArr);

                    String spliter[] = directorNew.split(" ", 0);

                    for(String dNew: spliter){
                        String temp;

                        temp = dNew.toLowerCase();
                        dNew = temp; 

                        //non letters and spaces remove
                        temp = dNew.replaceAll("[^a-z0-9]", "");
                        dNew = temp;
                        //System.out.println("arr " + dNew);

                        if(resp1.equals(dNew)){
                            dm.addElement(num + "_" + nameArr[count] + "_" + ageArr[count] + "_" + ageGroupArr[count] + "_" + dobArr[count] + "_" + addressArr[count]+ "_" + phoneArr[count] + "_" + idArr[count]);
                            //loans.println(num + " _ " + nameArr[count] + " _ " + ageArr[count] + " _ " + ageGroupArr[count] + " _ " + dobArr[count] + " _ " + addressArr[count]+ " _ " + phoneArr[count] + " _ " + idArr[count]);
                           
                            num++;
                        }


                    }
                    count++;
                }

            }
            

        }

        //director searcher
        if(response == 2){
            //System.out.println("Enter the age you are searching. ");

            
            int ageInt = Integer.parseInt(patronReply);

            int count = 0;
            int num = 1;



            while(count  < rnum){

                tempArr[0] = ageArr[count];

                String dateNew = Arrays.toString(tempArr);
                String temp;
                temp = dateNew.replaceAll("[^0-9]", "");
                dateNew = temp;

                int intAge = Integer.parseInt(dateNew);

                if(ageInt == intAge){
                    dm.addElement(num + "_" + nameArr[count] + "_" + ageArr[count] + "_" + ageGroupArr[count] + "_" + dobArr[count] + "_" + addressArr[count]+ "_" + phoneArr[count] + "_" + idArr[count]);
                    //loans.println(num + " _ " + nameArr[count] + " _ " + ageArr[count] + " _ " + ageGroupArr[count] + " _ " + dobArr[count] + " _ " + addressArr[count]+ " _ " + phoneArr[count] + " _ " + idArr[count]);
                    num++;
                }
                count++;

            }


        }

        //age searcher
        if(response == 3){

            String split[] = patronReply.split(" ", 0);
            for(String resp1: split){

                String temp1 = resp1.toLowerCase();
                resp1 = temp1;

                temp1 = resp1.replaceAll("^a-z0-9", "");
                resp1 = temp1; 

                //System.out.println("in " + resp2);


                int count = 0;
                int num = 1;
                while(count < rnum){

                    tempArr[0] = ageGroupArr[count];

                    String directorNew = Arrays.toString(tempArr);

                    String spliter[] = directorNew.split(" ", 0);

                    for(String dNew: spliter){
                        String temp;

                        temp = dNew.toLowerCase();
                        dNew = temp; 

                        //non letters and spaces remove
                        temp = dNew.replaceAll("[^a-z0-9]", "");
                        dNew = temp;
                        //System.out.println("arr " + dNew);

                        if(resp1.equals(dNew)){
                            dm.addElement(num + "_" + nameArr[count] + "_" + ageArr[count] + "_" + ageGroupArr[count] + "_" + dobArr[count] + "_" + addressArr[count]+ "_" + phoneArr[count] + "_" + idArr[count]);
                            //loans.println(num + " _ " + nameArr[count] + " _ " + ageArr[count] + " _ " + ageGroupArr[count] + " _ " + dobArr[count] + " _ " + addressArr[count]+ " _ " + phoneArr[count] + " _ " + idArr[count]);
                            num++;
                        }


                    }
                    count++;
                }

            }



        }

        if(response == 4){


            patronReply = patronReply.replaceAll("[^0-9]", "");


            int num = 1;
            int count = 0;

            while(count < rnum){

                tempArr[0] = dobArr[count];

                String nameNew = Arrays.toString(tempArr);
                String temp;

                //non letters and spaces remove
                temp = nameNew.replaceAll("[^0-9]", "");
                nameNew = temp;




                if(patronReply.equals(nameNew)){
                    dm.addElement(num + "_" + nameArr[count] + "_" + ageArr[count] + "_" + ageGroupArr[count] + "_" + dobArr[count] + "_" + addressArr[count]+ "_" + phoneArr[count] + "_" + idArr[count]);
                    //loans.println(num + " _ " + nameArr[count] + " _ " + ageArr[count] + " _ " + ageGroupArr[count] + " _ " + dobArr[count] + " _ " + addressArr[count]+ " _ " + phoneArr[count] + " _ " + idArr[count]);
                }   num++;
                count++;
            }

        }
        
     in.close();
       
    response = 0;
        
    }
    
    public void editLoans() throws FileNotFoundException{
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
        
        
        //Loans.txt is opened
        File viewFile = new File("Loans.txt");
        Scanner in = new Scanner(viewFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        int count = 1;
        int rnum = 0;
        
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
        
        String oldpatronFile = patronArr[row] + dobArr[row] + "Id" + patronidArr[row];
        oldpatronFile = oldpatronFile.replaceAll("[^a-zA-Z0-9]", "");
        oldpatronFile = oldpatronFile + ".txt"; 
        System.out.println("old" + oldpatronFile);
        
        //patronName for searching is made
        String oldpatronName = patronArr[row].toLowerCase();
        oldpatronName = oldpatronName.replaceAll("[^a-z]", "");
        
        
        String mediaFile = materialArr[row] + mDateArr[row] + "Id" + materialIdArr[row];
        
        mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = mediaFile + ".txt";
        
        //patron
        patronArr[row] = patronname;
        dobArr[row] = patronDOB;
        patronidArr[row] = patronId;
        
        //patronFile name is deduced 
        patronFile = patronArr[row] + dobArr[row] + "Id" + patronidArr[row];
        patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = patronFile + ".txt";
        
        //patronName for searching is made
        String patronName = patronArr[row].toLowerCase();
        patronName = patronName.replaceAll("[^a-z]", "");
        
        //materialname for searching is made
        String materialname = materialArr[row].toLowerCase();
        materialname = materialname.replaceAll("[^a-z]", "");
        
        
        
        //write new info to mediaFile
        File inputMediaFile = new File(mediaFile);
        Scanner inMedia = new Scanner(inputMediaFile);
        PrintWriter outMedia = new PrintWriter("temp2.txt");
        while(inMedia.hasNextLine()){

            String nextline = inMedia.nextLine();
            arrLine2 = nextline.split("~");
            String person = arrLine2[2];
            String [] spliter = person.split("#");
            String name = spliter[0];
            name = person.toLowerCase();


            name = name.replaceAll("[^a-z]", "");

            if(name == null ? patronName == null : name.equals(oldpatronName)){
                arrLine2[2] = " " + patronArr[row] + "#" + dobArr[row] + "#" + patronidArr[row]+ "#" + outdateArr[row] + "#" + indateArr[row];

            }
            outMedia.println(mediaFile + "~" + arrLine2[1] + "~" + arrLine2[2]);
        }

        inMedia.close();
        outMedia.close();
        Files loans = new Files("temp2.txt", mediaFile);
        loans.fileReplace();
        
        while(count < rnum){
            out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                        outdateArr[count] + "~" + indateArr[count] + "~" + employeeArr[count] + "~" + employeeidArr[count]);
            count++;
        }

        in.close();
        out.close();
        
        Files Loans = new Files("temp.txt", "Loans.txt");
        Loans.fileReplace();
            
            
            //fixing all of the patron file mess
            File inputpatronFile = new File(patronFile);
            Scanner inPatron = new Scanner(inputpatronFile);
            PrintWriter outPatron = new PrintWriter("temp.txt");
            if(patronFile == null ? oldpatronFile == null : patronFile.equals(oldpatronFile)){


                while(inPatron.hasNextLine()){
                    String nextline = inPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];

                    String name = title.toLowerCase();

                    name = name.replaceAll("[^a-z0-9]", "");

                    if(name == null ? materialname == null : name.equals(materialname)){
                        arrLine2[1] = outdateArr[row];
                        arrLine2[3] = materialArr[row];
                        arrLine2[5] = indateArr[row];
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

            else{
                while(inPatron.hasNextLine()){
                    outPatron.println(inPatron.nextLine());

                }

                outPatron.println("Checkout date ~" + outdateArr[row] + "~ Material name ~" + materialArr[row] + "~ dueDate ~" + indateArr[row]);

                inPatron.close();
                outPatron.close();

                Files patron = new Files("temp.txt",patronFile);
                patron.fileReplace();

                File inputoldpatronFile = new File(oldpatronFile);
                Scanner inoldPatron = new Scanner(inputoldpatronFile);
                PrintWriter outoldPatron = new PrintWriter("temp.txt");

                 while(inoldPatron.hasNextLine()){
                    String nextline = inoldPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];

                    String name = title.toLowerCase();

                    name = name.replaceAll("[^a-z0-9]", "");


                    if(name == null ? materialname == null : name.equals(materialname)){
                        //outPatron.println("Checkout date ~" + outdateArr[response] + "~ Material name ~" + materialArr[response] + "~ dueDate ~" + indateArr[response]);
                    }

                    else{
                        outoldPatron.println(nextline);
                    }
                }

                inoldPatron.close();
                outoldPatron.close();
                Files patronold = new Files("temp.txt",oldpatronFile);
                patronold.fileReplace();
            }
            
            
    }
    
    /**
     * @param args the command line arguments
     */
    public void editLwindow(String selection, int number) {
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
            java.util.logging.Logger.getLogger(editLoansWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editLoansWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editLoansWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editLoansWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editLoansWindow(selection, number).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ageGroupButton;
    private javax.swing.JRadioButton agesButton;
    private javax.swing.JRadioButton dobButton;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton namesButton;
    private javax.swing.JLabel newPatronName;
    private javax.swing.JLabel oldPatronName;
    private javax.swing.ButtonGroup patronButtonGroup;
    private javax.swing.JList<String> patronList;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}