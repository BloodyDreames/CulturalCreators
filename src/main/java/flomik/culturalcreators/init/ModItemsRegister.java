package flomik.culturalcreators.init;

import flomik.culturalcreators.CulturalCreatorsMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemsRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CulturalCreatorsMod.MOD_ID);

    public static final DeferredItem<Item> INCOMPLETE_ELOTE = registerItem("incomplete_elote");
    public static final DeferredItem<Item> INCOMPLETE_BEEF_BURRITO = registerItem("incomplete_beef_burrito");
    public static final DeferredItem<Item> INCOMPLETE_MUTTON_SANDWICH = registerItem("incomplete_mutton_sandwich");
    public static final DeferredItem<Item> INCOMPLETE_FRIED_EGGPLANT_PASTA = registerItem("incomplete_fried_eggplant_pasta");
    public static final DeferredItem<Item> INCOMPLETE_EGGPLANT_BURGER = registerItem("incomplete_eggplant_burger");
    public static final DeferredItem<Item> INCOMPLETE_HEARTY_SALAD = registerItem("incomplete_hearty_salad");
    public static final DeferredItem<Item> INCOMPLETE_CHICKEN_TACO = registerItem("incomplete_chicken_taco");
    public static final DeferredItem<Item> INCOMPLETE_FISH_TACO = registerItem("incomplete_fish_taco");
    public static final DeferredItem<Item> INCOMPLETE_PORK_WRAP = registerItem("incomplete_pork_wrap");
    public static final DeferredItem<Item> INCOMPLETE_SPICY_CURRY = registerItem("incomplete_spicy_curry");
    public static final DeferredItem<Item> INCOMPLETE_EXOTIC_ROLL_MEDLEY = registerItem("incomplete_exotic_roll_medley");

    private static DeferredItem<Item> registerItem(String name) {
        return ITEMS.registerSimpleItem(name, new Item.Properties()
                .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()));
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Items for " + CulturalCreatorsMod.MOD_ID);
    }
}
