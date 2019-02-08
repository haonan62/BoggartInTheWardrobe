
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class WardrobeSingleTest implements Runnable {
    private String name;

    private Boggart boggart;


    private ArrayList<JuniorWizard> juniorWizards;

    private Integer passesInthisWardrobe;
    private boolean isQueueEmpty;
    protected WizardScoreRegistry wizardScoreRegistry;
    protected CopyOnWriteArrayList<Instructor> instructors;


    public WardrobeSingleTest(String name, Boggart boggart, ArrayList<JuniorWizard> juniorWizards, Integer passesInthisWardrobe, WizardScoreRegistry wizardScoreRegistry, CopyOnWriteArrayList<Instructor> instructors) {
        this.name = name;
        this.boggart = boggart;

        this.juniorWizards = juniorWizards;
        this.passesInthisWardrobe = passesInthisWardrobe;

        this.isQueueEmpty = false;
        this.wizardScoreRegistry = wizardScoreRegistry;
        this.instructors = instructors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boggart getBoggart() {
        return boggart;
    }

    public void setBoggart(Boggart boggart) {
        this.boggart = boggart;
    }


    public ArrayList<JuniorWizard> getJuniorWizards() {
        return juniorWizards;
    }

    public void setJuniorWizards(ArrayList<JuniorWizard> juniorWizards) {
        this.juniorWizards = juniorWizards;
    }


    public Integer getPassesInthisWardrobe() {
        return passesInthisWardrobe;
    }

    public void setPassesInthisWardrobe(Integer passesInthisWardrobe) {
        this.passesInthisWardrobe = passesInthisWardrobe;
    }

    public boolean isQueueEmpty() {
        return isQueueEmpty;
    }

    public void setQueueEmpty(boolean queueEmpty) {
        isQueueEmpty = queueEmpty;
    }

    public WizardScoreRegistry getWizardScoreRegistry() {
        return wizardScoreRegistry;
    }

    public void setWizardScoreRegistry(WizardScoreRegistry wizardScoreRegistry) {
        this.wizardScoreRegistry = wizardScoreRegistry;
    }

    public CopyOnWriteArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(CopyOnWriteArrayList<Instructor> instructor) {
        this.instructors = instructor;
    }

    @Override
    public void run() {

        try {

            for (JuniorWizard currentJuniorWizard : juniorWizards) {

                boolean allPassFlag = true;
                while (currentJuniorWizard.getWorstFears().size() > 0) {
                    String currentFear = boggart.locateOneFear(currentJuniorWizard);
                    //Thread.sleep(1);
                    boggart.transformToFear(currentFear);
                    //Thread.sleep(1);

                    currentJuniorWizard.determineFear(currentFear);
                    if (!currentJuniorWizard.isScared()) {

                        currentJuniorWizard.castSpell(boggart);
                        int responseTime = ThreadLocalRandom.current().nextInt(10);
                        Thread.sleep(responseTime);
                        int awardedScore = 10 - responseTime;
                        wizardScoreRegistry.increaseSchoolScore(currentJuniorWizard.getSchool(), awardedScore);


                    } else {
                        allPassFlag = false;
                        Thread.sleep(50);

                        int index = ThreadLocalRandom.current().nextInt(instructors.size());

                        Instructor currentRandomInstructor = instructors.get(index);


                        Thread.sleep(50);

                        synchronized (currentRandomInstructor) {
                            currentRandomInstructor.helpJuniorWizard(boggart);

                            currentRandomInstructor.failJuniorWizard(currentJuniorWizard);
                        }

                        break;


                    }

                }
                if (allPassFlag == true) {
                    wizardScoreRegistry.increasePassbyOne();


                    passesInthisWardrobe++;
                }
                //System.out.println(currentJuniorWizard.getName()+" passed the test!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setQueueEmpty(true);
        }

    }


}
