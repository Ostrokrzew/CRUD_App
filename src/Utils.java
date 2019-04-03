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
	public static String getInfo() {
		 String info = Klienci.clientTable.getSelectionModel().getSelectedCells().toString();
		 return info;
	}
}
