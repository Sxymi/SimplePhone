package git.sxymi.simplephone;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number, ArrayList<Contact> allContacts) {
        this.name = name;
        this.number = number;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void showDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Number: " + this.number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}