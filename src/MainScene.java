import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScene implements EventHandler<ActionEvent> {
	
	Button dodaj, usun, zmodyfikuj, pokaz, reset, clear, insert;
	PopUp alertRes, alertClr, alertInit;
	boolean done;
	String database = SQLite.stat.toString();
	
	public Scene scene() {
		
		if (database == "") {
			done = false;
		}
		else {
			done = true;
		}
		
		insert = new Button("zainicjuj bazê danych i uzupe³nij j¹ domyœlnymi rekordami");
		insert.setOnAction(this);
		
		clear = new Button("opró¿nij bazê danych");
		clear.setOnAction(this);
		
		reset = new Button("zresetuj bazê danych");
		reset.setOnAction(this);
		
		dodaj = new Button("dodaj rekord");
		dodaj.setOnAction(this);
		
		usun = new Button("usuñ rekord");
		usun.setOnAction(this);
		
		zmodyfikuj = new Button("zmodyfikuj rekord");
		zmodyfikuj.setOnAction(this);
		
		pokaz = new Button("poka¿ rekord");
		pokaz.setOnAction(this);
		
		HBox layoutBott = new HBox(32);
		layoutBott.setPadding(new Insets(8,8,8,8));
		layoutBott.setAlignment(Pos.BOTTOM_CENTER);
		layoutBott.getChildren().addAll(reset, clear);
		
		HBox layoutTop = new HBox(32);
		layoutTop.setPadding(new Insets(8,8,8,8));
		layoutTop.setAlignment(Pos.TOP_CENTER);
		layoutTop.getChildren().addAll(dodaj, usun, zmodyfikuj, pokaz);
		
		VBox layout = new VBox(32);
		layout.setPadding(new Insets(8,8,8,8));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(insert, layoutTop, layoutBott);
		
		Scene scene = new Scene(layout, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == dodaj) {
			WindowForm.mainStage.setScene(WindowForm.addScene.scene());
			WindowForm.mainStage.setTitle("Dodaj rekord");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == usun) {
			WindowForm.mainStage.setScene(WindowForm.delScene.scene());
			WindowForm.mainStage.setTitle("Usuñ rekord");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == zmodyfikuj) {
			WindowForm.mainStage.setScene(WindowForm.modScene.scene());
			WindowForm.mainStage.setTitle("Zmieñ rekord");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == pokaz) {
			WindowForm.mainStage.setScene(WindowForm.showScene.scene());
			WindowForm.mainStage.setTitle("Poka¿ rekord");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == reset) {
			alertRes = new PopUp();
			alertRes.popUp("Reset", "Czy na pewno chcesz zresetowaæ ca³¹ bazê danych?", true);
			if (alertRes.answer == true) {
				AddRecords.reset();
				done = true;
			}
		}
		else if(event.getSource() == clear) {
			alertClr = new PopUp();
			alertClr.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ wszystkie rekordy?", true);
			if (alertClr.answer == true) {
				DropDown.eraseTables();
				InitiateDB.createTables();
				done = false;
			}
		}
		else if(event.getSource() == insert) {
			if (done == false) {
				InitiateDB.createTables();
				SQLite.exampleRecordsInput();
				alertInit = new PopUp();
				alertInit.popUp("Inicjacja", "Pomyœlnie zainicjowano bazê danych.", false);
				done = true;
			}
			else {
				alertInit = new PopUp();
				alertInit.popUp("Inicjacja", "Baza danych juz istnieje!", false);
				done = true;
			}
		}
	}
}
