package ElectroCraft.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityElectroBug extends EntityMob
{
	public EntityElectroBug(World par1World) 
	{
		super(par1World);
		this.texture = "/ElectroCraftMobs/ElectroBug.png";
		this.moveSpeed = 0.25F;
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(5, new EntityAISwimming(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}
	
	public int getTotalArmorValue()
	{
		return 2;
	}
	
	protected boolean isAIEnabled()
	{
		return true;
	}

	public int getMaxHealth() {
		return 1;
	}
	
	public int getAttackStrength(Entity par1Entity)
	{
		return 1;
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
	
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}
	
	protected String getHurtSound()
	{
		return "mob.skeleton.hurt";
	}
	
	protected String getDeathSound()
	{
		return "mob.ghast.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.worldObj.playSoundAtEntity(this, "mob.zombie.wood", 0.15F, 1.0F);
	}
	
	protected int getDropItemId()
	{
		return Block.bed.blockID;
	}
	
	protected void dropRareDrop(int par1)
	{
		switch(this.rand.nextInt(2))
		{
		case 0:
		this.dropItem(Item.appleGold.itemID, 1);
		}
	}
	
	protected void dropFewItems(boolean par1, int par2)
	{
		if(this.rand.nextInt(4) == 0)
		{
			this.dropItem(Item.appleRed.itemID, 5);
		}
	}
	
}
