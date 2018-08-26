package cr.api.core;

import org.json.JSONObject;

public class TournamentPlayer extends AbstractPlayer {
	
	public final Integer score;
	public final Integer rank;
	public final ClanDescription clan;
	
	public TournamentPlayer(JSONObject data) {
		super(data);
		score = retrieve("score");
		rank = retrieve("rank");
		clan = retrieveData("clan", ClanDescription.class);
	}
	
}
