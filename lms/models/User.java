package models;
public class User{

    private String username;
    private String password;
    private String role;
    private static int id;

    public User(String username, String password, String role){
        this.id++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String toString(){
        return "Hello, "+this.username+"!";
    }

}