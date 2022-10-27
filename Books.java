public class Books extends Materials{
    public Books(){
        setmaterialFile("BooksList.txt");
        setmaterialType(1);
        
    }
    
    @Override
    public void menuOptions() {
        System.out.println("Welcome to the Books Menu: "); 
        System.out.println("Please type 1 to view books: ");
        System.out.println("Please type 2 to add books: ");
        System.out.println("Please type 3 to remove books: ");
        System.out.println("Please type 4 to edit books: ");
        System.out.println("Please type 5 to search books: \n");
        
    }
}