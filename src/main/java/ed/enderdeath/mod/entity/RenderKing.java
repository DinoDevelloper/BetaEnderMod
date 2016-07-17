package ed.enderdeath.mod.entity;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;

public class RenderKing extends RenderBiped
{
	

	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/EnderMutant.png");
	public RenderKing(ModelEnderman m,float s) {
		
		super(m,s);
		
	}
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.Texture((KingHeal)living);
	}

	private ResourceLocation Texture(KingHeal KingHeal)
	{
		return texture;
	}

	public void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleMob((EntityMob)par1EntityLivingBase, par2);
    }
    protected void scaleMob(EntityMob par1Entitymob, float par2)
    {
            GL11.glScalef(2.5F, 2.5F,2.5F);

    }
    public void renderHealtBar(KingHeal mob, double x, double y, double z, float par8, float par9)
	{
		BossStatus.setBossStatus(mob, true);
		super.doRender(mob, x, y, z, par8, par9);
	}
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderHealtBar((KingHeal)entity, x, y, z, par8, par9);
	}
}
