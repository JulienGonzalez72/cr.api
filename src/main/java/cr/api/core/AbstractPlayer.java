package cr.api.core;

import org.json.JSONObject;

public abstract class AbstractPlayer extends Data {
	
	public final String tag;
	public final String name;
	
	public AbstractPlayer(JSONObject data) {
		super(data);
		tag = retrieve("tag");
		name = retrieve("name");
	}
	
}
