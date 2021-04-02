package git.sxymi.simplephone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Database
    static ArrayList<Contact> allContacts = new ArrayList<>();
    static ArrayList<Message> allMessages = new ArrayList<>();

    //Program
    public static void main(String[] args) {
        System.out.println("Welcome in SimplePhone created by Sxymi");
        welcomeScreen();
    }

    public static void welcomeScreen(){
        System.out.print("\t1. Contacts menu\n" +
                "\t2. Messages menu\n" +
                "\t3. Exit\n");

        Scanner scn = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            switch (scn.nextInt()) {
                case 1:
                    contacts();
                    loop = false;
                    break;
                case 2:
                    messages();
                    loop = false;
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }
    }

    //Contacts functions
    public static void contacts(){
        System.out.print("Contacts menu\n" +
                "\t1. Add contact\n" +
                "\t2. Show contacts\n" +
                "\t3. Delete contact\n" +
                "\t4. Go back\n");

        Scanner scn = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            switch(scn.nextInt()){
                case 1:
                    addContact();
                    loop = false;
                    break;
                case 2:
                    showContacts();
                    loop = false;
                    break;
                case 3:
                    deleteContact();
                    loop = false;
                    break;
                case 4:
                    welcomeScreen();
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }
    }

    public static void addContact(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = scn.next();
        if(name.equals("")){
            System.out.println("Please enter a valid name.");
            addContact();
        }

        System.out.print("Enter a number: ");
        String number = scn.next();
        if(number.equals("")){
            System.out.println("Please enter a valid number.");
            addContact();
        }

        Contact newContact = new Contact(name, number);
        allContacts.add(newContact);
        System.out.println("New contact " + name + " added properly.");
        contacts();
    }

    public static void showContacts(){
        if(allContacts.size() == 0){
            System.out.println("Contacts list is empty.");
        }
        else{
            System.out.println("Contacts list: ");
            for(Contact c: allContacts){
                System.out.println("\tName: " + c.getName() +
                        "\n\tNumber: " + c.getNumber() + "\n----");
            }
            System.out.println();
        }

        contacts();
    }

    public static void deleteContact(){
        if(allContacts.size() == 0){
            System.out.println("Contacts list is empty.");
            contacts();
        }

        Scanner scn = new Scanner(System.in);
        boolean found = false;

        System.out.print("Name of contact to delete: ");
        String name = scn.next();
        for(Contact c: allContacts){
            if(name.equals(c.getName())){
                allContacts.remove(c);
                System.out.println("Contact " + name + " deleted.");
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Contact not found.");
            contacts();
        }

        contacts();
    }

    //Messages functions
    public static void messages(){
        System.out.println("Messages menu\n" +
                "\t1. Send message\n" +
                "\t2. Show messages\n" +
                "\t3. Delete all messages\n" +
                "\t4. Go back\n");

        Scanner scn = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            switch(scn.nextInt()){
                case 1:
                    sendMessage();
                    loop = false;
                    break;
                case 2:
                    showMessages();
                    loop = false;
                    break;
                case 3:
                    deleteMessages();
                    loop = false;
                    break;
                case 4:
                    welcomeScreen();
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }
    }

    public static void sendMessage(){
        Scanner scn = new Scanner(System.in);

        if(allContacts.size() == 0){
            System.out.println("Contacts list is empty, please add a contact first.");
            messages();
        }

        System.out.print("Recipient: ");
        String recipient = scn.next();
        for(Contact c: allContacts){
            if(!recipient.equals(c.getName())){
                System.out.println("Contact not found. Please try again.");
                messages();
            }
            else{
                System.out.print("Text: ");
                //Used to clear the buffer (Enter skipped input).
                scn.nextLine();
                String text = scn.nextLine();
                Message msg = new Message(c, text);
                allMessages.add(msg);
                System.out.println("Message sent!");
            }
        }

        messages();
    }

    public static void showMessages(){
        if(allMessages.size() == 0){
            System.out.println("Message box is empty.");
        }
        else{
            System.out.println("Messages list:");
            for(Message m: allMessages){
                System.out.println("\tRecipient: " + m.getRecipient().getName() +
                        "\n\tText: " + m.getText() +
                        "\n----");
            }
        }

        messages();
    }

    public static void deleteMessages(){
        if(allMessages.size() == 0){
            System.out.println("Message box is empty.");
            messages();
        }

        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        System.out.print("Delete all messages? [y/n] ");

        while(loop){
            switch(scn.next()){
                case "y":
                    allMessages = new ArrayList<>();
                    System.out.println("All messages are gone!");
                    loop = false;
                    messages();
                    break;
                case "n":
                    System.out.println("Deleting aborted.");
                    loop = false;
                    messages();
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }
    }
}