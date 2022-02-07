package manyshields.manyshields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Manyshields implements ModInitializer {

    // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)
    public static final Item WOODEN_SHIELD = new FabricShieldItem(new FabricItemSettings().maxDamage(50).group(ItemGroup.COMBAT), 3, 2, ItemTags.PLANKS);

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("manyshields", "wooden_shield"), WOODEN_SHIELD);

    }
}
