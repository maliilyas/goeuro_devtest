package beans;
/**
 * 
 * @author Ali 
 * A simple Plain Java Object for handling the parsed Data.
 */
public class City {
	
	String _id			= "";
	String name 		= "";
	String type 		= "";
	String lat  		= "";
	String longitutde 	= "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongitutde() {
		return longitutde;
	}
	public void setLongitutde(String longitutde) {
		this.longitutde = longitutde;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

}
