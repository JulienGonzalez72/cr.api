package test;

import cr.api.core.*;

public class Main {
	
	public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjdkNWI5ZjE4LWFlYzktNDQ0Zi1hNjhjLTM2ZWZjNGU3M2YyMyIsImlhdCI6MTUzNDgwMDEzNiwic3ViIjoiZGV2ZWxvcGVyL2E3OTkzM2ZmLTY1MTItYjgyOS01YWIyLTI4OTNkNTRhZDhhNiIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyI5Mi45MS4xNTMuNzgiXSwidHlwZSI6ImNsaWVudCJ9XX0.MuWQfZuNtSFn0NLDh3EVre1WLCc7Pk7L4sTZpXL5mMdB0sojVbvLL9RyP2RoD5zE-r3IUJDqV3pfYgTS45wu9w";
	
	public static void main(String[] args) {
		CRApi api = new CRApi(TOKEN);
		
		Location loc = api.getLocation("Europe");
		api.getHighestClans(loc).stream().forEach(c -> System.out.println(c.name + ", " + c.rank));
	}
	
}
