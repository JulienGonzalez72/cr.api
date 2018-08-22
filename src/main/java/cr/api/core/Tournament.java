package cr.api.core;

import java.util.List;

import org.json.JSONObject;

public class Tournament extends TournamentDescription {
	
	public final List<TournamentPlayer> membersList;
	
	public Tournament(JSONObject data) {
		super(data);
		membersList = retrieveList("membersList", TournamentPlayer.class);
	}
	
}
