import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class ModScene implements EventHandler<ActionEvent> {
	
	Button wstecz, update0, update1, update2, update3;
	PopUp alertMod;
	
	TableView<Klienci> clientTable;
	TableView<Produkty> productsTable;
	TableView<Zakupy> transactionTable;
	TableView<Konto> accountTable;
	
	TextField client0, product0, trans0, account0;
	private String value, column, id_value, message, test;
	ChoiceBox<String> client1, product1, trans1, account1;
	
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
		client0.setPromptText("Nowa wartoœæ");
		client0.setMaxWidth(192);
				
		product0 = new TextField();
		product0.setPromptText("Nowa wartoœæ");
		product0.setMaxWidth(192);
		
		trans0 = new TextField();
		trans0.setPromptText("Nowa wartoœæ");
		trans0.setMaxWidth(192);
		
		account0 = new TextField();
		account0.setPromptText("Nowa wartoœæ");
		account0.setMaxWidth(192);
		
		client1 = new ChoiceBox<>();
		client1.getItems().addAll("Imiê", "Nazwisko", "Nr konta");
		client1.setValue("Imiê");
		client1.setMaxWidth(192);
		
		product1 = new ChoiceBox<>();
		product1.getItems().addAll("Kod produktu", "Nazwa", "Cena");
		product1.setValue("Kod produktu");
		product1.setMaxWidth(192);
		
		trans1 = new ChoiceBox<>();
		trans1.getItems().addAll("Nr konta", "Kod produktu", "Data transakcji");
		trans1.setValue("Nr klienta");
		trans1.setMaxWidth(192);
		
		account1 = new ChoiceBox<>();
		account1.getItems().addAll("Nr konta", "Nazwisko", "Saldo");
		account1.setValue("Nr konta");
		account1.setMaxWidth(192);
		
		HBox layoutMod0 = new HBox(16);
		layoutMod0.setPadding(new Insets(8,8,8,8));
		layoutMod0.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod0.getChildren().addAll(client0, client1, update0);
		GridPane.setConstraints(layoutMod0, 0, 1);
		
		HBox layoutMod1 = new HBox(16);
		layoutMod1.setPadding(new Insets(8,8,8,8));
		layoutMod1.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod1.getChildren().addAll(product0, product1, update1);
		GridPane.setConstraints(layoutMod1, 0, 3);
		
		HBox layoutMod2 = new HBox(16);
		layoutMod2.setPadding(new Insets(8,8,8,8));
		layoutMod2.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod2.getChildren().addAll(trans0, trans1, update2);
		GridPane.setConstraints(layoutMod2, 2, 1);
		
		HBox layoutMod3 = new HBox(16);
		layoutMod3.setPadding(new Insets(8,8,8,8));
		layoutMod3.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod3.getChildren().addAll(account0, account1, update3);
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
			if (Utils.getRowKlienciId() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
				id_value = Utils.getRowKlienciId();
				test = client1.getValue().toString();
				if (alertMod.answer == true) {
					boolean okey = false;
					if (test == "Imiê") {
						column = "imie";
						value = client0.getText();
						okey = true;
					}
					else if (test == "Nazwisko") {
						column = "nazwisko";
						value = client0.getText();
						okey = true;
					}
					else if (test == "Nr konta") {
						column = "id_konto";
						try {
							int temp = Integer.parseInt(client0.getText());
							value = Integer.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					if (okey == true) {
						message = Update.changeClient(column, value, id_value);
						PopUp konto = new PopUp();
						konto.popUp("Info", message, false);
					}
					client0.clear();
					Utils.refresh();
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
		}
		else if(event.getSource() == update1) {
			if (Utils.getRowProdukty() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
				id_value = Utils.getRowProdukty();
				test = product1.getValue().toString();
				if (alertMod.answer == true) {
					boolean okey = false;
					if (test == "Kod produktu") {
						column = "id_produkty";
						try {
							int temp = Integer.parseInt(product0.getText());
							value = Integer.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					else if (test == "Nazwa") {
						column = "nazwa";
						value = product0.getText();
						okey = true;
					}
					else if (test == "Cena") {
						column = "cena";
						try {
							double temp = Double.parseDouble(product0.getText());
							value = Double.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdna cena. Spróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					if (okey == true) {
						message = Update.changeProduct(column, value, id_value);
						PopUp konto = new PopUp();
						konto.popUp("Info", message, false);
					}
					product0.clear();
					Utils.refresh();
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
		}
		else if(event.getSource() == update2) {
			if (Utils.getRowZakupy() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
				id_value = Utils.getRowZakupy();
				test = trans1.getValue().toString();
				if (alertMod.answer == true) {
					boolean okey = false;
					if (test == "Nr konta") {
						column = "id_konto";
						try {
							int temp = Integer.parseInt(trans0.getText());
							value = Integer.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdny numer konta.\nSpróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					if (test == "Kod produktu") {
						column = "id_produkty";
						try {
							int temp = Integer.parseInt(trans0.getText());
							value = Integer.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdny kod produktu.\nSpróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					else if (test == "Data transakcji") {
						column = "data_zakupy";
						try {
							SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
							Date date = dateForm.parse(trans0.getText()); 
							value = dateForm.format(date) + " 00:00:00.000";
							okey = true;
						} catch(ParseException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdna data. Spróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					if (okey == true) {
						message = Update.changeTransaction(column, value, id_value);
						PopUp konto = new PopUp();
						konto.popUp("Info", message, false);
					}
					trans0.clear();
					Utils.refresh();
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
		}
		else if(event.getSource() == update3) {
			if (Utils.getRowKonta() != "0") {
				alertMod = new PopUp();
				alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
				id_value = Utils.getRowKonta();
				test = account1.getValue().toString();
				if (alertMod.answer == true) {
					boolean okey = false;
					if (test == "Nr konta") {
						column = "id_konto";
						try {
							int temp = Integer.parseInt(account0.getText());
							value = Integer.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdny numer klienta.\nSpróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					if (test == "Saldo") {
						column = "kwota";
						try {
							double temp = Double.parseDouble(account0.getText());
							value = Double.toString(temp);
							okey = true;
						} catch(NumberFormatException e) {
							PopUp konto = new PopUp();
							konto.popUp("B³¹d", "B³êdna cena. Spróbuj jeszcze raz.", false);
							okey = false;
						}
					}
					else if (test == "Nazwisko") {
						column = "nazwisko";
						value = account0.getText();
						okey = true;
					}
					if (okey == true) {
						message = Update.changeAccount(column, value, id_value);
						PopUp konto = new PopUp();
						konto.popUp("Info", message, false);
					}
					account0.clear();
					Utils.refresh();
				}
			}
			else {
				PopUp konto = new PopUp();
				konto.popUp("B³¹d", "Zaznacz wiersz, w którym chcesz dokonaæ zmian.", false);
			}
		}
	}
}