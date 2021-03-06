package com.uraneptus.sullysmod.core.registry;

import com.teamabnormals.blueprint.common.item.BlueprintMobBucketItem;
import com.teamabnormals.blueprint.common.item.InjectedItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.other.SMProperties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = SullysMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMItems {
    public static final ItemSubRegistryHelper HELPER = SullysMod.REGISTRY_HELPER.getItemSubHelper();

    //Basic Items
    public static final RegistryObject<Item> ROUGH_JADE = HELPER.createItem("rough_jade", () -> new InjectedItem(Items.COPPER_INGOT, SMProperties.Items.MISC_TAB));
    public static final RegistryObject<Item> POLISHED_JADE = HELPER.createItem("polished_jade", () -> new InjectedItem(SMItems.ROUGH_JADE.get(), SMProperties.Items.MISC_TAB));

    //Food
    public static final RegistryObject<Item> RAW_LANTERNFISH = HELPER.createItem("raw_lanternfish", () -> new Item(SMProperties.Items.FOOD_TAB.food(SMProperties.Foods.LANTERNFISH_FOOD)));
    public static final RegistryObject<Item> COOKED_LANTERNFISH = HELPER.createItem("cooked_lanternfish", () -> new Item(SMProperties.Items.FOOD_TAB.food(SMProperties.Foods.COOKED_LANTERNFISH_FOOD)));

    //Mob Buckets & Spawn Eggs
    public static final RegistryObject<Item> LANTERNFISH_BUCKET = HELPER.createItem("lanternfish_bucket", () -> SMItems.createMobBucketItem(SMEntityTypes.LANTERNFISH::get));
    public static final RegistryObject<ForgeSpawnEggItem> LANTERNFISH_SPAWN_EGG = HELPER.createSpawnEggItem("lanternfish", SMEntityTypes.LANTERNFISH::get, 12829605, 8778172);
    public static final RegistryObject<ForgeSpawnEggItem> TORTOISE_SPAWN_EGG = HELPER.createSpawnEggItem("tortoise", SMEntityTypes.TORTOISE::get, 15198183, 10844478);

    public static Item createMobBucketItem(Supplier<EntityType<? extends WaterAnimal>> entityType) {
        return new BlueprintMobBucketItem(entityType, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, SMProperties.Items.cannotStack().tab(CreativeModeTab.TAB_MISC));
    }
}
