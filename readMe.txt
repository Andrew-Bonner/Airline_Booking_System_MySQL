BASIC INFORMATION:
This program is made to access a particular MySQL server through knowing the following information:
        - Server url
        - server password
        - server username
        - database name (optional)
    The only class that needs to be changed in the order to accommodate the different servers is the parameters for the
ConnectionHandler object in the Main class. The Main class is where the main method is called. PLEASE DO NOT CHANGE ANY
OF THE OTHER CLASSES OTHER THAN THE SPECIFIED AREAS TO CHANGE IN THE MAIN. The password that is requested at the
start of the program after running it is the password used to access the MySQL server you link into the program. All the
menu items in the program are integer sensitive, so when selecting from a menu ONLY USE INTEGERS. When asked to select
between passenger, strings may be typed.
    In the employee menu, specify the database that you would like to use. From the following menu, you can create
databases and tables within the server as you please. For tables, you must type in a complete MySQL query for creating a
table.
    In the Passenger menu, the program is set to automatically access the database with the name "Falcon_Airlines". For
the program to work properly, YOU MUST HAVE A DATABASE WITH THE NAME "Falcon_Airlines". If you don't, you will have to
use the employee menu to create the database. The passenger menu also has several options that call methods that
manipulate, access, or alter the tuples within the tables of the database.
________________________________________________________________________________________________________________________
REQUIRED LIBRARIES:
- mysql-connector-j-9.1.0 or higher
________________________________________________________________________________________________________________________
REQUIRED JDK:
- JDK 19 or newer


