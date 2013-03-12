package ElectroCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBankBlock extends Block 
{
	public String getTextureFile()
    {
            return "/blocks.png";
    }
	
	public BlockBankBlock(int id, int texture)
	{
		super(id, texture, Material.anvil);
		this.setCreativeTab(CreativeTabs.tabBlock);
		//this.setCreativeTab(CreativeTabs.tabElectroCraftBlocks);
	}
}
