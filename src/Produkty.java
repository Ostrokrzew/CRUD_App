import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Produkty {
	
	public static ObservableList<Integer> avaliableProducts = FXCollections.observableArrayList();
	public static ObservableList<Integer> avaliableIds = FXCollections.observableArrayList();

	private int id_p;
	private String nazwa;
	private double cena;
	private int id_produkty;
	
	static TableView<Produkty> productsTable;

	public Produkty(int id_p, String nazwa, double cena, int id_produkty) {
		this.setId_p(id_p);
		this.setNazwa(nazwa);
		this.setCena(cena);
		this.setId_produkty(id_produkty);
	}

	public int getId_p() {
		return id_p;
	}


	public void setId_p(int id_p) {
		this.id_p = id_p;
	}


	public String getNazwa() {
		return nazwa;
	}


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public int getId_produkty() {
		return id_produkty;
	}


	public void setId_produkty(int id_produkty) {
		this.id_produkty = id_produkty;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static TableView<Produkty> productsTable() {
		
		TableColumn produktyIdCol = new TableColumn("LP");
		produktyIdCol.setCellValueFactory(new Callback<CellDataFeatures<Produkty, String>, ObservableValue<String>>() {
		@Override public ObservableValue<String> call(CellDataFeatures<Produkty, String> p) {
		    return new ReadOnlyObjectWrapper(productsTable.getItems().indexOf(p.getValue())+1 + "");
		  }
		});   
		produktyIdCol.setSortable(false);
		
		TableColumn<Produkty, Integer> produktyCol = new TableColumn<>("LP");
		produktyCol.setPrefWidth(64);
		produktyCol.setCellValueFactory(new PropertyValueFactory<>("id_p"));
		produktyCol.setVisible(false);
		
		TableColumn<Produkty, String> produktyNameCol = new TableColumn<>("Nazwa");
		produktyNameCol.setPrefWidth(192);
		produktyNameCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
		
		TableColumn<Produkty, Double> produktyPriceCol = new TableColumn<>("Cena");
		produktyPriceCol.setPrefWidth(192);
		produktyPriceCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
		
		TableColumn<Produkty, Integer> produktyNumberCol = new TableColumn<>("Kod produktu");
		produktyNumberCol.setPrefWidth(156);
		produktyNumberCol.setCellValueFactory(new PropertyValueFactory<>("id_produkty"));
	
		productsTable = new TableView<>();
		productsTable.setItems(ShowMeDB.showProdukty());
		productsTable.setPrefWidth(578);
		productsTable.getColumns().addAll(produktyIdCol, produktyCol, produktyNameCol, produktyPriceCol, produktyNumberCol);
		
		return productsTable;
	}
}