package ie.tudublin;

import processing.data.TableRow;

public class Weapon
{
    private String weaponName;
    private int damage;
    private int magSize;
    private String desc;

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * @param weaponName the weaponName to set
     */
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the magSize
     */
    public int getMagSize() {
        return magSize;
    }

    /**
     * @param magSize the magSize to set
     */
    public void setMagSize(int magSize) {
        this.magSize = magSize;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString()
    {
        return weaponName + "\t" + damage + "\t" + magSize + "\t" + desc;  
    }

    public Weapon(TableRow row)
    {
        weaponName = row.getString("Weapon Name");
        damage = row.getInt("Damage");
        magSize = row.getInt("Mag Size");
        desc = row.getString("Desc");
    }

    public Weapon()
    {
        
    }



}