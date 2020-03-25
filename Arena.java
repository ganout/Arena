import java.util.Scanner;

public class Arena {

    


    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int victory = 0; 
        // Une fois le champion créé, trois adversaires vont successivement le combattre. Chaque adversaire à ses attributs et élément attribués aléatoirement. De plus, ces points de vies sont sélectionnés aléatoirement entre 10 et 30.

        //création du champion
        Champion dracaufeu = new Champion("Dracaufeu", "feu");

        //création de trois adversaires
        Opponent roucool = new Opponent("Roucool");
        Opponent goupix = new Opponent("Goupix");
        Opponent tortank = new Opponent("Tortank");

        System.out.println();
        System.out.println("Le trio Jessie, James et Miaouss de la team rocket nous attaquent !!!!");
        System.out.println();
        System.out.println("appuyez sur entrée pour lancer votre pokéball");
        input.nextLine();        
        System.out.println("Dracaufeu, à toi de jouer !!!");
        System.out.println();
        System.out.println(dracaufeu.getName() + " est de type : " + dracaufeu.getElementary() + ", il a une attaque de : " + dracaufeu.getStrength() + ", une intelligence de : " + dracaufeu.getIntelligence() + ", ainsi que " + dracaufeu.getLife() + " points de vie.");
        System.out.println();
        System.out.println("appuyez sur entrée pour que la team rocket vous montre leurs pokémons");
        input.nextLine();
        System.out.println();
        System.out.println("Le 1er adversaire sera : " + roucool.getName());
        System.out.println("Le 2eme adversaire sera : " + goupix.getName());
        System.out.println("Le 3eme adversaire sera : " + tortank.getName());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("    ------------------------");
        System.out.println("    | DRACAUFEU VS ROUCOOL |");
        System.out.println("    ------------------------");
        System.out.println();
        System.out.println();
        System.out.println(roucool.getName() + " est de type : " + roucool.getElementary() + ", avec une attaque de : " + roucool.getStrength() + ", ainsi que " + roucool.getLife() + " points de vie.");
        System.out.println();
        System.out.println();
        System.out.println("appuyez sur entrée pour attaquer " + roucool.getName());
        input.nextLine();

        boolean heWant = false;

        //1er combat
        while (dracaufeu.getLife() > 0 && roucool.getLife() > 0) {
            
            if (dracaufeu.getLife() != 40) {
                heWant = askHeal();
            }
            if (heWant) {
                dracaufeu.heal();
            } else {
                int dracaufeuAttack = Champion.elementaryEffect(dracaufeu, roucool);
            System.out.println(dracaufeu.getName() + " a porté une attaque de : " + dracaufeuAttack);
            System.out.println();
            roucool.setLife(roucool.getLife() - dracaufeuAttack);
            System.out.println(roucool.getName() + " a " + roucool.getLife() + " de vie");
            System.out.println();
            }

            if (roucool.getLife() > 0) {
                int roucoolAttack = Opponent.elementaryEffect(roucool, dracaufeu);
                System.out.println(roucool.getName() + " a porté une attaque de : " + roucoolAttack);
                System.out.println();
                dracaufeu.setLife(dracaufeu.getLife() - roucoolAttack);
                System.out.println(dracaufeu.getName() + " a " + dracaufeu.getLife() + " de vie");
                System.out.println();
            }
        }

        if (dracaufeu.getLife() > 0) {
            victory += 1;
            System.out.println("Roucool est KO ! ");
            System.out.println();
            System.out.println("Dracaufeu a gagné");
            System.out.println();
            System.out.println("Dracaufeu a " + victory + " de victoire !");
        } else {
            System.out.println("Dracaufeu est KO !");
            System.out.println();
            System.out.println("Roucool a gagné");
            System.out.println();
            System.out.println("Dracaufeu n'a pas eu de victoire");
        }

        if (victory == 1) {
            System.out.println();
            System.out.println("    ------------------------");
            System.out.println("    | DRACAUFEU VS GOUPIX  |");
            System.out.println("    ------------------------");
            System.out.println();
        

            System.out.println();
            System.out.println(goupix.getName() + " est de type : " + goupix.getElementary() + ", avec une attaque de : " + goupix.getStrength() + ", ainsi que " + goupix.getLife() + " points de vie.");
            System.out.println();
        }

