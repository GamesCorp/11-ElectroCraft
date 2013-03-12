package ElectroCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockElectroPortalFrame extends Block 
{	
	public String getTextureFile()
    {
            return "/blocks.png";
    }
	
	public BlockElectroPortalFrame(int id, int texture)
	{
		super(id, texture, Material.anvil);
		this.setCreativeTab(CreativeTabs.tabBlock);
		//this.setCreativeTab(CreativeTabs.tabElectroCraftBlocks);
	}
}
