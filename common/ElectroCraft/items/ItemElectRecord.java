package ElectroCraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemElectRecord extends Item{
	
	public String getTextureFile()
    {
            return "/items.png";
    }
	
	public ItemElectRecord(int par1, String string) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMisc);
		
	}
  
}