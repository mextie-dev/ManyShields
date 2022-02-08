package manyshields.manyshields.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ManyshieldsClient implements ClientModInitializer {

    // wooden shield model layer
    public static final EntityModelLayer WOODEN_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("manyshields", "wooden_shield"),"main");

    // stone shield model layer
    public static final EntityModelLayer STONE_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("manyshields", "stone_shield"),"main");

    // stone shield model layer
    public static final EntityModelLayer COPPER_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("manyshields", "copper_shield"),"main");


    @Override
    public void onInitializeClient() {

        // wooden shield registry för client
        EntityModelLayerRegistry.registerModelLayer(WOODEN_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("manyshields", "entity/wooden_shield_base"));
            registry.register(new Identifier("manyshields", "entity/wooden_shield_base_nopattern"));
        });

        // stone shield registry för client
        EntityModelLayerRegistry.registerModelLayer(STONE_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("manyshields", "entity/stone_shield_base"));
            registry.register(new Identifier("manyshields", "entity/stone_shield_base_nopattern"));
        });

        // copper shield registry för client
        EntityModelLayerRegistry.registerModelLayer(COPPER_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("manyshields", "entity/copper_shield_base"));
            registry.register(new Identifier("manyshields", "entity/copper_shield_base_nopattern"));
        });

    }
}
