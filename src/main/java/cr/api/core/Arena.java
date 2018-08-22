package cr.api.core;

import org.json.JSONObject;

public class Arena extends Data {
	
	public final int id;
	public final String name;
	
	public Arena(JSONObject data) {
		super(data);
		id = retrieve("id");
		name = retrieve("name");
	}
	
}
