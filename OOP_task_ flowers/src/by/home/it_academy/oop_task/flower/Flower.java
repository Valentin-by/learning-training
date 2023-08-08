package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import by.home.it_academy.oop_task.flower_on_console.*;
import java.util.GregorianCalendar;

public class Flower implements StoreItem{
    private static final FlowerViewing FLOWER_VIEWING = FlowerViewing.getFlowerViewing();;
    private static final FlowerLogic FLOWER_LOGIC = FlowerLogic.getFlowerLogic();

    private final String NAME;
    private String colorFlower;
    private double lengthStemOfFlower;
    private double costFlower;
    private String vendorCode;
    private GregorianCalendar dateFlower;

//    Parameterless constructor
    public Flower(){
        String [] tempStringArray;
        tempStringArray = NameOfFlower.nameToArrayString(); // array with name of flower from enum
        FLOWER_VIEWING.displayTwoDimensionArray(FLOWER_LOGIC.correspondEnumByNum(tempStringArray));
        int tempNum;
        tempNum = FLOWER_VIEWING.choiceFromArrayIntByConsole(tempStringArray);
//        if(tempNum >= 0){
            NAME = tempStringArray[tempNum];
//        } else {
//            NAME_FLOWER = "Some Flower";
//        }
        FLOWER_VIEWING.chooseNeededParameterMessage();
        tempStringArray = ColorOfFlower.colorToArrayString();   //array with colors of flower from enum
        FLOWER_VIEWING.displayTwoDimensionArray(FLOWER_LOGIC.correspondEnumByNum(tempStringArray));
        tempNum = FLOWER_VIEWING.choiceFromArrayIntByConsole(tempStringArray);
        if(tempNum >= 0){
            colorFlower = tempStringArray[tempNum];
        } else {
            colorFlower = ColorOfFlower.WHITE.getColor();
        }
        FLOWER_VIEWING.enterStemLengthFlowerMessage();
        double minLengthStem = 0.2; // indicate min length of the stem of the flower
        double tempDbl;
        tempDbl = FLOWER_VIEWING.receiveDoubleFromConsole(minLengthStem);
        lengthStemOfFlower = FLOWER_LOGIC.roundTo2DecimalPlace(tempDbl);
        FLOWER_VIEWING.enterCostFlowerMessage();
        double minCost = 0.01;
        tempDbl = FLOWER_VIEWING.receiveDoubleFromConsole(minCost);
        costFlower = FLOWER_LOGIC.roundTo2DecimalPlace(tempDbl);
        String dateString = FLOWER_VIEWING.getStringDateWithConsole();

        String[] strArrFromDate = dateString.split("\\.");

        dateFlower = new GregorianCalendar(Integer.valueOf(strArrFromDate[2]),
                Integer.valueOf(strArrFromDate[1]), Integer.valueOf(strArrFromDate[0]));
        vendorCode = FLOWER_LOGIC
                .concat2StringDoubleDateIntoString(NAME, colorFlower, lengthStemOfFlower, dateFlower);
    }

    public Flower(NameOfFlower name, ColorOfFlower color, double lengthStem, double costFl,
                  GregorianCalendar dateFlower){
        NAME = name.name();
        colorFlower = color.getColor();
        if(lengthStem <= 0){
            lengthStemOfFlower = 0.1;  // some value by default for set a length of stem (if received an incorrect)
        } else {
            lengthStemOfFlower = FLOWER_LOGIC.roundTo2DecimalPlace(Math.abs(lengthStem));
        }
        if(costFl <= 0){
            costFlower = 0.1;   // some value by default for set a cost of flower (if received an incorrect)
        } else {
            costFlower = FLOWER_LOGIC.roundTo2DecimalPlace(Math.abs(costFl));
        }

        this.dateFlower = dateFlower;

        vendorCode = FLOWER_LOGIC.concat2StringDoubleDateIntoString
                (NAME, colorFlower, lengthStemOfFlower, dateFlower);
    }


    public String getName(){
        return NAME;
    }

    public String getColorFlower(){
        return colorFlower;
    }

    public double getLengthStemOfFlower(){
        return lengthStemOfFlower;
    }

    public double getCostFlower(){
        return costFlower;
    }

    public GregorianCalendar getDateFlower(){
        return dateFlower;
    }

    public String getCode(){
        return vendorCode;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Flower [nameFlower = ");
        sb.append(NAME).append(", colorFlower = ").append(colorFlower)
                .append(", lengthStemOfFlower = ").append(lengthStemOfFlower)
                .append(", vendorCode = ").append(vendorCode).append(", date = ")
                .append(FLOWER_LOGIC.convertDateToString(dateFlower)).append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        Flower other = (Flower)o;
        if(!NAME.equals(((Flower) o).NAME))
            return false;
        if(!colorFlower.equals(((Flower) o).colorFlower))
            return false;
        if(Double.doubleToLongBits(lengthStemOfFlower) != Double.doubleToLongBits(((Flower) o).lengthStemOfFlower))
            return false;
        if(Double.doubleToLongBits(costFlower) != Double.doubleToLongBits(((Flower) o).costFlower))
            return false;
        if(!vendorCode.equals(((Flower) o).vendorCode))
            return false;
        if(!dateFlower.equals(((Flower) o).dateFlower))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (NAME == null ? 0 : NAME.hashCode());
        result = prime * result + (colorFlower == null ? 0 : colorFlower.hashCode());
        long temp;
        temp = Double.doubleToLongBits(lengthStemOfFlower);
        result = prime * result + (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costFlower);
        result = prime * result + (int)(temp ^ (temp >>> 32));
        result = prime * result + (vendorCode == null ? 0 : vendorCode.hashCode());
        result = prime * result + (dateFlower == null ? 0 : dateFlower.hashCode());
        return result;
    }
}
