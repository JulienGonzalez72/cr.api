package test;

import cr.api.core.*;

public class Main {
	
	public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjdkNWI5ZjE4LWFlYzktNDQ0Zi1hNjhjLTM2ZWZjNGU3M2YyMyIsImlhdCI6MTUzNDgwMDEzNiwic3ViIjoiZGV2ZWxvcGVyL2E3OTkzM2ZmLTY1MTItYjgyOS01YWIyLTI4OTNkNTRhZDhhNiIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyI5Mi45MS4xNTMuNzgiXSwidHlwZSI6ImNsaWVudCJ9XX0.MuWQfZuNtSFn0NLDh3EVre1WLCc7Pk7L4sTZpXL5mMdB0sojVbvLL9RyP2RoD5zE-r3IUJDqV3pfYgTS45wu9w";
	
	public static void main(String[] args) {
		CRApi api = new CRApi(TOKEN);
		
		Clan c = api.getClanByName("Chicken Rasta");
		System.out.println(c.clanScore);
		Player p = api.getCompleteProfil(c.getHighestPlayer());
		System.out.println("Le plus fort du clan est " + p.name + " avec " + p.trophies + " trophées");
		System.out.println("Il a un PEKKA de niveau " + p.getCardByName("P.E.K.K.A").level);
		
		Player julien = api.getCompleteProfil(c.getPlayerByName("Julien"));
		System.out.println("Trophées de Julien : " + julien.trophies);
		System.out.println("Tag de Julien : " + julien.tag);
		
		/*for (Player pl : api.getCompleteProfils(c.memberList)) {
			System.out.println(pl.name + " : " + pl.getWinRate());
		}*/
		
		// get a clan by its name, the second argument is the minimum members of the clan and the third is the minimum clan score (both optional)
		Clan clan = api.getClanByName("Nova Esports", 49, 50000);
		// get a player in this clan
		ClanPlayer clanPlayer = clan.getPlayerByName("RIAN");
		// get the complete profil of this player
		Player player = api.getCompleteProfil(clanPlayer);
		// now you can access all information about him, for example, his trophies number
		System.out.println(player.trophies);
	}
	
}
