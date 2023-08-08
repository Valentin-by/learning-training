package by.home.it_academy.oop_task.flower;

public enum ColorOfFlower {
    GREEN("Green"),
    ORANGE("Orange"),
    PINK("Pink"),
    PINK_WHITE("Pink-white"),
    PURPLE("Purple"),
    RED("Red"),
    RED_YELLOW("Red-yellow"),
    WHITE("White"),
    YELLOW("Yellow");

    private final String COLOR;
    private ColorOfFlower(String color){
        this.COLOR = color;
    }
    public String getColor(){
        return COLOR;
    }

    public static String[] colorToArrayString(){
        String[] arrStr = new String[values().length];
        int i = 0;
        for(ColorOfFlower colorOfFlower : values()){
            arrStr[i++] = colorOfFlower.toString();
        }
        return arrStr;
    }


}
