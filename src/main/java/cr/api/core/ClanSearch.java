package cr.api.core;

import org.json.JSONObject;

public class ClanSearch extends ClanDescription {
	
	public final Integer clanChestLevel;
	public final Integer members;
	public final Integer requiredTrophies;
	public final Location location;
	public final Integer clanScore;
	public final Integer clanChestMaxLevel;
	public final Integer donationsPerWeek;
	
	public ClanSearch(JSONObject data) {
		super(data);
		clanChestLevel = retrieve("clanChestLevel");
		members = retrieve("members");
		requiredTrophies = retrieve("requiredTrophies");
		location = retrieveData("location", Location.class);
		clanScore = retrieve("clanScore");
		clanChestMaxLevel = retrieve("clanChestMaxLevel");
		donationsPerWeek = retrieve("donationsPerWeek");
	}
	
}
