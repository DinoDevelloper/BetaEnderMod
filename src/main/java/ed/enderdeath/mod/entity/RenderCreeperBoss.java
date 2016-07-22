package ed.enderdeath.mod.entity;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.Enderdeath;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;

public class RenderCreeperBoss extends RenderLiving
{
    public final ResourceLocation texture = new ResourceLocation(Enderdeath.MODID, "textures/entity/KCreeperBoss.png");

    public RenderCreeperBoss(ModelBase p_i1262_1_, float p_i1262_2_)
    {
        super(p_i1262_1_, p_i1262_2_);

    }

    protected ResourceLocation getEntityTexture(EntityLiving living)
    {
        return this.Texture((KCreeper)living);
    }

    private ResourceLocation Texture(KCreeper KCreeper)
    {
        return texture;
    }

    protected ResourceLocation getEntityTexture(Entity KCreeper)
    {

        return texture;
    }

    public void renderHealtBar(EntityCreeperBoss mob, double x, double y, double z, float par8, float par9)
    {
        BossStatus.setBossStatus(mob, true);
        super.doRender(mob, x, y, z, par8, par9);
    }

    public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
    {
        this.renderHealtBar((EntityCreeperBoss)entity, x, y, z, par8, par9);
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
