package cr.api.core;

import org.json.JSONObject;

public class LeagueStatistics extends Data {
	
	public final SeasonStatistics currentSeason;
	public final SeasonStatistics previousSeason;
	public final SeasonStatistics bestSeason;
	
	public LeagueStatistics(JSONObject data) {
		super(data);
		currentSeason = retrieveDataOp("currentSeason", SeasonStatistics.class);
		previousSeason = retrieveDataOp("previousSeason", SeasonStatistics.class);
		bestSeason = retrieveDataOp("bestSeason", SeasonStatistics.class);
	}
	
}
