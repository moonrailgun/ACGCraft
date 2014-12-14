package com.MRG.ACGCraft.entity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderThPic extends Render {

	public static final String[] titles = new String[] {
		"reimu", "marisa", "sanae"
	};
	
	@Override
	public void doRender(Entity entity, double pos_x, double pos_y,
			double pos_z, float rotation_yaw, float partial_tick_time) {
		this.renderThePainting((EntityThPic) entity, pos_x, pos_y, pos_z);
	}
	
	private void load_texture(int title_id) {
		bindTexture(new ResourceLocation("src/main/resources/assets/acgcraft/textures/entity/reimu.png"));
		//bindTexture("/fff/png/th_arts/" + titles[title_id] + ".png");
	}

	public void renderThePainting(EntityThPic entity_art, double pos_x,
			double pos_y, double pos_z) {

		entity_art.load_params();

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		
		GL11.glTranslatef((float) pos_x, (float) pos_y, (float) pos_z);
		GL11.glRotatef(entity_art.rotationYaw, 0.0F, 1.0F, 0.0F);
		
		load_texture(entity_art.title_id);
		draw(entity_art);
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	private void draw(EntityThPic entity) {
		float start_x = -EntityThPic.GRIDS_WIDTH / 2.0F;
		float start_y = EntityThPic.GRIDS_HEIGHT / 2.0F;
		float half_thickness = 0.03125F;

		for (float i = 0; i < EntityThPic.GRIDS_WIDTH; i++) {
			for (float j = 0; j < EntityThPic.GRIDS_HEIGHT; j++) {
				
				float left   = start_x + i;
				float right  = left + 1;
				float top    = start_y - j;
				float bottom = top - 1;
				
				this.render_light(entity, 
						(right + left) / 2, 
						(bottom + top) / 2);
				
				float texture_left   =  i / EntityThPic.GRIDS_WIDTH;
				float texture_right  = (i + 1) / EntityThPic.GRIDS_WIDTH;
				float texture_top    =  j / EntityThPic.GRIDS_HEIGHT;
				float texture_bottom = (j + 1) / EntityThPic.GRIDS_HEIGHT;
				
				Tessellator tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				
				tessellator.setNormal(0.0F, 0.0F, -1.0F);
				tessellator.addVertexWithUV(right, top, half_thickness, texture_right, texture_top);
				tessellator.addVertexWithUV(left, top, half_thickness, texture_left, texture_top);
				tessellator.addVertexWithUV(left, bottom, half_thickness, texture_left, texture_bottom);
				tessellator.addVertexWithUV(right, bottom, half_thickness, texture_right, texture_bottom);

				tessellator.setNormal(0.0F, 0.0F, 1.0F);
				tessellator.addVertexWithUV(left, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, bottom, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, bottom, -half_thickness, 0, 0);
				
				tessellator.setNormal(0.0F, 1.0F, 0.0F);
				tessellator.addVertexWithUV(right, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, top, half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, top, half_thickness, 0, 0);

				tessellator.setNormal(0.0F, -1.0F, 0.0F);
				tessellator.addVertexWithUV(right, bottom, half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, bottom, half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, bottom, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, bottom, -half_thickness, 0, 0);

				tessellator.setNormal(-1.0F, 0.0F, 0.0F);
				tessellator.addVertexWithUV(left, top, half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, bottom, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(left, bottom, half_thickness, 0, 0);
				
				tessellator.setNormal(1.0F, 0.0F, 0.0F);
				tessellator.addVertexWithUV(right, top, -half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, top, half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, bottom, half_thickness, 0, 0);
				tessellator.addVertexWithUV(right, bottom, -half_thickness, 0, 0);

				tessellator.draw();
			}
		}
	}

	private void render_light(EntityThPic entity, float center_x, float center_y) {
		int x = MathHelper.floor_double(entity.posX);
		int y = MathHelper.floor_double(entity.posY + center_y);
		int z = MathHelper.floor_double(entity.posZ);

		if (entity.hanging_direction == 2) {
			x = MathHelper.floor_double(entity.posX - center_x);
		}

		if (entity.hanging_direction == 1) {
			z = MathHelper.floor_double(entity.posZ + center_x);
		}

		if (entity.hanging_direction == 0) {
			x = MathHelper.floor_double(entity.posX + center_x);
		}

		if (entity.hanging_direction == 3) {
			z = MathHelper.floor_double(entity.posZ - center_x);
		}

		int light = this.renderManager.worldObj.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int var8 = light % 65536;
		int var9 = light / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, var8, var9);
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return null;
	}
}
