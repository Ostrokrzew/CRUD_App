import java.sql.SQLException;

public class Update {
	/*This class contains method that modifies chosen record*/
	
	//modifying chosen record
	public static String changeClient(String column, String value, String id_name, String id_value) {
		if (column == "imie" || column == "nazwisko") {
			value = "'"+value+"'";
		}
		if (id_name == "imie" || id_name == "nazwisko") {
			id_value = "'"+id_value+"'";
		}
		String update = String.format("UPDATE klienci SET %s = %s WHERE %s == %s", column, value, id_name, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych klienta.";
        }
        return "Dane klienta zmieniono pomyœlnie.";
	}
	
	public static String changeProduct(String column, String value, String id_name, String id_value) {
		if (column == "nazwa") {
			value = "'"+value+"'";
		}
		if (id_name == "nazwa") {
			id_value = "'"+id_value+"'";
		}
		String update = String.format("UPDATE produkty SET %s = %s WHERE %s == %s", column, value, id_name, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie produktu.";
        }
        return "Produkt zmieniono pomyœlnie.";
	}
	
	public static String changeTransaction(String column, String value, String id_name, String id_value) {
		if (column == "data_zakupy") {
			value = "'"+value+"'";
		}
		if (id_name == "data_zakupy") {
			id_value = "'"+id_value+"'";
		}
		String update = String.format("UPDATE zakupy SET %s = %s WHERE %s == %s", column, value, id_name, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie danych zakupu.";
        }
        return "Dane zakupu zmieniono pomyœlnie.";
	}
	
	public static String changeAccount(String column, String value, String id_name, String id_value) {
		if (column == "nazwisko") {
			value = "'"+value+"'";
		}
		if (id_name == "nazwisko") {
			id_value = "'"+id_value+"'";
		}
		String update = String.format("UPDATE konto SET %s = %s WHERE %s == %s", column, value, id_name, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie konta.";
        }
        return "Konto zmieniono pomyœlnie.";
	}
}
