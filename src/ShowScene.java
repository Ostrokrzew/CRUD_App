import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ShowScene implements EventHandler<ActionEvent> {
	
	Button wstecz;
	PopUp alertMod;
	
	TableView<Klienci> clientTable;
	TableView<Produkty> productsTable;
	TableView<Zakupy> transactionTable;
	TableView<Konto> accountTable;
	
	TextField client0, client1, client2, product0, product1, product2, trans0, trans1, trans2, account1, account2;
	ChoiceBox<Integer> clientID, productID, transID, accountID;
	private String toSplit, id_value;
	
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
		trans0.setPromptText("Nr konta");
		trans0.setMaxWidth(128);
		
		trans1 = new TextField();
		trans1.setPromptText("Kod produktu");
		trans1.setMaxWidth(128);
		
		trans2 = new TextField();
		trans2.setPromptText("Data (rrrr-mm-dd)");
		trans2.setMaxWidth(144);
		
		account1 = new TextField();
		account1.setPromptText("Nazwisko");
		account1.setMaxWidth(128);
		
		account2 = new TextField();
		account2.setPromptText("Saldo");
		account2.setMaxWidth(128);
		
		clientID = new ChoiceBox<>();
		for (int i = 1; i <= clientTable.getItems().size(); i++) {
			clientID.getItems().add(i);
		}
		clientID.setMaxWidth(192);
		clientID.setOnAction(this);

		
		productID = new ChoiceBox<>();
		for (int i = 1; i <= productsTable.getItems().size(); i++) {
			productID.getItems().add(i);
		}
		productID.setMaxWidth(192);
		productID.setOnAction(this);

		
		transID = new ChoiceBox<>();
		for (int i = 1; i <= transactionTable.getItems().size(); i++) {
			transID.getItems().add(i);
		}
		transID.setMaxWidth(192);
		transID.setOnAction(this);
		
		accountID = new ChoiceBox<>();
		for (int i = 1; i <= accountTable.getItems().size(); i++) {
			accountID.getItems().add(i);
		}
		accountID.setMaxWidth(192);
		accountID.setOnAction(this);

		
		HBox layoutShow0 = new HBox(16);
		layoutShow0.setPadding(new Insets(8,8,8,8));
		layoutShow0.setAlignment(Pos.BOTTOM_CENTER);
		layoutShow0.getChildren().addAll(clientID, client0, client1, client2);
		GridPane.setConstraints(layoutShow0, 0, 1);
		
		HBox layoutShow1 = new HBox(16);
		layoutShow1.setPadding(new Insets(8,8,8,8));
		layoutShow1.setAlignment(Pos.BOTTOM_CENTER);
		layoutShow1.getChildren().addAll(productID, product0, product1, product2);
		GridPane.setConstraints(layoutShow1, 0, 3);
		
		HBox layoutShow2 = new HBox(16);
		layoutShow2.setPadding(new Insets(8,8,8,8));
		layoutShow2.setAlignment(Pos.BOTTOM_CENTER);
		layoutShow2.getChildren().addAll(transID, trans0, trans1, trans2);
		GridPane.setConstraints(layoutShow2, 2, 1);
		
		HBox layoutShow3 = new HBox(16);
		layoutShow3.setPadding(new Insets(8,8,8,8));
		layoutShow3.setAlignment(Pos.BOTTOM_CENTER);
		layoutShow3.getChildren().addAll(accountID, account1, account2);
		GridPane.setConstraints(layoutShow3, 2, 3);

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(8,8,8,8));
		layout.setVgap(8);
		layout.setHgap(16);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(clientTable, layoutShow0, productsTable, layoutShow1, wstecz, transactionTable, layoutShow2, accountTable, layoutShow3);
		
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
		else if (event.getSource() == clientID) {
			id_value = clientID.getSelectionModel().getSelectedItem().toString();
			toSplit = Show.selectClient(id_value);
			String[] splitted = toSplit.split(",");
			client0.setText(splitted[0]);
			client1.setText(splitted[1]);
			client2.setText(splitted[2]);
		}
		else if (event.getSource() == productID) {
			id_value = productID.getSelectionModel().getSelectedItem().toString();
			toSplit = Show.selectProduct(id_value);
			String[] splitted = toSplit.split(",");
			product0.setText(splitted[0]);
			product1.setText(splitted[1]);
			product2.setText(splitted[2]);
		}
		else if (event.getSource() == transID) {
			id_value = transID.getSelectionModel().getSelectedItem().toString();
			toSplit = Show.selectTransaction(id_value);
			String[] splitted = toSplit.split(",");
			trans0.setText(splitted[0]);
			trans1.setText(splitted[1]);
			trans2.setText(splitted[2]);
		}
		else if (event.getSource() == accountID) {
			id_value = accountID.getSelectionModel().getSelectedItem().toString();
			toSplit = Show.selectAccount(id_value);
			String[] splitted = toSplit.split(",");
			account1.setText(splitted[0]);
			account2.setText(splitted[1]);
		}
	}
}