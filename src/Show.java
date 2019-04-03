import java.sql.SQLException;

public class Show {
	/*This class contains method that shows chosen record*/
	
	//showing chosen record
	public static String select(String table, String id_name, String id_value) {
		String show = String.format("SELECT * FROM %s WHERE %s == %s", table, id_name, id_value);
        try {
            SQLite.stat.execute(show);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B³¹d przy wybieraniu rekordów.";
        }
        return "Rekord pokazano pomyœlnie.";
	}
}

/*	unnecessary code
	public static void printAll() {
		System.out.println("Klienci\n");
		ShowMeDB.showKlienci();
		System.out.println("\nProdukty\n");
		ShowMeDB.showProdukty();
		System.out.println("\nZakupy\n");
		ShowMeDB.showZakupy();
		System.out.println("\nKonta\n");
		ShowMeDB.showKonto();
	}

    public static void showClient(String numer) {
        List<String> klient = new ArrayList<String>();
        try {
        	String vrbl = String.format("SELECT * FROM klienci WHERE id_klienci = '%s'", numer);
            ResultSet result = SQLite.stat.executeQuery(vrbl);
            while(result.next()) {
                int id_klienci = result.getInt("id_klienci");
                int id_konto = result.getInt("id_konto");
                String imie = result.getString("imie");
                String nazwisko = result.getString("nazwisko");
                String id_klienta = Integer.toString(id_klienci);
                String id_konta = Integer.toString(id_konto);
                klient.add("numer klienta: " + id_klienta);
                klient.add("imiê: " + imie);
                klient.add("nazwisko: " + nazwisko);
                klient.add("numer konta: " + id_konta);
                klient.add("\n");
            }
        } catch (SQLException e) {
        	System.out.println("Nie ma takiego klienta.");
            e.printStackTrace();
        }
        for (int i=0;i<klient.size();i++)
        	System.out.println(klient.get(i));
    }
}
*/