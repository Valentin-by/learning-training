package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;

import java.util.Objects;

public class Wrapper extends Accessory{

    private final String NAME = "Wrapper";
    private final double COST;
    private final String MATERIAL_WRAP;
    private final String COLOR;
    private final String WRAPPER_CODE;

    public Wrapper(ColorOfFlower color, WrapperMaterial wrapperMaterial, double cost){
        COST = FlowerLogic.getFlowerLogic().roundTo2DecimalPlace(Math.abs(cost));
        COLOR = color.getColor();
        MATERIAL_WRAP = wrapperMaterial.getWrapMaterial();
        WRAPPER_CODE = FlowerLogic.getFlowerLogic()
                .concat3StringDoubleIntoString(NAME, MATERIAL_WRAP, COLOR, COST);
    }

    public String getName(){
        return NAME;
    }
    public double getCost(){
        return COST;
    }
    public String getMaterialWrap(){
        return MATERIAL_WRAP;
    }

    public String getColor(){
        return COLOR;
    }

    public String getCode(){
        return WRAPPER_CODE;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Wrapper[")
                .append("COST = ").append(COST)
                .append(", MATERIAL_WRAP = ").append(MATERIAL_WRAP)
                .append(", COLOR = ").append(COLOR)
                .append(", WRAPPER_CODE = ").append(WRAPPER_CODE).append("];");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper wrapper = (Wrapper) o;
        return Double.compare(wrapper.COST, COST) == 0
                && Objects.equals(MATERIAL_WRAP, wrapper.MATERIAL_WRAP)
                && Objects.equals(COLOR, wrapper.COLOR)
                && Objects.equals(WRAPPER_CODE, wrapper.WRAPPER_CODE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(COST, MATERIAL_WRAP, COLOR, WRAPPER_CODE);
    }
}
