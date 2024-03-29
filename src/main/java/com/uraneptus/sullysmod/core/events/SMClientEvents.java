package com.uraneptus.sullysmod.core.events;

import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.client.model.*;
import com.uraneptus.sullysmod.client.particles.BlotEyesParticle;
import com.uraneptus.sullysmod.client.particles.RicochetParticle;
import com.uraneptus.sullysmod.client.renderer.be.AmberBER;
import com.uraneptus.sullysmod.client.renderer.be.AncientSkullBER;
import com.uraneptus.sullysmod.client.renderer.be.ItemStandBER;
import com.uraneptus.sullysmod.client.renderer.entities.*;
import com.uraneptus.sullysmod.common.blocks.AncientSkullBlock;
import com.uraneptus.sullysmod.common.items.VenomVialItem;
import com.uraneptus.sullysmod.core.registry.*;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SullysMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SMClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SMEntityTypes.LANTERNFISH.get(), LanternfishRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.TORTOISE.get(), TortoiseRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.TORTOISE_SHELL.get(), TortoiseShellRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.BOULDERING_ZOMBIE.get(), BoulderingZombieRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.JUNGLE_SPIDER.get(), JungleSpiderRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.PIRANHA.get(), PiranhaRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.THROWN_THROWING_KNIFE.get(), ThrownThrowingKnifeRenderer::new);
        event.registerBlockEntityRenderer(SMBlockEntityTypes.AMBER.get(), AmberBER::new);
        event.registerBlockEntityRenderer(SMBlockEntityTypes.ITEM_STAND.get(), ItemStandBER::new);
        event.registerBlockEntityRenderer(SMBlockEntityTypes.ANCIENT_SKULL.get(), AncientSkullBER::new);
    }

    @SubscribeEvent
    public static void registerLayerLocation(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LanternfishModel.LAYER_LOCATION, LanternfishModel::createBodyLayer);
        event.registerLayerDefinition(JadeShieldModel.LAYER_LOCATION, JadeShieldModel::createLayer);
        event.registerLayerDefinition(TortoiseShellModel.LAYER_LOCATION, TortoiseShellModel::createBodyLayer);
        event.registerLayerDefinition(JungleSpiderModel.LAYER_LOCATION, JungleSpiderModel::createBodyLayer);
        event.registerLayerDefinition(MinersHelmetModel.LAYER_LOCATION, MinersHelmetModel::createBodyLayer);
        event.registerLayerDefinition(CrackedAncientSkullModel.LAYER_LOCATION, CrackedAncientSkullModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SMParticleTypes.RICOCHET.get(), RicochetParticle.RicochetParticleProvider::new);
        event.registerSpriteSet(SMParticleTypes.BLOT_EYES.get(), BlotEyesParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemProperties.register(SMItems.JADE_SHIELD.get(), new ResourceLocation("blocking"), (itemStack, clientWorld, livingEntity, useTime) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    @SubscribeEvent
    public static void onItemColouring(RegisterColorHandlersEvent.Item event) {
        event.register(((stack, tint) -> tint == 0 ? -1 : VenomVialItem.getEffectColours(stack, tint)), SMItems.VENOM_VIAL.get());
    }

    @SubscribeEvent
    public static void onCreateSkullModels(EntityRenderersEvent.CreateSkullModels event) {
        EntityModelSet entityModelSet = event.getEntityModelSet();
        event.registerSkullModel(AncientSkullBlock.Types.CRACKED, new CrackedAncientSkullModel(entityModelSet.bakeLayer(CrackedAncientSkullModel.LAYER_LOCATION)));

    }
}
