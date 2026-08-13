package flomik.culturalcreators.init;

import flomik.culturalcreators.CulturalCreatorsMod;
import flomik.culturalcreators.fluids.CreamedCornFluid;
import flomik.culturalcreators.fluids.CreamedCornFluidType;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidsRegister {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CulturalCreatorsMod.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CulturalCreatorsMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CulturalCreatorsMod.MOD_ID);

    public static final RegistryObject<FluidType> CREAMED_CORN_FLUID_TYPE =
            FLUID_TYPES.register("creamed_corn", CreamedCornFluidType::new);

    public static final RegistryObject<FlowingFluid> STILL_CREAMED_CORN =
            FLUIDS.register("creamed_corn", () -> new CreamedCornFluid.Source(ModFluidsRegister.CREAMED_CORN_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CREAMED_CORN =
            FLUIDS.register("flowing_creamed_corn", () -> new CreamedCornFluid.Flowing(ModFluidsRegister.CREAMED_CORN_PROPERTIES));

    public static final RegistryObject<LiquidBlock> CREAMED_CORN_BLOCK =
            BLOCKS.register("creamed_corn_block", () -> new LiquidBlock(ModFluidsRegister.STILL_CREAMED_CORN,
                    BlockBehaviour.Properties.copy(Blocks.WATER).replaceable()));

    public static final RegistryObject<Item> CREAMED_CORN_BUCKET =
            ModItemsRegister.ITEMS.register("creamed_corn_bucket", () -> new BucketItem(ModFluidsRegister.STILL_CREAMED_CORN,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final ForgeFlowingFluid.Properties CREAMED_CORN_PROPERTIES =
            new ForgeFlowingFluid.Properties(CREAMED_CORN_FLUID_TYPE, STILL_CREAMED_CORN, FLOWING_CREAMED_CORN)
                    .slopeFindDistance(2)
                    .levelDecreasePerBlock(2)
                    .tickRate(30)
                    .explosionResistance(100.0f)
                    .block(CREAMED_CORN_BLOCK)
                    .bucket(CREAMED_CORN_BUCKET);

    public static void register(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);
        BLOCKS.register(modEventBus);

        CulturalCreatorsMod.LOGGER.debug("Registering Mod Fluids for " + CulturalCreatorsMod.MOD_ID);
    }
}
