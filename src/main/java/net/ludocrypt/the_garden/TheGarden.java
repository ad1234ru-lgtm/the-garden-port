package net.ludocrypt.the_garden;

import net.ludocrypt.the_garden.config.GardenConfigurations;
import net.ludocrypt.the_garden.init.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TheGarden.MOD_ID)
public class TheGarden {
    public static final String MOD_ID = "the_garden";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public TheGarden(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Initializing The Garden for NeoForge 1.21.1...");
        modContainer.registerConfig(ModConfig.Type.COMMON, GardenConfigurations.SPEC);

        GardenBlocks.BLOCKS.register(modEventBus);
        GardenBlocks.ITEMS.register(modEventBus);
        GardenBlocks.BLOCK_ENTITY_TYPES.register(modEventBus);
        GardenItems.ITEMS.register(modEventBus);
        GardenConfigurations.init();

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        LOGGER.info("The Garden core initialization complete.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup phase...");
    }

    @SubscribeEvent
    public void onRegisterCommands(final RegisterCommandsEvent event) {
        // GardenCommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public void onServerStarting(final ServerAboutToStartEvent event) {
        LOGGER.info("The Garden: Server starting.");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.parse(MOD_ID + ":" + path);
    }
}