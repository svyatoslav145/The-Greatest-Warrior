package theGreatestWarrior;

import theGreatestWarrior.creatures.Warrior;

public class Main {

    public static void main(String[] args) {

//        Warrior warrior = new Warrior("My Warrior", 100);
//
//        Arena arena = new Arena();
//
//        arena.doBattle(warrior);

        new Arena().doBattle(new Warrior("My Warrior", 100));
    }
}
