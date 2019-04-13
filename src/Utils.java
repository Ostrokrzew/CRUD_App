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
			int row = Produkty.productsTable.getSelectionModel().getSelectedItem().getId_p();
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
			int row = Konto.accountTable.getSelectionModel().getSelectedItem().getId_k();
			String id = Integer.toString(row);
			return id;
		} catch (NullPointerException e) {
			return "0";
		}
	}
	
	public static void fillBoxesAdd() {
		
		for (int i = 0; i < AddScene.clientTable.getItems().size(); i++) {
			Klienci.avaliableAccounts.add(AddScene.clientTable.getItems().get(i).getId_konto());
		}
		for (int i = 0; i < AddScene.clientTable.getItems().size(); i++) {
			Klienci.avaliableSurnames.add(AddScene.clientTable.getItems().get(i).getNazwisko());
		}
		for (int i = 0; i < AddScene.productsTable.getItems().size(); i++) {
			Produkty.avaliableProducts.add(AddScene.productsTable.getItems().get(i).getId_produkty());
		}
	}
	
	public static void fillBoxesMod() {

		for (int i = 0; i < ModScene.clientTable.getItems().size(); i++) {
			Klienci.avaliableAccounts.add(ModScene.clientTable.getItems().get(i).getId_konto());
		}
		for (int i = 0; i < ModScene.clientTable.getItems().size(); i++) {
			Klienci.avaliableSurnames.add(ModScene.clientTable.getItems().get(i).getNazwisko());
		}
		for (int i = 0; i < ModScene.productsTable.getItems().size(); i++) {
			Produkty.avaliableProducts.add(ModScene.productsTable.getItems().get(i).getId_produkty());
		}
		for (int i = 0; i < ModScene.clientTable.getItems().size(); i++) {
			Klienci.availableIds.add(ModScene.clientTable.getItems().get(i).getId_klienci());
		}
	}
	
	public static void fillBoxesShow() {

		for (int i = 0; i < ShowScene.productsTable.getItems().size(); i++) {
			Produkty.avaliableIds.add(ShowScene.productsTable.getItems().get(i).getId_p());
		}
		for (int i = 0; i < ShowScene.clientTable.getItems().size(); i++) {
			Klienci.availableIds.add(ShowScene.clientTable.getItems().get(i).getId_klienci());
		}
		for (int i = 0; i < ShowScene.transactionTable.getItems().size(); i++) {
			Zakupy.availableIds.add(ShowScene.transactionTable.getItems().get(i).getId_zakupy());
		}
		for (int i = 0; i < ShowScene.accountTable.getItems().size(); i++) {
			Konto.availableIds.add(ShowScene.accountTable.getItems().get(i).getId_k());
		}
	}
	
	public static void flushBoxes() {
		Klienci.avaliableAccounts.clear();
		Klienci.avaliableSurnames.clear();
		Produkty.avaliableProducts.clear();
		Klienci.availableIds.clear();
	}
}
