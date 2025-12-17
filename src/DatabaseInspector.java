import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseInspector {
    private Connection connection;
    private Statement statement;
    private String databaseName;
    private static Scanner scanner = new Scanner(System.in);
    public DatabaseInspector(Connection conn, Statement stat, String databaseName){
        this.connection = conn;
        this.statement = stat;
        this.databaseName = databaseName;
    }
    public void viewBooking(){
        try{
            statement.executeUpdate("USE " + databaseName);
            System.out.println("Enter Passenger ID: ");
            int passID = scanner.nextInt();
            String query = String.format("SELECT f_id,location " +
                    "FROM flight_details,arrives_at,airport " +
                    "WHERE pass_id=%d AND f_id=fli_id AND airport_id=a_id;",passID);
            ResultSet data = statement.executeQuery(query);
            System.out.println("____________MY BOOKINGS___________");
            while(data.next()){
                System.out.print(String.format("Flight ID: %d\tDestination: %s\n",
                        data.getInt("f_id"),data.getString("location")));

            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void viewPassengerInfo(){
        try {
            statement.executeUpdate("USE " + databaseName);
            System.out.println("Enter Passenger ID: ");
            int passID = scanner.nextInt();
            String query = String.format("SELECT * FROM Passenger WHERE passenger_id = %d;",passID);
            ResultSet data = statement.executeQuery(query);
            while(data.next()){
                System.out.println(String.format(
                        "Passenger ID: %d\nName: %s\nPhone: %d\nEmail: %s\nGender: %s\nAge: %d\n",
                        data.getInt("passenger_id"),data.getString("name"),
                        data.getInt("phone"),data.getString("email"),
                        data.getString("gender"),data.getInt("age")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void viewAvailableFlights(){
        System.out.println("Fetching flights...");
        try{
            statement.executeUpdate("USE " + databaseName);
            String query = "SELECT flight_id,location,dept_time,booking_id " +
                    "FROM flight,airport,arrives_at,booking " +
                    "WHERE airport_id=a_id AND flight_id=fli_id AND flight_id=id_flight;";
            ResultSet data = statement.executeQuery(query);
            System.out.println("____________AVAILABLE FLIGHTS___________");
            while(data.next()){
                System.out.print(String.format("Flight ID: %-10d Destination: %-22s Departure: %-10s Booking ID: %-10d\n",
                        data.getInt("flight_id"),data.getString("location"),
                        data.getString("dept_time"),data.getInt("booking_id")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
