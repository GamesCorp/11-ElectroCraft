package ElectroCraft.common;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import ElectroCraft.biomes.BiomeGenElectroBiome;
import ElectroCraft.blocks.BlockBankBlock;
import ElectroCraft.blocks.BlockElectroPortal;
import ElectroCraft.blocks.BlockElectroPortalFrame;
import ElectroCraft.items.ItemElectRecord;
import ElectroCraft.items.ItemElectroPlacer;
import ElectroCraft.mobs.EntityElectroBug;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ElectroCraft_ElectroCraft", name = "ElectroCraft Alpha0.0.1", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class ElectroCraft 
{

	
	@SidedProxy(clientSide = "ElectroCraft.client.ClientProxyElectroCraft", serverSide = "ElectroCraft.common.CommonproxyElectroCraft")	
	public static CommonProxyElectroCraft proxy;
	
	//BlockConstructer
	public static Block BankBlock;
	public static Block ElectroPortalFrame;
	public static Block ElectroPortal;
	
	//ItemConstructer
	public static Item ElectRecord;
	public static Item ElectroPlacer;
	
	//BiomeConstructer
	public static BiomeGenBase ElectroBiome;
	
	public static int dimension = 20;
	static int startEntityId = 300;
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRender();
		
		//BlockRegistry
		BankBlock = new BlockBankBlock(250, 0).setBlockName("BankBlock");
		ElectroPortalFrame = new BlockElectroPortalFrame(251, 1).setBlockName("ElectroPortalFrame");
		ElectroPortal = new BlockElectroPortal(252, 2).setBlockName("ElectroPortal");
		
		//ItemRegistry
		ElectRecord = new ItemElectRecord(5000, "streaming.ElectRecord.ogg").setIconIndex(0).setItemName("ElectRecord"); //.setIconCoord(0, 15)
		ElectroPlacer = new ItemElectroPlacer(5001).setIconIndex(1).setItemName("ElectroPlacer");

		//BiomeRegistry
		ElectroBiome = new BiomeGenElectroBiome(53).setDisableRain().setTemperatureRainfall(0.2F, 0F).setMinMaxHeight(0.2F, 1F).setColor(2900485).setBiomeName("ElectroBiome");
		
		//GameRegistry
		GameRegistry.registerBlock(BankBlock);
		GameRegistry.registerBlock(ElectroPortalFrame);
		GameRegistry.registerBlock(ElectroPortal);
		//GameRegistry.addBiome(ElectroBiome);

		//LanguageRegistry
		LanguageRegistry.addName(BankBlock,  "Bank Block");
		LanguageRegistry.addName(ElectroPortalFrame, "Electro Portal Frame");
		LanguageRegistry.addName(ElectroPortal, "Electro Portal");
		LanguageRegistry.addName(ElectRecord, "ElectRecord");
		LanguageRegistry.addName(ElectroPlacer, "Electro Placer");
		
		EntityRegistry.registerModEntity(EntityElectroBug.class, "ElectroBug", 1, this, 80, 3, true);
		EntityRegistry.addSpawn(EntityElectroBug.class, 10, 4, 10, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes)
		LanguageRegistry.instance().addStringLocalization("entity.ElectroCraft_ElectroCraft.ElectroBug", "Electro Bug");
		registerEntityEgg(EntityElectroBug.class, 0x0FF0FF, 0x4DF200);
	}
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
	
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id,  entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
