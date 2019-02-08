import java.util.ArrayList;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BoggartInTheWardrobeExamMain {
    public static void main(String []args){
        //please make sure STUDENT_NUMBER_PER_WARDROBE is divisible by 4, to ensure each thread has equal number of
        //students from 4 houses
        final int STUDENT_NUMBER_PER_WARDROBE = 100; //make sure this number is divisible by 4
        final int WARDROBE_NUMBER = 10;
        final int INSTRUCTOR_NUMBER=6;
        StopWatch timer = new StopWatch();
        timer.start();




        List<Thread> threadList = new ArrayList<Thread>();
        WizardScoreRegistry wizardScoreRegistry = new WizardScoreRegistry(0,0,0,0,0,0);
        //Create instructors
        CopyOnWriteArrayList<Instructor> instructorList = generateInstructors(INSTRUCTOR_NUMBER,wizardScoreRegistry);
        System.out.println(instructorList.size());

        //Create Wardrobe
        for(int a =0; a<WARDROBE_NUMBER;a++){
            String wardrobeName = "Wardrobe" + a;
            JuniorWizardDAO juniorWizardsForThisThread = new JuniorWizardDAO(STUDENT_NUMBER_PER_WARDROBE);
            juniorWizardsForThisThread.generateRandomJuniorWizards();
            ArrayList<JuniorWizard> juniorWizards = juniorWizardsForThisThread.getJuniorWizards();

            Boggart boggartInCurrentWardrobe = new Boggart("boggart"+a);

            WardrobeSingleTest toInclude = new WardrobeSingleTest(wardrobeName,boggartInCurrentWardrobe,juniorWizards,0,wizardScoreRegistry,instructorList);
            threadList.add(new Thread(toInclude));

        }
//        Instructor instructor = new Instructor("Instructor",wardrobes);
//        threadList.add(new Thread(instructor::examInspection));
        for (Thread t: threadList){
            t.start();
        }
        // main will join all threads in threadList
        for (Thread t: threadList){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Elapsed time: " + timer);
        System.out.println();


        System.out.println("acutal number of students is " +STUDENT_NUMBER_PER_WARDROBE*WARDROBE_NUMBER );
        System.out.println("registry recordrd student number is "+ (wizardScoreRegistry.getTotalFails()+wizardScoreRegistry.getTotalPasses()));
        //shows the summary of the competition, indicate which house wins
        wizardScoreRegistry.displaySummary();



    }



    public static CopyOnWriteArrayList<Instructor> generateInstructors(int instructorCount,WizardScoreRegistry wizardScoreRegistry){
        CopyOnWriteArrayList<Instructor> toReturn = new CopyOnWriteArrayList<Instructor>();
        for(int a =0;a<instructorCount;a++){
            String instructorName="Instructor"+a;

            Instructor toAdd = new Instructor(instructorName,wizardScoreRegistry);
            toReturn.add(toAdd);

        }

        return toReturn;
    }


}
