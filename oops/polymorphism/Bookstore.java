class Book{
   private String name;
   private double price; 
   private String author;
   private int volume;

   //No parameter constructor 
   public Book(){ 
   }

   //parameterized constructor 
   public Book(String name, double price, String author, int volume){
        this.name = name;
        this.price = price;
        this.author = author;
        this.volume = volume;
   }

    //getters and setters for all variables 
    public String getFname(){
        return this.name;
    }

    public void setFname(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getVolume(){
        return this.volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
}

//Child class for Book
class Novel extends Book{
    private String genre;

    public Novel(String name, double price, String author, int volume, String genre){
        //super is used to call parent methods
        super(name, price, author, volume); 
        this.genre = genre;
    }

    public String toString(){
        return "\nBook Name: "+this.getFname()+"\nPrice: "+this.getPrice()+"\nAuthor is Mr. " +this.getAuthor()+"\nVolume " +this.getVolume()+"\nGenre Type ?" +this.genre+"\n\n";
    }
}
 //Another child class for parent 'Book'
class Encyclopedia extends Book{
        private String category;

        public Encyclopedia(String name, double price, String author, int volume, String category){
            super(name, price, author, volume);
            this.category = category;
        }
        public String toString(){
            return "\nBook Name: "+this.getFname()+"\nPrice: "+this.getPrice()+"\nAuthor is Mr. " +this.getAuthor()+"\nVolume " +this.getVolume()+"\nCategory Type ?" +this.category+"\n\n";
        }
    }

//Main class
public class Bookstore{
        
    public static void main(String[]args)
    {
        //Novel
        Book Nov = new Novel("Falling", 680, "T.J. New Jersey", 1,"fiction");

        //Encyclopedia
        Book Encyc = new Encyclopedia("Falling 2", 500, "J.J Thompson", 3, "Science");

        //Book with no args
        Book b1 = new Book();
        b1.setFname("Beloved");
        b1.setPrice(250);
        b1.setAuthor("James");
        b1.setVolume(1);

        //Book with args
        Book b2 = new Book("Harry Potter and the Sorcerer's Stone", 800, "J.K.Rowling", 1);
        b2.setPrice(900);

        //Other three books
        Book b3 = new Book();
        b3.setFname("Beloved - II");
        b3.setPrice(280);
        b3.setAuthor("James");
        b3.setVolume(2);

        Book b4 = new Book("Harry Potter and the Chamber of Secrets", 880, "J.K.Rowling", 2);

        Book b5 = new Book("Harry Potter and the Order of the Phoenix", 900, "J.K.Rowling", 3);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(Nov);
        System.out.println(Encyc);

        }

}