package theGreatestWarrior.creatures;

import static theGreatestWarrior.TheGreatestWarriorConfig.*;

/**
 * Contains method for making enemy.
 */
public class EnemyFactory {

    /**
     * Creates a random enemy. Enemy level depend on our warrior level.
     *
     * @param warrior This our warrior.
     * @return Random enemy.
     */
    public Warrior makeEnemy(Warrior warrior) {
        Warrior enemy = new Warrior();

        String[] enemyName = new String[]{"Bob", "Mary", "Ivan", "Lavrentiy",
                "Ostap", "Vanessa", "Vanderbilt", "Elena", "Thomas", "Hamilton", "Suzie",
                "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily",
                "Daniel", "Neda", "Aaron", "Kate", "Soon Van", "Attila", "Julius Caesar",
                "Napoleon", "Bruce Lee", "Terminator T-1000"};
        int randomName = (int) (Math.random() * enemyName.length);
        enemy.setName(enemyName[randomName]);

        int increaseOrDecrease = 1;
        int randomIncreaseOrDecrease = (int) (Math.random() * (100 - 1) + 1);
        if (randomIncreaseOrDecrease >
                PROBABILITY_OF_GETTING_ENEMY_IS_HIGHER_THAN_WARRIOR) {
            increaseOrDecrease = -1;
        }

        int levelIncreaseOrDecrease = (increaseOrDecrease > 0) ?
                (int) (Math.random() * MAXIMUM_INCREASE_IN_LEVEL) :
                (int) (Math.random() * MAXIMUM_DECREASE_IN_LEVEL);


        int enemyExperience = warrior.getExperience() +
                100 * increaseOrDecrease * levelIncreaseOrDecrease;

        if (enemyExperience < 100 || enemyExperience > 10000) {
            enemy.setExperience(1);
            enemy.setName("Unknown");
            return enemy;
        }

        enemy.setExperience(enemyExperience);

        return enemy;
    }
}
