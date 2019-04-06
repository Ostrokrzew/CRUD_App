import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ModScene implements EventHandler<ActionEvent> {
	
	Button wstecz, update0, update1, update2, update3;
	PopUp alertMod;
	
	static TableView<Klienci> clientTable;
	static TableView<Produkty> productsTable;
	static TableView<Zakupy> transactionTable;
	static TableView<Konto> accountTable;
	
	TextField client0, client1, client2, product0, product1, product2, account2;
	private String value0, value1, value2, id_value, message;
	DatePicker trans2;
	static ChoiceBox<Integer> trans0, trans1, account0;
	static ChoiceBox<String> account1;
	
	public Scene scene() {
			
		clientTable = Klienci.clientTable();
		GridPane.setConstraints(clientTable, 0, 0);
		
		productsTable = Produkty.productsTable();
		GridPane.setConstraints(productsTable, 0, 2);
		
		transactionTable = Zakupy.transactionTable();
		GridPane.setConstraints(transactionTable, 2, 0);
		
		accountTable = Konto.accountTable();
		GridPane.setConstraints(accountTable, 2, 2);
		
		Utils.fillBoxesMod();
		
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
		client0.setPromptText("Imi�");
		client0.setPrefWidth(128);
		
		client1 = new TextField();
		client1.setPromptText("Nazwisko");
		client1.setPrefWidth(128);
		
		client2 = new TextField();
		client2.setPromptText("Numer konta");
		client2.setPrefWidth(128);
		
		product0 = new TextField();
		product0.setPromptText("Nazwa");
		product0.setPrefWidth(128);
		
		product1 = new TextField();
		product1.setPromptText("Cena");
		product1.setPrefWidth(128);
		
		product2 = new TextField();
		product2.setPromptText("Kod produktu");
		product2.setPrefWidth(128);
		
		trans0 = new ChoiceBox<Integer>();
		trans0.setItems(Klienci.avaliableAccounts);
		trans0.setPrefWidth(128);
		
		trans1 = new ChoiceBox<Integer>();
		trans1.setItems(Produkty.avaliableProducts);
		trans1.setPrefWidth(128);
		
		trans2 = new DatePicker();
		trans2.setPrefWidth(144);
		trans2.setValue(LocalDate.now());
		
		account0 = new ChoiceBox<Integer>();
		account0.setItems(Klienci.avaliableAccounts);
		account0.setPrefWidth(128);
		
		account1 = new ChoiceBox<String>();
		account1.setItems(Klienci.avaliableSurnames);
		account1.setPrefWidth(128);
		
		account2 = new TextField();
		account2.setPromptText("Saldo");
		account2.setPrefWidth(128);

		
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
			Utils.flushBoxes();
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs�uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == update0) {
			if (Utils.getRowKlienciId() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieni� rekord?", true);
				id_value = Utils.getRowKlienciId();
				boolean okey = false;
				if (alertMod.answer == true) {
					value0 = client0.getText().trim();
					value1 = client1.getText().trim();
					okey = true;
					try {
						int temp = Integer.parseInt(client2.getText().trim());
						value2 = Integer.toString(temp);
						okey = true;
					} catch(NumberFormatException e) {
						PopUp konto = new PopUp();
						konto.popUp("B��d", "B��dny numer konta.\nSpr�buj jeszcze raz.", false);
						okey = false;
					}
				}
				if (okey == true) {
					message = Update.changeClient(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}
				client0.clear();
				client1.clear();
				client2.clear();
				Utils.refresh();
				Utils.flushBoxes();
				Utils.fillBoxesMod();
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B��d", "Zaznacz wiersz, w kt�rym chcesz dokona� zmian.", false);
			}
		}
		else if(event.getSource() == update1) {
			if (Utils.getRowProdukty() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieni� rekord?", true);
				id_value = Utils.getRowProdukty();
				boolean okey = false;
				if (alertMod.answer == true) {
					value0 = product0.getText();
					value1 = product1.getText();
					okey = true;
					try {
						int temp = Integer.parseInt(product2.getText().trim());
						value2 = Integer.toString(temp);
						okey = true;
					} catch(NumberFormatException e) {
						PopUp konto = new PopUp();
						konto.popUp("B��d", "B��dny kod produktu.\nSpr�buj jeszcze raz.", false);
						okey = false;
					}
				}
				if (okey == true) {
					message = Update.changeProduct(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}
				product0.clear();
				product1.clear();
				product2.clear();
				Utils.refresh();
				Utils.flushBoxes();
				Utils.fillBoxesMod();
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B��d", "Zaznacz wiersz, w kt�rym chcesz dokona� zmian.", false);
			}
		}
		else if(event.getSource() == update2) {
			if (Utils.getRowZakupy() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieni� rekord?", true);
				id_value = Utils.getRowZakupy();
				boolean okey = false;
				if (alertMod.answer == true) {
					value0 = trans0.getValue().toString();
					value1 = trans1.getValue().toString();
					value2 = trans2.getValue().toString() + " 21:37:00.000";
					okey = true;
					}
				if (okey == true) {
					message = Update.changeTransaction(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}
				trans0.setValue(null);
				trans1.setValue(null);
				trans2.setValue(null);
				Utils.refresh();
				Utils.flushBoxes();
				Utils.fillBoxesMod();
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B��d", "Zaznacz wiersz, w kt�rym chcesz dokona� zmian.", false);
			}
		}
		else if(event.getSource() == update3) {
			if (Utils.getRowKonta() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieni� rekord?", true);
				id_value = Utils.getRowKonta();
				boolean okey = false;
				if (alertMod.answer == true) {
					value0 = account0.getValue().toString();
					value1 = account1.getValue().toString();
					okey = true;
					try {
						double temp = Double.parseDouble(account2.getText().trim());
						value2 = Double.toString(temp);
						okey = true;
					} catch(NumberFormatException e) {
						PopUp konto = new PopUp();
						konto.popUp("B��d", "B��dne saldo. Spr�buj jeszcze raz.", false);
						okey = false;
					}
				if (okey == true) {
					message = Update.changeAccount(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}
				account0.setValue(null);
				account1.setValue(null);
				account2.clear();
				Utils.refresh();
				Utils.flushBoxes();
				Utils.fillBoxesMod();
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B��d", "Zaznacz wiersz, w kt�rym chcesz dokona� zmian.", false);
			}
		}
	}
}