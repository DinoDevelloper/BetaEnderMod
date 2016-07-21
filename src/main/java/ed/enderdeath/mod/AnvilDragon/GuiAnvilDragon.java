package ed.enderdeath.mod.AnvilDragon;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.Extractor.ContainerAlloyer;
import ed.enderdeath.mod.Extractor.GuiAlloyer;
import ed.enderdeath.mod.Extractor.TileEntityAlloyer;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiAnvilDragon extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/gui/container/GuiAlloyer.png");

    public GuiAnvilDragon(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        super(new ContainerDragonAnvil(invPlayer, world, x, y, z));
        this.xSize = 176; // La largeur du gui en pixels (supprimez-le pour laisser celle par d�faut)
        this.ySize = 188; // La hauteur du gui en pixels (supprimez-le pour laisser celle par d�faut)
    }

    /**
     * Fonction pour dessiner le premier plan
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        fontRendererObj.drawString(I18n.format("container.crafting_table"), 100, 5, 0xFFFFFF); // On dessine le "titre" du gui, le I18n.format va traduire le texte donn�, n'oubliez pas de l'ajouter
                                                                                               // dans votre fichier de langues !
    }

    /**
     * Fonction pour dessiner l'arrière plan
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        mc.getTextureManager().bindTexture(texture); // On bind la texture
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize); // Et on la dessine
    }
}
