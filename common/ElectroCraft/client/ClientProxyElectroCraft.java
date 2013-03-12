package ElectroCraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import ElectroCraft.common.CommonProxyElectroCraft;

public class ClientProxyElectroCraft extends CommonProxyElectroCraft
{
	@Override
	public void registerRender()
	{
		MinecraftForgeClient.preloadTexture("/blocks.png");
		MinecraftForgeClient.preloadTexture("/items.png");
	}
}
