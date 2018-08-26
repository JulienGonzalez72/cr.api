import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cr.api.core.Clan;

class ClanTest extends AbstractTest {
	
	private Clan clan;
	
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		clan = api.getClanByName("Chicken Rasta");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	void test() {
		assertTrue(clan.badgeId != null);
		assertTrue(clan.description != null);
		assertTrue(clan.name != null);
		assertTrue(clan.clanScore != null);
		assertTrue(clan.donationsPerWeek != null);
		assertTrue(clan.location != null);
		assertTrue(clan.memberList != null && !clan.memberList.isEmpty());
		assertTrue(clan.requiredTrophies != null);
		assertTrue(clan.tag != null);
		assertTrue(clan.type != null);
	}
	
}
