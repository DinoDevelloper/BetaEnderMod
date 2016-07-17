package ed.enderdeath.mod.entity;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.ResourceLocation;

public class RenderBoss extends RenderLiving
{
	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/Boss.png");
	public RenderBoss(ModelBoss modelH, float shadow)
	{
		super(modelH, shadow);
	}
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.Texture((Boss)living);
	}

	private ResourceLocation Texture(Boss Boss)
	{
		return texture;
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
	
		return texture;
	}
	public void renderHealtBar(Boss mob, double x, double y, double z, float par8, float par9)
	{
		BossStatus.setBossStatus(mob, true);
		super.doRender(mob, x, y, z, par8, par9);
	}
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderHealtBar((Boss)entity, x, y, z, par8, par9);
	}
	public void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleMob((EntityMob)par1EntityLivingBase, par2);
    }
    protected void scaleMob(EntityMob par1Entitymob, float par2)
    {
            GL11.glScalef(1.775F, 1.775F, 1.775F);

    }
}
