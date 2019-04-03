import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ModScene implements EventHandler<ActionEvent> {
	
	Button wstecz, update;
	PopUp alertMod;
	
	public Scene scene() {
		
		wstecz = new Button("wstecz");
		wstecz.setOnAction(this);

		update = new Button("zmodyfikuj");
		update.setOnAction(this);
		
		HBox layoutMod = new HBox(32);
		layoutMod.setPadding(new Insets(8,8,8,8));
		layoutMod.setAlignment(Pos.BOTTOM_CENTER);
		layoutMod.getChildren().addAll(wstecz, update);
		
		Scene scene = new Scene(layoutMod, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == wstecz) {
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == update) {
			alertMod = new PopUp();
			alertMod.popUp("Modyfikacja", "Czy na pewno chcesz zmieniæ rekord?", true);
			if (alertMod.answer == true) {
				Update.change(null, null, null, null, null);
			}
		}
	}
}