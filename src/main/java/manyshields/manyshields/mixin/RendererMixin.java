package manyshields.manyshields.mixin;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;
import manyshields.manyshields.Manyshields;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import manyshields.manyshields.client.ManyshieldsClient;


@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

    // wooden shield model
    private ShieldEntityModel modelWoodenShield;
    private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/wooden_shield_base"));
    private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/wooden_shield_base_nopattern"));

    // stone shield model
    private ShieldEntityModel modelStoneShield;
    private static final SpriteIdentifier STONE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/stone_shield_base"));
    private static final SpriteIdentifier STONE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/stone_shield_base_nopattern"));

    // copper shield model
    private ShieldEntityModel modelCopperShield;
    private static final SpriteIdentifier COPPER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/copper_shield_base"));
    private static final SpriteIdentifier COPPER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/copper_shield_base_nopattern"));

    // gold shield model
    private ShieldEntityModel modelGoldShield;
    private static final SpriteIdentifier GOLD_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/gold_shield_base"));
    private static final SpriteIdentifier GOLD_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/gold_shield_base_nopattern"));

    // diamond shield model
    private ShieldEntityModel modelDiamondShield;
    private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/diamond_shield_base"));
    private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("manyshields","entity/diamond_shield_base_nopattern"));


    @Final
    @Shadow
    private EntityModelLoader entityModelLoader;

    // wooden shield

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelWoodenShield(CallbackInfo ci){
        this.modelWoodenShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(ManyshieldsClient.WOODEN_SHIELD_MODEL_LAYER));
    }

    // stone shield

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelStoneShield(CallbackInfo ci){
        this.modelStoneShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(ManyshieldsClient.STONE_SHIELD_MODEL_LAYER));
    }

    // copper shield

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelCopperShield(CallbackInfo ci){
        this.modelCopperShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(ManyshieldsClient.COPPER_SHIELD_MODEL_LAYER));
    }

    // gold shield

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelGoldShield(CallbackInfo ci){
        this.modelGoldShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(ManyshieldsClient.GOLD_SHIELD_MODEL_LAYER));
    }

    // diamond shield

    @Inject(method = "reload", at = @At("HEAD"))
    private void setModelDiamondShield(CallbackInfo ci){
        this.modelDiamondShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(ManyshieldsClient.DIAMOND_SHIELD_MODEL_LAYER));
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

        // wooden shield banner render
        if (stack.isOf(Manyshields.WOODEN_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelWoodenShield, WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }

        // stone shield banner render
        if (stack.isOf(Manyshields.STONE_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelStoneShield, STONE_SHIELD_BASE, STONE_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }

        // copper shield banner render
        if (stack.isOf(Manyshields.COPPER_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelCopperShield, COPPER_SHIELD_BASE, COPPER_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }

        // gold shield banner render
        if (stack.isOf(Manyshields.GOLD_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelGoldShield, GOLD_SHIELD_BASE, GOLD_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }

        // diamond shield banner render
        if (stack.isOf(Manyshields.DIAMOND_SHIELD)) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelGoldShield, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of ''//SHIELD_NAME//_BASE'' and then ''//SHIELD_NAME//_BASE_NOPATTERN.
        }

    }


}