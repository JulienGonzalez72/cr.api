package cr.api.core;

import org.json.JSONObject;

public class ClanPlayer extends AbstractPlayer {
	
	public final String role;
	public final Integer expLevel;
	public final Integer trophies;
	public final Arena arena;
	public final Integer clanRank;
	public final Integer previousClanRank;
	public final Integer donations;
	public final Integer donationsReceived;
	
	public ClanPlayer(JSONObject data) {
		super(data);
		role = retrieve("role");
		expLevel = retrieve("expLevel");
		trophies = retrieve("trophies");
		arena = new Arena((JSONObject) retrieve("arena"));
		clanRank = retrieve("clanRank");
		previousClanRank = retrieve("previousClanRank");
		donations = retrieve("donations");
		donationsReceived = retrieve("donationsReceived");
	}
	
}
