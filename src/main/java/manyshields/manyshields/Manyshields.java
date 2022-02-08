package manyshields.manyshields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Manyshields implements ModInitializer {

    // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem), Wooden Shield, 50 durability, low cooldown, very low enchantability, 2, uses planks to repair
    public static final Item WOODEN_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(50).group(ItemGroup.COMBAT), 3, 2, ItemTags.PLANKS);
    // Stone Shield, 113 durability, very high cooldown, 13, low enchantability, 4, uses cobblestone to repair
    public static final Item STONE_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(113).group(ItemGroup.COMBAT), 13, 4, Items.COBBLESTONE);
    // Copper Shield, 478 durability, moderate cooldown, 7, moderate enchantability, 6, uses copper ingot to repair
    public static final Item COPPER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(478).group(ItemGroup.COMBAT), 7, 6, Items.COPPER_INGOT);
    // Gold Shield, 27 durability, very high cooldown, 16, very high enchantability, 23, uses gold ingot to repair
    public static final Item GOLD_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(27).group(ItemGroup.COMBAT), 16, 23, Items.GOLD_INGOT);


    @Override
    public void onInitialize() {

        // wooden shield register
        Registry.register(Registry.ITEM, new Identifier("manyshields", "wooden_shield"), WOODEN_SHIELD);
        // stone shield register
        Registry.register(Registry.ITEM, new Identifier("manyshields", "stone_shield"), STONE_SHIELD);
        // copper shield register
        Registry.register(Registry.ITEM, new Identifier("manyshields", "copper_shield"), COPPER_SHIELD);
        // gold shield register
        Registry.register(Registry.ITEM, new Identifier("manyshields", "gold_shield"), GOLD_SHIELD);

    }
}
