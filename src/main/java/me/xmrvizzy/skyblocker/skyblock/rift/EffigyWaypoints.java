package me.xmrvizzy.skyblocker.skyblock.rift;

import me.xmrvizzy.skyblocker.config.getConfig;
import me.xmrvizzy.skyblocker.utils.RenderHelper;
import me.xmrvizzy.skyblocker.utils.Utils;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EffigyWaypoints {
    private static final Logger LOGGER = LoggerFactory.getLogger(EffigyWaypoints.class);
    private static final List<BlockPos> effigies = List.of(
            new BlockPos(150, 79, 95), //Effigy 1
            new BlockPos(193, 93, 119), //Effigy 2
            new BlockPos(235, 110, 147), //Effigy 3
            new BlockPos(293, 96, 134), //Effigy 4
            new BlockPos(262, 99, 94), //Effigy 5
            new BlockPos(240, 129, 118) //Effigy 6
    );
    private static final List<BlockPos> unBrokenEffigies = new ArrayList<>();

    protected static void updateEffigies() {
        if (!shouldUpdateEffigies()) return;

        unBrokenEffigies.clear();
        try {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (player == null) return;

            Scoreboard scoreboard = player.getScoreboard();
            ScoreboardObjective objective = getScoreboardObjective(scoreboard);

            if (objective == null) return;

            updateUnBrokenEffigies(scoreboard, objective);
        } catch (NullPointerException e) {
            LOGGER.error("[Skyblocker] Error while updating effigies.", e);
        }
    }

    private static boolean shouldUpdateEffigies() {
        return getConfig.get().slayer.vampireSlayer.enableEffigyWaypoints &&
                Utils.isOnSkyblock() &&
                Utils.isInTheRift() &&
                Utils.getLocation().contains("Stillgore Château");
    }

    private static ScoreboardObjective getScoreboardObjective(Scoreboard scoreboard) {
        return scoreboard.getObjectiveForSlot(1);
    }

    private static void updateUnBrokenEffigies(Scoreboard scoreboard, ScoreboardObjective objective) {
        unBrokenEffigies.clear();
        for (ScoreboardPlayerScore score : scoreboard.getAllPlayerScores(objective)) {
            Team team = scoreboard.getPlayerTeam(score.getPlayerName());
            if (team != null && teamContainsEffigies(team)) {
                extractUnBrokenEffigiesFromTeam(team);
            }
        }
    }

    private static boolean teamContainsEffigies(Team team) {
        String line = team.getPrefix().getString() + team.getSuffix().getString();
        return line.contains("Effigies");
    }

    private static void extractUnBrokenEffigiesFromTeam(Team team) {
        List<Text> prefixesAndSuffixes = new ArrayList<>(team.getPrefix().getSiblings());
        prefixesAndSuffixes.addAll(team.getSuffix().getSiblings());

        for (int i = 1; i < prefixesAndSuffixes.size(); i++) {
            TextColor color = prefixesAndSuffixes.get(i).getStyle().getColor();
            if (color == TextColor.parse("gray")) {
                unBrokenEffigies.add(effigies.get(i - 1));
            }
        }
    }

    protected static void render(WorldRenderContext context) {
        if (getConfig.get().slayer.vampireSlayer.enableEffigyWaypoints && Utils.getLocation().contains("Stillgore Château")) {
            for (BlockPos effigy : unBrokenEffigies) {
                float[] colorComponents = DyeColor.RED.getColorComponents();
                if (getConfig.get().slayer.vampireSlayer.compactEffigyWaypoints) {
                    RenderHelper.renderFilledThroughWallsWithBeaconBeam(context, effigy.down(6), colorComponents, 0.5F);
                } else {
                    RenderHelper.renderFilledThroughWallsWithBeaconBeam(context, effigy, colorComponents, 0.5F);
                    for (int i = 1; i < 6; i++) {
                        RenderHelper.renderFilledThroughWalls(context, effigy.down(i), colorComponents, 0.5F - (0.075F * i));
                    }
                }
            }
        }
    }
}