package net.ludocrypt.the_garden.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class GardenConfigurations {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ENABLE_POINT_ONE;
    public static final ModConfigSpec.BooleanValue ENABLE_POINT_TWO;
    public static final ModConfigSpec.IntValue BAIT_MULTIPLIER;
    public static final ModConfigSpec.IntValue REDSTONE_DAMPENING;

    static {
        BUILDER.push("biomes");
        ENABLE_POINT_ONE = BUILDER.define("enablePointOne", true);
        ENABLE_POINT_TWO = BUILDER.define("enablePointTwo", true);
        BUILDER.pop();

        BUILDER.push("general");
        BAIT_MULTIPLIER = BUILDER.defineInRange("baitMultiplier", 4, 1, 64);
        REDSTONE_DAMPENING = BUILDER.defineInRange("redstoneDampening", 4, 0, 15);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    public static void init() {}

    public static boolean isPointOneEnabled() { return ENABLE_POINT_ONE.get(); }
    public static boolean isPointTwoEnabled() { return ENABLE_POINT_TWO.get(); }
    public static int getBaitMultiplier() { return BAIT_MULTIPLIER.get(); }
    public static int getRedstoneDampening() { return REDSTONE_DAMPENING.get(); }
}