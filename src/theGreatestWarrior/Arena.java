package theGreatestWarrior;

import theGreatestWarrior.creatures.EnemyFactory;
import theGreatestWarrior.creatures.Warrior;
import theGreatestWarrior.printer.ColorPrint;
import theGreatestWarrior.rank.Rank;

/**
 * Makes battle warrior against enemies.
 */
class Arena {

    /**
     * Makes battle warrior against enemies.
     *
     * @param warrior Warrior.
     */
    void doBattle(Warrior warrior) {
        EnemyFactory enemyFactory = new EnemyFactory();
        TheGreatestWarriorRules theGreatestWarriorRules = new TheGreatestWarriorRules();
        Training training = new Training();

        while (warrior.getExperience() < 10000) {
            int oldExperienceOfWarrior = warrior.getExperience();
            int oldLevelOfWarrior = warrior.getLevel();
            Rank oldRankOfWarrior = warrior.calculateRank(warrior.getExperience());

            Warrior enemy = enemyFactory.makeEnemy(warrior);

            if (enemy.getLevel() == 0) {
                System.out.println("Invalid level of enemy.");
                continue;
            }
            if (!theGreatestWarriorRules.isWarriorWinner(warrior, enemy)) {
                System.out.println(ColorPrint.BLACK.getColor());
                System.out.printf("You have been defeated by %s.\n", enemy.getName());
                System.out.println(ColorPrint.RESET.getColor());
                continue;
            }

            int newExperienceOfWarrior = oldExperienceOfWarrior +
                    theGreatestWarriorRules.countExtraExperience(warrior, enemy);

            sayResultOfFighting(warrior, theGreatestWarriorRules, enemy);

            warrior.setExperience(newExperienceOfWarrior);

            int newLevelOfWarrior = warrior.getLevel();

            checkIfWarriorHadNewLevel(warrior, oldLevelOfWarrior);

            checkIfWarriorHadNewRank(warrior, oldRankOfWarrior);

            training.trainingWithOdysseus(warrior);
            training.trainingWithAchilles(warrior);
            training.trainingWithHercules(warrior);


            checkIfWarriorHadNewLevel(warrior, newLevelOfWarrior);
            checkIfWarriorHadNewRank(warrior, warrior.calculateRank(newExperienceOfWarrior));

        }

    }

    /**
     * Says positive result of battle.
     *
     * @param warrior                 Warrior.
     * @param theGreatestWarriorRules Rules of the battle and counting of received experience.
     * @param enemy                   Enemy.
     */
    private void sayResultOfFighting(Warrior warrior, TheGreatestWarriorRules theGreatestWarriorRules, Warrior enemy) {
        if (warrior.getLevel() - enemy.getLevel() >= 2) {
            System.out.println(ColorPrint.YELLOW.getColor());
            System.out.printf("Easy fight. You defeated %s level %d.\n" +
                            "But you did not have experience.\n",
                    enemy.getName(),
                    enemy.getLevel());
            System.out.println(ColorPrint.RESET.getColor());
        }
        else if (warrior.getLevel() - enemy.getLevel() == 1 ||
                warrior.getLevel() - enemy.getLevel() == 0) {
            int exp = (warrior.getLevel() - enemy.getLevel() == 1) ? 5 : 10;
            System.out.println(ColorPrint.GREEN.getColor());
            System.out.printf("A good fight. You defeated %s level %d.\n" +
                            "You receive %d experience.\n",
                    enemy.getName(),
                    enemy.getLevel(),
                    exp);
            System.out.println(ColorPrint.RESET.getColor());
        }
        else {
            System.out.println(ColorPrint.PURPLE.getColor());
            System.out.printf("An intense fight. You defeated %s level %d.\n" +
                            "You receive %d experience.\n",
                    enemy.getName(),
                    enemy.getLevel(),
                    theGreatestWarriorRules.countExtraExperience(warrior, enemy));
            System.out.println(ColorPrint.RESET.getColor());
        }
    }

    /**
     * Check if warrior got new level and reports about it.
     *
     * @param warrior           Warrior.
     * @param oldLevelOfWarrior Previous warrior level.
     */
    private void checkIfWarriorHadNewLevel(Warrior warrior, int oldLevelOfWarrior) {
        if (warrior.getLevel() > oldLevelOfWarrior) {
            System.out.println(ColorPrint.CYAN.getColor());
            System.out.printf("You reached new level. Your new level is %d.\n",
                    warrior.getLevel());
            System.out.println(ColorPrint.RESET.getColor());
        }
    }

    /**
     * Check if warrior got new rank and reports about it.
     *
     * @param warrior          Warrior.
     * @param oldRankOfWarrior Previous warrior rank.
     */
    private void checkIfWarriorHadNewRank(Warrior warrior, Rank oldRankOfWarrior) {
        if (warrior.calculateRank(warrior.getExperience()).getExperience() >
                oldRankOfWarrior.getExperience()) {
            System.out.println(ColorPrint.RED.getColor());
            System.out.printf("You reached new rank. Your new rank is %s.\n",
                    warrior.calculateRank(warrior.getExperience()));
            System.out.println(ColorPrint.RESET.getColor());
        }
    }
}
