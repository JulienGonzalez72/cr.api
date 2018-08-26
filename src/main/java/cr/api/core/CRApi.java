package cr.api.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public final class CRApi {
	
	private static final String ENCODING = "UTF-8";
	
	private final String token;
	
	private List<Card> cards;
	private List<Location> locations;
	
	public CRApi(String token) {
		this.token = token;
		getAllCards();
		getAllLocations();
	}
	
	public ClanSearch searchForClan(String name) {
		JSONObject data;
		try {
			data = request("clans?name=" + URLEncoder.encode(name, ENCODING) + "&limit=1")
					.getJSONArray("items").getJSONObject(0);
			return new ClanSearch(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ClanSearch searchForClan(String name, int minMembers, int minScore) {
		JSONObject data;
		try {
			data = request("clans?name=" + URLEncoder.encode(name, ENCODING)
					+ "&mimMembers=" + minMembers
					+ "&minScore=" + minScore
					+ "&limit=1")
					.getJSONArray("items").getJSONObject(0);
			return new ClanSearch(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Clan getClanByTag(String tag) {
		JSONObject data;
		try {
			data = request("clans/" + URLEncoder.encode(tag, ENCODING));
			return new Clan(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Clan getClanByName(String name) {
		return getClanByTag(searchForClan(name).tag);
	}
	
	public Clan getClanByName(String name, int minMembers, int minScore) {
		return getClanByTag(searchForClan(name, minMembers, minScore).tag);
	}
	
	public Player getCompleteProfil(AbstractPlayer player) {
		return getPlayerByTag(player.tag);
	}
	
	public <P extends AbstractPlayer> List<Player> getCompleteProfils(List<P> players) {
		return players.stream()
				.map(p -> getCompleteProfil(p))
				.collect(Collectors.toList());
	}
	
	public Player getPlayerByTag(String tag) {
		JSONObject data;
		try {
			data = request("players/" + URLEncoder.encode(tag, ENCODING));
			return data != null ? new Player(data) : null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Card> getAllCards() {
		if (cards != null) {
			return cards;
		}
		cards = new ArrayList<>();
		JSONObject data = request("cards");
		JSONArray array = data.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			cards.add(new Card(array.getJSONObject(i)));
		}
		return cards;
	}
	
	public Card getCardByName(String name) {
		return cards.stream()
				.filter(c -> c.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
	public List<Card> getCardsByMaxLevel(int maxLevel) {
		return cards.stream()
				.filter(c -> c.maxLevel == maxLevel)
				.collect(Collectors.toList());
	}
	
	public List<Card> getCommonCards() {
		return getCardsByMaxLevel(13);
	}
	
	public List<Card> getRareCards() {
		return getCardsByMaxLevel(11);
	}
	
	public List<Card> getEpicCards() {
		return getCardsByMaxLevel(8);
	}
	
	public List<Card> getLegendaryCards() {
		return getCardsByMaxLevel(5);
	}
	
	public List<TournamentDescription> searchForTournaments(String name, int limit) {
		try {
			JSONObject data = request("tournaments"
					+ "?name=" + URLEncoder.encode(name, ENCODING)
					+ "&limit=" + limit);
			List<TournamentDescription> tournaments = new ArrayList<>();
			JSONArray array = data.getJSONArray("items");
			for (int i = 0; i < array.length(); i++) {
				tournaments.add(new TournamentDescription(array.getJSONObject(i)));
			}
			return tournaments;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public TournamentDescription searchForTournament(String name) {
		List<TournamentDescription> t = searchForTournaments(name, 1);
		return !t.isEmpty() ? t.get(0) : null;
	}
	
	public Tournament getTournamentByTag(String tag) {
		try {
			JSONObject data = request("tournaments/" + URLEncoder.encode(tag, ENCODING));
			return new Tournament(data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Tournament getTournamentByName(String name) {
		TournamentDescription td = searchForTournament(name);
		return td != null ? getTournamentByTag(td.tag) : null;
	}
	
	public List<UpcomingChest> getUpcomingChests(String playerTag) {
		try {
			JSONObject data = request("players/" + URLEncoder.encode(playerTag, ENCODING)
					+ "/upcomingchests");
			List<UpcomingChest> chests = new ArrayList<>();
			JSONArray array = data.getJSONArray("items");
			for (int i = 0; i < array.length(); i++) {
				chests.add(new UpcomingChest(array.getJSONObject(i)));
			}
			return chests;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UpcomingChest getNextUpcomingChest(String playerTag) {
		return getUpcomingChest(playerTag, 0);
	}
	
	public UpcomingChest getUpcomingChest(String playerTag, int position) {
		return getUpcomingChests(playerTag).stream()
				.filter(uc -> uc.index == position)
				.findFirst()
				.orElse(null);
	}
	
	public List<Battle> getBattleLog(String playerTag) {
		try {
			JSONArray data = requestForArray("players/" + URLEncoder.encode(playerTag, ENCODING)
					+ "/battlelog");
			List<Battle> battles = new ArrayList<>();
			for (int i = 0; i < data.length(); i++) {
				battles.add(new Battle(data.getJSONObject(i)));
			}
			return battles;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Battle getLastBattle(String playerTag) {
		return getBattleLog(playerTag).get(0);
	}
	
	public List<Location> getAllLocations() {
		if (locations != null) {
			return locations;
		}
		locations = new ArrayList<>();
		JSONObject data = request("locations");
		JSONArray array = data.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			locations.add(new Location(array.getJSONObject(i)));
		}
		return locations;
	}
	
	public Location getLocation(String name) {
		return locations.stream()
				.filter(l -> l.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
	public List<RankedPlayer> getHighestPlayers(Location location, int limit) {
		List<RankedPlayer> players = new ArrayList<>();
		JSONObject data = request("locations/" + location.id + "/rankings/players?limit=" + limit);
		JSONArray array = data.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			players.add(new RankedPlayer(array.getJSONObject(i)));
		}
		return players;
	}
	
	public List<RankedPlayer> getHighestPlayers(Location location) {
		return getHighestPlayers(location, 500);
	}
	
	public List<RankedClan> getHighestClans(Location location, int limit) {
		List<RankedClan> clans = new ArrayList<>();
		JSONObject data = request("locations/" + location.id + "/rankings/clans?limit=" + limit);
		JSONArray array = data.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			clans.add(new RankedClan(array.getJSONObject(i)));
		}
		return clans;
	}
	
	public List<RankedClan> getHighestClans(Location location) {
		return getHighestClans(location, 500);
	}
	
	private JSONObject request(String operation) {
		return new JSONObject(getResponse(operation));
	}
	
	private JSONArray requestForArray(String operation) {
		return new JSONArray(getResponse(operation));
	}
	
	private String getResponse(String operation) {
		URL url;
		try {
			url = new URL("https://api.clashroyale.com/v1/" + operation);
			HttpURLConnection co = (HttpURLConnection) url.openConnection();
			co.setRequestProperty("Accept", "application/json");
			co.setRequestProperty("Accept-Charset", ENCODING);
			co.setRequestProperty("authorization", "Bearer " + token);
			InputStreamReader input = new InputStreamReader(co.getInputStream());
			BufferedReader reader = new BufferedReader(input);
			String response = "", line;
			while ((line = reader.readLine()) != null) {
				response += line + "\n";
			}
			return response;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
