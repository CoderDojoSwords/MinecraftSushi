package swords.coderdojo.samples.items;

import swords.coderdojo.samples.ToolsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemKryptonitePickaxe extends ItemPickaxe {
	
	public ItemKryptonitePickaxe(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(ToolsMod.MODID + "_" + name);
		setTextureName(ToolsMod.MODID + ":" + name);
	}

}
