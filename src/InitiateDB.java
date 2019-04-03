import java.sql.SQLException;

public class InitiateDB {
	/*This class prepares data base without any values*/
    
    //creating tables with SQLite syntax
    public static void createTables()  {
        String createKlienci = "CREATE TABLE IF NOT EXISTS klienci "
        		+ "(id_klienci INTEGER PRIMARY KEY AUTOINCREMENT,"
        		+ "imie varchar(255),"
        		+ "nazwisko varchar(255),"
        		+ "id_konto INTEGER UNIQUE)";
        
        String createProdukty = "CREATE TABLE IF NOT EXISTS produkty "
        		+ "(id_p INTEGER PRIMARY KEY AUTOINCREMENT,"
        		+ "id_produkty INTEGER UNIQUE,"
        		+ "nazwa varchar(255) NOT NULL,"
        		+ "cena decimal(16,2) NOT NULL)";
        
        String createZakupy = "CREATE TABLE IF NOT EXISTS zakupy "
        		+ "(id_zakupy INTEGER PRIMARY KEY AUTOINCREMENT,"
        		+ "id_klienci int,"
        		+ "id_produkty int,"
        		+ "data_zakupy TEXT,"
        		+ "FOREIGN KEY (id_klienci) REFERENCES klienci (id_klienci) ON UPDATE SET NULL,"
        		+ "FOREIGN KEY (id_produkty) REFERENCES produkty (id_produkty) ON UPDATE SET NULL)";
        
        String createKonto = "CREATE TABLE IF NOT EXISTS konto "
        		+ "(id_konto int,"
        		+ "kwota decimal(32,2),"
        		+ "nazwisko varchar(255) NOT NULL,"
        		+ "FOREIGN KEY (id_konto) REFERENCES klienci (id_konto) ON UPDATE SET NULL)";
        try {
        	SQLite.stat.execute(createKlienci);
        	SQLite.stat.execute(createProdukty);
        	SQLite.stat.execute(createKonto);
        	SQLite.stat.execute(createZakupy);
        } catch (SQLException e) {
            System.err.println("B³¹d przy tworzeniu tabel.");
            e.printStackTrace();
        }
    }
}
