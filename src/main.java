import Core.Facade;

import java.util.Scanner;

public class main {
    static Scanner sc= new Scanner(System.in); //System.in is a standard input stream
    static Facade fPattern = new Facade();
    public static void main(String[] args) throws Exception {
        System.out.println("Enter User name:");
        String userName = sc.nextLine();
        System.out.println("Enter User password:");
        String password = sc.nextLine();
        System.out.println("Enter Type of User 0: Buyer , 1: Seller");
        Integer type = sc.nextInt();
        if(type == 1 || type == 2) {
            fPattern.login(userName, password, type);
        } else {
            System.out.println("Invalid Type");
            System.out.println("Exiting...");
            System.exit(1);
        }
    }
}
