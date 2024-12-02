public interface Character{
    String getName();
    int getLevel();
    int getHp();
    void setHp(int hp);
    int getHpMax();
    void setHpMax(int hpMax);
    double getRunSpeed();
    void updateRunSpeed();
    int getDefense();
    void equipAccessory(Accessory accessory);
    void removeAccessory(Accessory accessory);
    void displayStats();

}


