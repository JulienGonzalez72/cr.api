package cr.api.core;

import org.json.JSONObject;

public class GameMode extends Data {
	
	public final Integer id;
	public final String name;
	
	public GameMode(JSONObject data) {
		super(data);
		id = retrieve("id");
		name = retrieve("name");
	}
	
}
