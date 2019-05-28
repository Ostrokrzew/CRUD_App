import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Show {
	/*This class contains method that shows chosen record*/
	
	//showing chosen record
	public static String selectClient(String id_value) {
		String klient = "";
		try {
			ResultSet result = SQLite.stat.executeQuery("SELECT * FROM klienci WHERE id_klienci == "+id_value);
			while(result.next()) {
				int id_konto = result.getInt("id_konto");
				String imie = result.getString("imie");
				String nazwisko = result.getString("nazwisko");
				String konto = Integer.toString(id_konto);
				klient = imie+","+nazwisko+","+konto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return klient;
	}
	
	public static String selectProduct(String id_value) {
    	String produkt = "";
    	try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM produkty WHERE id_p == "+id_value);
            while(result.next()) {
                String nazwa = result.getString("nazwa");
                double cena = result.getDouble("cena");
                int id_produkty = result.getInt("id_produkty");
                String cenka = Double.toString(cena);
                String prod = Integer.toString(id_produkty);
                produkt = nazwa+","+cenka+","+prod;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return produkt;
    }
	
	public static String selectTransaction(String id_value) {
    	String zakup = "";
        try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM zakupy"
            		+ " INNER JOIN klienci ON zakupy.id_konto = klienci.id_konto"
            		+ " INNER JOIN produkty ON zakupy.id_produkty = produkty.id_produkty"
            		+ " WHERE id_zakupy == "+id_value);
            while(result.next()) {
                int id_konto = result.getInt("id_konto");
                int id_produkty = result.getInt("id_produkty");
                Date data_zakupy = result.getDate("data_zakupy");
                String konto = Integer.toString(id_konto);
                String produkt = Integer.toString(id_produkty);
				SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
                String data = dateForm.format(data_zakupy);
                zakup = konto+","+produkt+","+data;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return zakup;
    }
	
	public static String selectAccount(String id_value) {
    	String konto = "";
        try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM konto"
            		+ " INNER JOIN klienci ON konto.id_konto = klienci.id_konto"
            		+ " WHERE id_k == "+id_value);
            while(result.next()) {
            	int id_konto = result.getInt("id_konto");
                String nazwisko = result.getString("nazwisko");
                double kwota = result.getDouble("kwota");
                String saldo = Double.toString(kwota);
                String id_kont = Integer.toString(id_konto);
                konto = id_kont+","+nazwisko+","+saldo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return konto;
    }
}