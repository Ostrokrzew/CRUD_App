import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class DelScene implements EventHandler<ActionEvent> {
	
	Button wstecz, delete;
	PopUp alertDel;	
	
	public Scene scene() {
		
		wstecz = new Button("wstecz");
		wstecz.setOnAction(this);

		delete = new Button("usuñ");
		delete.setOnAction(this);
		
		HBox layout = new HBox(32);
		layout.setPadding(new Insets(8,8,8,8));
		layout.setAlignment(Pos.BOTTOM_CENTER);
		layout.getChildren().addAll(wstecz, delete);
		
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
		else if(event.getSource() == delete) {
			alertDel = new PopUp();
			alertDel.popUp("Usuniêcie", "Czy na pewno chcesz usun¹æ rekord?", true);
			if (alertDel.answer == true) {
				Delete.hardDelete(null, null, null);
			}
		}
	}
}