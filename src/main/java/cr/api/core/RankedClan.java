package cr.api.core;

import org.json.JSONObject;

public class RankedClan extends ClanDescription {
	
	public final Integer rank;
	public final Integer previousRank;
	public final Location location;
	public final Integer clanScore;
	public final Integer members;
	
	public RankedClan(JSONObject data) {
		super(data);
		rank = retrieve("rank");
		previousRank = retrieve("previousRank");
		location = retrieveData("location", Location.class);
		clanScore = retrieve("clanScore");
		members = retrieve("members");
	}
	
}
