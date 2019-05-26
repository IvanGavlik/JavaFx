package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * StringProperty is String with lot of cool staf
 * @author ivgavlik
 *
 */
public class Person {
	
	/**
	  	this -> object that contains proopery
	 	"name" -> name of proiperty 
	 	"" -> defoult value
	 */
	private StringProperty name = new SimpleStringProperty(this, "name", "");

	//WATCH THIS THREE METHODS
	public StringProperty nameStringProperty() {
		return name;
	}
	
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	} 
	
	
	private StringProperty address = new SimpleStringProperty(this, "address", "");

	public StringProperty addressStringProperty() {
		return address;
	}
	
	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	} 

	
}
