

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Calendar;

/**
 *
 * @author phoeb
 */
public class Age{

    private int dateC;
    private int monthC;
    private int yearC;
    private int dateB;
    private int monthB;
    private int yearB;
    private int dateR;
    private int monthR;
    private int yearR;
    private int age;
    private String currentDate;
    private String returnDate;
    private int difference;
    private int overDue;

    public Age() {
        Calendar cal = Calendar.getInstance();
        
        dateC = cal.get(Calendar.DAY_OF_MONTH);
        monthC = cal.get(Calendar.MONTH);
        yearC = cal.get(Calendar.YEAR);

    }

    public String getcurrentDate() {
        currentDate = (monthC + 1) + "/" + dateC + "/" + (yearC);
        return currentDate;
    }

    public String getreturnDate(int loan) {
        if ((dateC + loan) <= 28) {
            monthR = monthC;
            dateR = dateC + loan;
            yearR = yearC;
        } else if ((monthC == 0) || (monthC == 2) || (monthC == 4) || (monthC == 6) || (monthC == 7) || (monthC == 9) || (monthC == 11)) {
            if ((dateC + loan) <= 31) {
                dateR = dateC + loan;
                monthR = monthC;
                yearR = yearC;
            } else {
                if ((monthC == 11)) {
                    dateR = (dateC + loan) - 31;
                    monthR = 0;
                    yearR = yearC + 1;
                } else {
                    dateR = (dateC + loan) - 31;
                    monthR = monthC + 1;
                    yearR = yearC;
                }
            }
        } else if ((monthC == 3) || (monthC == 5) || (monthC == 8) || (monthC == 10)) {
            if ((dateC + loan) <= 30) {
                dateR = dateC + loan;
                monthR = monthC;
                yearR = yearC;
            } else {
                dateR = (dateC + loan) - 30;
                monthR = monthC + 1;
                yearR = yearC;
            }
        } else if ((monthC == 1)) {
            if (yearC % 4 == 0) {
                if ((dateC + loan) <= 29) {
                    dateR = dateC + loan;
                    monthR = monthC;
                } else {
                    dateR = (dateC + loan) - 29;
                    monthR = monthC + 1;
                    yearR = yearC;
                }
            } else {
                dateR = (dateC + loan) - 28;
                monthR = monthC + 1;
                yearR = yearC;
            }
        }

        returnDate = (monthR + 1) + "/" + dateR + "/" + (yearR);
        return returnDate;
    }

    public Age(String dob) {
        Calendar cal = Calendar.getInstance();
        
        dateC = cal.get(Calendar.DAY_OF_MONTH);
        monthC = cal.get(Calendar.MONTH);
        yearC = cal.get(Calendar.YEAR);
        
        String[] dueD = new String[3];
        dueD = dob.split("/");

        String monthtemp = dueD[0].replaceAll("[^0-9]", "");
        String datetemp = dueD[1].replaceAll("[^0-9]", "");
        String yeartemp = dueD[2].replaceAll("[^0-9]", "");
        
        monthB = Integer.parseInt(monthtemp)-1;
        dateB = Integer.parseInt(datetemp);
        yearB = Integer.parseInt(yeartemp);
    }

    public void printDateC() {
        System.out.println((monthC + 1) + "/" + dateC + "/" + (yearC));
    }

    public void printDateB() {
        System.out.println((monthB + 1) + "/" + dateB + "/" + (yearB));
    }

    public int findAge() {
        if (monthB < monthC) {
            age = (yearC - yearB);
        } else if (monthB == monthC) {
            if (dateC >= dateB) {
                age = (yearC - yearB);
            } else {
                age = (yearC - yearB - 1);
            }
        } else {
            age = (yearC - yearB - 1);
        }

        return age;
    }

    public int overDue(String dueDate) {
        String[] dueD = new String[3];
        dueD = dueDate.split("/");
        String returned = dueD[0];
        returned = returned.replaceAll("[^a-z]", "");
        
        if("returned".equals(returned) ){
            overDue = 0;
        }
        
        else{
        String monthD = dueD[0];
        String temp = monthD.replaceAll("[^0-9]", "");
        monthD = temp;
        int mR = Integer.parseInt(monthD)-1;

        String dateD = dueD[1];
        temp = dateD.replaceAll("[^0-9]", "");
        dateD = temp;
        int dR = Integer.parseInt(dateD);

        String yearD = dueD[2];
        temp = yearD.replaceAll("[^0-9]", "");
        yearD = temp;
        int yR = Integer.parseInt(yearD);
        yR = yR;
        
        
        if (yR == yearC) {
            if (monthC < mR) {
                overDue = 0;
                
            } 
            else if (monthC == mR) {
                difference = (dateC - dR);
                if (difference <= 0) {
                    overDue = 0;
                }
                else {
                    overDue = difference;
                }
            }
            else {
                if((mR == 0) || (mR == 2) || (mR == 4) || (mR == 6) || (mR == 7) || (mR == 9) || (mR == 11)) {
                    overDue = (31-dR)+dateC;
                }
                else if ((mR == 3) || (mR == 5) || (mR == 8) || (mR == 10)) {
                    overDue = (30-dR) + dateC;
                }
                
                else if(mR == 1){
                    if (yR % 4 == 0) {
                        overDue = (29-dR) + dateC;
                    }
                    
                    else{
                        overDue = (28-dR) + dateC;
                    }
                }

            }
        }
        }
        return overDue;
    }

}

