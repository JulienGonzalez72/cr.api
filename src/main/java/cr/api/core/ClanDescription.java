package cr.api.core;

import org.json.JSONObject;

public class ClanDescription extends Data {
	
	public final Integer badgeId;
	public final String name;
	public final String tag;
	
	public ClanDescription(JSONObject data) {
		super(data);
		badgeId = retrieve("badgeId");
		name = retrieve("name");
		tag = retrieve("tag");
	}
	
}
