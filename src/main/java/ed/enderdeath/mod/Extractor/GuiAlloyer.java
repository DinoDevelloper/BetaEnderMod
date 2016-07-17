package ed.enderdeath.mod.Extractor;

import org.lwjgl.opengl.GL11;


import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation(enderdeath.MODID,"textures/gui/container/GuiAlloyer.png");
    private TileEntityAlloyer tileAlloyer;
    private IInventory playerInv;
    private int xSize1 = 106;
    private int ySize1 = 30;

 

    public GuiAlloyer(TileEntityAlloyer tile, InventoryPlayer inventory)
    {
        super(new ContainerAlloyer(tile, inventory));
        this.tileAlloyer = tile;
        this.playerInv = inventory;
        this.allowUserInput = false;
        this.ySize = 166;
        this.xSize = 176;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
      
        this.drawTexturedModalRect(k - xSize1, l + ySize1, 0, 166, xSize1, ySize1);

     
        
    }

    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        String s = this.tileAlloyer.hasCustomInventoryName() ? this.tileAlloyer.getInventoryName() : I18n.format(this.tileAlloyer.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInv.hasCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName()), 9, 73, 4210752);
        this.fontRendererObj.drawString(tileAlloyer.burnTime + "/" + tileAlloyer.burnTimeTotal, -76, 41, 4210752);
        this.fontRendererObj.drawString((100 * tileAlloyer.workingTime / tileAlloyer.workingTimeNeeded) + "%", 80, 57, 4210752);
    }
}