package theGreatestWarrior.creatures;

import theGreatestWarrior.rank.Rank;

/**
 * The warrior and enemy model.
 */
public class Warrior {
    private String name;
    private int experience;
//    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Counts the level "on the fly".
     *
     * @return Level of warrior or enemy.
     */
    public int getLevel() {
        return (experience / 100);
    }

    public Warrior(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public Warrior() {
    }

    /**
     * Counts the rank "on the fly".
     *
     * @param experience Warrior or enemy experience.
     * @return Rank of warrior or enemy.
     */
    public Rank calculateRank(int experience) {
        return Rank.findRankByExp(experience / 1000);
    }

    @Override
    public String toString() {
        return String.format("name: %s, experience: %d, level %d, rank %d-%s",
                name, experience, getLevel(), calculateRank(experience).getExperience(),
                calculateRank(experience).name());
    }
}

