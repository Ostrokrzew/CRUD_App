import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ShowScene implements EventHandler<ActionEvent> {
	
	Button wstecz, show;
	PopUp alertMod;
	
	public Scene scene() {
		
		wstecz = new Button("wstecz");
		wstecz.setOnAction(this);

		show = new Button("poka¿");
		show.setOnAction(this);
		
		HBox layoutShow = new HBox(32);
		layoutShow.setPadding(new Insets(8,8,8,8));
		layoutShow.setAlignment(Pos.BOTTOM_CENTER);
		layoutShow.getChildren().addAll(wstecz, show);
		
		Scene scene = new Scene(layoutShow, 1280, 768);
		return scene;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == wstecz) {
			WindowForm.mainStage.setScene(WindowForm.mainScene.scene());
			WindowForm.mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
			WindowForm.mainStage.show();
		}
		else if(event.getSource() == show) {

		}
	}
}