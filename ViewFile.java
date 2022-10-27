import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class ViewFile {
    private String text;
    private String answer;
    
    
    public void setFile(String fileText) throws FileNotFoundException{
        text = fileText;
        
        File viewFile = new File(text);
        Scanner in = new Scanner(viewFile);
        
        while(in.hasNextLine()){
                
                System.out.println(in.nextLine());
                
        }
                
                
    }
    
    
}