package flomik.culturalcreators.client;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import flomik.culturalcreators.CulturalCreatorsMod;
import flomik.culturalcreators.init.ModFluidsRegister;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.joml.Vector3f;

@EventBusSubscriber(modid = CulturalCreatorsMod.MOD_ID, value = Dist.CLIENT)
public class ModClientExtensions {
    private static final ResourceLocation STILL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CulturalCreatorsMod.MOD_ID, "block/creamed_corn_still");
    private static final ResourceLocation FLOWING_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CulturalCreatorsMod.MOD_ID, "block/creamed_corn_flow");

    private static final float FOG_RED = 252.0f / 255.0f;
    private static final float FOG_GREEN = 230.0f / 255.0f;
    private static final float FOG_BLUE = 165.0f / 255.0f;

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                           int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return new Vector3f(FOG_RED, FOG_GREEN, FOG_BLUE);
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
                                        float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(-8.0f);
                RenderSystem.setShaderFogEnd(5.0f);
            }
        }, ModFluidsRegister.CREAMED_CORN_FLUID_TYPE.value());
    }
}
