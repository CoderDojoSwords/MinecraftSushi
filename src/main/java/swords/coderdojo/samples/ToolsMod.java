package swords.coderdojo.samples;

import swords.coderdojo.samples.items.ItemKryptoniteAxe;
import swords.coderdojo.samples.items.ItemKryptoniteHoe;
import swords.coderdojo.samples.items.ItemKryptonitePickaxe;
import swords.coderdojo.samples.items.ItemKryptoniteSpade;
import swords.coderdojo.samples.items.ItemKryptoniteSword;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ToolsMod.MODID, name = ToolsMod.NAME, version = ToolsMod.VERSION)
public class ToolsMod {

	public static final String MODID = "toolsmod";
	public static final String NAME = "Materials Mod";
	public static final String VERSION = "1.0";
	
	/*
	 * Define a new material before you can create new tools/weapons/armour
	 * 
	 * addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability)
	 * name 	  	  = level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD)
	 * maxUses		  = number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
	 * efficiency	  = how fast you can swing the tool (axe or pickaxe only)
	 * damage 		  = base damage value against entities (swords have additional weapon damage)
	 * enchantability = odds of getting more/better enchantments
	 */
	public ToolMaterial kryptonite = EnumHelper.addToolMaterial("kryptonite", 4, 10000, 15.5f, 10.0f, 30);
	
	/*
	 * The new item handle.
	 */
	public Item kryptoniteSword;
	public Item kryptoniteAxe;
	public Item kryptonitePickaxe;
	public Item kryptoniteHoe;
	public Item kryptoniteSpade;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		
		kryptoniteSword = new ItemKryptoniteSword(kryptonite, "kryptsword");
		kryptoniteAxe = new ItemKryptoniteAxe(kryptonite, "kryptaxe");
		kryptonitePickaxe = new ItemKryptonitePickaxe(kryptonite, "kryptpickaxe");
		kryptoniteHoe = new ItemKryptoniteHoe(kryptonite, "krypthoe");
		kryptoniteSpade = new ItemKryptoniteSpade(kryptonite, "kryptspade");
		
		GameRegistry.registerItem(kryptoniteSword, "KryptSword");
		GameRegistry.registerItem(kryptoniteAxe, "KryptAxe");
		GameRegistry.registerItem(kryptonitePickaxe, "KryptPickaxe");
		GameRegistry.registerItem(kryptoniteHoe, "KryptHoe");
		GameRegistry.registerItem(kryptoniteSpade, "KryptSpade");
		
	}
}
