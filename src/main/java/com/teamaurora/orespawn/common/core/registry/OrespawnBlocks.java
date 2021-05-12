package com.teamaurora.orespawn.common.core.registry;

import com.teamaurora.orespawn.common.block.OreOreBlock;
import com.teamaurora.orespawn.common.core.Orespawn;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class OrespawnBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Orespawn.MODID);

    public static final RegistryObject<Block> ORE_ORE = registerBlock("ore_ore", ItemGroup.TAB_BUILDING_BLOCKS, () -> new OreOreBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.5F, 4.0F).sound(SoundType.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, ItemGroup itemGroup, Supplier<T> blockSupplier) {
        RegistryObject<T> blockRegistryObject = BLOCKS.register(name, blockSupplier);
        OrespawnItems.ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().tab(itemGroup)));
        return blockRegistryObject;
    }
}