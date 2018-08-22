package cr.api.core;

import org.json.JSONObject;

public class Achievement extends Data {
	
	public final String name;
	public final Integer stars;
	public final Integer value;
	public final Integer target;
	public final String info;
	
	public Achievement(JSONObject data) {
		super(data);
		name = retrieve("name");
		stars = retrieve("stars");
		value = retrieve("value");
		target = retrieve("target");
		info = retrieve("info");
	}
	
}
