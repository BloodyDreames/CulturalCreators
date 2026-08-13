package flomik.culturalcreators.item;

import flomik.culturalcreators.CulturalCreatorsMod;
import flomik.culturalcreators.init.ModFluidsRegister;
import flomik.culturalcreators.init.ModItemsRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemsGroup {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CulturalCreatorsMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder().title(Component.translatable("itemgroup." + CulturalCreatorsMod.MOD_ID))
                    .icon(() -> new ItemStack(ModItemsRegister.INCOMPLETE_ELOTE.get())).displayItems((displayContext, entries) -> {
                        entries.accept(ModItemsRegister.INCOMPLETE_ELOTE.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_BEEF_BURRITO.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_MUTTON_SANDWICH.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_FRIED_EGGPLANT_PASTA.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_EGGPLANT_BURGER.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_HEARTY_SALAD.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_CHICKEN_TACO.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_FISH_TACO.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_PORK_WRAP.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_SPICY_CURRY.get());
                        entries.accept(ModItemsRegister.INCOMPLETE_EXOTIC_ROLL_MEDLEY.get());
                        entries.accept(ModFluidsRegister.CREAMED_CORN_BUCKET.get());

    }).build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Item Group for " + CulturalCreatorsMod.MOD_ID);
    }
}
