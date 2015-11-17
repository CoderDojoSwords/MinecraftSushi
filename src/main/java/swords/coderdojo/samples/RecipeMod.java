package swords.coderdojo.samples;

// These are the various classes we use, but did not write here.
// This section can get very long, very fast.
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

// We have to declare an identifier for our mod, and give it a version.
@Mod(modid = RecipeMod.MODID, version = RecipeMod.VERSION, name = RecipeMod.NAME)
public class RecipeMod {
	
	// These are our *Constants*
	public static final String MODID = "recipemod";
	public static final String VERSION = "1.1";
	public static final String NAME = "CoderDojo Swords Recipe Mod";
	
	// A lot of the code we write will happen here.
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		// Load the recipes into the game.
		setupCraftingRecipe();
		setupShapelessRecipe();
		setupSmeltingRecipe();
		setupMagicSwordRecipe();
	}

	// Crafting recipes require certain items to be arranged in a particular order.
	// For example, to create a Sword, or an Axe, you have to arrange wood and another material.
	private void setupCraftingRecipe() {
		
		// First, setup the input/output stacks with what you want.
		ItemStack input = new ItemStack(Blocks.dirt);
		ItemStack output = new ItemStack(Blocks.obsidian, 64);
		
		// Add the recipe to the game.
		/* Look familiar?
		 * +---+---+---+
		 * |   | x |   |
		 * +---+---+---+
		 * | x |   | x |
		 * +---+---+---+
		 * |   | x |   |
		 * +---+---+---+
		 */
		GameRegistry.addRecipe(output,
				" x ",
				"x x",
				" x ",
				'x', input);
		
		// Change 'input' and 'output' to be something else
		input = new ItemStack(Blocks.cobblestone);
		output = new ItemStack(Blocks.bedrock, 64);
		
		// Add another recipe
		/* What does this look like?
		 * +---+---+
		 * | y |   |
		 * +---+---+
		 * |   | y |
		 * +---+---+
		 */
		GameRegistry.addRecipe(output,
				"y ",
				" y",
				'y', input);
	}
	
	// Shapeless recipes are those that work regardless of arrangement. For example, turning raw wood into wood.
	private void setupShapelessRecipe() {

		ItemStack input = new ItemStack(Items.stick);
		ItemStack output = new ItemStack(Blocks.wool, 64, 12);
		
		GameRegistry.addShapelessRecipe(output, input);
	}
	
	// Have a guess what we need for these recipes?
	private void setupSmeltingRecipe() {

		GameRegistry.addSmelting(
				Blocks.stone, 
				new ItemStack(Blocks.stonebrick), 
				0.2f);
		
	}
	
	// We can add an enchantment too!
	private void setupMagicSwordRecipe() {

		// Create the sword "stack"
		ItemStack mySword = new ItemStack(Items.stone_sword);
		
		// Add Level 1 Smite
		mySword.addEnchantment(Enchantment.smite, 1);
		
		// Tell the game how to add the enchantment
		GameRegistry.addShapelessRecipe(mySword, Items.stone_sword, Items.beef);
		
	}
}
