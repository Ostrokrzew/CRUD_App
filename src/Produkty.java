import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Produkty {
	
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
	
	@SuppressWarnings("unchecked")
	public static TableView<Produkty> productsTable() {
		
		TableColumn<Produkty, Integer> produktyIdCol = new TableColumn<>("LP");
		produktyIdCol.setPrefWidth(64);
		produktyIdCol.setCellValueFactory(new PropertyValueFactory<>("id_p"));
		
		TableColumn<Produkty, String> produktyNameCol = new TableColumn<>("Nazwa");
		produktyNameCol.setPrefWidth(192);
		produktyNameCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
		
		TableColumn<Produkty, Double> produktyPriceCol = new TableColumn<>("Cena");
		produktyPriceCol.setPrefWidth(192);
		produktyPriceCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
		
		TableColumn<Produkty, Integer> produktyNumberCol = new TableColumn<>("Kod produktu");
		produktyNumberCol.setPrefWidth(128);
		produktyNumberCol.setCellValueFactory(new PropertyValueFactory<>("id_produkty"));
	
		productsTable = new TableView<>();
		productsTable.setItems(ShowMeDB.showProdukty());
		productsTable.setPrefWidth(578);
		productsTable.getColumns().addAll(produktyIdCol, produktyNameCol, produktyPriceCol, produktyNumberCol);
		
		return productsTable;
	}
}