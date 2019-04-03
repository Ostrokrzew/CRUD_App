import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowMeDB {
	
    //printing values of tables in next 4 methods
    public static ObservableList<Klienci> showKlienci() {
        ObservableList<Klienci> klient = FXCollections.observableArrayList();
        try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM klienci");
            while(result.next()) {
                int id_klienci = result.getInt("id_klienci");
                int id_konto = result.getInt("id_konto");
                String imie = result.getString("imie");
                String nazwisko = result.getString("nazwisko");
                klient.add(new Klienci(id_klienci, imie, nazwisko, id_konto));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return klient;
    }

    public static ObservableList<Produkty> showProdukty() {
    	ObservableList<Produkty> produkt = FXCollections.observableArrayList();
    	try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM produkty");
            while(result.next()) {
                int id_p = result.getInt("id_p");
                String nazwa = result.getString("nazwa");
                double cena = result.getDouble("cena");
                int id_produkty = result.getInt("id_produkty");
                produkt.add(new Produkty(id_p, nazwa, cena, id_produkty));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return produkt;
    }
    
    public static ObservableList<Zakupy> showZakupy() {
    	ObservableList<Zakupy> zakup = FXCollections.observableArrayList();
        try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM zakupy"
            		+ " INNER JOIN klienci ON zakupy.id_klienci = klienci.id_klienci"
            		+ " INNER JOIN produkty ON zakupy.id_produkty = produkty.id_produkty");
            while(result.next()) {
                int id_zakupy = result.getInt("id_zakupy");
                int id_klienci = result.getInt("id_klienci");
                int id_produkty = result.getInt("id_produkty");
                Date data_zakupy = result.getDate("data_zakupy");
                zakup.add(new Zakupy(id_zakupy, id_klienci, id_produkty, data_zakupy));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return zakup;
    }
   
    public static ObservableList<Konto> showKonto() {
    	ObservableList<Konto> konto = FXCollections.observableArrayList();
        try {
            ResultSet result = SQLite.stat.executeQuery("SELECT * FROM konto"
            		+ " INNER JOIN klienci ON konto.id_konto = klienci.id_konto");
            while(result.next()) {
                int id_konto = result.getInt("id_konto");
                String nazwisko = result.getString("nazwisko");
                double kwota = result.getDouble("kwota");
                konto.add(new Konto(id_konto, nazwisko, kwota));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return konto;
    }
}
