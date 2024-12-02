public class Ring implements Accessory {
    private String name;
    private int hpBoost; // เพิ่มพลังชีวิต
    private int manaBoost;   // เพิ่มมานา (เฉพาะ Mage)

    public Ring(String name, int hpBoost, int manaBoost) {
        this.name = name;
        this.hpBoost = hpBoost;
        this.manaBoost = manaBoost;
    }

    public int getHpBoost() {
        return hpBoost;
    }

    public int getManaBoost() {
        return manaBoost;
    }

    public String getName() {
        return name;
    }

    public void applyEffect(Character character) {
        character.setHp(character.getHp() + hpBoost); // เพิ่ม HP ของ Character
        if (character instanceof Mage) {
            ((Mage) character).setMana(((Mage) character).getMana() + manaBoost); // เพิ่ม Mana หากเป็น Mage
        }
    }


    public void removeEffect(Character character) {
        character.setHp(character.getHp() - hpBoost); // ลด HP เมื่อถอดแหวน
        if (character instanceof Mage) {
            ((Mage) character).setMana(((Mage) character).getMana() - manaBoost); // ลด Mana หากเป็น Mage
        }
    }
}
