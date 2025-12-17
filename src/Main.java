import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Boolean keepGoing = true;
        System.out.println("Welcome to Falcon Airlines!");
        while(keepGoing) {
            System.out.print("Enter password to proceed. Type 'q' to quit: ");
            String password = scanner.next();
            if (password.equals("Deshawn101603#")) {
                keepGoing=false;
                ConnectionHandler conn = new ConnectionHandler(
                        "jdbc:mysql://localhost:3306",
                        "root",
                        password
                );
                Connection newConnection = conn.createConnection();
                Statement statement = newConnection.createStatement();
                DatabaseManager manager = new DatabaseManager(newConnection, statement);
                manager.specifyUserType();
                conn.closeConnection();
            } else if (password.equals("q")) {
                keepGoing = false;
                System.out.println("Exiting software.....");
            } else {
                System.out.println("Invalid password, try again.");
            }
        }

    }
}
