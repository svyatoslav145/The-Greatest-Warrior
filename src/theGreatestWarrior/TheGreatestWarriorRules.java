package theGreatestWarrior;

import theGreatestWarrior.creatures.Warrior;
import theGreatestWarrior.rank.Rank;

import static theGreatestWarrior.TheGreatestWarriorConfig.*;

/**
 * Contains rules of the battle and counting of received experience.
 */
class TheGreatestWarriorRules {

    /**
     * Defines an our warrior win or defeat.
     *
     * @param warrior Our warrior.
     * @param enemy   Enemy.
     * @return Either the victory yes or no.
     */
    boolean isWarriorWinner(Warrior warrior, Warrior enemy) {
        if (!isAbleWarriorToFight(warrior, enemy)) {
            System.out.printf("You can not fight with %s level %d.\n",
                    enemy.getName(),
                    enemy.getLevel());
            return false;
        }
        boolean victory = true;
        int randomDefeat = (int) ((Math.random() * 100 - 1 + 1) + 1);

        if ((PROBABILITY_OF_WARRIOR_VICTORY + warrior.getLevel() - enemy.getLevel())
                < randomDefeat) {
            victory = false;
        }
        return victory;
    }

    /**
     * Calculates the experience gained by warrior.
     *
     * @param warrior Our warrior.
     * @param enemy   Enemy.
     * @return The experience gained by warrior.
     */
    int countExtraExperience(Warrior warrior, Warrior enemy) {
        int extraExperience;

        if (warrior.getLevel() - enemy.getLevel() >= 2) {
            extraExperience = EXPERIENCE_FOR_DEFEATING_ENEMY_TWO_AND_MORE_LEVEL_LOWER;
        }
        else if (warrior.getLevel() - enemy.getLevel() == 1) {
            extraExperience = EXPERIENCE_FOR_DEFEATING_ENEMY_ONE_LEVEL_LOWER;
        }
        else if (warrior.getLevel() == enemy.getLevel()) {
            extraExperience = EXPERIENCE_FOR_DEFEATING_ENEMY_EQUAL_LEVEL;
        }
        else {
            int levelDifference = enemy.getLevel() - warrior.getLevel();
            extraExperience = EXPERIENCE_COEFFICIENT_FOR_DEFEATING_HIGHER_LEVEL_ENEMY *
                    levelDifference * levelDifference;
        }

        return extraExperience;
    }

    /**
     * Check if warrior can fight with enemy.
     *
     * @param warrior Our warrior.
     * @param enemy   Enemy.
     * @return True if warrior is able to fight.
     */
    private boolean isAbleWarriorToFight(Warrior warrior, Warrior enemy) {
        boolean isAbleFight = true;

        Rank warriorRank = warrior.calculateRank(warrior.getExperience());
        Rank enemyRank = enemy.calculateRank(enemy.getExperience());

        if ((enemy.getLevel() - warrior.getLevel()) >
                CRITICAL_LEVEL_DIFFERENCE_FOR_DIFFERENT_RANKS
                && enemyRank.getExperience()
                > warriorRank.getExperience()) {
            isAbleFight = false;
        }
        return isAbleFight;
    }
}
