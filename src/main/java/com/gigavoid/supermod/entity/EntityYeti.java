package com.gigavoid.supermod.entity;

import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityYeti extends EntityMob {

    private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);
    /**
     * Above zero if this Yeti is Angry.
     */
    private int angerLevel;

    private boolean field_146076_bu = false;
    private float field_146074_bv = -1.0F;
    private float field_146073_bw;
    private int randomSoundDelay;
    private Entity field_110191_bu;
    private static final String __OBFID = "CL_00001702";

    public EntityYeti(World par1World) {
        super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(0.8F, 1.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte) 0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte) 0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte) 0));
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
        int i = super.getTotalArmorValue() + 2;

        if (i > 20) {
            i = 20;
        }

        return i;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    public boolean func_146072_bX() {
        return this.field_146076_bu;
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    @Override
    public boolean isChild() {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }

    /**
     * Get the experience points the entity currently has.
     */
    @Override
    protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
        if (this.isChild()) {
            this.experienceValue = (int) ((float) this.experienceValue * 2.5F);
        }

        return super.getExperiencePoints(par1EntityPlayer);
    }

    /**
     * Set whether this zombie is a child.
     */
    public void setChild(boolean par1) {
        this.getDataWatcher().updateObject(12, Byte.valueOf((byte) (par1 ? 1 : 0)));

        if (this.worldObj != null && !this.worldObj.isRemote) {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(babySpeedBoostModifier);

            if (par1) {
                iattributeinstance.applyModifier(babySpeedBoostModifier);
            }
        }

        this.func_146071_k(par1);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
                boolean flag = true;
                ItemStack itemstack = this.getEquipmentInSlot(4);

                if (itemstack != null) {
                    if (itemstack.isItemStackDamageable()) {
                        itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

                        if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage()) {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(4, (ItemStack) null);
                        }
                    }

                    flag = false;
                }
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (!super.attackEntityFrom(par1DamageSource, par2)) {
            return false;
        } else {
            EntityLivingBase entitylivingbase = this.getAttackTarget();

            if (entitylivingbase == null && this.getEntityToAttack() instanceof EntityLivingBase) {
                entitylivingbase = (EntityLivingBase) this.getEntityToAttack();
            }

            if (entitylivingbase == null && par1DamageSource.getEntity() instanceof EntityLivingBase) {
                entitylivingbase = (EntityLivingBase) par1DamageSource.getEntity();
            }

            return true;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        boolean flag = super.attackEntityAsMob(par1Entity);

        if (flag) {
            int i = this.worldObj.difficultySetting.getDifficultyId();

            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float) i * 0.3F) {
                par1Entity.setFire(2 * i);
            }
        }

        return flag;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        return "mob.zombie.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return "mob.zombie.death";
    }

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }

    @Override
    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    @Override
    protected void dropRareDrop(int par1) {
        switch (this.rand.nextInt(3)) {
            case 0:
                this.dropItem(Items.iron_ingot, 1);
                break;
            case 1:
                this.dropItem(Items.carrot, 1);
                break;
            case 2:
                this.dropItem(Items.potato, 1);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);

        if (this.isChild()) {
            par1NBTTagCompound.setBoolean("IsBaby", true);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.getBoolean("IsBaby")) {
            this.setChild(true);
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
        super.onKillEntity(par1EntityLivingBase);

        if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) && par1EntityLivingBase instanceof EntityVillager) {
            if (this.rand.nextBoolean()) {
                return;
            }

            EntityYeti entityYeti = new EntityYeti(this.worldObj);
            entityYeti.copyLocationAndAnglesFrom(par1EntityLivingBase);
            this.worldObj.removeEntity(par1EntityLivingBase);
            entityYeti.onSpawnWithEgg((IEntityLivingData) null);

            if (par1EntityLivingBase.isChild()) {
                entityYeti.setChild(true);
            }

            this.worldObj.spawnEntityInWorld(entityYeti);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
        }
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
        Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);
        float f = this.worldObj.func_147462_b(this.posX, this.posY, this.posZ);
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

        if (par1EntityLivingData1 == null) {
            par1EntityLivingData1 = new EntityYeti.GroupData(this.worldObj.rand.nextFloat() < ForgeModContainer.zombieBabyChance, this.worldObj.rand.nextFloat() < 0.05F, null);
        }

        if (par1EntityLivingData1 instanceof EntityYeti.GroupData) {
            EntityYeti.GroupData groupdata = (EntityYeti.GroupData) par1EntityLivingData1;
            if (groupdata.field_142048_a) {
                this.setChild(true);
            }
        }

        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
        double d0 = this.rand.nextDouble() * 1.5D * (double) this.worldObj.func_147462_b(this.posX, this.posY, this.posZ);

        if (d0 > 1.0D) {
            this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

        if (this.rand.nextFloat() < f * 0.05F) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
        }

        return (IEntityLivingData) par1EntityLivingData1;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack itemstack = par1EntityPlayer.getCurrentEquippedItem();

        if (itemstack != null && itemstack.getItem() == Items.golden_apple && itemstack.getItemDamage() == 0 && this.isPotionActive(Potion.weakness)) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0) {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
            }

            return true;
        } else {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1) {
        if (par1 == 16) {
            this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
        } else {
            super.handleHealthUpdate(par1);
        }
    }

    public void func_146071_k(boolean p_146071_1_) {
        this.func_146069_a(p_146071_1_ ? 0.5F : 1.0F);
    }

    /**
     * Sets the width and height of the entity. Args: width, height
     */
    @Override
    protected final void setSize(float par1, float par2) {
        boolean flag = this.field_146074_bv > 0.0F && this.field_146073_bw > 0.0F;
        this.field_146074_bv = par1;
        this.field_146073_bw = par2;

        if (!flag) {
            this.func_146069_a(1.0F);
        }
    }

    protected final void func_146069_a(float p_146069_1_) {
        super.setSize(this.field_146074_bv * p_146069_1_, this.field_146073_bw * p_146069_1_);
    }

    class GroupData implements IEntityLivingData {
        public boolean field_142048_a;
        public boolean field_142046_b;
        private static final String __OBFID = "CL_00001704";

        private GroupData(boolean par2, boolean par3) {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = par2;
            this.field_142046_b = par3;
        }

        GroupData(boolean par2, boolean par3, Object par4EntityYetiINNER1) {
            this(par2, par3);
        }
    }

    public int getHoldRoseTick() {
        // TODO Auto-generated method stub
        return 0;
    }
}
