package com.mycompany.cs234project;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoeb
 */
public class Materials {
    
    private int materialType = 1;
    private String name = "";
    private String authors = "";
    private int publicationDate = 0;
    private String country = "";
    private int genreInt = 0;
    private String genre = "";
    private int rnum = 1;
    private String iD = "";
    private String mediaFile = "";
    private String materialFile = "MoviesList.txt";
    private String[] arrLine;
    private String oldFilename;
    private String[] nameArr;
    private String[] authorArr;
    private String[] dateArr;
    private String[] countryArr;
    private String[] genreArr; 
    private String[] tempNameArr;
    private String idFile;
    private int copies;
   
    /**
     *
     * @param materialFile
     * @param materialType
     * @throws FileNotFoundException
     */
    
    public void setmaterialFile(String materialFile){
        this.materialFile = materialFile;
    }
    
    public void setmaterialType(int materialType){
        this.materialType = materialType;
    }
    
    public void copies(String fileName) throws FileNotFoundException{
        IntCreate material = new IntCreate();
        copies = material.intC("How many copies do you have? ");
        
        //people.txt and temp.txt are opened
        File inputFile = new File(fileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
      
        rnum = 1;
        while(rnum <= copies){
            out.println(fileName + "~ 1");
            rnum++;
        }
        
        //close both files so they are not cleared. 
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , fileName);
        
    }
    public void addMaterial()throws FileNotFoundException {
        //name
        
        StringCreate material = new StringCreate();
        IntCreate numb = new IntCreate();
           
        if(materialType == 1){
            //name
            name = material.stringC("Please type the name of the book: ");


            //authors
            authors = material.stringC("Please type the name of the author of the book: ");


            //Publication Date

            publicationDate = numb.intC("Please type the year of publication of the book: ");

            //country of origin 
            country = material.stringC("Please type country of origin of the book: ");

            //genre
            genreInt = numb.intC("Please type 1 if the book is nonfiction and 2 if the book is fiction. ");
        }
        
        
        if(materialType == 2){
            //name
            name = material.stringC("Please type the name of the movie: ");


            //authors
            authors = material.stringC("Please type the name of the director of the movie: ");


            //Publication Date
            
            publicationDate = numb.intC("Please type the year of publication of the movie: ");

            //country of origin 
            country = material.stringC("Please type country of origin of the movie: ");

            //genre
            genreInt = numb.intC("Please type 1 if the movie is nonfiction and 2 if the movie is fiction. ");
        }
        
        if(genreInt == 1){
            genre = "nonfiction";
        }
        
        if(genreInt == 2){
            genre = "fiction";
        }
        
        
        
        //people.txt and temp.txt are opened
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
      
        rnum = 1;
        //read the input and write the output
        while(in.hasNextLine()){
            //replace all of the existing users
            out.println(in.nextLine());
            
            //increment rnum 
            rnum ++;
        }
        
        
        if(materialType == 1){
            idFile = "idList3.txt";
            
        }
        
        else if(materialType == 2){
            idFile = "idList1.txt";
        }
        
        idCreate create = new idCreate();
        iD = create.idCreate("000", idFile);
        
        
        fileReplace2 replace = new fileReplace2();
        replace.fileReplace2( "temp2.txt" , idFile);
        
        
        //print new user's information to temp.txt 
        out.println(rnum +  " ~ " + name + " ~ " + authors + " ~ " + publicationDate + " ~ " + country + " ~ " + genre + " ~ " + iD);
        
        //close both files so they are not cleared. 
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , materialFile);
        
        //creates file for movie. 
        
        mediaFile = name + publicationDate + "Id" + iD; 
        //Trims whitespace and characters other than letters and numbers
        String rePlace = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = rePlace; 
        String tempString = mediaFile + ".txt";
        mediaFile = tempString;
        
        //Creates file with fileCreate 
        fileCreate createFile = new fileCreate();      
        createFile.fileCreate(mediaFile);
        
