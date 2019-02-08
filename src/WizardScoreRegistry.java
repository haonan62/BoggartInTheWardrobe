import java.util.concurrent.locks.*;

public class WizardScoreRegistry {
    private int totalPasses;
    private int totalFails;
    private int gryffindorScore;
    private int hufflepuffScore;
    private int ravenclawScore;
    private int slytherinScore;

    private Lock scoreLock = new ReentrantLock();

    public WizardScoreRegistry(int totalPasses, int totalFails, int gryffindorScore, int hufflepuffScore, int ravenclawScore, int slytherinScore) {
        this.totalPasses = totalPasses;
        this.totalFails = totalFails;
        this.gryffindorScore=gryffindorScore;
        this.hufflepuffScore=hufflepuffScore;
        this.ravenclawScore=ravenclawScore;
        this.slytherinScore=slytherinScore;
    }

    public int getTotalPasses() {
        return totalPasses;
    }

    public void setTotalPasses(int totalPasses) {
        this.totalPasses = totalPasses;
    }

    public int getTotalFails() {
        return totalFails;
    }

    public void setTotalFails(int totalFails) {
        this.totalFails = totalFails;
    }

    public int getGryffindorScore() {
        return gryffindorScore;
    }

    public int getHufflepuffScore() {
        return hufflepuffScore;
    }

    public int getRavenclawScore() {
        return ravenclawScore;
    }

    public int getSlytherinScore() {
        return slytherinScore;
    }

    public Lock getScoreLock() {
        return scoreLock;
    }

    public void increasePassbyOne(){
        scoreLock.lock();
        try {

            totalPasses++;
        }finally {
            scoreLock.unlock();
        }

    }

    public void increaseFailByOne(){
        scoreLock.lock();
        try {
            totalFails++;
        }finally {
            scoreLock.unlock();
        }

    }

    public  int getTotalNumbers(){
        return totalFails+totalPasses;
    }

    public void increaseSchoolScore(String schoolName, int increaseAmt){
        scoreLock.lock();
        try {
            if (schoolName.equals("Gryffindor")) {
                gryffindorScore += increaseAmt;
            } else if (schoolName.equals("Hufflepuff")) {
                hufflepuffScore += increaseAmt;
            } else if (schoolName.equals("Ravenclaw")) {
                ravenclawScore += increaseAmt;
            } else if (schoolName.equals("Slytherin")) {
                slytherinScore += increaseAmt;
            }
        }finally {
            scoreLock.unlock();
        }
    }


    public void decreaseSchoolScore(String schoolName, int decreaseAmt){
        scoreLock.lock();
        try {
            if (schoolName.equals("Gryffindor")) {
                gryffindorScore -= decreaseAmt;
            } else if (schoolName.equals("Hufflepuff")) {
                hufflepuffScore -= decreaseAmt;
            } else if (schoolName.equals("Ravenclaw")) {
                ravenclawScore -= decreaseAmt;
            } else if (schoolName.equals("Slytherin")) {
                slytherinScore -= decreaseAmt;
            }
        }finally {
            scoreLock.unlock();
        }
    }

    public void displaySummary(){

        System.out.println("Total Passes recorded in Registry:    "+ totalPasses);
        System.out.println("Total Fails recorded in Registry    "+totalFails);
        System.out.println("Gryffindor :    "+gryffindorScore);
        System.out.println("Hufflepuff :    "+hufflepuffScore);
        System.out.println("Ravenclaw :    "+ravenclawScore);
        System.out.println("Slytherin :    "+slytherinScore);



    }
}
