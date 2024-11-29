package kg.geeks.game.template;

public class Avrora extends Hero {
    private boolean isInvis = false;
    private int invisRounds = 0;
    private int damageAccumuLated = 0;
    private boolean usedAbilite = false;
    private int invis;

    public Avrora(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.INVIS);
    }

    public void returnDamage(Boss boss) {
        if (damageAccumuLated > 0 && !isInvis) {
            boss.setHealth(boss.getHealth() - damageAccumuLated);
            System.out.println(getName() + "возвращать боссу накопленный урон");
            damageAccumuLated = 0;
        }
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!usedAbilite && getHealth() > 0) {
            isInvis = true;
            invisRounds = 2;
            usedAbilite = true;
            System.out.println("становится невидимой на 2 раунда");
        } else if (isInvis) {
            damageAccumuLated += boss.getDamage();
            invisRounds--;
            System.out.println("невидимка! накоплено урона" + damageAccumuLated);

           if (invisRounds == 0) {
                isInvis = false;
                System.out.println("выходит из невидимости!");

            }

        }
    }
}




