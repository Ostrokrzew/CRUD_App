public class Utils {
	
	public static void refresh() {
		Klienci.clientTable.setItems(ShowMeDB.showKlienci());
		Klienci.clientTable.refresh();
		Produkty.productsTable.setItems(ShowMeDB.showProdukty());
		Produkty.productsTable.refresh();
		Zakupy.transactionTable.setItems(ShowMeDB.showZakupy());
		Zakupy.transactionTable.refresh();
		Konto.accountTable.setItems(ShowMeDB.showKonto());
		Konto.accountTable.refresh();
	}
	
	public static String getRowKlienciId() {
		try {
			int row = Klienci.clientTable.getSelectionModel().getSelectedItem().getId_klienci();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
	
	public static String getRowKlienciKon() {
		try {
			int row = Klienci.clientTable.getSelectionModel().getSelectedItem().getId_konto();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
	
	public static String getRowProdukty() {
		try {
			int row = Produkty.productsTable.getSelectionModel().getSelectedItem().getId_produkty();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
	
	public static String getRowZakupy() {
		try {
			int row = Zakupy.transactionTable.getSelectionModel().getSelectedItem().getId_zakupy();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
	
	public static String getRowKonta() {
		try {
			int row = Konto.accountTable.getSelectionModel().getSelectedItem().getId_konto();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
}
