package cr.api.core;

import org.json.JSONObject;

public class Card extends Data  {
	
	public final String name;
	public final Integer id;
	public final Integer maxLevel;
	
	public Card(JSONObject data) {
		super(data);
		name = retrieve("name");
		id = retrieve("id");
		maxLevel = retrieve("maxLevel");
	}
	
}
