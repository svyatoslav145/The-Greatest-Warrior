package theGreatestWarrior;

import theGreatestWarrior.creatures.Warrior;
import theGreatestWarrior.printer.ColorPrint;

import static theGreatestWarrior.TheGreatestWarriorConfig.PROBABILITY_OF_SUCCESSFUL_TRAINING;

/**
 * Contains methods of training warrior.
 */
class Training {

    /**
     * Workout counter.
     */
    private int numberOfTraining = 0;

    private String coachName;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    private Runnable successfulTraining = () -> {
        System.out.println(ColorPrint.GREEN.getColor());
        System.out.printf("Training with %s was successful.\n" +
                "You got some experience.\n", getCoachName());
        System.out.println(ColorPrint.RESET.getColor());
    };

    private Runnable failedTraining = () -> {
        System.out.println(ColorPrint.BLACK.getColor());
        System.out.printf("You could not understand the wisdom of the teacher.\n" +
                "Training with %s was unsuccessful.\n", getCoachName());
        System.out.println(ColorPrint.RESET.getColor());
    };

    /**
     * Training of warrior from level 30. Can be used only once.
     *
     * @param warrior Warrior parameters.
     * @return Warrior with more experience than before in case successful training.
     */
    Warrior trainingWithOdysseus(Warrior warrior) {
        setCoachName("Odysseus");
        int extraExperience = 0;
        if (warrior.getLevel() > 29 && numberOfTraining == 0) {
            int checkingTheChanceOfSuccess = (int) ((Math.random() * 100 - 1 + 1) + 1);
            if (PROBABILITY_OF_SUCCESSFUL_TRAINING >= checkingTheChanceOfSuccess) {
                extraExperience = 100;
                successfulTraining.run();
            }
            else {
                failedTraining.run();
            }
            numberOfTraining += 1;
        }
        warrior.setExperience(warrior.getExperience() + extraExperience);
        return warrior;
    }

    /**
     * Training of warrior from level 50. Can be used only once.
     * Can be used only after{@link Training#trainingWithOdysseus(Warrior)}
     *
     * @param warrior Warrior parameters.
     * @return Warrior with more experience than before in case successful training.
     */
    Warrior trainingWithAchilles(Warrior warrior) {
        setCoachName("Achilles");
        int extraExperience = 0;
        if (warrior.getLevel() > 49 && numberOfTraining == 1) {
            int checkingTheChanceOfSuccess = (int) ((Math.random() * 100 - 1 + 1) + 1);
            if (PROBABILITY_OF_SUCCESSFUL_TRAINING >= checkingTheChanceOfSuccess) {
                extraExperience = 200;
                successfulTraining.run();
            }
            else {
                failedTraining.run();
            }
            numberOfTraining += 1;
        }
        warrior.setExperience(warrior.getExperience() + extraExperience);
        return warrior;
    }

    /**
     * Training of warrior from level 70. Can be used only once.
     * Can be used only after {@link Training#trainingWithAchilles(Warrior)}
     *
     * @param warrior Warrior parameters.
     * @return Warrior with more experience than before in case successful training.
     */
    Warrior trainingWithHercules(Warrior warrior) {
        setCoachName("Hercules");
        int extraExperience = 0;
        if (warrior.getLevel() > 69 && numberOfTraining == 2) {
            int checkingTheChanceOfSuccess = (int) ((Math.random() * 100 - 1 + 1) + 1);
            if (PROBABILITY_OF_SUCCESSFUL_TRAINING >= checkingTheChanceOfSuccess) {
                extraExperience = 300;
                successfulTraining.run();
            }
            else {
                failedTraining.run();
            }
            numberOfTraining += 1;
        }
        warrior.setExperience(warrior.getExperience() + extraExperience);
        return warrior;
    }
}
