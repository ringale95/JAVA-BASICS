abstract class Person{
   private String fname;
   private String lname;
   private int age; 

    /* 
        Constructors are always public.
        Since we need to make object of it so need to public.
        They do not have a return type
    */
   public Person(){ 
   }

   public Person(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
   }


   public String getFname(){
    return this.fname;
   }

   public void setFname(String fname){
        this.fname = fname;
   }

   public String getLname(){
        return this.lname;
   }

   public void setLname(String lname){
        this.lname = lname;
   }

    public int getAge(){
        return this.age;
   }

   public void setAge(int age){
        this.age = age;
   }

   abstract public String getFullName();
}

class Doctor extends Person{
    
    private boolean isAvailable;

    public Doctor(){
        super();
        this.isAvailable = true;
    }

    public Doctor(String fname, String lname, int age){
        super(fname, lname, age);
        this.isAvailable = true;
    }

    public String getFullName(){
        return "Dr. "+this.getFname() + " " + this.getLname();
    }

    public String toString(){
        return "\nName: "+this.getFullName()+"\nAge: "+this.getAge()+"\nType: "+this.getClass().getName()+"\nIs Available?: "+this.isAvailable+"\n";
    }
}

class Patient extends Person{

    public String getFullName(){
        return this.getFname() + " " + this.getLname();
    }
    
    public String toString(){
        return "\nName: "+this.getFullName()+"\nAge: "+this.getAge()+"\nType: "+this.getClass().getName()+"\n\n";
    }
}

public class Hospital{
    public static void main(String args[]){
        
        // Doctor
        Person p1 = new Doctor("Raveena","Tambe",40);
        
        // Patient
        Person p2 = new Patient();
        p2.setFname("Aniruddha");
        p2.setAge(35);
        p2.setLname("Tambe");                                   
        
        // Display doctor & patient
        System.out.println(p1);
        System.out.println(p2);
    }
}

