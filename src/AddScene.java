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

public class AddScene implements EventHandler<ActionEvent> {
	
	Button wstecz, add0, add1, add2, add3;
	
	static TableView<Klienci> clientTable;
	static TableView<Produkty> productsTable;
	static TableView<Zakupy> transactionTable;
	static TableView<Konto> accountTable;
	
	TextField client0, client1, client2, product0, product1, product2, account2;
	private String imie, nazwisko, id_konto, message, id_produkty, nazwa, cena, kwota, data_zakupy;
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
		
		Utils.fillBoxesAdd();
		
		wstecz = new Button("wstecz");
		wstecz.setOnAction(this);
		GridPane.setConstraints(wstecz, 1, 3);
		
		client0 = new TextField();
		client0.setPromptText("Imiê");
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

		add0 = new Button("dodaj");
		add0.setOnAction(this);
		
		add1 = new Button("dodaj");
		add1.setOnAction(this);
		
		add2 = new Button("dodaj");
		add2.setOnAction(this);
		
		add3 = new Button("dodaj");
		add3.setOnAction(this);
		
		HBox layoutAdd0 = new HBox(16);
		layoutAdd0.setPadding(new Insets(8,8,8,8));
		layoutAdd0.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd0.getChildren().addAll(client0, client1, client2, add0);
		GridPane.setConstraints(layoutAdd0, 0, 1);
		
		HBox layoutAdd1 = new HBox(16);
		layoutAdd1.setPadding(new Insets(8,8,8,8));
		layoutAdd1.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd1.getChildren().addAll(product0, product1, product2, add1);
		GridPane.setConstraints(layoutAdd1, 0, 3);
		
		HBox layoutAdd2 = new HBox(16);
		layoutAdd2.setPadding(new Insets(8,8,8,8));
		layoutAdd2.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd2.getChildren().addAll(trans0, trans1, trans2, add2);
		GridPane.setConstraints(layoutAdd2, 2, 1);
		
		HBox layoutAdd3 = new HBox(16);
		layoutAdd3.setPadding(new Insets(8,8,8,8));
		layoutAdd3.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd3.getChildren().addAll(account0, account1, account2, add3);
		GridPane.setConstraints(layoutAdd3, 2, 3);

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(8,8,8,8));
		layout.setVgap(8);
		layout.setHgap(16);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(clientTable, layoutAdd0, productsTable, layoutAdd1, wstecz, transactionTable, layoutAdd2, accountTable, layoutAdd3);
		
		Scene scene = new Scene(layout, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		if(event.getSource() == wstecz) {
			Utils.flushBoxes();
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == add0) {
			boolean okey = false;
			try {
				nazwisko = client1.getText().trim();
				imie = client0.getText().trim();
				okey = true;
				try {
					int id = Integer.parseInt(client2.getText().trim());
					id_konto = Integer.toString(id);
					okey = true;
				} catch(NumberFormatException e) {
					PopUp konto = new PopUp();
					konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
					okey = false;
				}
			} catch(NullPointerException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Uzupe³nij dane klienta.\nSpróbuj jeszcze raz.", false);
				okey = false;
			}
			if (okey == true) {
				message = Add.addClient(imie, nazwisko, id_konto);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			client0.clear();
			client1.clear();
			client2.clear();
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesAdd();
		}
		else if(event.getSource() == add1) {
			boolean okey = false;
			try {
				nazwa = product0.getText().trim();
				okey = true;
				try {
					int id = Integer.parseInt(product2.getText().trim());
					id_produkty = Integer.toString(id);
					okey = true;
				} catch(NumberFormatException e) {
					PopUp konto = new PopUp();
					konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
					okey = false;
				}
				try {
					double price = Double.parseDouble(product1.getText().trim());
					cena = Double.toString(price);
					okey = true;
				} catch(NumberFormatException e) {
					PopUp konto = new PopUp();
					konto.popUp("B³¹d", "B³êdna cena.\nSpróbuj jeszcze raz.", false);
					okey = false;
				}
			} catch(NullPointerException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Uzupe³nij dane produktu.\nSpróbuj jeszcze raz.", false);
				okey = false;
			}
			if (okey == true) {
				message = Add.addProduct(id_produkty, nazwa, cena);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			product0.clear();
			product1.clear();
			product2.clear();
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesAdd();
		}
		else if(event.getSource() == add2) {
			boolean okey = false;
			try {
				data_zakupy = trans2.getValue().toString() + " 21:37:00.000";
				id_produkty = trans1.getValue().toString();
				id_konto = trans0.getValue().toString();
				okey = true;
			} catch (NullPointerException e ) {
				okey = false;
				PopUp alert = new PopUp();
				alert.popUp("B³¹d", "Uzupe³nij dane transakcji", false);
			}
			if (okey == true) {
				message = Add.addTransaction(id_konto, id_produkty, data_zakupy);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			trans0.setValue(null);
			trans1.setValue(null);
			trans2.setValue(null);
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesAdd();
		}
		else if (event.getSource() == add3) {
			boolean okey = false;
			try {
				id_konto = account0.getValue().toString();
				nazwisko = account1.getValue();
				okey = true;
				try {
					double sum = Double.parseDouble(account2.getText().trim());
					kwota = Double.toString(sum);
					okey = true;
				} catch(NumberFormatException e) {
					PopUp konto = new PopUp();
					konto.popUp("B³¹d", "B³êdne saldo. Spróbuj jeszcze raz.", false);
					okey = false;
				}
			} catch (NullPointerException e) {
				okey = false;
				PopUp alert = new PopUp();
				alert.popUp("B³¹d", "Uzupe³nij dane konta", false);
			}
			if (okey == true) {
				message = Add.addAccount(id_konto, kwota, nazwisko);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			account0.setValue(null);
			account1.setValue(null);
			account2.clear();
			Utils.refresh();
			Utils.flushBoxes();
			Utils.fillBoxesAdd();
		}
	}
}
