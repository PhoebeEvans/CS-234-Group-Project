/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oldLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phoeb
 */
public class LoansGUI extends javax.swing.JFrame {

    private int editRemove;
    private String searchPatron;
    private String searchMaterial;
    private int response;
    private String search;
    
    private String patronFile;
    private String mediaFile;
    private String materialFile;
    private int materialType;
    
    private String employeeName;
    private String employeeId;
    private String patronResponse;
    private String materialResponse;
    private String[] arrLine;
    private String[] arrLine2;
    private String patronReply;
    private String materialReply;
    private String[] tempNameArr;
    
    private String[] nameArr;
    private String[] idArr;
    private String[] ageArr;
    private String[] ageGroupArr;
    private String[] dobArr;
    private String[] addressArr;
    private String[] phoneArr;
    private String[] tempArr;
    
    private String[] titleArr;
    private String[] authorArr;
    private String[] dateArr;
    private String[] countryArr;
    private String[] genreArr; 
    private String[] idMArr;
    
    private int patronValue;
    private int materialValue;
    private String materialName;
    
    private String patronname;
    private String patronId;
    private String patronDOB;
    
    private String materialTypeName;
    private String materialDate;
    private String materialId;
    private String currentDate;
    private String dueDate;
    private int loanlength;
    
    private String[] materialArr;
    private String[] mDateArr;
    private String[] materialIdArr;
    private String[] patronArr;
    
    private String[] patronidArr;
    private String[] indateArr;
    private String[] outdateArr;
    private String[] employeeArr;
    private String[] employeeidArr;
    
    private int loan; 
    
    private String [][] table;
    private String [] columns = {"#", "Material Title","Material Date", "Material Id", "Patron", "Patron DOB" , "Patron Id", "Checkout Date", "Due date", "Employee Name", "Employee Id"};
    
    private DefaultListModel dm = new DefaultListModel();
    private DefaultListModel dm2 = new DefaultListModel();
    private DefaultListModel sm = new DefaultListModel();
    private DefaultListModel overDue = new DefaultListModel();
    
    private DefaultTableModel model = new DefaultTableModel(table, columns);
    /**
     * Creates new form LoansGUI
     * @throws java.io.FileNotFoundException
     */
    public LoansGUI() throws FileNotFoundException{
        initComponents();
        
        overdue();
        fileArr();
        
        model = new DefaultTableModel(table, columns);
        jTable1.setModel(model);
        
        loanMenu();
    }

    public void dates(){
        Age loandate = new Age();
        currentDate = loandate.getcurrentDate();
        dueDate = loandate.getreturnDate(loanlength);
    }
    
    public void overdue() throws FileNotFoundException{
        int value = 1000; 
        
        
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
        
        int rnum = 0;
        
        File inputFile = new File("Loans.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            indateArr[rnum] = arrLine[6];
            outdateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        int count = 0;
        while(count < rnum){
            String dueDate = outdateArr[count];
            Age returns = new Age();
            int due = returns.overDue(dueDate);
            if(due > 0){
                //the material is overdue
                overDue.clear();
                overDue.addElement(materialArr[count] + " is overdue by " + due + " days.\n");
                
                patronFile = patronArr[count] + dobArr[count] + "Id" + patronidArr[count];
                patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
                patronFile = patronFile + ".txt";
                
                patronname = patronArr[count];
                String patronName = patronname.replaceAll("[^a-z0-9]", "");
                
                mediaFile = materialArr[count] + mDateArr[count] + "Id" + materialIdArr[count];
                mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
                mediaFile = mediaFile + ".txt";
                
                materialName = materialArr[count];
                String materialname = materialName.replaceAll("[^a-z0-9]", "");
                
                currentDate = indateArr[count];
                dueDate = outdateArr[count];
                
                outdateArr[count] = dueDate + " overdue/" + due;
                out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                        indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                
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
                    
                    
                    if(name == null ? patronName == null : name.equals(patronName)){
                        
                        arrLine2[2] = arrLine2[2] + "#" + "overdue by " + due + " days. ";
                        System.out.println(materialName + " was loaned to " + patronname + " on " + currentDate + " it is due " + dueDate);
                        loan = 1;
                        

                    }
                    outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                }
                
                inMedia.close();
                outMedia.close();
                Files loans = new Files("temp.txt", mediaFile);
                loans.fileReplace();
                    
                    
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
                        
                        arrLine2[5] = arrLine[5] + "#" + "overdue by " + due + " days. ";
                        
                        loan = 1;
                        

                    }
                    //outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                }
                
                inPatron.close();
                outPatron.close();
                Files patrons = new Files("temp.txt",patronFile);
                patrons.fileReplace();    
                
                overDue o = new overDue(overDue);
                o.over(overDue);
        
        
                }
                else{
                    out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                }
                count++;    
            }
        
