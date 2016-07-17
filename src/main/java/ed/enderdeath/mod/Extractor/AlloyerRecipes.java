package ed.enderdeath.mod.Extractor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyerRecipes {
	private static final AlloyerRecipes smeltingBase = new AlloyerRecipes();
	private Map<ItemStack[], ItemStack> smeltingList = new HashMap<ItemStack[], ItemStack>();

	public AlloyerRecipes() {

		this.addRecipe(enderdeath.OrbBlue, Items.ender_pearl, new ItemStack(enderdeath.MegaEnder, 1, 1));
		this.addRecipe(Items.ender_pearl, enderdeath.Saphir, new ItemStack(enderdeath.OrbBlue, 1, 1));
		this.addRecipe(enderdeath.OrbBlue, enderdeath.EnderHeart, new ItemStack(enderdeath.OrbRed, 1, 1));
		this.addRecipe(enderdeath.OrbBlue, Items.gold_ingot, new ItemStack(enderdeath.OrbYellow, 1, 1));
		this.addRecipe(enderdeath.OrbBlue, Items.emerald, new ItemStack(enderdeath.OrbGreen, 1, 1));
		this.addRecipe(Items.leather, Items.slime_ball, new ItemStack(Items.saddle, 1, 1));
		this.addRecipe(enderdeath.NuggetEnderite, Items.apple, new ItemStack(Items.golden_apple, 1, 1));
		this.addRecipe(Items.bone, enderdeath.Baie, new ItemStack(enderdeath.SitckJolo, 1, 1));
		this.addRecipe(enderdeath.StickIron, enderdeath.SaphirCroquette, new ItemStack(enderdeath.StickSpeed, 1, 1));
		this.addRecipe(Items.stick, enderdeath.OrbRed, new ItemStack(enderdeath.StickHeal, 1, 1));
		this.addRecipe(enderdeath.SitckJolo, Items.iron_ingot, new ItemStack(enderdeath.StickJump, 1, 1));
	}

	public void addRecipe(ItemStack input1, ItemStack input2, ItemStack output1) {
		ItemStack[] stackList = new ItemStack[] { input1, input2 };
		this.smeltingList.put(stackList, output1);
	}

	public void addRecipe(Item input1, Item input2, ItemStack output1) {
		this.addRecipe(new ItemStack(input1), new ItemStack(input2), output1);
	}

	public ItemStack getSmeltingResult(ItemStack[] stack) {
		Iterator<Entry<ItemStack[], ItemStack>> iterator = this.smeltingList.entrySet().iterator();
		Entry<ItemStack[], ItemStack> entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry<ItemStack[], ItemStack>) iterator.next();
		} while (!this.isSameKey(stack, (ItemStack[]) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean isSameKey(ItemStack[] stackList, ItemStack[] stackList2) {
		boolean isSame = false;
		for (int i = 0; i < 2; i++) {
			if (stackList[i].getItem() == stackList2[i].getItem()) {
				isSame = true;
			} else {
				return false;
			}
		}
		return isSame;
	}

	public Map<ItemStack[], ItemStack> getSmeltingList() {
		return this.smeltingList;
	}

	public static AlloyerRecipes smelting() {
		return smeltingBase;
	}
}