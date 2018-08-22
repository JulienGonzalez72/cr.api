# cr.api

The fastest and simpliest way to access to the official **Clash Royale API** in Java !

## Initialization

After creating an [access token here](https://developer.clashroyale.com/#/), you need to instanciate a **CRApi** like that :

```java
CRApi api = new CRApi("[my token]");
```

Now with the *api* object, if your token is correct, you can do all operations you want.

## Operations

### Clans

```java
// get a clan by its name, the second argument is the minimum members of the clan and the third is the minimum clan score (both optional)
Clan clan = api.getClanByName("Nova Esports", 49, 50000);
// get a player in this clan
ClanPlayer clanPlayer = clan.getPlayerByName("RIAN");
// get the complete profil of this player
Player player = api.getCompleteProfil(clanPlayer);
// now you can access all information about him, for example, his trophies number
System.out.println(player.trophies);
```
