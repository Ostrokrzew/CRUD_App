import java.sql.*;

public class SQLite {
	/*This is main class of whole application. It starts connection with SQLite data base, turns on foreign keys,
	 * uses method to make new data base with example records, opens program UI and closes connection with data base. */
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:zadanie.db";

    public static Connection conn;
    public static Statement stat;
    
    public static void DataBase() {

		//adding JDCB class
	    try {
            Class.forName(SQLite.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
	    
        //opening connection with DB
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem po³¹czenia.");
            e.printStackTrace();
        }
        
        //switch on foreign keys
		String foreignON = "PRAGMA foreign_keys = ON";
		try {
			stat.execute(foreignON);
		} catch (SQLException e) {
            System.err.println("Problem z uruchomieniem mechanizmu kluczy obcych.");
			e.printStackTrace();
		}
    }
    
	//clear, instantiate and fill data base
    public static void exampleRecordsInput() {
		AddRecords.addKlient();
		AddRecords.addProdukty();
		AddRecords.addZakupy();
		AddRecords.addKonto();
    }
    
	//closing connection with DB
    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamkniêciem po³¹czenia");
            e.printStackTrace();
        }
    }
    
    //main method in class
	public static void main(String[] args) {
		DataBase();
		WindowForm.main(args);
		closeConnection();
	}
}
