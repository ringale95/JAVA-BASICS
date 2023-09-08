class Person{
   private String fname;
   private String lname;
   private int age; 

   public String toString(){
        return "I am a person..";
   }  
}

class Book{
    private String name = "Harry Potter - Deathly Hallows";
    private double price = 13.99;
    private boolean isAvailable = true;

    public String toString(){
        return "\nBook: "+name+"\n"+"Price: "+price+"\n"+"isAvailable: "+isAvailable+"\n";
    }
}

public class Hospital{
    public static void main(String args[]){
        Book hp7 = new Book();
        System.out.println("Welcome to my bookstore!!!!\n\n");
        System.out.println("List of books available:-");
        System.out.println(hp7);
        System.out.println("We'll notify you if anymore books are available**");
    }
}

