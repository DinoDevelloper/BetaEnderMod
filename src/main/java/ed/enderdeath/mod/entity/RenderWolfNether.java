package ed.enderdeath.mod.entity;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;

public class RenderWolfNether extends RenderLiving {
	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/WitchBoss.png");

	public RenderWolfNether(ModelWitch model, float shadow) {

		super(model, shadow);

	}

	/**
	 * Queries whether should render the specified pass or not.
	 */

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */

	/**
	 * Queries whether should render the specified pass or not.
	 */

	protected ResourceLocation getEntityTexture(EntityLiving living) {
		return this.Texture((WolfNether) living);
	}

	private ResourceLocation Texture(WolfNether WolfNether) {
		return texture;
	}

	public void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.scaleMob((EntityMob) par1EntityLivingBase, par2);
	}

	protected void scaleMob(EntityMob par1Entitymob, float par2) {
		GL11.glScalef(1.775F, 1.775F, 1.775F);

	}

	public void renderHealtBar(WolfNether mob, double x, double y, double z, float par8, float par9) {
		BossStatus.setBossStatus(mob, true);
		super.doRender(mob, x, y, z, par8, par9);
	}

	public void doRender(Entity entity, double x, double y, double z, float par8, float par9) {
		this.renderHealtBar((WolfNether) entity, x, y, z, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return texture;
	}

}
