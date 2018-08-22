package cr.api.core;

import java.util.List;

import org.json.JSONObject;

public class Battle extends Data {
	
	public final String type;
	public final String battleTime;
	public final Arena arena;
	public final GameMode gameMode;
	public final String deckSelection;
	public final List<BattlePlayer> team;
	public final List<BattlePlayer> opponent;
	
	public Battle(JSONObject data) {
		super(data);
		type = retrieve("type");
		battleTime = retrieve("battleTime");
		arena = retrieveData("arena", Arena.class);
		gameMode = retrieveData("gameMode", GameMode.class);
		deckSelection = retrieve("deckSelection");
		team = retrieveList("team", BattlePlayer.class);
		opponent = retrieveList("opponent", BattlePlayer.class);
	}
	
	public int getTeamCrowns() {
		return team.get(0).crowns;
	}
	
	public int getOpponentCrowns() {
		return opponent.get(0).crowns;
	}
	
	public boolean hasWon() {
		return getTeamCrowns() > getOpponentCrowns();
	}
	
	public boolean wasDraw() {
		return getTeamCrowns() == getOpponentCrowns();
	}
	
}
