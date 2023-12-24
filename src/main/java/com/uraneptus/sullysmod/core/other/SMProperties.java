package com.uraneptus.sullysmod.core.other;

import com.teamabnormals.blueprint.core.util.PropertyUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

@SuppressWarnings("unused")
public class SMProperties {

    public static final class Blocks {
        public static final BlockBehaviour.Properties JADE_ORE = BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F);
        public static final BlockBehaviour.Properties DEEPSLATE_JADE_ORE = BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE);
        public static final BlockBehaviour.Properties ROUGH_JADE_BLOCKS = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F);
        public static final BlockBehaviour.Properties POLISHED_JADE_BLOCKS = BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F);
        public static final BlockBehaviour.Properties COPPER_BUTTONS = BlockBehaviour.Properties.of().noCollission().strength(0.5F);
    }

    public static final class Items {
        //Item Specific
        public static final Item.Properties MUSIC_DISCS = PropertyUtil.stacksOnce().rarity(Rarity.RARE);
        public static final Item.Properties JADE_SHIELD = new Item.Properties().durability(400);

        public static Item.Properties sixteenStack() {
            return new Item.Properties().stacksTo(16);
        }
    }

    public static final class Foods {
        public static final FoodProperties LANTERNFISH_FOOD = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).build();
        public static final FoodProperties COOKED_LANTERNFISH_FOOD = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).build();
    }
}
