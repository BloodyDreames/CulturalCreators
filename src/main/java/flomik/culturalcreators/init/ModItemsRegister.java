package flomik.culturalcreators.init;

import flomik.culturalcreators.CulturalCreatorsMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsRegister {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CulturalCreatorsMod.MOD_ID);

    public static final RegistryObject<Item> INCOMPLETE_ELOTE = registerItem("incomplete_elote");
    public static final RegistryObject<Item> INCOMPLETE_BEEF_BURRITO = registerItem("incomplete_beef_burrito");
    public static final RegistryObject<Item> INCOMPLETE_MUTTON_SANDWICH = registerItem("incomplete_mutton_sandwich");
    public static final RegistryObject<Item> INCOMPLETE_FRIED_EGGPLANT_PASTA = registerItem("incomplete_fried_eggplant_pasta");
    public static final RegistryObject<Item> INCOMPLETE_EGGPLANT_BURGER = registerItem("incomplete_eggplant_burger");
    public static final RegistryObject<Item> INCOMPLETE_HEARTY_SALAD = registerItem("incomplete_hearty_salad");
    public static final RegistryObject<Item> INCOMPLETE_CHICKEN_TACO = registerItem("incomplete_chicken_taco");
    public static final RegistryObject<Item> INCOMPLETE_FISH_TACO = registerItem("incomplete_fish_taco");
    public static final RegistryObject<Item> INCOMPLETE_PORK_WRAP = registerItem("incomplete_pork_wrap");
    public static final RegistryObject<Item> INCOMPLETE_SPICY_CURRY = registerItem("incomplete_spicy_curry");
    public static final RegistryObject<Item> INCOMPLETE_EXOTIC_ROLL_MEDLEY = registerItem("incomplete_exotic_roll_medley");

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).build())));
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Items for " + CulturalCreatorsMod.MOD_ID);
    }
}
