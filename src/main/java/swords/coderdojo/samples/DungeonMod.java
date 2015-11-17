package swords.coderdojo.samples;

// These are the various classes we use, but did not write here.
// This section can get very long, very fast.
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

// We have to declare an identifier for our mod, and give it a version.
@Mod(modid = DungeonMod.MODID, version = DungeonMod.VERSION, name = DungeonMod.NAME)
public class DungeonMod {
	
	// These are our *Constants*
	public static final String MODID = "dungeonmod";
	public static final String VERSION = "1.0";
	public static final String NAME = "CoderDojo Swords Dungeon Mod";
	
	// A lot of the code we write will happen here.
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		setupDungeonMobs();
		setupDungeonChests();
		
	}

	// Because nobody likes spiders in the dungeons
	private void setupDungeonMobs() {

		// Let's remove Spiders from dungeons...
		DungeonHooks.removeDungeonMob("Spider");
		
		// And replace them with Snowmen!
		// Make sure to spell correctly and use quotation marks
		// The number determines how like you are to meet the mob. (200 = very; 10 = super rare)
		DungeonHooks.addDungeonMob("SnowMan", 200);
		
	}
	
	// Make that journey worth it!
	private void setupDungeonChests() {

		// No more apples in the dungeons!
		ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.apple));
		
		// This might put 25-50 diamond blocks in the dungeon chest. 
		// For reference, gunpowder has rarity of 10, golden apple - 1.
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
				new WeightedRandomChestContent(new ItemStack(Blocks.diamond_block), 25, 50, 10));
		
	}

}
