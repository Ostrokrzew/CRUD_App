import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Konto {

	public static ObservableList<Integer> availableIds = FXCollections.observableArrayList();
	
	private int id_k;
	private int id_konto;
	private double kwota;
	private String nazwisko;
	
	static TableView<Konto> accountTable;
	
	public Konto(int id_k, int id_konto, String nazwisko, double kwota) {
		this.setId_k(id_k);
		this.setId_konto(id_konto);
		this.setNazwisko(nazwisko);
		this.setKwota(kwota);
	}

	public int getId_k() {
		return id_k;
	}

	public void setId_k(int id_k) {
		this.id_k = id_k;
	}

	public int getId_konto() {
		return id_konto;
	}

	public void setId_konto(int id_konto) {
		this.id_konto = id_konto;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static TableView<Konto> accountTable() {
		
		//autoincrementing column
		TableColumn kontoNoCol = new TableColumn("LP");
		kontoNoCol.setCellValueFactory(new Callback<CellDataFeatures<Konto, String>, ObservableValue<String>>() {
		  @Override public ObservableValue<String> call(CellDataFeatures<Konto, String> p) {
		    return new ReadOnlyObjectWrapper(accountTable.getItems().indexOf(p.getValue())+1 + "");
		  }
		});   
		kontoNoCol.setSortable(false);
		
		TableColumn<Konto, Integer> kontoCol = new TableColumn<>("LP");
		kontoCol.setPrefWidth(64);
		kontoCol.setCellValueFactory(new PropertyValueFactory<>("id_k"));
		kontoCol.setId("id_k");
		kontoCol.setVisible(false);
		
		TableColumn<Konto, Integer> kontoIdCol = new TableColumn<>("Nr konta");
		kontoIdCol.setPrefWidth(108);
		kontoIdCol.setCellValueFactory(new PropertyValueFactory<>("id_konto"));
		
		TableColumn<Konto, String> kontoClientSurameCol = new TableColumn<>("Nazwisko");
		kontoClientSurameCol.setPrefWidth(234);
		kontoClientSurameCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		
		TableColumn<Konto, Double> produktyAmountCol = new TableColumn<>("Saldo");
		produktyAmountCol.setPrefWidth(198);
		produktyAmountCol.setCellValueFactory(new PropertyValueFactory<>("kwota"));

	
		accountTable = new TableView<>();
		accountTable.setItems(ShowMeDB.showKonto());
		accountTable.setPrefWidth(578);
		accountTable.getColumns().addAll(kontoCol, kontoNoCol, kontoIdCol, kontoClientSurameCol, produktyAmountCol);
		
		return accountTable;
	}
	
	
}