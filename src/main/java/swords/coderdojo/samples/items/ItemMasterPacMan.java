package swords.coderdojo.samples.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import swords.coderdojo.samples.ItemsMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

/*
 * This master PacMan item can become all 4 colours of PacMan, so it takes a lot more code.
 */
public class ItemMasterPacMan extends Item {
	
	/*
	 * IIcon class is only available in the Client version of Minecraft, i.e. the one that you play.
	 * If you try to load this on a Minecraft server, it will result in the server crashing.
	 * For testing on your own computer, you don't have to add the @SideOnly annotation.
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	/*
	 * The array of colours that we want to use for PacMan.
	 * 
	 * Remember: programmers count from 0, so even though "blue" is the 4th item, it's Index is 3.
	 */
	private String[] colours = {"yellow", "red", "green", "blue"};
	
	public ItemMasterPacMan() {
		
		setUnlocalizedName(ItemsMod.MODID + "_" + "masterPacman");
		setCreativeTab(CreativeTabs.tabMisc);
		
		// This tells the game, that it is a master file and has variations of itself. Wool is made the same way.
		setHasSubtypes(true);
	}
	
	/*
	 * The @Override annotation tells Java to rewrite what the getUnlocalizedName() function does in ItemMasterPacMan 
	 * The game calls this function when you hover your mouse over an item in inventory to display its name.
	 */
	@Override
	public String getUnlocalizedName(ItemStack pacStack) {
		
		/*
		 * MathHelper.clamp_int() reads the item damage/metadata and checks that it is 0, 1, 2, or 3.
		 */
		int metadata = MathHelper.clamp_int(pacStack.getItemDamage(), 0, 3);
		
		/*
		 * Our class extends the Item class, so using the special keyword "super", we can use any functions that Item has.
		 * Even though we are rewriting the unlocalised name function, we can still use it in its original form.
		 */
		return super.getUnlocalizedName(pacStack) + "." + colours[metadata];
	}
	
	/*
	 * This is a special function to register textures in the game's library.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister icReg) {

		/*
		 * Create an array for as many icons, as we have colours.
		 */
		icons = new IIcon[colours.length];
		
		/*
		 * For each icon that we want in the game, we have to register the file reference.
		 * This reference is made up of the mod ID, and the file name, just like we do for Texture Names.
		 * e.g. itemsmod:red_pacman is one of the icon references that will be added.
		 */
		for (int i = 0; i < icons.length; i++) {
			icons[i] = icReg.registerIcon(ItemsMod.MODID + ":" + colours[i] + "_pacman");
		}
	}
	
	/*
	 * When setting up the unlocalised name, we checked that the damage value for this item is between 0 and 3 (inclusive).
	 * arrayName[idx] is how we retrieve values from an array.
	 */
	@Override
	public IIcon getIconFromDamage(int damage) {
		
		return icons[damage];
	}
	
	/*
	 * After we call the setHasSubtypes() function above, this is one of the methods that the game uses.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs,
			List itemList) {
		
		// For each colour, we add an item to the list of subitems of the Master
		for (int i = 0; i < colours.length; i++) {
			/*
			 * Items are added as ItemStacks. The ItemStack is given 3 parameters: 
			 * - 1st: "this" is a special keyword that refers to an *instance* of this Master class.
			 * - 2nd: stack size
			 * - 3rd: the damage value
			 */
			itemList.add(new ItemStack(this, 1, i));
		}
	}

}
