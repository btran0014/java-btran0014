package java_oop_practice_questions;

public class Entry {
    String name;
    String username;
    String address;

    Entry(String name, String username, String address){
        this.name = name;
        this.username = username;
        this.address = address;
    }
    public String email(){
        return(username + address);
    }
    public void output(){
        System.out.println("Your email address is: " + this.email());
    }
}
