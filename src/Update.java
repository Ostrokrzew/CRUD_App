import java.sql.SQLException;

public class Update {
	/*This class contains method that modifies chosen record*/
	
	//modifying chosen record
	public static String changeClient(String value0, String value1, String value2, String id_value) {
		String update = String.format("UPDATE klienci SET imie = '%s', nazwisko = '%s', id_konto = %s WHERE id_klienci == %s", value0, value1, value2, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych klienta.";
        }
        return "Dane klienta zmieniono pomyœlnie.";
	}
	
	public static String changeProduct(String value0, String value1, String value2, String id_value) {
		String update = String.format("UPDATE produkty SET id_produkty = %s, nazwa = '%s', cena = %s WHERE id_p == %s", value0, value1, value2, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych produktu.";
        }
        return "Produkt zmieniono pomyœlnie.";
	}
	
	public static String changeTransaction(String value0, String value1, String value2, String id_value) {

		String update = String.format("UPDATE zakupy SET id_konto = %s, id_produkty = %s, data_zakupy = '%s' WHERE id_zakupy == %s", value0, value1, value2, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych zakupu.";
        }
        return "Dane zakupu zmieniono pomyœlnie.";
	}
	
	public static String changeAccount(String value0, String value1, String value2, String id_value) {
		String update = String.format("UPDATE konto SET id_konto = %s, kwota = %s, nazwisko = '%s' WHERE id_k == %s", value0, value1, value2, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie konta.";
        }
        return "Konto zmieniono pomyœlnie.";
	}
}
