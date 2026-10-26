
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Add Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.println("You selected option: " + choice);

        sc.close();
    }
}
