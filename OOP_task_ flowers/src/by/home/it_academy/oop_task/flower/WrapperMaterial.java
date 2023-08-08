package by.home.it_academy.oop_task.flower;

public enum WrapperMaterial {
    PLASTIC("Plastic"),
    PAPER("Paper"),
    FOIL("Foil");

    private final String MATERIAL;
    private WrapperMaterial(String material){
        MATERIAL = material;
    }
    public String getWrapMaterial(){
        return MATERIAL;
    }
}

