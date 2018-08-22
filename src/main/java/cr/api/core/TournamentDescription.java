package cr.api.core;

import org.json.JSONObject;

public class TournamentDescription extends Data {
	
	public final String tag;
	public final String type;
	public final String status;
	public final String creatorTag;
	public final String name;
	public final String description;
	public final Integer capacity;
	public final Integer maxCapacity;
	public final Integer preparationDuration;
	public final Integer duration;
	public final String createdTime;
	
	public TournamentDescription(JSONObject data) {
		super(data);
		tag = retrieve("tag");
		type = retrieve("type");
		status = retrieve("status");
		creatorTag = retrieve("creatorTag");
		name = retrieve("name");
		description = retrieve("description");
		capacity = retrieve("capacity");
		maxCapacity = retrieve("maxCapacity");
		preparationDuration = retrieve("preparationDuration");
		duration = retrieve("duration");
		createdTime = retrieve("createdTime");
	}
	
}
