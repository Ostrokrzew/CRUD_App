import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp implements EventHandler<ActionEvent>{
	/*This class supports alert window with communicate*/
	
	Button yes, no, close;
	Stage popUp;
	boolean answer;
	Label message;
	
	//alert window method with 2 or 1 button, according to arguments
	public boolean popUp(String title, String message,boolean yesNo) {
		popUp = new Stage();
		popUp.setTitle(title);
		popUp.initModality(Modality.APPLICATION_MODAL);
		Label blad = new Label(message);
		VBox layoutAlert = new VBox(32);
		no = new Button("Nie");
		yes = new Button("Tak");
		yes.setOnAction(this);
		no.setOnAction(this);
		close = new Button("Zamknij");
		close.setOnAction(this);
		if (yesNo) {
			HBox buttons = new HBox(32);
			buttons.getChildren().addAll(yes, no);
			buttons.setAlignment(Pos.CENTER);
			layoutAlert.getChildren().addAll(blad, buttons);
		}
		else {
			layoutAlert.getChildren().addAll(blad,close);
		}
		layoutAlert.setAlignment(Pos.CENTER);
		Scene alert = new Scene(layoutAlert, 512, 128);
		popUp.setScene(alert);
		popUp.showAndWait();
		return answer;
	}
	
	//handling of buttons action events, adding value to boolean variable "answer"
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == yes) {
			answer = true;
			popUp.close();
		}
		else if(event.getSource() == no) {
			answer = false;
			popUp.close();
		}
		else if(event.getSource() == close) {
			answer = false;
			popUp.close();
		}
	}
}
