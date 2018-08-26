package cr.api.core;

import org.json.JSONObject;

public class Location extends Data {
	
	public final Boolean isCountry;
	public final String name;
	public final Integer id;
	public final String countryCode;
	
	public Location(JSONObject data) {
		super(data);
		isCountry = retrieve("isCountry");
		name = retrieve("name");
		id = retrieve("id");
		countryCode = retrieveOp("countryCode");
	}
	
}
