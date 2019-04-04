import java.sql.SQLException;

public class Update {
	/*This class contains method that modifies chosen record*/
	
	//modifying chosen record
	public static String changeClient(String column, String value, String id_value) {
		if (column == "imie" || column == "nazwisko") {
			value = "'"+value+"'";
		}
		String update = String.format("UPDATE klienci SET %s = %s WHERE id_klienci == %s", column, value, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych klienta.";
        }
        return "Dane klienta zmieniono pomyœlnie.";
	}
	
	public static String changeProduct(String column, String value, String id_value) {
		if (column == "nazwa") {
			value = "'"+value+"'";
		}
		String update = String.format("UPDATE produkty SET %s = %s WHERE id_p == %s", column, value, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie produktu.";
        }
        return "Produkt zmieniono pomyœlnie.";
	}
	
	public static String changeTransaction(String column, String value, String id_value) {
		if (column == "data_zakupy") {
			value = "'"+value+"'";
		}
		String update = String.format("UPDATE zakupy SET %s = %s WHERE id_zakupy == %s", column, value, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych zakupu.";
        }
        return "Dane zakupu zmieniono pomyœlnie.";
	}
	
	public static String changeAccount(String column, String value, String id_value) {
		if (column == "nazwisko") {
			value = "'"+value+"'";
		}
		String update = String.format("UPDATE konto SET %s = %s WHERE id_konto == %s", column, value, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie konta.";
        }
        return "Konto zmieniono pomyœlnie.";
	}
}
