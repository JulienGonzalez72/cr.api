package cr.api.core;

import org.json.JSONObject;

public class Location extends Data {
	
	public final boolean isCountry;
	public final String name;
	public final int id;
	
	public Location(JSONObject data) {
		super(data);
		isCountry = retrieve("isCountry");
		name = retrieve("name");
		id = retrieve("id");
	}
	
}
