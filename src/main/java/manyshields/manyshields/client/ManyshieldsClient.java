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

    public static final EntityModelLayer WOODEN_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("manyshields", "wooden_shield"),"main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(WOODEN_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("manyshields", "entity/wooden_shield_base"));
            registry.register(new Identifier("manyshields", "entity/wooden_shield_base_nopattern"));
        });
    }
}
