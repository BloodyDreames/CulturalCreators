package flomik.culturalcreators.init;

import flomik.culturalcreators.CulturalCreatorsMod;
import flomik.culturalcreators.fluids.CreamedCornFluid;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidsRegister {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CulturalCreatorsMod.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CulturalCreatorsMod.MOD_ID);
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CulturalCreatorsMod.MOD_ID);

    public static final Holder<FluidType> CREAMED_CORN_FLUID_TYPE = FLUID_TYPES.register("creamed_corn",
            () -> new FluidType(FluidType.Properties.create()
                    .canConvertToSource(false)
                    .canSwim(true)
                    .canDrown(true)
                    .supportsBoating(false)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)));

    public static final DeferredHolder<Fluid, FlowingFluid> STILL_CREAMED_CORN =
            FLUIDS.register("creamed_corn", () -> new CreamedCornFluid.Source(ModFluidsRegister.properties()));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_CREAMED_CORN =
            FLUIDS.register("flowing_creamed_corn", () -> new CreamedCornFluid.Flowing(ModFluidsRegister.properties()));

    public static final DeferredBlock<LiquidBlock> CREAMED_CORN_BLOCK =
            BLOCKS.register("creamed_corn_block", () -> new LiquidBlock(ModFluidsRegister.STILL_CREAMED_CORN.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).replaceable()));

    public static final DeferredItem<Item> CREAMED_CORN_BUCKET =
            ModItemsRegister.ITEMS.register("creamed_corn_bucket", () -> new BucketItem(ModFluidsRegister.STILL_CREAMED_CORN.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    private static BaseFlowingFluid.Properties properties() {
        return new BaseFlowingFluid.Properties(CREAMED_CORN_FLUID_TYPE::value, STILL_CREAMED_CORN, FLOWING_CREAMED_CORN)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .tickRate(30)
                .explosionResistance(100.0f)
                .block(CREAMED_CORN_BLOCK)
                .bucket(CREAMED_CORN_BUCKET);
    }

    public static void register(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);
        BLOCKS.register(modEventBus);

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Fluids for " + CulturalCreatorsMod.MOD_ID);
    }
}
