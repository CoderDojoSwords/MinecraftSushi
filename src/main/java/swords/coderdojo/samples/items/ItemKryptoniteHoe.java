package swords.coderdojo.samples.items;

import swords.coderdojo.samples.ToolsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemKryptoniteHoe extends ItemHoe {
	
	public ItemKryptoniteHoe(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(ToolsMod.MODID + "_" + name);
		setTextureName(ToolsMod.MODID + ":" + name);
	}

}
