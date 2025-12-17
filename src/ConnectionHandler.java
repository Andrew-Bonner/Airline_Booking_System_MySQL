import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionHandler {
    private static String url;
    private static String user;
    private static String password;
    private static java.sql.Connection connection;
     public ConnectionHandler(String url, String user, String pwd){
         this.url = url;
         this.user = user;
         this.password = pwd;
     }
    public Connection createConnection(){

        System.out.println("Connecting to Falcon Airlines server...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection =
                    DriverManager.getConnection(url, user, password);
             if (connection.isValid(2)&&connection!=null) {
                 System.out.println("Connection Successful.");
             }
        }catch (SQLException | ClassNotFoundException r) {
            r.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }
    public void closeConnection(){
        System.out.println("Closing connection to Falcon Airlines database...");
        try{
            connection.close();
            if(connection.isClosed()){
                System.out.println("Connection Ended.");
            }
        }catch (SQLException e){
            System.out.println("Error: failed to close connection.");
            e.printStackTrace();

        }
    }
}
