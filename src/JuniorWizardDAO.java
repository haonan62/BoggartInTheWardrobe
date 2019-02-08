

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JuniorWizardDAO {
    private ArrayList<JuniorWizard> juniorWizards;

    private int wizardNumberPerWardrobe;


    public JuniorWizardDAO(int wizardNumberPerWardrobe) {
        this.juniorWizards = new ArrayList<>();
        this.wizardNumberPerWardrobe=wizardNumberPerWardrobe;
    }

    public ArrayList<JuniorWizard> getJuniorWizards(){
        return juniorWizards;
    }
    public void setJuniorWizards(ArrayList<JuniorWizard> newValue){
        this.juniorWizards= newValue;
    }



    public void generateRandomJuniorWizards(){
        ArrayList<JuniorWizard> toReturn = new ArrayList<>();
        int firstQuaterMark = wizardNumberPerWardrobe/4;
        int secondQuarterMark = wizardNumberPerWardrobe/2;
        int thirdQuarterMark = firstQuaterMark*3;
        for(int a = 0;a<wizardNumberPerWardrobe;a++){
            //Assign the first quarter of population to school Gryffindor
            if(a<firstQuaterMark) {
                String wizardName = "Wizard" + a;
                ArrayList<String> currentWizardFear = generateRandomFearedList();
                String schoolName = "Gryffindor";
                JuniorWizard wizardToAdd = new JuniorWizard(wizardName,currentWizardFear,schoolName);
                toReturn.add(wizardToAdd);
            }else if(a>=firstQuaterMark&&a<secondQuarterMark){
                String wizardName = "Wizard" + a;
                ArrayList<String> currentWizardFear = generateRandomFearedList();
                String schoolName = "Hufflepuff";
                JuniorWizard wizardToAdd = new JuniorWizard(wizardName,currentWizardFear,schoolName);
                toReturn.add(wizardToAdd);
            }else if(a>=secondQuarterMark&&a<thirdQuarterMark){
                String wizardName = "Wizard" + a;
                ArrayList<String> currentWizardFear = generateRandomFearedList();
                String schoolName = "Ravenclaw";
                JuniorWizard wizardToAdd = new JuniorWizard(wizardName,currentWizardFear,schoolName);
                toReturn.add(wizardToAdd);
            }else{
                String wizardName = "Wizard" + a;
                ArrayList<String> currentWizardFear = generateRandomFearedList();
                String schoolName = "Slytherin";
                JuniorWizard wizardToAdd = new JuniorWizard(wizardName,currentWizardFear,schoolName);
                toReturn.add(wizardToAdd);
            }

        }
        setJuniorWizards(toReturn);

    }

    public ArrayList<String> generateRandomFearedList() {
        ArrayList<String> toReturn = new ArrayList<>();

        //The list contains 10 most feared objects by the general public
        List<String> commonFearsOfPublic = Arrays.asList("darkness", "spider", "thunder&lightning", "clown", "insect", "reptile", "tornado&hurricane", "snake", "moon", "witch&witchcraft");

        //shuffle the list to obtain randomness
        Collections.shuffle(commonFearsOfPublic);


        //get the top6 feared items and assign them as user's top6 feared item
        toReturn = new ArrayList<String>(commonFearsOfPublic.subList(0, 6));


        return toReturn;

    }
}
