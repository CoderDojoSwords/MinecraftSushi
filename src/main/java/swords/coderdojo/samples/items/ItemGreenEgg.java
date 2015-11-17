package swords.coderdojo.samples.items;

import swords.coderdojo.samples.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemEgg;

public class ItemGreenEgg extends ItemEgg {
	
	public ItemGreenEgg() {
		
		setUnlocalizedName(ItemsMod.MODID + "_" + "greenEgg");
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName("itemsmod:greenEgg");
		
	}

}
