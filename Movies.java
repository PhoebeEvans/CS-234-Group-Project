public class Movies extends Materials{
    public Movies(){
        setmaterialFile("MoviesList.txt");
        setmaterialType(2);
    }
    
    @Override
    public void menuOptions() {
        System.out.println("Welcome to the Movies Menu: "); 
        System.out.println("Please type 1 to view movies: ");
        System.out.println("Please type 2 to add movies: ");
        System.out.println("Please type 3 to remove movies: ");
        System.out.println("Please type 4 to edit movies: ");
        System.out.println("Please type 5 to search movies: \n");
        
    }
}