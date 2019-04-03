import java.sql.SQLException;

public class AddRecords {
	/*This class inserts example records to data base and could reset whole data base*/
	
	//reseting whole data base
	public static void reset() {
        DropDown.eraseTables();
        InitiateDB.createTables();
        SQLite.exampleRecordsInput();
	}
	
    //inserting values into tables in next 4 methods
    public static void addKlient() {
	    String vrbl;
	    try {
	    	vrbl="INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('Jan','Wawe³', 12113);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('Janusz','Maj', 20001);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('Krystian','Polacki', 30322);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('Dawid','Wawe³', 16154);";
	    	SQLite.stat.execute(vrbl);
	    } catch (SQLException e) {
	        System.err.println("B³¹d przy dodawaniu klientów.");
	        e.printStackTrace();
	    }
    }
    
    public static void addProdukty() {
	    String vrbl;
	    try {
	    	vrbl="INSERT INTO produkty (id_produkty, nazwa, cena) VALUES (495615, 'papierosy', 12.50);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO produkty (id_produkty, nazwa, cena) VALUES (612431, 'tabletki', 4.25);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO produkty (id_produkty, nazwa, cena) VALUES (921375, 'telefon', 499.90);";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO produkty (id_produkty, nazwa, cena) VALUES (943516, 'pierogi', 3.69);";
	    	SQLite.stat.execute(vrbl);
	    } catch (SQLException e) {
	        System.err.println("B³¹d przy dodawaniu produktów.");
	        e.printStackTrace();
	    }
    }
    
    public static void addZakupy() {
	    String vrbl;
	    try {
	    	vrbl="INSERT INTO zakupy (id_klienci, id_produkty, data_zakupy) VALUES (1, 495615, '2010-03-07 21:37:05.000');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO zakupy (id_klienci, id_produkty, data_zakupy) VALUES (3, 943516, '2012-12-10 14:14:23.000');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO zakupy (id_klienci, id_produkty, data_zakupy) VALUES (4, 921375, '2011-11-11 15:26:10.000');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO zakupy (id_klienci, id_produkty, data_zakupy) VALUES (2, 612431, '2011-01-16 19:04:58.000');";
	    	SQLite.stat.execute(vrbl);
	    } catch (SQLException e) {
	        System.err.println("B³¹d przy dodawaniu zakupów.");
	        e.printStackTrace();
	    }
    }
    
    public static void addKonto() {
	    String vrbl;
	    try {
	    	vrbl="INSERT INTO konto (id_konto, kwota, nazwisko) VALUES (12113, 2137.00, 'Wawe³');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO konto (id_konto, kwota, nazwisko) VALUES (20001, 1488.00, 'Polacki');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO konto (id_konto, kwota, nazwisko) VALUES (30322, 1000000.00, 'Maj');";
	    	SQLite.stat.execute(vrbl);
	    	vrbl="INSERT INTO konto (id_konto, kwota, nazwisko) VALUES (16154, 912.50, 'Wawe³');";
	    	SQLite.stat.execute(vrbl);
	    } catch (SQLException e) {
	        System.err.println("B³¹d przy dodawaniu kont.");
	        e.printStackTrace();
	    }
    }
}
