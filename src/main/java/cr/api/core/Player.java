package cr.api.core;

import java.util.List;

import org.json.JSONObject;

public class Player extends AbstractPlayer {
	
	public final Integer expLevel;
	public final Integer trophies;
	public final Arena arena;
	public final Integer bestTrophies;
	public final Integer wins;
	public final Integer losses;
	public final Integer battleCount;
	public final Integer threeCrownWins;
	public final Integer challengeCardsWon;
	public final Integer challengeMaxWins;
	public final Integer tournamentCardsWon;
	public final Integer tournamentBattleCount;
	public final String role;
	public final Integer donations;
	public final Integer donationsReceived;
	public final Integer totalDonations;
	public final Integer warDayWins;
	public final Integer clanCardsCollected;
	public final ClanDescription clan;
	public final LeagueStatistics leagueStatistics;
	public final List<Achievement> achievements;
	public final List<PlayerCard> cards;
	public final Card currentFavouriteCard;
	
	public Player(JSONObject data) {
		super(data);
		expLevel = retrieve("expLevel");
		trophies = retrieve("trophies");
		arena = retrieveData("arena", Arena.class);
		bestTrophies = retrieve("bestTrophies");
		wins = retrieve("wins");
		losses = retrieve("losses");
		battleCount = retrieve("battleCount");
		threeCrownWins = retrieve("threeCrownWins");
		challengeCardsWon = retrieve("challengeCardsWon");
		challengeMaxWins = retrieve("challengeMaxWins");
		tournamentCardsWon = retrieve("tournamentCardsWon");
		tournamentBattleCount = retrieve("tournamentBattleCount");
		role = retrieve("role");
		donations = retrieve("donations");
		donationsReceived = retrieve("donationsReceived");
		totalDonations = retrieve("totalDonations");
		warDayWins = retrieve("warDayWins");
		clanCardsCollected = retrieve("clanCardsCollected");
		clan = retrieveData("clan", ClanDescription.class);
		leagueStatistics = retrieveData("leagueStatistics", LeagueStatistics.class);
		achievements = retrieveList("achievements", Achievement.class);
		cards = retrieveList("cards", PlayerCard.class);
		currentFavouriteCard = retrieveData("currentFavouriteCard", Card.class);
	}
	
	public PlayerCard getCardByName(String name) {
		return cards.stream()
				.filter(c -> c.name.equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}
	
	public double getWinRate() {
		return wins / (double) losses;
	}
	
}
