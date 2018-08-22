package cr.api.core;

import java.util.List;

import org.json.JSONObject;

public class Clan extends ClanDescription {
	
	public final String type;
	public final String description;
	public final String clanChestStatus;
	public final Integer clanChestPoints;
	public final Integer clanChestLevel;
	public final List<ClanPlayer> memberList;
	
	public Clan(JSONObject data) {
		super(data);
		type = retrieve("tag");
		description = retrieve("description");
		clanChestStatus = retrieve("clanChestStatus");
		clanChestPoints = retrieve("clanChestPoints");
		clanChestLevel = retrieve("clanChestLevel");
		memberList = retrieveList("memberList", ClanPlayer.class);
	}
	
	public ClanPlayer getHighestPlayer() {
		return memberList.stream()
				.max((p1, p2) -> p1.trophies - p2.trophies)
				.orElse(null);
	}
	
	public ClanPlayer getLowestPlayer() {
		return memberList.stream()
				.min((p1, p2) -> p1.trophies - p2.trophies)
				.orElse(null);
	}
	
	public ClanPlayer getPlayerByName(String name) {
		return memberList.stream()
				.filter(p -> p.name.equals(name))
				.findFirst()
				.orElse(null);
	}
	
}
