package cr.api.core;

import org.json.JSONObject;

public class SeasonStatistics extends Data {
	
	public final String id;
	public final Integer trophies;
	public final Integer bestTrophies;
	
	public SeasonStatistics(JSONObject data) {
		super(data);
		id = retrieveOp("id");
		trophies = retrieveOp("trophies");
		bestTrophies = retrieveOp("bestTrophies");
	}
	
}
