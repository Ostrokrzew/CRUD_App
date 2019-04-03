import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ModScene implements EventHandler<ActionEvent> {
	
	Button wstecz, update0, update1, update2, update3;
	PopUp alertMod;
	TableView<Klienci> clientTable;
	TableView<Produkty> productsTable;
	TableView<Zakupy> transactionTable;
	TableView<Konto> accountTable;
	
	TextField client0, client1, client2, product0, product1, product2, trans0, trans1, trans2, account0, account1, account2;
	private String imie, nazwisko, id_konto, message, id_produkty, nazwa, cena, kwota, id_klienci, data_zakupy;
	
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

		update0 = new Button("zmodyfikuj");
		update0.setOnAction(this);
		
		update1 = new Button("zmodyfikuj");
		update1.setOnAction(this);
		
		update2 = new Button("zmodyfikuj");
		update2.setOnAction(this);
		
		update3 = new Button("zmodyfikuj");
		update3.setOnAction(this);
		
		client0 = new TextField();
		client0.setPromptText("Imiê");
		client0.setMaxWidth(128);
		
		client1 = new TextField();
		client1.setPromptText("Nazwisko");
		client1.setMaxWidth(128);
		
		client2 = new TextField();
		client2.setPromptText("Numer konta");
		client2.setMaxWidth(128);
		
		product0 = new TextField();
		product0.setPromptText("Nazwa");
		product0.setMaxWidth(128);
		
		product1 = new TextField();
		product1.setPromptText("Cena");
		product1.setMaxWidth(128);
		
		product2 = new TextField();
		product2.setPromptText("Kod produktu");
		product2.setMaxWidth(128);
		
		trans0 = new TextField();
		trans0.setPromptText("Nr Klienta");
		trans0.setMaxWidth(128);
		
		trans1 = new TextField();
		trans1.setPromptText("Kod produktu");
		trans1.setMaxWidth(128);
		
		trans2 = new TextField();
		trans2.setPromptText("Data (rrrr-mm-dd)");
		trans2.setMaxWidth(144);
		
		account0 = new TextField();
		account0.setPromptText("Kod Produktu");
		account0.setMaxWidth(128);
		
		account1 = new TextField();
		account1.setPromptText("Saldo");
		account1.setMaxWidth(128);
		
		account2 = new TextField();
		account2.setPromptText("Nazwisko");
		account2.setMaxWidth(128);
		
		HBox layoutMod0 = new HBox(16);
		layoutMod0.setPadding(new Insets(8,8,8,8));
		layoutMod0.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod0.getChildren().addAll(client0, client1, client2, update0);
		GridPane.setConstraints(layoutMod0, 0, 1);
		
		HBox layoutMod1 = new HBox(16);
		layoutMod1.setPadding(new Insets(8,8,8,8));
		layoutMod1.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod1.getChildren().addAll(product0, product1, product2, update1);
		GridPane.setConstraints(layoutMod1, 0, 3);
		
		HBox layoutMod2 = new HBox(16);
		layoutMod2.setPadding(new Insets(8,8,8,8));
		layoutMod2.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod2.getChildren().addAll(trans0, trans1, trans2, update2);
		GridPane.setConstraints(layoutMod2, 2, 1);
		
		HBox layoutMod3 = new HBox(16);
		layoutMod3.setPadding(new Insets(8,8,8,8));
		layoutMod3.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod3.getChildren().addAll(account0, account1, account2, update3);
		GridPane.setConstraints(layoutMod3, 2, 3);

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(8,8,8,8));
		layout.setVgap(8);
		layout.setHgap(16);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(clientTable, layoutMod0, productsTable, layoutMod1, wstecz, transactionTable, layoutMod2, accountTable, layoutMod3);
		
		Scene scene = new Scene(layout, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == wstecz) {
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == update0) {
			alertMod = new PopUp();
			alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
			if (alertMod.answer == true) {
				Update.changeClient(null, null, null, null);
			}
		}
		else if(event.getSource() == update0) {
			boolean okey = false;
			imie = client0.getText();
			nazwisko = client1.getText();
			try {
				int id = Integer.parseInt(client2.getText());
				id_konto = Integer.toString(id);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
				okey = false;
				}
			if (okey == true) {
				message = Update.changeClient(null, null, null, null);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			client0.clear();
			client1.clear();
			client2.clear();
			Utils.refresh();
		}
		else if(event.getSource() == update1) {
			System.out.println(Utils.getInfo());
		}
	}
}