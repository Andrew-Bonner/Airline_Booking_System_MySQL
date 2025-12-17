import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class DatabaseManager {
    private Statement statement;
    private Connection connection;
    private static String databaseName;
    private Scanner scanner = new Scanner(System.in);
    public DatabaseManager(Connection connection,Statement statement){
        this.connection = connection;
        this.statement = statement;
    }
    private void deleteBooking(){
        try {
            statement.executeUpdate("USE " + databaseName);
            System.out.println("Enter Passenger ID: ");
            int passID = scanner.nextInt();
            System.out.println("Enter Booking ID: ");
            int bookID = scanner.nextInt();
            String query = String.format("DELETE FROM Flight_Details WHERE " +
                    "pass_id = %d AND book_id = %d;",passID,bookID);
            statement.executeUpdate(query);
            System.out.println("Reservation Cancelled");

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    private void insertBooking(){
        try {
            statement.executeUpdate("USE " + databaseName);
            System.out.println("Enter Passenger ID: ");
            int passID = scanner.nextInt();
            System.out.println("Enter Booking ID: ");
            int bookID = scanner.nextInt();
            System.out.println("Enter Flight ID: ");
            int flightID = scanner.nextInt();
            String query = String.format("INSERT INTO Flight_Details VALUES(" +
                    "%d,%d,%d);",passID,bookID,flightID);
            statement.executeUpdate(query);
            System.out.println("Reservation Added");

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }



    }
    private void createTable(){
        try{
            String useDatabase = " USE "+databaseName;
            statement.executeUpdate(useDatabase);
            System.out.println("Please type query for new table and its attributes: ");
            String query = scanner.nextLine();
            statement.executeUpdate(query);
            System.out.println("Table created.");
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private void createDatabase(){
        try{
            System.out.println("Name the database: ");
            String newDatabaseName = scanner.nextLine();
            System.out.println(String.format("Creating database for %s...",newDatabaseName));
            String query = String.format("CREATE DATABASE %s",newDatabaseName);
            statement.executeUpdate(query);
            System.out.println("Database created.");
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    public void employeeChooseMenuOption() {
        Boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("_______________________\n" +
                    "\tMAIN MENU\n" +
                    "Select Option Number\n" +
                    "1. Create New Database\n" +
                    "2. Create Table\n" +
                    "3. Quit\n" +
                    "_______________________");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> createDatabase();
                case 2 -> createTable();
                case 3 -> keepGoing = false;
                default -> System.out.println("Invalid input, try again");
            }
        }
    }
    public void specifyDatabase(){
        System.out.println("_______________________");
        Boolean keepGoing = true;
        while(keepGoing) {
            System.out.println("Type number you would like to access: \n" +
                    "1. Falcon Airlines Database\n" +
                    "2. Other Database\n" +
                    "3. Quit\n" +
                    "_______________________");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    databaseName = "Falcon_Airlines";
                    keepGoing=false;
                    break;

                case 2:
                    System.out.print("Type database name: ");
                    databaseName = scanner.nextLine();
                    keepGoing=false;
                    break;

                case 3:
                    keepGoing = false;
                    break;

                default:
                    System.out.println("Invalid input, try again");
            }
        }
        }
    public void passengerChooseMenuOption() {
        databaseName="Falcon_Airlines";
        Boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("_______________________\n" +
                    "\tMAIN MENU\n" +
                    "Select Option Number\n" +
                    "1. View Available Flights\n" +
                    "2. Book Flight\n" +
                    "3. Cancel Reservation\n" +
                    "4. View My Bookings\n" +
                    "5. View My Info\n"+
                    "6. Quit\n" +
                    "_______________________");
            int selection = scanner.nextInt();
            DatabaseInspector inspector = new DatabaseInspector(connection,statement,databaseName);
            switch (selection) {
                case 1 -> inspector.viewAvailableFlights();
                case 2 -> insertBooking();
                case 3 -> deleteBooking();
                case 4 -> inspector.viewBooking();
                case 5 -> inspector.viewPassengerInfo();
                case 6 -> keepGoing = false;
                default -> System.out.println("Invalid input, try again");
            }
        }
    }
    public void specifyUserType(){
        Boolean keepGoing = true;
        while(keepGoing) {
            System.out.print("Are you an employee or passenger: ");
            String userType = scanner.nextLine();
            if (userType.toLowerCase().equals("passenger")) {
                passengerChooseMenuOption();
                keepGoing = false;
            } else if (userType.toLowerCase().equals("employee")) {
                specifyDatabase();
                employeeChooseMenuOption();
                keepGoing=false;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
    }
    }

