package com.uraneptus.sullysmod.client.model;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.uraneptus.sullysmod.SullysMod;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CrackedAncientSkullModel extends SkullModelBase {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(SullysMod.modPrefix("cracked_ancient_skull"), "main");
	private final ModelPart head;

	public CrackedAncientSkullModel(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).addBox(-7.0F, -14.0F, -20.0F, 14.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -14.0F, -5.0F, 16.0F, 14.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(4.0F, -12.0F, -10.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(4.0F, -1.0F, -10.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(43, 25).addBox(-9.0F, -12.0F, -10.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-9.0F, -3.0F, -10.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(float pMouthAnimation, float pYRot, float pXRot) {

	}
}