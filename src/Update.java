import java.sql.SQLException;

public class Update {
	/*This class contains method that modifies chosen record*/
	
	//modifying chosen record
	public static String change(String table, String param, String value, String id_name, String id_value) {
		String update = String.format("UPDATE %s SET %s = %s WHERE %s == %s", table, param, value, id_name, id_value);
        try {
            SQLite.stat.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy zmianie rekordu.";
        }
        return "Rekord zmieniono pomyœlnie.";
	}
}
