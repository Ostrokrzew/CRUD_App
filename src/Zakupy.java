import java.sql.Date;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Zakupy {
	
	private int id_zakupy;
	private int id_klienci;
	private int id_produkty;
	private Date data_zakupy;
	
	static TableView<Zakupy> transactionTable;

	public Zakupy(int id_zakupy, int id_klienci, int id_produkty, Date data_zakupy) {
		this.setId_zakupy(id_zakupy);
		this.setId_klienci(id_klienci);
		this.setId_produkty(id_produkty);
		this.setData_zakupy(data_zakupy);
	}

	public int getId_zakupy() {
		return id_zakupy;
	}

	public void setId_zakupy(int id_zakupy) {
		this.id_zakupy = id_zakupy;
	}

	public int getId_klienci() {
		return id_klienci;
	}

	public void setId_klienci(int id_klienci) {
		this.id_klienci = id_klienci;
	}

	public int getId_produkty() {
		return id_produkty;
	}

	public void setId_produkty(int id_produkty) {
		this.id_produkty = id_produkty;
	}

	public Date getData_zakupy() {
		return data_zakupy;
	}

	public void setData_zakupy(Date data_zakupy) {
		this.data_zakupy = data_zakupy;
	}
	
	@SuppressWarnings("unchecked")
	public static TableView<Zakupy> transactionTable() {
		
		TableColumn<Zakupy, Integer> zakupyIdCol = new TableColumn<>("LP");
		zakupyIdCol.setPrefWidth(64);
		zakupyIdCol.setCellValueFactory(new PropertyValueFactory<>("id_zakupy"));
		
		TableColumn<Zakupy, Integer> zakupyIdClientCol = new TableColumn<>("Nr klienta");
		zakupyIdClientCol.setPrefWidth(64);
		zakupyIdClientCol.setCellValueFactory(new PropertyValueFactory<>("id_klienci"));
		
		TableColumn<Zakupy, Integer> zakupyIdProductCol = new TableColumn<>("Kod produktu");
		zakupyIdProductCol.setPrefWidth(192);
		zakupyIdProductCol.setCellValueFactory(new PropertyValueFactory<>("id_produkty"));
		
		TableColumn<Zakupy, Date> zakupyDateCol = new TableColumn<>("Data zakupu");
		zakupyDateCol.setPrefWidth(234);
		zakupyDateCol.setCellValueFactory(new PropertyValueFactory<>("data_zakupy"));
	
		transactionTable = new TableView<>();
		transactionTable.setItems(ShowMeDB.showZakupy());
		transactionTable.setPrefWidth(578);
		transactionTable.getColumns().addAll(zakupyIdCol, zakupyIdClientCol, zakupyIdProductCol, zakupyDateCol);
		
		return transactionTable;
	}
}
