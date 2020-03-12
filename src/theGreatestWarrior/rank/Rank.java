package theGreatestWarrior.rank;

/**
 * Contains an enumeration of ranks.
 */
public enum Rank {
    PUSHOVER(0),
    NOVICE(1),
    FIGHTER(2),
    WARRIOR(3),
    VETERAN(4),
    SAGE(5),
    ELITE(6),
    CONQUEROR(7),
    CHAMPION(8),
    MASTER(9),
    GREATEST(10),
    UNKNOWN_RANK(77777);

    /**
     * Experience level of rank.
     */
    private int experience;

    public int getExperience() {
        return experience;
    }

    Rank(int experience) {
        this.experience = experience;
    }

    /**
     * Finds warrior or enemy rank.
     *
     * @param experienceOfWarrior Warrior or enemy experience.
     * @return Rank of warrior or enemy.
     */
    public static Rank findRankByExp(int experienceOfWarrior) {
        Rank[] values = values();
        for (Rank rank : values) {
            if (rank.experience == experienceOfWarrior) {
                return rank;
            }
        }
        return UNKNOWN_RANK;
    }
}
