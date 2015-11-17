package swords.coderdojo.samples;

// These are the various classes we use, but did not write here.
// This section can get very long, very fast.
import swords.coderdojo.samples.items.ItemColouredPacMan;
import swords.coderdojo.samples.items.ItemGreenEgg;
import swords.coderdojo.samples.items.ItemMasterPacMan;
import swords.coderdojo.samples.items.ItemPacMan;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

// We have to declare an identifier for our mod, and give it a version.
@Mod(modid = ItemsMod.MODID, version = ItemsMod.VERSION, name = ItemsMod.NAME)
public class ItemsMod {
	
	// These are our *Constants*
	public static final String MODID = "itemsmod";
	public static final String VERSION = "1.0";
	public static final String NAME = "CoderDojo Swords Items Mod";
	
	// These are our *Variables*
	public Item greenEgg;
	public Item pacman;
	public Item redPacman;
	public Item greenPacman;
	public Item bluePacman;
	public Item masterPacman;
	
	// Some things might need to be loaded before running the main (init) code,
	// for example, your custom item.
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		greenEgg = new ItemGreenEgg();
		pacman = new ItemPacMan();
		// Coloured PacMan
		redPacman = new ItemColouredPacMan("green");
		greenPacman = new ItemColouredPacMan("blue");
		bluePacman = new ItemColouredPacMan("red");
		// Master PacMan
		masterPacman = new ItemMasterPacMan();
		
		
		// Register our items in the game
		GameRegistry.registerItem(greenEgg, "GreenEgg");
		
		/* 
		 * Removing 4 PacMan items to be replaced by the Master.
		 */
		// GameRegistry.registerItem(pacman, "PacMan");
		// GameRegistry.registerItem(redPacman, "RedPacMan");
		// GameRegistry.registerItem(greenPacman, "GreenPacMan");
		// GameRegistry.registerItem(bluePacman, "BluePacMan");
		
		// This Master Pacman creates all 4 of the above items
		GameRegistry.registerItem(masterPacman, "MasterPacman");
	}
	
	// A lot of the code we write will happen here.
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		// TODO
		
	}

}
