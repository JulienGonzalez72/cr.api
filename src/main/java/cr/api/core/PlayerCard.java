package cr.api.core;

import org.json.JSONObject;

public class PlayerCard extends Data {
	
	public final String name;
	public final Integer level;
	public final Integer maxLevel;
	public final Integer count;
	
	public PlayerCard(JSONObject data) {
		super(data);
		name = retrieve("name");
		level = retrieve("level");
		maxLevel = retrieve("maxLevel");
		count = retrieveOp("count");
	}
	
}
