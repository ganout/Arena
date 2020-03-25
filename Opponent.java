import java.util.Random;

public class Opponent {

    
    private String name; 
    private int strength;  
    private int life;
    private String elementary;


    Random nbRandom = new Random();
        

    public Opponent(String name) {
        this.name = name;
        this.strength = 1 + nbRandom.nextInt(10 - 1);
        this.life = 10 + nbRandom.nextInt(31 - 10);
        this.elementary = randomElementary(1 + nbRandom.nextInt(4 - 1));
    }

    public String randomElementary(int nbRandom) {
        int elementaryRandom = nbRandom;

        if (elementaryRandom == 1) {
            return "fire";
        } else if (elementaryRandom == 2) {
            return "water";
        } else {
            return "air";
        }
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

    public static int elementaryEffect(Opponent attackingMonster, Champion victimMonster) {
        
        String elementaryOpponent = attackingMonster.getElementary();
            String elementaryVictim = victimMonster.getElementary();

            if (elementaryOpponent.equals("fire")) {
                if (elementaryVictim.equals("fire")) {
                    return attackingMonster.attack();
                } else if (elementaryVictim.equals("water")) {
                    return attackingMonster.attack() / 2 ;
                } else {
                    return attackingMonster.attack() * 2 ;
                }
            } else if (elementaryOpponent.equals("air")) {
                if (elementaryVictim.equals("air")) {
                    return attackingMonster.attack();
                } else if (elementaryVictim.equals("fire")) {
                    return attackingMonster.attack() / 2 ;
                } else {
                    return attackingMonster.attack() * 2 ;
                }
            } else if (elementaryOpponent.equals("water")) {
                if (elementaryVictim.equals("water")) {
                    return attackingMonster.attack();
                } else if (elementaryVictim.equals("air")) {
                    return attackingMonster.attack() / 2 ;
                } else {
                    return attackingMonster.attack() * 2 ;
                }
            } else {
                return 200;
            }
    }
    
}