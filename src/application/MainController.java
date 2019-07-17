package application;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

	@FXML private TableView<Gun> tableView;
    @FXML private TableColumn<Gun, String> gunName;
    @FXML private TableColumn<Gun, Double> weight;
    @FXML private TableColumn<Gun, Integer> range;
    @FXML private TableColumn<Gun, Integer> fireRate;
    @FXML private TableColumn<Gun, Integer> price;
    @FXML private ComboBox<String> functionBox;
    @FXML private ComboBox<String> configBox;
    @FXML private ComboBox<String> purposeBox;
    @FXML private ComboBox<String> gunTypeBox;
    @FXML private TextField priceFrom;
    @FXML private TextField priceTo;
    List<Gun> l = null;
   
    public void initialize() {
    	gunName.setCellValueFactory(new PropertyValueFactory<Gun, String>("gunName"));
    	weight.setCellValueFactory(new PropertyValueFactory<Gun, Double>("weight"));
    	range.setCellValueFactory(new PropertyValueFactory<Gun, Integer>("range"));
    	fireRate.setCellValueFactory(new PropertyValueFactory<Gun, Integer>("fireRate"));
    	price.setCellValueFactory(new PropertyValueFactory<Gun, Integer>("price"));
       
    	functionBox.getItems().setAll("All Function","Automatic","Manual","Selective-fire","Semi-automatic");
    	functionBox.getSelectionModel().select(0);
    	configBox.getItems().setAll("All Configurations","Handgun","Longgun");
    	configBox.getSelectionModel().select(0);
    	purposeBox.getItems().setAll("All Purposes","Attack-aerial-vehicle","Continuous-fire","Ease-of-transport","Institutional-safety");
    	purposeBox.getSelectionModel().select(0);
    	gunTypeBox.getItems().setAll("All Gun types","Machinegun","Pistol","Revolver","Rifle","Shotgun","Sniper");
    	gunTypeBox.getSelectionModel().select(0);
    	l = new ArrayList<Gun>();
    	
    	
    }
    
	public void search() {
		System.out.println("Search clicked!");
		FirearmOntology fa = new FirearmOntology();
		
		String function = functionBox.getValue();
		String config = configBox.getValue();
		String purpose = purposeBox.getValue();
		String gunT = gunTypeBox.getValue();
		if(functionBox.getValue().equals("All Function")) {
			function = null;
		}
		if(configBox.getValue().equals("All Configurations")) {
			config = null;
		}
		if(purposeBox.getValue().equals("All Purposes")) {
			purpose = null;
		}
		if(gunTypeBox.getValue().equals("All Gun types")) {
			gunT = null;
		}
		
		List<Gun> gList = fa.findGunsForGunSearch(function, config, purpose,gunT, priceFrom.getText(),priceTo.getText());
		/*for(Gun g : l) {
			System.out.println(g.getGunName());
		}*/
    	//l.add(new Gun("Glock57","0.8","600","50","150USD"));
    	tableView.getItems().setAll(gList);
		
	}
	
	public void test() {
		//l.add(new Gun("AK47","0.5","2000","1450","300USD"));
    	//tableView.getItems().setAll(l);
	}
}
