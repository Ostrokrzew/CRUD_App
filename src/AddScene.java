import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
	private String imie, nazwisko, id_konto, message;
	
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
		layoutAdd1.getChildren().addAll(add1);
		GridPane.setConstraints(layoutAdd1, 0, 3);
		
		HBox layoutAdd2 = new HBox(16);
		layoutAdd2.setPadding(new Insets(8,8,8,8));
		layoutAdd2.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd2.getChildren().addAll(add2);
		GridPane.setConstraints(layoutAdd2, 2, 1);
		
		HBox layoutAdd3 = new HBox(16);
		layoutAdd3.setPadding(new Insets(8,8,8,8));
		layoutAdd3.setAlignment(Pos.BOTTOM_CENTER);
		layoutAdd3.getChildren().addAll(add3);
		GridPane.setConstraints(layoutAdd3, 2, 3);

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(8,8,8,8));
		layout.setVgap(8);
		layout.setHgap(16);
		layout.getChildren().addAll(clientTable, layoutAdd0, productsTable, layoutAdd1, wstecz, transactionTable, layoutAdd2, accountTable, layoutAdd3);
		GridPane.setHalignment(layout, HPos.CENTER);
		GridPane.setValignment(layout, VPos.CENTER);
		
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
			}
			client0.clear();
			client1.clear();
			client2.clear();
			Klienci.clientTable.setItems(ShowMeDB.showKlienci());
			clientTable.refresh();
			PopUp konto = new PopUp();
			konto.popUp("Info", message, false);
		}
		else if(event.getSource() == add1) {

		}
		else if(event.getSource() == add2) {

		}
		else if(event.getSource() == add3) {

		}
	}
}