        in.close();
        out.close();
        Files loans = new Files("temp.txt", "Loans.txt");
        loans.fileReplace();
        
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButtonGroup = new javax.swing.ButtonGroup();
        addPatron = new javax.swing.ButtonGroup();
        booksMovies = new javax.swing.ButtonGroup();
        addMaterial = new javax.swing.ButtonGroup();
        searchLoansButtonGroup = new javax.swing.ButtonGroup();
        searchMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loansSearchGO = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        loansList = new javax.swing.JList<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        loansMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        viewLoans = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editRemoveLoans = new javax.swing.JPanel();
        editRemoveTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        editTable = new javax.swing.JTable();
        editRinstruct = new javax.swing.JLabel();
        refreshLoans = new javax.swing.JButton();
        addLoans = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        patronSearchField = new javax.swing.JTextField();
        searchPatrons = new javax.swing.JButton();
        namesButton = new javax.swing.JRadioButton();
        agesButton = new javax.swing.JRadioButton();
        ageGroupButton = new javax.swing.JRadioButton();
        dobButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        patronList = new javax.swing.JList<>();
        patronPicked = new javax.swing.JLabel();
        titleButton = new javax.swing.JRadioButton();
        authorButton = new javax.swing.JRadioButton();
        countryButton = new javax.swing.JRadioButton();
        publicationButton = new javax.swing.JRadioButton();
        genreButton = new javax.swing.JRadioButton();
        booksButton = new javax.swing.JRadioButton();
        moviesButton = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        materialsSearchField = new javax.swing.JTextField();
        searchMaterials = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        materialList = new javax.swing.JList<>();
        materialPicked = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        employeeNameR = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        employeeIdR = new javax.swing.JTextField();
        loanInfo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        preview = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        addL = new javax.swing.JMenuItem();
        removeL = new javax.swing.JMenuItem();
        editL = new javax.swing.JMenuItem();
        searchL = new javax.swing.JMenuItem();
        viewL = new javax.swing.JMenuItem();

        searchMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("Search Loans");

        loansSearchGO.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        loansSearchGO.setText("GO");
        loansSearchGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loansSearchGOActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Search");

        searchField.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        loansList.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        loansList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(loansList);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        searchLoansButtonGroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jRadioButton1.setText("Material Names");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        searchLoansButtonGroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jRadioButton2.setText("PatronNames");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        searchLoansButtonGroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jRadioButton3.setText("EmployeeNames");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        searchLoansButtonGroup.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jRadioButton4.setText("Due Dates");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        searchLoansButtonGroup.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jRadioButton5.setText("Checkout Dates");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchMenuLayout = new javax.swing.GroupLayout(searchMenu);
        searchMenu.setLayout(searchMenuLayout);
        searchMenuLayout.setHorizontalGroup(
            searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchMenuLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(searchMenuLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(loansSearchGO))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(searchMenuLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchMenuLayout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(100, 100, 100)
                        .addComponent(jRadioButton5))
                    .addComponent(jLabel1)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchMenuLayout.setVerticalGroup(
            searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton5))
                .addGap(38, 38, 38)
                .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(searchMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(loansSearchGO))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        loansMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel3.setText("Loans Menu");

        jButton2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton2.setText("Add Loans");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton3.setText("Remove Loans");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton4.setText("Edit Loans");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton5.setText("Search Loans");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jButton6.setText("View Loans");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oldLibrary/dextercabin.gif"))); // NOI18N

