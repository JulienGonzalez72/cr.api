package cr.api.core;

import java.util.List;

import org.json.JSONObject;

public class BattlePlayer extends AbstractPlayer {
	
	public final Integer startingTrophies;
	public final Integer trophyChange;
	public final Integer crowns;
	//public final String clan;
	public final List<PlayerCard> cards;
	
	public BattlePlayer(JSONObject data) {
		super(data);
		startingTrophies = retrieveOp("startingTrophies");
		trophyChange = retrieveOp("trophyChange");
		crowns = retrieve("crowns");
		cards = retrieveList("cards", PlayerCard.class);
	}
	
}