        copies(mediaFile);
        
        
    }
    
    public void removeMaterial() throws FileNotFoundException{
        /*read name to be removed*/
        rnum = 1;
        
        if(materialType == 1){
            System.out.println("Please number of the book to remove ");
        }
        
        else if(materialType == 2){
            System.out.println("Please number of the movies to remove ");
        }
        Scanner delete = new Scanner(System.in);
        int response = delete.nextInt();
        
        
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        //read the input and write the output
        while(in.hasNextLine()){
            if(response == in.nextInt()){
                //out.printf("");
                System.out.println(in.nextLine()+" is being removed. ");
            }

            else{
                out.println(rnum + in.nextLine());
                //System.out.println("keep " + in.nextLine());
                rnum ++;
            }
        }
        
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , materialFile);
        

    }
    
    public void editMaterial() throws FileNotFoundException{
        //name
        if(materialType == 1){
            System.out.println("Please type the number of the book you want to edit ");
        }
        
        if(materialType == 2){
            System.out.println("Please type the number of the movie you want to edit ");
        }
        Scanner numb = new Scanner(System.in);
        int response = numb.nextInt();
        
        rnum = 1;
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
         
        
       //read the input and write the output
        while(in.hasNextLine() && in.hasNextInt()){
            if(response == in.nextInt()){
                String lineChange = in.nextLine();
                System.out.println(lineChange);
                
                arrLine = new String[7];
                arrLine = lineChange.split("~");
                
                //find file name 
                oldFilename = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
                String rePlace2 = oldFilename.replaceAll("[^a-zA-Z0-9]", "");
                oldFilename = rePlace2;
                String temp3 = oldFilename +".txt";
                oldFilename = temp3; 
               
                
                
                int loop2 = 1;
                
                while(loop2 == 1 ){
                    
                    System.out.println("What part do you want to edit? ");
                    
                    if(materialType == 1){
                        System.out.println("Type 1 to edit the name of the book. ");
                        System.out.println("Type 2 to edit the name of the author of the book. ");
                        System.out.println("Type 3 to edit the date of the book. ");
                        System.out.println("Type 4 to edit the country of the book. ");
                    }
                    
                    if(materialType == 2){
                        System.out.println("Type 1 to edit the name of the movie. ");
                        System.out.println("Type 2 to edit the name of the director of the movie. ");
                        System.out.println("Type 3 to edit the date of the movie. ");
                        System.out.println("Type 4 to edit the country of the movie. ");
                    }
                    //scan
                    Scanner pick = new Scanner(System.in);
                    int pick2 = pick.nextInt();
                
                    StringCreate material = new StringCreate();
                    if(pick2 == 1){
                        System.out.println(" Name Change ");
                        System.out.println("Current Name is: " + arrLine[1]);

                        
        
                        //name
                        arrLine[1] = " " + material.stringC("Please type the name: ") + " ";
                        System.out.println(arrLine[1]);
                        
                        
                        loop2 = 0;
                    }

                    
                    
                    if(pick2 == 2){
                        
                        if(materialType == 1){
                            System.out.println("Author Name Change ");
                            System.out.println("Current Author Name is: " + arrLine[2]);
                        }
                        
                        if(materialType == 2){
                            System.out.println(" Director Name Change ");
                            System.out.println("Current Director Name is: " + arrLine[2]);
                        }
                        

                        arrLine[2] = material.stringC("Please type the new name: ");
                        System.out.println(arrLine[2]);
                        
                        
                        loop2 = 0;
                    }
                    
                    
                    
                    if(pick2 == 3){
                        System.out.println(" Date Change ");
                        System.out.println("Current Date is: " + arrLine[3]);

                        //int string conflict maybe??
                        arrLine[3] = material.stringC("Please type the date: ");
                        System.out.println(arrLine[3]);
                        
                        loop2 = 0;
                    }
                    
                    if(pick2 == 4){
                        System.out.println(" Country of Origin Change ");
                        System.out.println("Current Country of Origin is: " + arrLine[4]);

                        arrLine[4] = material.stringC("Please type the country: ");
                        System.out.println(arrLine[4]);
                        
                        
                        loop2 = 0;
                    }

                    
                }
                
                out.println(rnum + " ~" + arrLine[1] + "~" + arrLine[2] + "~" + arrLine[3] + "~" + arrLine[4] + "~" + arrLine[5]+ "~" + arrLine[6]);
                rnum ++;
                
                
                iD = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
                //Trims whitespace and characters other than letters and numbers
                String rePlace = iD.replaceAll("[^a-zA-Z0-9]", "");
                iD = rePlace; 
                String temp = iD + ".txt";
                iD = temp;

                //Creates file with fileCreate 
                fileCreate createFile = new fileCreate();      
                createFile.fileCreate(iD);
                
                fileReplace2 replace2 = new fileReplace2();
                replace2.fileReplace2( oldFilename ,iD);
                    
            }

            else{
                out.println(rnum + in.nextLine());
                //System.out.println("keep " + in.nextLine());
                rnum ++;
            }
        }
        
        
        
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , materialFile);
        

    }
    
    public void searchMaterials() throws FileNotFoundException{
        
        int num = 0;
        
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        int value = 100; 
        
        
        nameArr = new String[value];
        authorArr = new String[value];
        dateArr = new String[value];
        countryArr = new String[value];
        genreArr = new String[value]; 
        tempNameArr = new String[1];
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            String[] arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            
            nameArr[num] = arrLine[1];
            authorArr[num] = arrLine[2];
            dateArr[num] = arrLine[3];
            countryArr[num] = arrLine[4];
            genreArr[num] = arrLine[5];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            num++;
          
        }
        int cnum = 1;
        while(cnum == 1){
            if(materialType == 1){
                System.out.println("Please type the catagory you are searching. ");
                System.out.println("Please type 1 to search names of books. ");
                System.out.println("Please type 2 to search for authors. ");
                System.out.println("Please tpye 3 to search dates. ");
                System.out.println("Please type 4 to search for countries. ");
                System.out.println("Please type 5 to search genre: ");
            }
            
            if(materialType == 2){
                System.out.println("Please type the catagory you are searching. ");
                System.out.println("Please type 1 to search names of movies. ");
                System.out.println("Please type 2 to search for directors. ");
                System.out.println("Please tpye 3 to search dates of publication. ");
                System.out.println("Please type 4 to search for countries of origin. ");
                System.out.println("Please type 5 to search genre: ");
            }
            

            Scanner number = new Scanner(System.in);
            int response = number.nextInt();
            
            
            //name searcher
            //country searcher
            
            //director searcher
            if(response == 1){
                System.out.println("You are searching titles. ");
                System.out.println("Please input the name you are searching. ");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;

                    while(count < num){

                        tempNameArr[0] = nameArr[count];

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
                                System.out.println(nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                 
            }

            //director searcher
            if(response == 2){
                if(materialType == 2){
                System.out.println("You are searching directors. ");
                }
                
                if(materialType == 1){
                System.out.println("You are searching authors. ");
                }
                
                System.out.println("Please input the name you are searching. ");

                Scanner name2 = new Scanner(System.in);
                String resp = name2.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp2: split){
                
                    String temp2 = resp2.toLowerCase();
                    resp2 = temp2;

                    temp2 = resp2.replaceAll("^a-z0-9", "");
                    resp2 = temp2; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;

                    while(count < num){

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
                                System.out.println(nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                 
            }
            
            //age searcher
            if(response == 3){
                System.out.println("Enter the date you are searching. ");

                Scanner age2 = new Scanner(System.in);
                int ageInt = age2.nextInt();
                
                int counter = 0;
                
                

                
                while(counter  < num){
                    
                    tempNameArr[0] = dateArr[counter];

                    String dateNew = Arrays.toString(tempNameArr);
                    String temp;
                    temp = dateNew.replaceAll("[^0-9]", "");
                    dateNew = temp;
                    
                    int intAge = Integer.parseInt(dateNew);

                    if(ageInt == intAge){
                        System.out.println(nameArr[counter] + " ~ " + authorArr[counter] + " ~ " + dateArr[counter] + " ~ " + countryArr[counter] );
                    }
                    counter++;

                }
                
                
                
            }
            
            //country searcher
            
            if(response == 4){
                System.out.println("You are searching countries. ");
                System.out.println("Please input the country you are searching for. ");

                Scanner name4 = new Scanner(System.in);
                String resp = name4.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp4: split){
                
                    String temp4 = resp4.toLowerCase();
                    resp4 = temp4;

                    temp4 = resp4.replaceAll("^a-z0-9", "");
                    resp4 = temp4; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;

                    while(count < num){

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
                                System.out.println(nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
            
            }
            //genre searcher
            //director searcher
            if(response == 5){
                System.out.println("You are searching genres. ");
                System.out.println("Please input the genre you are searching. ");

                Scanner name5 = new Scanner(System.in);
                String respG = name5.nextLine();
                
                String split5[] = respG.split(" ", 0);
                for(String resp5: split5){
                
                    String temp5 = resp5.toLowerCase();
                    resp5 = temp5;

                    temp5 = resp5.replaceAll("^a-z0-9", "");
                    resp5 = temp5; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;

                    while(count < num){

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
                                System.out.println(nameArr[count] + " ~ " + authorArr[count] + " ~ " + dateArr[count] + " ~ " + countryArr[count] + " ~ " + genreArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                }
            } 
            if(materialType == 2){
            System.out.println("Type 1 to continue searching, type 0 to return to the movies menu. ");
            }
            
            if(materialType == 1){
            System.out.println("Type 1 to continue searching, type 0 to return to the books menu. ");
            }
            
            Scanner  cont = new Scanner(System.in);
            cnum = cont.nextInt();
            
        }
        
        
        
     in.close();
     out.close();
    }
    
    public void printMaterials() throws FileNotFoundException{
        
        Viewfile viewOne = new Viewfile();
        
        viewOne.setFile(materialFile);
    }
    
    public void menuOptions(){
        
    }
    /**
     *
     * @throws FileNotFoundException
     */
    public void menu() throws FileNotFoundException{
        
        Scanner choice = new Scanner(System.in);
                
        int cont = 1;
        while(cont == 1){
            int pick = 0; 
            
            menuOptions();
            pick = choice.nextInt();
            
            //switch to pick users choice
            switch (pick) {
                
                case 1:
                    printMaterials();
                    break;
                    
                
                case 2:
                    addMaterial();
                    break;
                    
                
                case 3:
                    removeMaterial();
                    break;
                case 4:
                    editMaterial();
                    break;
                    
                case 5:
                    searchMaterials();
                    break;
                    
                //if invalid option is picked print that
                default:
                    System.out.println("You selected " + pick);
                    System.out.println("Invalid option \n");
                    cont = 3;
                    break;
            }


            
        }
    }
}
