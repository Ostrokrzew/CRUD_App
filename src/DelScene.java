import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DelScene implements EventHandler<ActionEvent> {
	
	Button wstecz, delete0, delete1, delete2, delete3;
	PopUp alertDel = new PopUp();
	
	TableView<Klienci> clientTable;
	TableView<Produkty> productsTable;
	TableView<Zakupy> transactionTable;
	TableView<Konto> accountTable;
	
	private String param, id, kon;
	
	public Scene scene() {
		
		clientTable = Klienci.clientTable();
		GridPane.setConstraints(clientTable, 0, 0);
		
		productsTable = Produkty.productsTable();
		GridPane.setConstraints(productsTable, 0, 2);
		
		transactionTable = Zakupy.transactionTable();
		GridPane.setConstraints(transactionTable, 2, 0);
		
		accountTable = Konto.accountTable();
		GridPane.setConstraints(accountTable, 2, 2);
		
		wstecz = new Button("wstecz");
		wstecz.setOnAction(this);
		GridPane.setConstraints(wstecz, 1, 3);

		delete0 = new Button("usuñ");
		delete0.setOnAction(this);
		
		delete1 = new Button("usuñ");
		delete1.setOnAction(this);
		
		delete2 = new Button("usuñ");
		delete2.setOnAction(this);
		
		delete3 = new Button("usuñ");
		delete3.setOnAction(this);
		
		HBox layoutDel0 = new HBox(16);
		layoutDel0.setPadding(new Insets(8,8,8,8));
		layoutDel0.setAlignment(Pos.BOTTOM_CENTER);
		layoutDel0.getChildren().addAll(delete0);
		GridPane.setConstraints(layoutDel0, 0, 1);
		
		HBox layoutDel1 = new HBox(16);
		layoutDel1.setPadding(new Insets(8,8,8,8));
		layoutDel1.setAlignment(Pos.BOTTOM_CENTER);
		layoutDel1.getChildren().addAll(delete1);
		GridPane.setConstraints(layoutDel1, 0, 3);
		
		HBox layoutDel2 = new HBox(16);
		layoutDel2.setPadding(new Insets(8,8,8,8));
		layoutDel2.setAlignment(Pos.BOTTOM_CENTER);
		layoutDel2.getChildren().addAll(delete2);
		GridPane.setConstraints(layoutDel2, 2, 1);
		
		HBox layoutDel3 = new HBox(16);
		layoutDel3.setPadding(new Insets(8,8,8,8));
		layoutDel3.setAlignment(Pos.BOTTOM_CENTER);
		layoutDel3.getChildren().addAll(delete3);
		GridPane.setConstraints(layoutDel3, 2, 3);

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(8,8,8,8));
		layout.setVgap(8);
		layout.setHgap(16);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(clientTable, layoutDel0, productsTable, layoutDel1, wstecz, transactionTable, layoutDel2, accountTable, layoutDel3);
		
		Scene scene = new Scene(layout, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == wstecz) {
			Utils.refresh();
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == delete0) {
			if (Utils.getRowKlienciId() != "0") {
				alertDel.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ klienta?\nOperacji nie mo¿na cofn¹æ!", true);
				if (alertDel.answer == true) {
					id = Utils.getRowKlienciId();
					kon = Utils.getRowKlienciKon();
					Delete.deleteClient(id, kon);
				}
			}
			else {
				alertDel.popUp("B³¹d", "Zaznacz wiersz, który chcesz usun¹æ.", false);
			}
			Utils.refresh();
		}
		else if(event.getSource() == delete1) {
			if (Utils.getRowProdukty() != "0") {
			alertDel.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ produkt?\nOperacji nie mo¿na cofn¹æ!", true);
			if (alertDel.answer == true) {
				param = Utils.getRowProdukty();
				Delete.deleteProduct(param);
			}
			}
			else {
				alertDel.popUp("B³¹d", "Zaznacz wiersz, który chcesz usun¹æ.", false);
			}
			Utils.refresh();
		}
		else if(event.getSource() == delete2) {
			if (Utils.getRowZakupy() != "0") {
				alertDel.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ transakcjê?\nOperacji nie mo¿na cofn¹æ!", true);
				if (alertDel.answer == true) {
					param = Utils.getRowZakupy();
					Delete.deleteTransaction(param);
				}
			}
			else {
				alertDel.popUp("B³¹d", "Zaznacz wiersz, który chcesz usun¹æ.", false);
			}
			Utils.refresh();
		}
		else if(event.getSource() == delete3) {
			if (Utils.getRowKonta() != "0") {
				alertDel.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ konto?\nOperacji nie mo¿na cofn¹æ!", true);
				if (alertDel.answer == true) {
					param = Utils.getRowKonta();
					Delete.deleteAccount(param);
				}
			}
			else {
				alertDel.popUp("B³¹d", "Zaznacz wiersz, który chcesz usun¹æ.", false);
			}
			Utils.refresh();
		}
	}
}