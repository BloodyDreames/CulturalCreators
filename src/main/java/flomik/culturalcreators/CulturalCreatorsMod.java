package flomik.culturalcreators;

import flomik.culturalcreators.init.ModFluidsRegister;
import flomik.culturalcreators.init.ModItemsRegister;
import flomik.culturalcreators.item.ModItemsGroup;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CulturalCreatorsMod.MOD_ID)
public class CulturalCreatorsMod {
    public static final String MOD_ID = "culturalcreators";
    public static final Logger LOGGER = LoggerFactory.getLogger("Cultural Creators");

    public CulturalCreatorsMod(IEventBus modEventBus) {
        ModFluidsRegister.register(modEventBus);
        ModItemsRegister.register(modEventBus);
        ModItemsGroup.register(modEventBus);
    }
}
