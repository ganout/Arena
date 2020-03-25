import java.util.Random;

public class Champion {

    
    Random nbRandom = new Random();

    private String name; 
    private int strength; 
    private int intelligence; 
    private int life;
    private String elementary;

    public Champion(String name, String elementary) {
        this.name = name;
        this.strength = 1 + nbRandom.nextInt(9 - 1);
        this.intelligence = 1 + nbRandom.nextInt(9 - 1);
        this.life = 40;
        this.elementary = elementary;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(int life) {
        this.life = life;
    }
    
    /**
     * @return the elementary
     */
    public String getElementary() {
        return elementary;
    }

    /**
     * @param elementary the elementary to set
     */
    public void setElementary(String elementary) {
        this.elementary = elementary;
    }
    
    //Lorsqu'il attaque, il inflige un nombre de dégât lié à sa force + 1.
    public int attack() {
        int attackValue = this.strength + 1;
        return attackValue;
    }

    
    //Lorsqu'il se soigne, il gagne un nombre de point de vie lié à son intelligence + 1.
    public void heal() {
        int healValue = this.intelligence + 1;
        //this.life = Math.min(this.life + this.intelligence, 40);
        if ((this.life + this.intelligence) > 40) {
            int healMini = 40 - this.life;
            this.life = 40;
            System.out.println(this.name + " s'est soigné de : " + healMini + " points.");
            System.out.println();
            System.out.println("La vie de " + this.name + " est passé a : " + this.life + " points.");
            System.out.println();
        } else {
            this.life = this.life + healValue;
            System.out.println(this.name + " s'est soigné de : " + healValue + " points.");
            System.out.println();
            System.out.println("La vie de " + this.name + " est passé a : " + this.life + " points.");
            System.out.println();
        }
    }

    public static int elementaryEffect(Champion attackingMonster, Opponent victimMonster) {
        
        String elementaryChampion = attackingMonster.getElementary();
        String elementaryVictim = victimMonster.getElementary();

        int damage = attackingMonster.attack();
        if (elementaryChampion.equals("feu") && elementaryVictim.equals("air")
                || elementaryChampion.equals("air") && elementaryVictim.equals("eau")
                || elementaryChampion.equals("eau") && elementaryVictim.equals("feu")) {
            damage *= 2; // damage = damage * 2;
            return damage;
        } else if (elementaryChampion.equals("eau") && elementaryVictim.equals("air")
            || elementaryChampion.equals("air") && elementaryVictim.equals("feu")
            || elementaryChampion.equals("feu") && elementaryVictim.equals("eau")) {
            damage /= 2; // damage = damage / 2;
            return damage;
        } else {
            return damage;
        }
    }    
}