        //2eme combat
        while (dracaufeu.getLife() > 0 && goupix.getLife() > 0) {
            
            if (dracaufeu.getLife() != 40) {
                heWant = askHeal();
            }
            if (heWant) {
                dracaufeu.heal();
            } else {
                int dracaufeuAttack = Champion.elementaryEffect(dracaufeu, goupix);
            System.out.println(dracaufeu.getName() + " a porté une attaque de : " + dracaufeuAttack);
            System.out.println();
            goupix.setLife(goupix.getLife() - dracaufeuAttack);
            System.out.println(goupix.getName() + " a " + goupix.getLife() + " de vie");
            System.out.println();
            }

            if (goupix.getLife() > 0) {
                int goupixAttack = Opponent.elementaryEffect(goupix, dracaufeu);
                System.out.println(goupix.getName() + " a porté une attaque de : " + goupixAttack);
                System.out.println();
                dracaufeu.setLife(dracaufeu.getLife() - goupixAttack);
                System.out.println(dracaufeu.getName() + " a " + dracaufeu.getLife() + " de vie");
                System.out.println();
            }
        }
        if (victory == 1) {
            if (dracaufeu.getLife() > 0) {
                victory += 1;
                System.out.println("Goupix est KO ! ");
                System.out.println();
                System.out.println("Goupix a gagné");
                System.out.println();
                System.out.println("Dracaufeu a " + victory + " de victoires !");
            } else {
                System.out.println("Dracaufeu est KO !");
                System.out.println();
                System.out.println("Goupix a gagné");
                System.out.println();
                System.out.println("Dracaufeu a eu " + victory + " de victoire !");
            }
        }
        if (victory == 2) {
            System.out.println();
            System.out.println("    ------------------------");
            System.out.println("    | DRACAUFEU VS TORTANK  |");
            System.out.println("    ------------------------");
            System.out.println();
        

            System.out.println();
            System.out.println(tortank.getName() + " est de type : " + tortank.getElementary() + ", avec une attaque de : " + tortank.getStrength() + ", ainsi que " + tortank.getLife() + " points de vie.");
            System.out.println();
        }
    
        //3eme combat
        while (dracaufeu.getLife() > 0 && tortank.getLife() > 0) {
            
            if (dracaufeu.getLife() != 40) {
                heWant = askHeal();
            }
            if (heWant) {
                dracaufeu.heal();
            } else {
                int dracaufeuAttack = Champion.elementaryEffect(dracaufeu, tortank);
            System.out.println(dracaufeu.getName() + " a porté une attaque de : " + dracaufeuAttack);
            System.out.println();
            tortank.setLife(tortank.getLife() - dracaufeuAttack);
            System.out.println(tortank.getName() + " a " + tortank.getLife() + " de vie");
            System.out.println();
            }

            if (tortank.getLife() > 0) {
                int tortankAttack = Opponent.elementaryEffect(tortank, dracaufeu);
                System.out.println(tortank.getName() + " a porté une attaque de : " + tortankAttack);
                System.out.println();
                dracaufeu.setLife(dracaufeu.getLife() - tortankAttack);
                System.out.println(dracaufeu.getName() + " a " + dracaufeu.getLife() + " de vie");
                System.out.println();
            }
        }
        if (victory == 2) {
            if (dracaufeu.getLife() > 0) {
                victory += 1;
                System.out.println("Tortank est KO ! ");
                System.out.println();
                System.out.println("Dracaufeu a gagné");
                System.out.println();
                System.out.println("Dracaufeu a " + victory + " de victoires !");
            } else {
                System.out.println("Dracaufeu est KO !");
                System.out.println();
                System.out.println("Tortank a gagné");
                System.out.println();
                System.out.println("Dracaufeu a eu " + victory + " de victoires !");
            }
        }
    }
    //end méthode main


    public static boolean askHeal() {

        Scanner input = new Scanner(System.in);

        System.out.println("Veux-tu soigner ton champion ?");
        
        String answer = input.nextLine();
        char yesOrNo = answer.charAt(0);
        while (yesOrNo != 'y' && yesOrNo != 'n') {
            System.out.println("entrer seulement y ou n .");
            answer = input.nextLine();
            yesOrNo = answer.charAt(0);
        }
        if (yesOrNo == 'y') { 
            return true;
        } else {
            return false;
        }
    }
}