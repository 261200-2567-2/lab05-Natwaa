public class Mage implements Character{
    private String name;
    private int level;
    private int hp;
    private int hpMax;
    private int mana;
    private int intelligence;
    private int resistance;
    private double baseRunSpeed;
    private double runSpeed;
    private Accessory[] accessories; // ใช้ array สำหรับเก็บอุปกรณ์
    private int accessoryCount;      // เก็บจำนวนอุปกรณ์ที่ใช้อยู่

    public Mage(String name, int level, int hpMax, int mana, int intelligence, int resistance){
        this.name = name;
        this.level = level;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.mana = mana;
        this.intelligence = intelligence;
        this.resistance = resistance;
        this.baseRunSpeed = 10.0; //กำหนดให้ความเร็วตั้งต้นคือ10
        this.runSpeed = baseRunSpeed;
        this.accessories = new Accessory[5];
        this.accessoryCount = 0;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = Math.max(0, hp); // ค่า hp ไม่ต่ำกว่า 0
        this.hpMax = Math.max(this.hp, this.hpMax); // ถ้า hp ใหม่ > hpMax, อัปเดต hpMax
    }

    public int getHpMax(){
        return hpMax;
    }

    public void setHpMax(int hpMax){
        this.hpMax = hpMax;
        if (hp > hpMax) {
            hp = hpMax;
        }
    }

    public int getMana(){
        return mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public int getDefense(){
        return 0;
    }

    public int getIntelligence(){
        return intelligence;
    }

    public int getResistance(){
        return resistance;
    }

    public void castSpell(String spellName, int manaCost){
        if (mana >= manaCost){
            mana -= manaCost;
            System.out.println(name + " casts " + spellName + "! Mana left: " + mana);
        }else{
            System.out.println(name + " does not have enough mana to cast " + spellName + ".");
        }
    }

    public void regenerateMana(int amount){
        mana += amount;
        System.out.println(name + " regenerates " + amount + " mana. Current mana: " + mana);
    }

    public double getRunSpeed(){
        return runSpeed;
    }

    public void updateRunSpeed(){
        runSpeed = baseRunSpeed; // เริ่มจากความเร็วพื้นฐาน
        for (int i = 0; i < accessoryCount; i++) {
            if (accessories[i] instanceof Boots) {
                runSpeed += ((Boots) accessories[i]).getSpeedBoost();
            }
        }
        if (runSpeed < 0) {
            runSpeed = 0; // ป้องกันไม่ให้ความเร็วติดลบ
        }
    }

    public void equipAccessory(Accessory accessory){
        if (accessoryCount < accessories.length){
            accessories[accessoryCount] = accessory;
            accessory.applyEffect(this);
            accessoryCount++;
            if (accessory instanceof Boots) {
                updateRunSpeed(); // อัปเดตความเร็วเมื่อใส่รองเท้า
            }
            System.out.println("Accessory equipped: " + accessory.getName());
        }else{
            System.out.println("Cannot equip more accessories.");
        }
    }

    public void removeAccessory(Accessory accessory){
        for (int i = 0; i < accessoryCount; i++){
            if (accessories[i] == accessory){
                accessory.removeEffect(this);
                accessories[i] = accessories[accessoryCount - 1];
                accessories[accessoryCount - 1] = null;
                accessoryCount--;
                if (accessory instanceof Boots){
                    updateRunSpeed(); // อัปเดตความเร็วเมื่อถอดรองเท้า
                }
                System.out.println("Accessory removed: " + accessory.getName());
                return;
            }
        }
        System.out.println("Accessory not found.");
    }


    public void displayStats(){
        System.out.println("\nMage Stats... ");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Hp: " + hp + "/" + hpMax);
        System.out.println("Mana: " + mana);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Resistance: " + resistance);
        System.out.println("Run Speed: " + runSpeed);
        System.out.println("Accessories Equipped: " + accessoryCount);
        for (int i = 0; i < accessoryCount; i++){
            System.out.println("- " + accessories[i].getName());
        }
    }
}
