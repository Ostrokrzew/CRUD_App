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
		clientTable.getSelectionModel().selectFirst();
		
		productsTable = Produkty.productsTable();
		GridPane.setConstraints(productsTable, 0, 2);
		productsTable.getSelectionModel().selectFirst();

		transactionTable = Zakupy.transactionTable();
		GridPane.setConstraints(transactionTable, 2, 0);
		transactionTable.getSelectionModel().selectFirst();

		accountTable = Konto.accountTable();
		GridPane.setConstraints(accountTable, 2, 2);
		accountTable.getSelectionModel().selectFirst();
		
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
		client0.setPromptText("Imiê");
		client0.setPrefWidth(128);
		client0.setText(clientTable.getSelectionModel().getSelectedItem().getImie());
		
		client1 = new TextField();
		client1.setPromptText("Nazwisko");
		client1.setPrefWidth(128);
		client1.setText(clientTable.getSelectionModel().getSelectedItem().getNazwisko());

		client2 = new TextField();
		client2.setPromptText("Numer konta");
		client2.setPrefWidth(128);
		String textNrKontaKlient = Integer.toString(clientTable.getSelectionModel().getSelectedItem().getId_konto());
		client2.setText(textNrKontaKlient);

		product0 = new TextField();
		product0.setPromptText("Nazwa");
		product0.setPrefWidth(128);
		product0.setText(productsTable.getSelectionModel().getSelectedItem().getNazwa());
		
		product1 = new TextField();
		product1.setPromptText("Cena");
		product1.setPrefWidth(128);
		String cenaProdukt = Double.toString(productsTable.getSelectionModel().getSelectedItem().getCena());
		product1.setText(cenaProdukt);
		
		product2 = new TextField();
		product2.setPromptText("Kod produktu");
		product2.setPrefWidth(128);
		String kodProduktuProdukt = Integer.toString(productsTable.getSelectionModel().getSelectedItem().getId_produkty());
		product2.setText(kodProduktuProdukt);

		trans0 = new ChoiceBox<Integer>();
		trans0.setItems(Klienci.avaliableAccounts);
		trans0.setPrefWidth(128);
		trans0.setValue(transactionTable.getSelectionModel().getSelectedItem().getId_konto());
		
		trans1 = new ChoiceBox<Integer>();
		trans1.setItems(Produkty.avaliableProducts);
		trans1.setPrefWidth(128);
		trans1.setValue(transactionTable.getSelectionModel().getSelectedItem().getId_produkty());

		trans2 = new DatePicker();
		trans2.setPrefWidth(144);
		trans2.setValue(LocalDate.now());
		
		account0 = new ChoiceBox<Integer>();
		account0.setItems(Klienci.avaliableAccounts);
		account0.setPrefWidth(128);
		account0.setValue(accountTable.getSelectionModel().getSelectedItem().getId_konto());
		
		account1 = new ChoiceBox<String>();
		account1.setItems(Klienci.avaliableSurnames);
		account1.setPrefWidth(128);
		account1.setValue(accountTable.getSelectionModel().getSelectedItem().getNazwisko());

		account2 = new TextField();
		account2.setPromptText("Saldo");
		account2.setPrefWidth(128);
		String kwotaKonto = Double.toString(accountTable.getSelectionModel().getSelectedItem().getKwota());
		account2.setText(kwotaKonto);
		
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
			Utils.refresh();
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == update0) {
			if (Utils.getRowKlienciId() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
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
						konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
						okey = false;
					}
				}
				if (okey == true) {
					message = Update.changeClient(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}

			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesMod();
		}
		else if(event.getSource() == update1) {
			if (Utils.getRowProdukty() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
				id_value = Utils.getRowProdukty();
				boolean okey = false;
				if (alertMod.answer == true) {
					value0 = product0.getText();
					try {
						double temp = Double.parseDouble(product2.getText().trim());
						value1 = Double.toString(temp);
						okey = true;
					} catch(NumberFormatException e) {
						PopUp konto = new PopUp();
						konto.popUp("B³¹d", "B³êdna cena produktu.\nSpróbuj jeszcze raz.", false);
						okey = false;
					}
					okey = true;
					try {
						int temp = Integer.parseInt(product2.getText().trim());
						value2 = Integer.toString(temp);
						okey = true;
					} catch(NumberFormatException e) {
						PopUp konto = new PopUp();
						konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
						okey = false;
					}
				}
				if (okey == true) {
					message = Update.changeProduct(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}

			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesMod();
		}
		else if(event.getSource() == update2) {
			if (Utils.getRowZakupy() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
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

			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesMod();
		}
		else if(event.getSource() == update3) {
			if (Utils.getRowKonta() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
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
						konto.popUp("B³¹d", "B³êdne saldo. Spróbuj jeszcze raz.", false);
						okey = false;
					}
				if (okey == true) {
					message = Update.changeAccount(value0, value1, value2, id_value);
					PopUp konto = new PopUp();
					konto.popUp("Info", message, false);
				}
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesMod();
		}
		if (event.getSource() == clientTable) {
			client0.setText(clientTable.getSelectionModel().getSelectedItem().getImie());
			client1.setText(clientTable.getSelectionModel().getSelectedItem().getNazwisko());
			String textNrKontaKlient = Integer.toString(clientTable.getSelectionModel().getSelectedItem().getId_konto());
			client2.setText(textNrKontaKlient);
		}
	}
}