//A Boggart is an amortal shape-shifting non-being that takes on the form of
//the viewer's worst fear. It is used in dark magic defence class to
//let student confront their fears.


import java.util.List;
import java.util.Random;

public class Boggart{
    private String name;

    private String currentForm;



    //constructor
    public Boggart(String name){
        this.name=name;

        this.currentForm="originalForm";

    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInOriginalForm() {
        boolean flag = false;
        if(currentForm.equals("originalForm")){
            flag=true;
        }
        return flag;
    }

    public String getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(String currentForm) {
        this.currentForm = currentForm;
    }




    //retrieve a random feared image from victim, and then removes it from fearedList for rest of Boggarts to choose differently
    public String locateOneFear(JuniorWizard victim){
        List<String> victimFearList = victim.getWorstFears();
        int FearListSize = victimFearList.size();
        Random r = new Random();
        String selectedFear = victimFearList.get(r.nextInt(FearListSize));
        //TO MODIFY: maybe later add in racing condition if there are more than one boggarts inside the wardrobe
        return selectedFear;



    }

    public void transformToFear(String fearOfSubject){
        this.setCurrentForm(fearOfSubject);
        //System.out.println("Boggart "+ getName()+" transformed into a "+fearOfSubject);
    }


}
