package cr.api.core;

import org.json.JSONObject;

public class RankedPlayer extends AbstractPlayer {
	
	public final Integer expLevel;
	public final Integer trophies;
	public final Integer rank;
	public final Integer previousRank;
	public final ClanDescription clan;
	public final Arena arena;
	
	public RankedPlayer(JSONObject data) {
		super(data);
		expLevel = retrieve("expLevel");
		trophies = retrieve("trophies");
		rank = retrieve("rank");
		previousRank = retrieve("previousRank");
		clan = retrieveDataOp("clan", ClanDescription.class);
		arena = retrieveData("arena", Arena.class);
		
	}
	
}
