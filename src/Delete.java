import java.sql.SQLException;

public class Delete {
	/*This class contains method that deletes chosen record*/
	
	//deleting chosen record
	public static String hardDelete(String table, String id_name, String id_value) {
		String delete = String.format("DELETE FROM %s WHERE %s == '%s'", table, id_name, id_value);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu rekordu.";
        }
        return "Rekord usuniêto pomyœlnie.";
	}
}
/*	unnecessary code

	public static String deleteClient(String param) {
        String delete = String.format("DELETE * FROM klienci WHERE id_klienci == '%s'", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu klienta.";
        }
        return "Klienta usuniêto pomyœlnie.";
	}
	
	public static String deleteProduct(String param) {
        String delete = String.format("DELETE * FROM produkty WHERE id_p == '%s'", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu produktu.";
        }
        return "Produkt usuniêto pomyœlnie.";
	}
	
	public static String deleteTransaction(String param) {
        String delete = String.format("DELETE * FROM zakupy WHERE id_zakupy == '%s'", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu tranzakcji.";
        }
        return "Tranzakcjê usuniêto pomyœlnie.";
	}
	
	public static String deleteAccount(String param) {
        String delete = String.format("DELETE * FROM konto WHERE id_konto == '%s'", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu konta.";
        }
        return "Konto usuniêto pomyœlnie.";
	}
}
*/
