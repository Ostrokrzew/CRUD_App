import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Klienci {
	
	private int id_klienci;
	private String imie;
	private String nazwisko;
	private int id_konto;
	
	static TableView<Klienci> clientTable;

	public Klienci(int id_klienci, String imie, String nazwisko, int id_konto) {
		this.setId_klienci(id_klienci);
		this.setImie(imie);
		this.setNazwisko(nazwisko);
		this.setId_konto(id_konto);
	}
	
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public int getId_konto() {
		return id_konto;
	}
	public void setId_konto(int id_konto) {
		this.id_konto = id_konto;
	}

	public int getId_klienci() {
		return id_klienci;
	}

	public void setId_klienci(int id_klienci) {
		this.id_klienci = id_klienci;
	}
	
	@SuppressWarnings("unchecked")
	public static TableView<Klienci> clientTable() {
		
		TableColumn<Klienci, Integer> klienciIdCol = new TableColumn<>("LP");
		klienciIdCol.setPrefWidth(64);
		klienciIdCol.setCellValueFactory(new PropertyValueFactory<>("id_klienci"));
		
		TableColumn<Klienci, String> klienciNameCol = new TableColumn<>("Imiê");
		klienciNameCol.setPrefWidth(192);
		klienciNameCol.setCellValueFactory(new PropertyValueFactory<>("imie"));
		
		TableColumn<Klienci, String> klienciSurnameCol = new TableColumn<>("Nazwisko");
		klienciSurnameCol.setPrefWidth(192);
		klienciSurnameCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		
		TableColumn<Klienci, Integer> klienciAccountCol = new TableColumn<>("Nr konta");
		klienciAccountCol.setPrefWidth(128);
		klienciAccountCol.setCellValueFactory(new PropertyValueFactory<>("id_konto"));
	
		clientTable = new TableView<>();
		clientTable.setItems(ShowMeDB.showKlienci());
		clientTable.setPrefWidth(578);
		clientTable.getColumns().addAll(klienciIdCol, klienciNameCol, klienciSurnameCol, klienciAccountCol);
		
		return clientTable;
	}
}