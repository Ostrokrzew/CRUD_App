import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class AddScene implements EventHandler<ActionEvent> {
	
	Button wstecz, add0, add1, add2, add3;
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
		account0.setPromptText("Numer konta");
		account0.setMaxWidth(128);
		
		account1 = new TextField();
		account1.setPromptText("Nazwisko");
		account1.setMaxWidth(128);
		
		account2 = new TextField();
		account2.setPromptText("Saldo");
		account2.setMaxWidth(128);

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
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == add0) {
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
				message = Add.addClient(imie, nazwisko, id_konto);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			client0.clear();
			client1.clear();
			client2.clear();
			Utils.refresh();
		}
		else if(event.getSource() == add1) {
			boolean okey = false;
			nazwa = product0.getText();
			try {
				double price = Double.parseDouble(product1.getText());
				cena = Double.toString(price);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdna cena.\nSpróbuj jeszcze raz.", false);
				okey = false;
			}
			try {
				int id = Integer.parseInt(product2.getText());
				id_produkty = Integer.toString(id);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
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
		}
		else if(event.getSource() == add2) {
			boolean okey = false;
			try {
				int id = Integer.parseInt(trans0.getText());
				id_klienci = Integer.toString(id);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdny numer klienta.\nSpróbuj jeszcze raz.", false);
				okey = false;
			}
			try {
				int id = Integer.parseInt(trans1.getText());
				id_produkty = Integer.toString(id);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
				okey = false;
			}
			try {
				SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
				Date date = dateForm.parse(trans2.getText()); 
				data_zakupy = dateForm.format(date) + " 00:00:00.000";
				okey = true;
			} catch(ParseException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdna data. Spróbuj jeszcze raz.", false);
				okey = false;
			}
			if (okey == true) {
				message = Add.addTransaction(id_klienci, id_produkty, data_zakupy);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			trans0.clear();
			trans1.clear();
			trans2.clear();
			Utils.refresh();
		}
		else if(event.getSource() == add3) {
			boolean okey = false;
			nazwisko = account1.getText();
			try {
				int id = Integer.parseInt(account0.getText());
				id_konto = Integer.toString(id);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
				okey = false;
				}
			try {
				double sum = Double.parseDouble(account2.getText());
				kwota = Double.toString(sum);
				okey = true;
			} catch(NumberFormatException e) {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "B³êdne saldo. Spróbuj jeszcze raz.", false);
				okey = false;
			}
			if (okey == true) {
				message = Add.addAccount(id_konto, kwota, nazwisko);
				PopUp konto = new PopUp();
				konto.popUp("Info", message, false);
			}
			account0.clear();
			account1.clear();
			account2.clear();
			Utils.refresh();
		}
	}
}
