package swords.coderdojo.samples.items;

import swords.coderdojo.samples.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * You can tell this PacMan what colour to be.
 * Available colours: red, green, blue
 */
public class ItemColouredPacMan extends Item {
	
	public ItemColouredPacMan(String colour) {
		
		// e.g. itemsmod_greenPacman
		setUnlocalizedName(ItemsMod.MODID + "_" + colour + "Pacman");
		
		setCreativeTab(CreativeTabs.tabMisc);
		
		// e.g. itemsmod:green_pacman
		setTextureName(ItemsMod.MODID + ":" + colour + "_pacman");
	}

}
