package flomik.culturalcreators.init;

import flomik.culturalcreators.CulturalCreatorsMod;
import flomik.culturalcreators.fluids.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluidsRegister {
    public static FlowableFluid STILL_CREAMED_CORN;
    public static FlowableFluid FLOWING_CREAMED_CORN;
    public static Block CREAMED_CORN_BLOCK;
    public static Item CREAMED_CORN_BUCKET;

    public static boolean isCreamedCorn(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_CREAMED_CORN) || state.isOf(ModFluidsRegister.FLOWING_CREAMED_CORN);
    }

    public static void register() {
        STILL_CREAMED_CORN = Registry.register(Registries.FLUID,
                Identifier.of(CulturalCreatorsMod.MOD_ID, "creamed_corn"), new CreamedCornFluid.Still());
        FLOWING_CREAMED_CORN = Registry.register(Registries.FLUID,
                Identifier.of(CulturalCreatorsMod.MOD_ID, "flowing_creamed_corn"), new CreamedCornFluid.Flowing());
        CREAMED_CORN_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(CulturalCreatorsMod.MOD_ID, "creamed_corn_block"),
                new FluidBlock(ModFluidsRegister.STILL_CREAMED_CORN, AbstractBlock.Settings.copy(Blocks.WATER).replaceable()));
        CREAMED_CORN_BUCKET = Registry.register(Registries.ITEM, Identifier.of(CulturalCreatorsMod.MOD_ID, "creamed_corn_bucket"),
                new BucketItem(ModFluidsRegister.STILL_CREAMED_CORN, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Fluids for " + CulturalCreatorsMod.MOD_ID);
    }
}
