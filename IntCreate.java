import java.util.Scanner;
public class IntCreate {
    private int response;
    public int intC(String x){
        System.out.println(x);
        
        //get response from user
        Scanner date = new Scanner(System.in);
        response = date.nextInt();
        
        return response;
    }
}