package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import java.util.Objects;

public class Ribbon extends Accessory{

    private final String NAME = "Ribbon";
    private final double RIBBON_COST;
    private final String RIBBON_COLOR;
    private final double RIBBON_LENGTH;
    private final String RIBBON_CODE;
    public Ribbon(ColorOfFlower color, double ribbonLength, double cost){
        RIBBON_COST = FlowerLogic.getFlowerLogic().roundTo2DecimalPlace(Math.abs(cost));
        RIBBON_COLOR = color.getColor();
        RIBBON_LENGTH = FlowerLogic.getFlowerLogic().roundTo2DecimalPlace(ribbonLength);
        RIBBON_CODE = FlowerLogic.getFlowerLogic()
                .concat3StringDoubleIntoString(NAME, RIBBON_COLOR, String.valueOf(RIBBON_LENGTH), RIBBON_COST);
    }

    public String getName(){
        return NAME;
    }
    public double getCost(){
        return RIBBON_COST;
    }
    public String getRibbonColor(){
        return RIBBON_COLOR;
    }

    public double getRibbonLength(){
        return RIBBON_LENGTH;
    }

    public String getCode(){
        return RIBBON_CODE;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Ribbon [");
        sb.append("RIBBON_COST = ").append(RIBBON_COST)
                .append(", RIBBON_COLOR = ").append(RIBBON_COLOR)
                .append(", RIBBON_LENGTH = ").append(RIBBON_LENGTH)
                .append(", RIBBON_CODE = ").append(RIBBON_CODE).append("];");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ribbon ribbon = (Ribbon) o;
        return Double.compare(ribbon.RIBBON_LENGTH, RIBBON_LENGTH) == 0
                && RIBBON_COLOR.equals(ribbon.RIBBON_COLOR) && RIBBON_CODE.equals(ribbon.RIBBON_CODE)
                && Double.compare(ribbon.RIBBON_COST, RIBBON_COST) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RIBBON_COST, RIBBON_COLOR, RIBBON_LENGTH, RIBBON_CODE);
    }
}
