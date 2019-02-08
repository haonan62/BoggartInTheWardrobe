import java.util.*;


public class JuniorWizard {
    private String name;
    private ArrayList<String> worstFears;
    private boolean isScared;
    private String school;

    public JuniorWizard(String name,ArrayList<String> worstFears, String school) {
        this.name = name;

        this.isScared = false;
        //randomly creates 9 most feared objects of a Junior Wizard
        this.worstFears = worstFears;
        this.school=school;

    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWorstFears() {
        return worstFears;
    }

    public void setWorstFears(ArrayList<String> worstFears) {
        this.worstFears = worstFears;
    }

    public boolean isScared() {
        return isScared;
    }

    public void setScared(boolean scared) {
        isScared = scared;
    }




    //everytime the uer sees the transformed boggart, he/she has a 1/100 chance of feeling scared
    //when a user is scared, he/she cannot cast spells and fails the exam
    public void determineFear(String boggartCurrentForm) {


        Random r = new Random();
        if (r.nextInt(100) == 1) {

            setScared(true);
        }

    }

    //cast a spell on the boggart and remove fear from list
    public void castSpell(Boggart target) {
        String boggartCurrentForm = target.getCurrentForm();
        //System.out.println("Redicule!");

        target.setCurrentForm("OriginalForm");
        //System.out.println("Boggart "+target.getName()+" was back to original form");

        for (Iterator<String> iter = worstFears.listIterator(); iter.hasNext(); ) {
            String a = iter.next();
            if (a.equals(boggartCurrentForm)) {
                iter.remove();
            }
        }


    }
}
