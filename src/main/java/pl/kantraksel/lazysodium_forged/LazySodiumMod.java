package pl.kantraksel.lazysodium_forged;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import pl.kantraksel.lazysodium_forged.utils.LibraryLoader;

@Mod(LazySodiumMod.MODID)
public class LazySodiumMod
{
    public static final String MODID = "lazysodium_forged";
    private static final Logger LOGGER = LogUtils.getLogger();

    public LazySodiumMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Loading LazySodium mod");
        new SodiumJava(LibraryLoader.Mode.PREFER_BUNDLED);
        LOGGER.info("Loaded LazySodium mod");
    }
}
