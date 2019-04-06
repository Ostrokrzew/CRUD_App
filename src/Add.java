import java.sql.SQLException;

public class Add {
	/*This class contains method that adds new record*/
	
	//adding chosen record
	public static String addClient(String imie, String nazwisko, String id_konto) {
		String add = String.format("INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('%s', '%s', %s);", imie, nazwisko, id_konto);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy dodawaniu klienta.";
        }
        return "Klienta dodano pomyœlnie.";
	}
	
	//adding chosen record
	public static String addProduct(String id_produkty, String nazwa, String cena) {
		String add = String.format("INSERT INTO produkty (id_produkty, nazwa, cena) VALUES (%s, '%s', %s);", id_produkty, nazwa, cena);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy dodawaniu produktu.";
        }
        return "Produkt dodano pomyœlnie.";
	}
	
	//adding chosen record
	public static String addTransaction(String id_konto, String id_produkty, String data_zakupy) {
		String add = String.format("INSERT INTO zakupy (id_konto, id_produkty, data_zakupy) VALUES (%s, %s, '%s');", id_konto, id_produkty, data_zakupy);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy dodawaniu transakcji.";
        }
        return "transakcjê dodano pomyœlnie.";
	}
	
	//adding chosen record
	public static String addAccount(String id_konto, String kwota, String nazwisko) {
		String add = String.format("INSERT INTO konto (id_konto, kwota, nazwisko) VALUES (%s, %s, '%s');", id_konto, kwota, nazwisko);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy dodawaniu konta.";
        }
        return "Konto dodano pomyœlnie.";
	}
}