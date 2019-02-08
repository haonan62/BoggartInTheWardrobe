

public class Instructor {
    private String name;
    protected WizardScoreRegistry wizardScoreRegistry;



    public Instructor(String name,WizardScoreRegistry wizardScoreRegistry){
        this.name = name;

        this.wizardScoreRegistry=wizardScoreRegistry;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    //helping a junior wizard by transforming back the boggart
    public void helpJuniorWizard(Boggart boggartsInWardrobe){
        boggartsInWardrobe.setCurrentForm("OriginalForm");
        System.out.println(name+" forced "+ boggartsInWardrobe.getName()+" to Original Form");
    }

    //This methods helps a student who cannot handle the Boggart, meanwhile, fails the student
    //Upon failing, 100 points are dedcucted from the house
    public void failJuniorWizard(JuniorWizard juniorWizard){

        wizardScoreRegistry.increaseFailByOne();
        wizardScoreRegistry.decreaseSchoolScore(juniorWizard.getSchool(),100);
        System.out.println(juniorWizard.getName()+" failed the test");
    }

}
