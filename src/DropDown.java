import java.sql.SQLException;

public class DropDown {
    /*This class resets whole database*/
	
    //deleting tables from previous sessions to avoid errors
    public static void eraseTables() {
        String dropKlienci = "DROP TABLE IF EXISTS klienci";
        String dropProdukty = "DROP TABLE IF EXISTS produkty";
        String dropZakupy = "DROP TABLE IF EXISTS zakupy";
        String dropKonto = "DROP TABLE IF EXISTS konto";
        try {
            SQLite.stat.execute(dropKonto);
            SQLite.stat.execute(dropZakupy);
            SQLite.stat.execute(dropProdukty);
            SQLite.stat.execute(dropKlienci);
        } catch (SQLException e) {
            System.err.println("B³¹d przy usuwaniu tabel.");
            e.printStackTrace();
        }
    }
}