        javax.swing.GroupLayout loansMenuLayout = new javax.swing.GroupLayout(loansMenu);
        loansMenu.setLayout(loansMenuLayout);
        loansMenuLayout.setHorizontalGroup(
            loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loansMenuLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(23, 23, 23)
                .addGroup(loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        loansMenuLayout.setVerticalGroup(
            loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loansMenuLayout.createSequentialGroup()
                .addGroup(loansMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loansMenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(86, 86, 86)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17))
                .addGap(47, 47, 47)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        viewLoans.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel2.setText("View Loans");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout viewLoansLayout = new javax.swing.GroupLayout(viewLoans);
        viewLoans.setLayout(viewLoansLayout);
        viewLoansLayout.setHorizontalGroup(
            viewLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLoansLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(viewLoansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewLoansLayout.setVerticalGroup(
            viewLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLoansLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        editRemoveLoans.setBackground(new java.awt.Color(255, 255, 255));

        editRemoveTitle.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        editRemoveTitle.setText("Loans");

        editTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        editTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(editTable);

        editRinstruct.setText("Click on the part of the loan you want to edit. ");

        refreshLoans.setText("Refresh");
        refreshLoans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshLoansActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editRemoveLoansLayout = new javax.swing.GroupLayout(editRemoveLoans);
        editRemoveLoans.setLayout(editRemoveLoansLayout);
        editRemoveLoansLayout.setHorizontalGroup(
            editRemoveLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editRemoveLoansLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editRemoveTitle)
                .addGap(361, 361, 361))
            .addGroup(editRemoveLoansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(editRemoveLoansLayout.createSequentialGroup()
                .addGroup(editRemoveLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editRemoveLoansLayout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(refreshLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editRemoveLoansLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editRinstruct)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editRemoveLoansLayout.setVerticalGroup(
            editRemoveLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editRemoveLoansLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(editRemoveTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(editRinstruct)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(refreshLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        addLoans.setBackground(new java.awt.Color(255, 255, 255));
        addLoans.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addLoans.setPreferredSize(new java.awt.Dimension(750, 750));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel5.setText("Add Loans");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel6.setText("First, search for a patron and click on the patron's name to select them.");

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel7.setText("Patron Search");

        patronSearchField.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        patronSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patronSearchFieldMouseClicked(evt);
            }
        });
        patronSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patronSearchFieldActionPerformed(evt);
            }
        });

        searchPatrons.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        searchPatrons.setText("GO");
        searchPatrons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatronsActionPerformed(evt);
            }
        });

        namesButton.setBackground(new java.awt.Color(255, 255, 255));
        addPatron.add(namesButton);
        namesButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        namesButton.setText("Names");
        namesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesButtonActionPerformed(evt);
            }
        });

        agesButton.setBackground(new java.awt.Color(255, 255, 255));
        addPatron.add(agesButton);
        agesButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        agesButton.setText("Ages");
        agesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agesButtonActionPerformed(evt);
            }
        });

        ageGroupButton.setBackground(new java.awt.Color(255, 255, 255));
        addPatron.add(ageGroupButton);
        ageGroupButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        ageGroupButton.setText("Age Group");
        ageGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageGroupButtonActionPerformed(evt);
            }
        });

        dobButton.setBackground(new java.awt.Color(255, 255, 255));
        addPatron.add(dobButton);
        dobButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        dobButton.setText("DOB");
        dobButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel8.setText("Now, search for a material to loan.");

        patronList.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
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
        jScrollPane4.setViewportView(patronList);

        patronPicked.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        patronPicked.setText("Your patron is _____. To pick a different patron search and select again.");

        titleButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterial.add(titleButton);
        titleButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        titleButton.setText("Title");
        titleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleButtonActionPerformed(evt);
            }
        });

        authorButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterial.add(authorButton);
        authorButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        authorButton.setText("Author");
        authorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorButtonActionPerformed(evt);
            }
        });

        countryButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterial.add(countryButton);
        countryButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        countryButton.setText("Country");
        countryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryButtonActionPerformed(evt);
            }
        });

        publicationButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterial.add(publicationButton);
        publicationButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        publicationButton.setText("Publication Date");
        publicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicationButtonActionPerformed(evt);
            }
        });

        genreButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterial.add(genreButton);
        genreButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        genreButton.setText("Genre");
        genreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreButtonActionPerformed(evt);
            }
        });

        booksButton.setBackground(new java.awt.Color(255, 255, 255));
        booksMovies.add(booksButton);
        booksButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        booksButton.setText("Books");
        booksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksButtonActionPerformed(evt);
            }
        });

        moviesButton.setBackground(new java.awt.Color(255, 255, 255));
        booksMovies.add(moviesButton);
        moviesButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        moviesButton.setText("Movies");
        moviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moviesButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel10.setText("Select Books or Movies.");

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel11.setText("Material Search");

        materialsSearchField.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        materialsSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialsSearchFieldMouseClicked(evt);
            }
        });

        searchMaterials.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        searchMaterials.setText("GO");
        searchMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMaterialsActionPerformed(evt);
            }
        });

        materialList.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        materialList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        materialList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(materialList);

        materialPicked.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        materialPicked.setText("Your material is ______. To pick a different material search and select again.");

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel13.setText("Now, type the name and id number of the employee completed the checkout.");

        jLabel14.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel14.setText("If self-checkout was used type self-checkout as the name and 000 as the id number.");

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel15.setText("Employee name:");

        employeeNameR.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        employeeNameR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameRActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel16.setText("Employee Id Number");

        employeeIdR.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        employeeIdR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdRActionPerformed(evt);
            }
        });

        loanInfo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        loanInfo.setText("???? is being loaned to ???? on ????? by ????. ????? is due on ????.");

        jLabel18.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel18.setText("Click the save button to complete the loan.");

        jButton1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel9.setText("Click Preview to preview your loan.");

        preview.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        preview.setText("Preview");
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addLoansLayout = new javax.swing.GroupLayout(addLoans);
        addLoans.setLayout(addLoansLayout);
        addLoansLayout.setHorizontalGroup(
            addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLoansLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addLoansLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(namesButton)
                        .addGap(89, 89, 89)
                        .addComponent(agesButton)
                        .addGap(85, 85, 85)
                        .addComponent(ageGroupButton)
                        .addGap(100, 100, 100)
                        .addComponent(dobButton))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(addLoansLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addLoansLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addLoansLayout.createSequentialGroup()
                        .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeNameR, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(employeeIdR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(materialPicked)
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(patronSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPatrons))
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(addLoansLayout.createSequentialGroup()
                                        .addComponent(patronPicked)
                                        .addGap(62, 62, 62))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addLoansLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addGap(58, 58, 58)
                                        .addComponent(booksButton)
                                        .addGap(29, 29, 29)))
                                .addComponent(moviesButton))
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(publicationButton)
                                .addGap(18, 18, 18)
                                .addComponent(genreButton))
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(titleButton))
                                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addLoansLayout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(authorButton)
                                        .addGap(53, 53, 53)
                                        .addComponent(countryButton))
                                    .addGroup(addLoansLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(materialsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchMaterials))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(preview)
                                .addComponent(loanInfo))
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jButton1))
                            .addGroup(addLoansLayout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel18))
                            .addComponent(jLabel9))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addLoansLayout.setVerticalGroup(
            addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLoansLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namesButton)
                    .addComponent(agesButton)
                    .addComponent(ageGroupButton)
                    .addComponent(dobButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patronSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPatrons)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patronPicked)
                .addGap(18, 18, 18)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(booksButton)
                    .addComponent(moviesButton)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleButton)
                    .addComponent(authorButton)
                    .addComponent(countryButton)
                    .addComponent(publicationButton)
                    .addComponent(genreButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(materialsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMaterials))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(materialPicked)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(employeeNameR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(employeeIdR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addLoansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(preview))
                .addGap(15, 15, 15)
                .addComponent(loanInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jMenu1.setText("Loans Menu");

        jMenuItem1.setText("Loans Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        addL.setText("Add Loans");
        addL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLActionPerformed(evt);
            }
        });
        jMenu1.add(addL);

        removeL.setText("Remove Loans");
        removeL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLActionPerformed(evt);
            }
        });
        jMenu1.add(removeL);

        editL.setText("Edit Loans");
        editL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLActionPerformed(evt);
            }
        });
        jMenu1.add(editL);

        searchL.setText("Search Loans");
        searchL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLActionPerformed(evt);
            }
        });
        jMenu1.add(searchL);

        viewL.setText("View All Loans");
        viewL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLActionPerformed(evt);
            }
        });
        jMenu1.add(viewL);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addLoans, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(searchMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loansMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 27, Short.MAX_VALUE)
                    .addComponent(viewLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editRemoveLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addLoans, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loansMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(viewLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editRemoveLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 838, 801);
    }// </editor-fold>//GEN-END:initComponents

    private void patronSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patronSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patronSearchFieldActionPerformed

    private void searchMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMaterialsActionPerformed
        // TODO add your handling code here:
        materialReply = materialsSearchField.getText();
        
        materialType();
        
        try {
            searchMaterials();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchMaterialsActionPerformed

    private void searchPatronsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatronsActionPerformed
        // TODO add your handling code here:
        patronReply = patronSearchField.getText();
        
        try {
            searchPatrons();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchPatronsActionPerformed

    private void searchLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLActionPerformed
        // TODO add your handling code here:
        searchLoanMenu();
    }//GEN-LAST:event_searchLActionPerformed

    private void addLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLActionPerformed
        // TODO add your handling code here:
        addLoanMenu();
        
    }//GEN-LAST:event_addLActionPerformed

    private void removeLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLActionPerformed
        try {
            // TODO add your handling code here:
            removeLoanMenu();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeLActionPerformed

    private void editLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLActionPerformed
        try {
            // TODO add your handling code here:
            editLoanMenu();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editLActionPerformed

    private void viewLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLActionPerformed
        try {
            // TODO add your handling code here:
            viewLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewLActionPerformed

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

    private void booksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksButtonActionPerformed
        // TODO add your handling code here:
        materialType = 1;
    }//GEN-LAST:event_booksButtonActionPerformed

    private void moviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moviesButtonActionPerformed
        // TODO add your handling code here:
        materialType = 2;
    }//GEN-LAST:event_moviesButtonActionPerformed

    private void titleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleButtonActionPerformed
        // TODO add your handling code here:
        response = 1;
    }//GEN-LAST:event_titleButtonActionPerformed

    private void authorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorButtonActionPerformed
        // TODO add your handling code here:
        response = 2;
    }//GEN-LAST:event_authorButtonActionPerformed

    private void countryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryButtonActionPerformed
        // TODO add your handling code here:
        response = 4;
    }//GEN-LAST:event_countryButtonActionPerformed

    private void publicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicationButtonActionPerformed
        // TODO add your handling code here:
        response = 3;
    }//GEN-LAST:event_publicationButtonActionPerformed

    private void genreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreButtonActionPerformed
        // TODO add your handling code here:
        response = 5;
    }//GEN-LAST:event_genreButtonActionPerformed

    private void patronListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patronListMouseClicked
        // TODO add your handling code here:
        DefaultListModel listModel = (DefaultListModel) patronList.getModel();
        patronValue = patronList.getSelectedIndex();
        
        patronResponse = patronList.getSelectedValue();
        
        parsePatron();
        
        patronPicked.setText("Your patron is " + patronname + ". To pick a different patron search and select again.");
        
    }//GEN-LAST:event_patronListMouseClicked

    private void materialListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialListMouseClicked
        // TODO add your handling code here:
        DefaultListModel listModel = (DefaultListModel) materialList.getModel();
        materialValue = materialList.getSelectedIndex();
        
        materialResponse = materialList.getSelectedValue();
        
        parseMaterial();
        
        materialPicked.setText("Your " + materialTypeName + " is " + materialName + ". To pick a different " + materialTypeName + " search and select again.");
    }//GEN-LAST:event_materialListMouseClicked

    private void employeeNameRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameRActionPerformed
        // TODO add your handling code here:
        employeeName = employeeNameR.getText();
    }//GEN-LAST:event_employeeNameRActionPerformed

    private void employeeIdRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdRActionPerformed
        // TODO add your handling code here:
        employeeId = employeeIdR.getText();
        
    }//GEN-LAST:event_employeeIdRActionPerformed

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
        // TODO add your handling code here:
        employeeName = employeeNameR.getText();
        employeeId = employeeIdR.getText();
        
        dates();
        
        loanInfo.setText(materialName+ " is being loaned to " + patronname + " on " + currentDate + " by " + employeeName + ". " + materialName + " is due on " + dueDate + ".");
    }//GEN-LAST:event_previewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(employeeNameR.getText().isEmpty() || employeeIdR.getText().isEmpty()){
            new error().setVisible(true);
            
        }
        
        else{
            try {
                // TODO add your handling code here:
                addLoans();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            clearAdd();

            if(loan == 0){
                System.out.println("sorry");
            }

            else if(loan != 0){
                loanMenu();
            }
        }
            
            
            
        dm.clear();
        dm2.clear();
        patronSearchField.setText("");
        materialsSearchField.setText("");
        employeeNameR.setText("");
        employeeIdR.setText("");
        
        namesButton.setSelected(false);
        agesButton.setSelected(false);
        ageGroupButton.setSelected(false);
        dobButton.setSelected(false);
        
        titleButton.setSelected(false);
        authorButton.setSelected(false);
        countryButton.setSelected(false);
        publicationButton.setSelected(false);
        genreButton.setSelected(false);
        
        booksButton.setSelected(false);
        moviesButton.setSelected(false);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addLoanMenu();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            removeLoanMenu();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            editLoanMenu();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        searchLoanMenu();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            viewLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        loanMenu();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void loansSearchGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loansSearchGOActionPerformed
        // TODO add your handling code here:
        search = searchField.getText();
        
        try {
            searchLoans();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loansSearchGOActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        response = 5;
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        response = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        response = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        response = 3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        response = 4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void editTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tb1Model = (DefaultTableModel)editTable.getModel();
        
        int cValue = editTable.getSelectedColumn();
        String selection = (String) tb1Model.getValueAt(editTable.getSelectedRow(), cValue);
        //System.out.println(selection);
        
        String n = (String)tb1Model.getValueAt(editTable.getSelectedRow(),0);
        ///System.out.println(n);
        int numb = Integer.parseInt(n);
        
        
        
        if(editRemove == 1){
            //remove
            
            try {
                removeLoanWindow removeW = new removeLoanWindow(numb);
                removeW.removeLwindow(numb);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(patronGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(editRemove == 0){
            
            //materialsEdit
            if(cValue == 1 || cValue == 2 || cValue == 3){
                editLoansMWindow editM = new editLoansMWindow(selection, numb);
                editM.editMwindow(selection, numb);
            }

            else if(cValue == 4 || cValue == 5 || cValue == 6){
                editLoansWindow editL = new editLoansWindow(selection, numb);
                editL.editLwindow(selection, numb);
            }
            
            //due date and return
            else if(cValue == 7 || cValue == 8){
                selection = (String) tb1Model.getValueAt(editTable.getSelectedRow(), 8);
                editDatesWindow editD = new editDatesWindow(numb, selection);
                editD.editLwindow(numb, selection);
            }
            
            //employee info if time allows
            else if(cValue == 9 || cValue == 10){
                
            }
            
        }
        
    }//GEN-LAST:event_editTableMouseClicked

    private void patronSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patronSearchFieldMouseClicked
        // TODO add your handling code here:
        dm.clear();
    }//GEN-LAST:event_patronSearchFieldMouseClicked

    private void materialsSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialsSearchFieldMouseClicked
        // TODO add your handling code here:
        dm2.clear();
    }//GEN-LAST:event_materialsSearchFieldMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        // TODO add your handling code here:
        sm.clear();
    }//GEN-LAST:event_searchFieldMouseClicked

    private void refreshLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshLoansActionPerformed

        try {
            // TODO add your handling code here:
            fileArr();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model = new DefaultTableModel(table, columns);
        editTable.setModel(model);
    }//GEN-LAST:event_refreshLoansActionPerformed

    public void fileArr() throws FileNotFoundException{
        File viewFile = new File("Loans.txt");
        Scanner in = new Scanner(viewFile);
        
        int value = 100; 
        
        int rnum = 0;
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
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            indateArr[rnum] = arrLine[6];
            outdateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
          
        }
        
        
        table = new String[rnum][11];
        int count = 0;
        while(count < rnum){
            table[count][0] = Integer.toString(count+1);
            table[count][1] = materialArr[count];
            table[count][2] = mDateArr[count];
            table[count][3] = materialIdArr[count];
            table[count][4] = patronArr[count];
            table[count][5] = dobArr[count];
            table[count][6] = patronidArr[count];
            table[count][7] = indateArr[count];
            table[count][8] = outdateArr[count];
            table[count][9] = employeeArr[count];
            table[count][10] = employeeidArr[count];
            count++;
        }
        
        
    }
    
    
    public void searchLoans() throws FileNotFoundException{
        int rnum = 0;
        File inputFile = new File("Loans.txt");
        Scanner in = new Scanner(inputFile);
        
        
        
        
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            indateArr[rnum] = arrLine[6];
            outdateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        loansList.setModel(sm);
        
        //director searcher
            if(response == 1){
                String resp = search;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = materialArr[count];
                        
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
                                sm.addElement(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //patron searcher
            if(response == 2){
                String resp = search;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = patronArr[count];
                        
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
                                sm.addElement(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            
            //employee searcher
            if(response == 3){
                
                String resp = search;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = employeeArr[count];
                        
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
                                sm.addElement(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //due date searcher
            if(response == 4){
                
                String resp = search;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = outdateArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                sm.addElement(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //due date searcher
            if(response == 5){
                
                String resp = search;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = indateArr[count];
                        
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
                                sm.addElement(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
    }
    
    public void clearAdd(){
        loanInfo.setText("");
        employeeNameR.setText("");
        employeeIdR.setText("");
        
        materialPicked.setText("");
        patronPicked.setText("");
        patronSearchField.setText("");
        materialsSearchField.setText("");
    }
    
    
    public void parsePatron(){
        arrLine = patronResponse.split("_");
        
        patronFile = arrLine[1] + arrLine[4] + "Id" + arrLine[7]; 
        String rePlace = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = rePlace;
        String temp1 = patronFile +".txt";
        patronFile = temp1; 
        patronname = arrLine[1];
        patronId = arrLine[7];
        patronDOB = arrLine[4];
        
    }
    
    public void parseMaterial(){
        arrLine = materialResponse.split("~");
        
        //System.out.println(arrLine);

        //find file name 
        mediaFile = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
        String rePlace2 = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = rePlace2;
        String temp3 = mediaFile +".txt";
        mediaFile = temp3;
        materialName = arrLine[1];
        materialDate = arrLine[3];
        materialId = arrLine[6];
    }
    
    public void materialType(){
        if(materialType == 1){
            materialFile = "BooksList.txt";
            materialTypeName = "Book";
            loanlength = 14;
        }
        
        else if(materialType == 2){
            materialFile = "MoviesList.txt";
            materialTypeName = "Movie";
            loanlength = 3;
        }
    }
    
    public void searchMaterials() throws FileNotFoundException{
        int rnum = 0;
        
        
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        
        int value = 1000;
        
        titleArr = new String[value];
        authorArr = new String[value];
        dateArr = new String[value];
        countryArr = new String[value];
        genreArr = new String[value];
        idMArr = new String[value];
        arrLine = new String[7]; 
        tempNameArr = new String[1];
        
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            arrLine = lineChange.split("~");
            
            titleArr[rnum] = arrLine[1];
            authorArr[rnum] = arrLine[2];
            dateArr[rnum] = arrLine[3];
            countryArr[rnum] = arrLine[4];
            genreArr[rnum] = arrLine[5];
            idMArr[rnum] = arrLine[6];
            
            rnum++;
        }
        
        materialList.setModel(dm2);
        
        //director searcher
            if(response == 1){
                
                String resp = materialReply;
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    int numb = 1;
                    int count = 0;

                    while(count < rnum){

                        tempNameArr[0] = titleArr[count];

                        String directorNew = Arrays.toString(tempNameArr);
                        
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
                                dm2.addElement(numb + " ~ " + titleArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idMArr[count]);
                                //loans.println(numb + " ~ " + nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idArr[count]);
                                numb++;
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                 
            }

            //director searcher
            if(response == 2){
                
                String resp = materialReply;
                
                String split[] = resp.split(" ", 0);
                for(String resp2: split){
                
                    String temp2 = resp2.toLowerCase();
                    resp2 = temp2;

                    temp2 = resp2.replaceAll("^a-z0-9", "");
                    resp2 = temp2; 

                    //System.out.println("in " + resp2);
                    
                    int numb = 1;
                    int count = 0;

                    while(count < rnum){

                        tempNameArr[0] = authorArr[count];

                        String directorNew = Arrays.toString(tempNameArr);
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^a-z0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp2.equals(dNew)){
                                dm2.addElement(numb + " ~ " + titleArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idMArr[count]);
                                //loans.println(numb + " ~ " + nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idArr[count]);
                                numb++;
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                 
            }
            
            //age searcher
            if(response == 3){
                
                int ageInt = Integer.parseInt(materialReply);
                int count = 0;
                int numb = 1;
                
                while(count  < rnum){
                    
                    tempNameArr[0] = dateArr[count];

                    String dateNew = Arrays.toString(tempNameArr);
                    String temp;
                    temp = dateNew.replaceAll("[^0-9]", "");
                    dateNew = temp;
                    
                    int intAge = Integer.parseInt(dateNew);

                    if(ageInt == intAge){
                        dm2.addElement(numb + " ~ " + titleArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idMArr[count]);
                        //loans.println(numb + " ~ " + nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idArr[count]);
                        numb++;
                    }
                    count++;

                }
                
                
                
            }
            
            //country searcher
            
            if(response == 4){
                String resp = materialReply;
                
                String split[] = resp.split(" ", 0);
                for(String resp4: split){
                
                    String temp4 = resp4.toLowerCase();
                    resp4 = temp4;

                    temp4 = resp4.replaceAll("^a-z0-9", "");
                    resp4 = temp4; 

                    //System.out.println("in " + resp2);
                    
                    int numb = 1;
                    int count = 0;

                    while(count < rnum){

                        tempNameArr[0] = countryArr[count];

                        String directorNew = Arrays.toString(tempNameArr);
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String cNew: spliter){
                            String temp;

                            temp = cNew.toLowerCase();
                            cNew = temp; 

                            //non letters and spaces remove
                            temp = cNew.replaceAll("[^a-z0-9]", "");
                            cNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp4.equals(cNew)){
                                dm2.addElement(numb + " ~ " + titleArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idMArr[count]);
                                //loans.println(numb + " ~ " + nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idArr[count]);
                                numb++;
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
            
            }
            //genre searcher
            //director searcher
            if(response == 5){
                
                String respG = materialReply;
                
                String split5[] = respG.split(" ", 0);
                for(String resp5: split5){
                
                    String temp5 = resp5.toLowerCase();
                    resp5 = temp5;

                    temp5 = resp5.replaceAll("^a-z0-9", "");
                    resp5 = temp5; 

                    //System.out.println("in " + resp2);
                    
                    int numb = 1;
                    int count = 0;

                    while(count < rnum){

                        tempNameArr[0] = genreArr[count];

                        String directorNew = Arrays.toString(tempNameArr);
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String gNew: spliter){
                            String temp;

                            temp = gNew.toLowerCase();
                            gNew = temp; 

                            //non letters and spaces remove
                            temp = gNew.replaceAll("[^a-z0-9]", "");
                            gNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp5.equals(gNew)){
                                dm2.addElement(numb + " ~ " + titleArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count] + " ~ " + idMArr[count]);
                                
                                numb++;
                            }
                            
                        
                        }
                        count++;
                    }
                }
            }
            
        
     in.close();
        
        
    }
    
    public void addLoans() throws FileNotFoundException{
        //print info to mediaFile
        FileInputStream inputMediaFile = new FileInputStream(mediaFile);
        Scanner inMedia = new Scanner(inputMediaFile);
        PrintWriter outMedia = new PrintWriter("temp.txt");
        
        //loan is 0 because media has not been loaned
        loan = 0;
        
        //while the mediaFile has a next Line
        while(inMedia.hasNextLine()){
            
            //next line = next line in mediaFile
            String nextline = inMedia.nextLine();
            
            //splits nextline into an array
            arrLine2 = nextline.split("~");
            
            //the avalibility part is arrLine2[1]
            String avalibility = arrLine2[1];
            
            //non letters and spaces remove
            avalibility = avalibility.replaceAll("[^0-9]", "");
           
            //converts to an Integer
            int aval = Integer.parseInt(avalibility);
            
            //if the material has not been loaned yet.
            if(loan == 0){
                //if the copy is avalible
                if(aval == 0){
                    //updates info
                    arrLine2[2] = " " + patronname + " # " + patronDOB + " # " + patronId+ " # " + currentDate+ " # " + dueDate;
                    arrLine2[1] = "1";
                    
                    //prints loan
                    //System.out.println(materialName + " was loaned to " + patronname + " on " + outDate + " it is due " + inDate);
                    
                    //changes loan status so that all copies are not loaned. 
                    loan = 1;
                }
                
            }
            
            //line is printed
            outMedia.println(arrLine2[0] + "~" + arrLine2[1] + "~" + arrLine2[2]);
        }
        
        //if after all copies have been checked there are no avalible copies
        if(loan == 0){
            //print sorry
            System.out.println("Sorry, no copies of " + materialName + " were avalible.\n");
            copiesError c = new copiesError(materialName);
            c.error(materialName);
        }
        //close files
        inMedia.close();
        outMedia.close();
        
        //replace files
        Files media = new Files("temp.txt",mediaFile);
        media.fileReplace();
        
        //writing patron file only if the material has been loaned
        if(loan != 0){
            File inputpatronFile = new File(patronFile);
            Scanner inPatron = new Scanner(inputpatronFile);
            PrintWriter outPatron = new PrintWriter("temp.txt");

            while(inPatron.hasNextLine()){
                outPatron.println(inPatron.nextLine());
            }
            outPatron.println("Checkout date~" + currentDate + "~Material name~" + materialName + "~ dueDate ~" + dueDate);

            inPatron.close();
            outPatron.close();
            Files patrons = new Files("temp.txt",patronFile);
            patrons.fileReplace();
            
            
            //print info to Loans.txt
            File inputL = new File("Loans.txt");
            Scanner inL = new Scanner(inputL);
            PrintWriter outL = new PrintWriter("temp.txt");
            while(inL.hasNextLine()){
            outL.println(inL.nextLine());
            }
            outL.println(materialName + "~" + materialDate + "~" + materialId + "~" + patronname + "~" + patronDOB + "~" + patronId + "~" + currentDate + "~" + dueDate + "~" + employeeName + "~" + employeeId);

            inL.close();
            outL.close();
            Files loans = new Files("temp.txt","Loans.txt");
            loans.fileReplace();
        }
        
        
        
        
        
    }
    
    public void searchPatrons() throws FileNotFoundException{
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
    
    
     public void searchLoanMenu(){
        addLoans.setVisible(false);
        searchMenu.setVisible(true);
        loansMenu.setVisible(false);
        editRemoveLoans.setVisible(false);
        
        viewLoans.setVisible(false);
        searchMenu.setVisible(true);
        //searchPanel.setVisible(true);
        
    }
     
    public void addLoanMenu(){
        addLoans.setVisible(true);
        searchMenu.setVisible(false);
        loansMenu.setVisible(false);
        editRemoveLoans.setVisible(false);
        
        viewLoans.setVisible(false);
        //searchLoans.setVisible(false);
        //searchPanel.setVisible(false);
    }
    
    public void editLoanMenu() throws FileNotFoundException{
        fileArr();
        model = new DefaultTableModel(table,columns);
        editTable.setModel(model);
        
        editRemoveTitle.setText("Edit Loans");
        editRinstruct.setText("Click on the part of the loan you wish to edit. To return, click on the date. ");
        
        editRemove = 0;
        addLoans.setVisible(false);
        loansMenu.setVisible(false);
        editRemoveLoans.setVisible(true);
        
        viewLoans.setVisible(false);
        searchMenu.setVisible(false);
        //searchPanel.setVisible(false);
    }
    
    public void removeLoanMenu() throws FileNotFoundException{
        fileArr();
        model = new DefaultTableModel(table,columns);
        editTable.setModel(model);
        
        editRemoveTitle.setText("Remove Loans");
        editRinstruct.setText("Click on the loan you wish to remove. ");
        
        editRemove = 1;
        
        addLoans.setVisible(false);
        loansMenu.setVisible(false);
        editRemoveLoans.setVisible(true);
        
        viewLoans.setVisible(false);
        searchMenu.setVisible(false);
        //searchPanel.setVisible(false);
    }
    
    public void loanMenu(){
        addLoans.setVisible(false);
        loansMenu.setVisible(true);
        editRemoveLoans.setVisible(false);
        
        viewLoans.setVisible(false);
        searchMenu.setVisible(false);
        //searchPanel.setVisible(false);
    }
    
    public void viewLoans() throws FileNotFoundException{
        fileArr();
        
        model = new DefaultTableModel(table, columns);
        jTable1.setModel(model);
        
        
        addLoans.setVisible(false);
        loansMenu.setVisible(false);
        editRemoveLoans.setVisible(false);
        
        viewLoans.setVisible(true);
        searchMenu.setVisible(false);
        //searchPanel.setVisible(false);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public void loansRun() {
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
            java.util.logging.Logger.getLogger(LoansGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoansGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoansGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoansGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoansGUI().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoansGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addL;
    private javax.swing.JPanel addLoans;
    private javax.swing.ButtonGroup addMaterial;
    private javax.swing.ButtonGroup addPatron;
    private javax.swing.JRadioButton ageGroupButton;
    private javax.swing.JRadioButton agesButton;
    private javax.swing.JRadioButton authorButton;
    private javax.swing.JRadioButton booksButton;
    private javax.swing.ButtonGroup booksMovies;
    private javax.swing.JRadioButton countryButton;
    private javax.swing.JRadioButton dobButton;
    private javax.swing.JMenuItem editL;
    private javax.swing.JPanel editRemoveLoans;
    private javax.swing.JLabel editRemoveTitle;
    private javax.swing.JLabel editRinstruct;
    private javax.swing.JTable editTable;
    private javax.swing.JTextField employeeIdR;
    private javax.swing.JTextField employeeNameR;
    private javax.swing.JRadioButton genreButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loanInfo;
    private javax.swing.JList<String> loansList;
    private javax.swing.JPanel loansMenu;
    private javax.swing.JButton loansSearchGO;
    private javax.swing.JList<String> materialList;
    private javax.swing.JLabel materialPicked;
    private javax.swing.JTextField materialsSearchField;
    private javax.swing.JRadioButton moviesButton;
    private javax.swing.JRadioButton namesButton;
    private javax.swing.JList<String> patronList;
    private javax.swing.JLabel patronPicked;
    private javax.swing.JTextField patronSearchField;
    private javax.swing.JButton preview;
    private javax.swing.JRadioButton publicationButton;
    private javax.swing.JButton refreshLoans;
    private javax.swing.JMenuItem removeL;
    private javax.swing.ButtonGroup searchButtonGroup;
    private javax.swing.JTextField searchField;
    private javax.swing.JMenuItem searchL;
    private javax.swing.ButtonGroup searchLoansButtonGroup;
    private javax.swing.JButton searchMaterials;
    private javax.swing.JPanel searchMenu;
    private javax.swing.JButton searchPatrons;
    private javax.swing.JRadioButton titleButton;
    private javax.swing.JMenuItem viewL;
    private javax.swing.JPanel viewLoans;
    // End of variables declaration//GEN-END:variables
}
