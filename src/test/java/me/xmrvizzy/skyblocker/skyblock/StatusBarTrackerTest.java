package me.xmrvizzy.skyblocker.skyblock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusBarTrackerTest {
    private StatusBarTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new StatusBarTracker();
    }

    @Test
    void normalStatusBar() {
        String actionBar = "§c934/1086❤     §a159§a❈ Defense     §b562/516✎ Mana";
        tracker.update(actionBar, false);

        assertEquals(934, tracker.getHealth().value());
        assertEquals(1086, tracker.getHealth().max());
        assertEquals(159, tracker.getDefense());
        assertEquals(562, tracker.getMana().value());
        assertEquals(516, tracker.getMana().max());
        assertEquals(0, tracker.getMana().overflow());
    }

    @Test
    void overflowMana() {
        String res = tracker.update("§61605/1305❤     §a270§a❈ Defense     §b548/548✎ §3200ʬ", false);
        assertNull(res);
        tracker.assertStats(1605, 1305, 270, 548, 548, 200);
    }

    @Test
    void regeneration() {
        String res = tracker.update("§c2484/2484❤+§c120▄     §a642§a❈ Defense     §b2557/2611✎ Mana", false);
        assertEquals("§c❤+§c120▄", res);
    }

    @Test
    void instantTransmission() {
        String actionBar = "§c2259/2259❤     §b-20 Mana (§6Instant Transmission§b)     §b549/2676✎ Mana";
        assertEquals("§b-20 Mana (§6Instant Transmission§b)", tracker.update(actionBar, false));
        assertNull(tracker.update(actionBar, true));
    }

    @Test
    void rapidFire() {
        String actionBar = "§c2509/2509❤     §b-48 Mana (§6Rapid-fire§b)     §b2739/2811✎ Mana";
        assertEquals("§b-48 Mana (§6Rapid-fire§b)", tracker.update(actionBar, false));
        assertNull(tracker.update(actionBar, true));
    }

    @Test
    void zombieSword() {
        String actionBar = "§c2509/2509❤     §b-56 Mana (§6Instant Heal§b)     §b2674/2821✎ Mana    §e§lⓩⓩⓩⓩ§6§lⓄ";
        assertEquals("§b-56 Mana (§6Instant Heal§b)     §e§lⓩⓩⓩⓩ§6§lⓄ", tracker.update(actionBar, false));
        assertEquals("§e§lⓩⓩⓩⓩ§6§lⓄ", tracker.update(actionBar, true));
    }

    @Test
    void campfire() {
        String res = tracker.update("§c17070/25565❤+§c170▃   §65,625 DPS   §c1 second     §b590/626✎ §3106ʬ", false);
        assertEquals("§c❤+§c170▃   §65,625 DPS   §c1 second", res);
    }
}
