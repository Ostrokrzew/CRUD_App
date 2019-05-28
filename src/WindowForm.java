import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class WindowForm extends Application implements EventHandler<ActionEvent> {

	static Stage mainStage;
	static MainScene mainScene;
	static AddScene addScene;
	static DelScene delScene;
	static ModScene modScene;
	static ShowScene showScene;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		
		WindowForm.mainStage = mainStage;
		mainStage.setTitle("Obs³uga bazy danych sklepu \"Pope'seye\"");
		
		//initiating scenes
		mainScene = new MainScene();
		addScene = new AddScene();
		delScene = new DelScene();
		modScene = new ModScene();
		showScene = new ShowScene();
		
		//starting with default scene
		mainStage.setScene(mainScene.scene());
		mainStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		
	}
}