package cr.api.core;

import org.json.JSONObject;

public class UpcomingChest extends Data {
	
	public final Integer index;
	public final String name;
	
	public UpcomingChest(JSONObject data) {
		super(data);
		index = retrieve("index");
		name = retrieve("name");
	}
	
}
