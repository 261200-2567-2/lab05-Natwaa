public class Boots implements Accessory {
    private String name;
    private double speedBoost;    // เพิ่มความเร็ว
    private int durability;       // ความคงทนปัจจุบัน
    private int maxDurability;    // ความคงทนสูงสุด

    public Boots(String name, double speedBoost) {
        this.name = name;
        this.speedBoost = speedBoost;
        this.maxDurability = 15;
        this.durability = maxDurability;
    }

    public double getSpeedBoost() {
        return (durability > 0) ? speedBoost : 0; // ถ้าความคงทนหมด ความเร็วจะไม่เพิ่ม
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }

    public void applyEffect(Character character) {
        System.out.println(character.getName() + " moves faster with " + name + "!");
        if (character instanceof Warrior) {
            Warrior warrior = (Warrior) character;
            warrior.updateRunSpeed(); // อัปเดต runSpeed เมื่อใส่รองเท้า
        } else if (character instanceof Mage) {
            Mage mage = (Mage) character;
            mage.updateRunSpeed(); // อัปเดต runSpeed เมื่อใส่รองเท้า
        }
    }


    public void removeEffect(Character character) {
        if (character instanceof Warrior) {
            Warrior warrior = (Warrior) character;
            warrior.updateRunSpeed(); // อัปเดต runSpeed เมื่อถอดรองเท้า
        } else if (character instanceof Mage) {
            Mage mage = (Mage) character;
            mage.updateRunSpeed(); // อัปเดต runSpeed เมื่อถอดรองเท้า
        }
    }

    public void reduceDurability() {
        if (durability > 0) {
            durability--;
            System.out.println(name + " durability reduced to " + durability + ".");
        } else {
            System.out.println(name + " is broken and needs repair!");
        }
    }

    public void repair() {
        durability = maxDurability;
        System.out.println(name + " has been fully repaired!");
    }
}
