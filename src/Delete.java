import java.sql.SQLException;

public class Delete {
	/*This class contains method that deletes chosen record*/
	
	public static String deleteClient(String id, String kon) {
        String delete = String.format("DELETE FROM klienci WHERE id_klienci == %s", id);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu klienta.";
        }
        return "Klienta usuniêto pomyœlnie.";
	}
	
	public static String deleteProduct(String param) {
        String delete = String.format("DELETE FROM produkty WHERE id_produkty == %s", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu produktu.";
        }
        return "Produkt usuniêto pomyœlnie.";
	}
	
	public static String deleteTransaction(String param) {
        String delete = String.format("DELETE FROM zakupy WHERE id_zakupy == %s", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu transakcji.";
        }
        return "transakcjê usuniêto pomyœlnie.";
	}
	
	public static String deleteAccount(String param) {
        String delete = String.format("DELETE FROM konto WHERE id_konto == %s", param);
        try {
            SQLite.stat.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy usuwaniu konta.";
        }
        return "Konto usuniêto pomyœlnie.";
	}
}
