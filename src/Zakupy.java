import java.sql.Date;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Zakupy {
	
	private int id_zakupy;
	private int id_konto;
	private int id_produkty;
	private Date data_zakupy;
	
	public static ObservableList<Integer> availableIds = FXCollections.observableArrayList();
	
	static TableView<Zakupy> transactionTable;

	public Zakupy(int id_zakupy, int id_konto, int id_produkty, Date data_zakupy) {
		this.setId_zakupy(id_zakupy);
		this.setId_konto(id_konto);
		this.setId_produkty(id_produkty);
		this.setData_zakupy(data_zakupy);
	}

	public int getId_zakupy() {
		return id_zakupy;
	}

	public void setId_zakupy(int id_zakupy) {
		this.id_zakupy = id_zakupy;
	}

	public int getId_konto() {
		return id_konto;
	}

	public void setId_konto(int id_konto) {
		this.id_konto = id_konto;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static TableView<Zakupy> transactionTable() {
		
		//autoincrementing column
		TableColumn zakupyIdCol = new TableColumn("LP");
		zakupyIdCol.setCellValueFactory(new Callback<CellDataFeatures<Zakupy, String>, ObservableValue<String>>() {
		  @Override public ObservableValue<String> call(CellDataFeatures<Zakupy, String> p) {
		    return new ReadOnlyObjectWrapper(transactionTable.getItems().indexOf(p.getValue())+1 + "");
		  }
		});   
		zakupyIdCol.setSortable(false);
		
//		TableColumn<Zakupy, Integer> zakupyIdCol = new TableColumn<>("LP");
//		zakupyIdCol.setPrefWidth(64);
//		zakupyIdCol.setCellValueFactory(new PropertyValueFactory<>("id_zakupy"));
		
		TableColumn<Zakupy, Integer> zakupyIdClientCol = new TableColumn<>("Nr konta");
		zakupyIdClientCol.setPrefWidth(100);
		zakupyIdClientCol.setCellValueFactory(new PropertyValueFactory<>("id_konto"));
		
		TableColumn<Zakupy, Integer> zakupyIdProductCol = new TableColumn<>("Kod produktu");
		zakupyIdProductCol.setPrefWidth(206);
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
