public class Warrior implements Character {
    private String name;
    private int level;
    private int hp;
    private int hpMax;
    private int damage;
    private int defense;
    private double baseRunSpeed;
    private double runSpeed;
    private Accessory[] accessories;
    private int accessoryCount;

    public Warrior(String name, int level, int hpMax, int damage, int defense) {
        this.name = name;
        this.level = level;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.damage = damage;
        this.defense = defense;
        this.baseRunSpeed = 10.0;
        this.runSpeed = baseRunSpeed;
        this.accessories = new Accessory[5];
        this.accessoryCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp); // ค่า hp ไม่ต่ำกว่า 0
        this.hpMax = Math.max(this.hp, this.hpMax); // ถ้า hp ใหม่ > hpMax, อัปเดต hpMax
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
        if (hp > hpMax) {
            hp = hpMax;
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public double getRunSpeed() {
        return runSpeed;
    }

    public void updateRunSpeed() {
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

    public void attack(Character target) {
        int actualDamage = Math.max(0, this.damage - target.getDefense());
        target.setHp(target.getHp() - actualDamage);
        System.out.println(this.name + " attacks " + target.getName() + " for " + actualDamage + " damage!");
    }

    public void block() {
        System.out.println(this.name + " blocks the incoming attack, reducing damage by " + this.defense + "!");
    }

    public void equipAccessory(Accessory accessory) {
        if (accessoryCount < accessories.length) {
            accessories[accessoryCount] = accessory;
            accessory.applyEffect(this);
            accessoryCount++;
            if (accessory instanceof Boots) {
                updateRunSpeed(); // อัปเดตความเร็วเมื่อใส่รองเท้า
            }
            System.out.println("Accessory equipped: " + accessory.getName());
        } else {
            System.out.println("Cannot equip more accessories.");
        }
    }

    public void removeAccessory(Accessory accessory) {
        for (int i = 0; i < accessoryCount; i++) {
            if (accessories[i] == accessory) {
                accessory.removeEffect(this);
                accessories[i] = accessories[accessoryCount - 1];
                accessories[accessoryCount - 1] = null;
                accessoryCount--;
                if (accessory instanceof Boots) {
                    updateRunSpeed(); // อัปเดตความเร็วเมื่อถอดรองเท้า
                }
                System.out.println("Accessory removed: " + accessory.getName());
                return;
            }
        }
        System.out.println("Accessory not found.");
    }



    public void displayStats() {
        System.out.println("\nWarrior Stats... ");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Hp: " + hp + "/" + hpMax);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Run Speed: " + runSpeed);
        System.out.println("Accessories Equipped: " + accessoryCount);
        for (int i = 0; i < accessoryCount; i++) {
            System.out.println("- " + accessories[i].getName());
        }
    }
}
