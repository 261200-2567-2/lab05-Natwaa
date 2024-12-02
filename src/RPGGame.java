public class RPGGame {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("OOP", 10, 120, 25, 20);
        Mage mage = new Mage("CPEStudent", 12, 80, 100, 30, 15);

        Accessory ring = new Ring("Ring of Vitality", 50, 30);
        Accessory boots = new Boots("Boots of Agility", 10);

        // สถานะตั้งต้น
        System.out.println("___ Initial Stats ___");
        warrior.displayStats();  // แสดงสถานะของ Warrior
        mage.displayStats();    // แสดงสถานะของ Mage

        // Warrior ติดตั้งแหวนและรองเท้า
        System.out.println("\n___ Warrior Equipping Ring and Boots ___");
        warrior.equipAccessory(ring);
        warrior.equipAccessory(boots);
        warrior.displayStats();

        // Mage ติดตั้งแหวนและรองเท้า
        System.out.println("\n___ Mage Equipping Ring and Boots ___");
        mage.equipAccessory(ring);
        mage.equipAccessory(boots);
        mage.displayStats();

        System.out.println("\n___ Battle begins ___");
        warrior.attack(mage); // warrior โจมตี mage
        mage.castSpell("Fireball", 20); // Mage ใช้เวทย์มนต์

        // Warrior ถอดรองเท้า
        System.out.println("\n___ Warrior Removing Boots ___");
        warrior.removeAccessory(boots);
        warrior.displayStats();

        // Mage ถอดแหวนและรองเท้า
        System.out.println("\n___ Mage Removing Accessories ___");
        mage.removeAccessory(ring);
        mage.removeAccessory(boots);
        mage.displayStats();
    }
}
