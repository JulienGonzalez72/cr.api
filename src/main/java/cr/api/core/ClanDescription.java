package cr.api.core;

import org.json.JSONObject;

public class ClanDescription extends Data {
	
	public final Integer clanChestLevel;
	public final Integer badgeId;
	public final Integer members;
	public final String name;
	public final Integer requiredTrophies;
	public final Location location;
	public final String tag;
	public final Integer clanScore;
	public final Integer clanChestMaxLevel;
	public final Integer donationsPerWeek;
	
	public ClanDescription(JSONObject data) {
		super(data);
		clanChestLevel = retrieve("clanChestLevel");
		badgeId = retrieve("badgeId");
		members = retrieve("members");
		name = retrieve("name");
		requiredTrophies = retrieve("requiredTrophies");
		location = retrieveData("location", Location.class);
		tag = retrieve("tag");
		clanScore = retrieve("clanScore");
		clanChestMaxLevel = retrieve("clanChestMaxLevel");
		donationsPerWeek = retrieve("donationsPerWeek");
	}
	
}
