package swords.coderdojo.samples.items;

import swords.coderdojo.samples.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPacMan extends Item {
	
	public ItemPacMan() {
		
		setUnlocalizedName(ItemsMod.MODID + "_" + "pacman");
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName(ItemsMod.MODID + ":" + "pacman");
	}
	
}
