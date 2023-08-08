package by.home.it_academy.oop_task.flower;

public enum NameOfFlower {
    ROSE,
    TULIP,
    LILY,
    NARCISSUS,
    CHAMOMILE,
    PEONY;

    public static String[] nameToArrayString(){
        String[] arrStr = new String[values().length];
        int i = 0;
        for(NameOfFlower nof : values()){
            arrStr[i++] = nof.toString();
        }
        return arrStr;
    }
}
