class Person{
    public void eats(){
        System.out.println("Person can eat fast and fresh food");
    }
}
class Student extends Person{
    public void eats(){
        System.out.println("Student can only eat fresh food");
    }
}
public class Overriding{
    public static void main(String args[]){
        Person s1 = new Student();
        Person p1 = new Person();
        s1.eats();
        p1.eats();  
    }
}