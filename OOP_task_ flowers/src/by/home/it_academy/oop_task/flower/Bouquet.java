package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import by.home.it_academy.oop_task.flower_on_console.FlowerViewing;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Bouquet {
    private static final FlowerLogic FLOW_LOGIC = FlowerLogic.getFlowerLogic();
    private static final FlowerViewing FLOW_VIEW = FlowerViewing.getFlowerViewing();
    private HashMap<Flower, Integer> difFlower;
    private HashMap<Accessory, Integer> difAccessory;
    private boolean presentFlower;
    private boolean presentAccessory;
    private double bouquetCost;

    public Bouquet(){
        difFlower = new HashMap<>();
        difAccessory = new HashMap<>();
        bouquetCost = 0.0;
        presentFlower = false;
        presentAccessory = false;
        }

    public boolean getPresentFlower(){
    return presentFlower;
    }

    public boolean getPresentAccessory(){
        return presentAccessory;
    }

    public double getBouquetCost(){
        return bouquetCost;
    }

    public HashMap<Flower, Integer> getDifFlower(){
        return difFlower;
    }

    public HashMap<Accessory, Integer> getDifAccessory(){
        return difAccessory;
    }

    //    adds an accessory to bouquet and deletes this amount from accessory store
    //    if accessories added - returns true, otherwise false
    public boolean addAccessoryToBouquet(Accessory accessory, AccessoryStore storage, int num) {
        if(accessory == null | storage == null | num == 0){
            FLOW_VIEW.nothingNowhereToAddMessage();
            return false;
        }
        if(!presentAccessory){
            int tempNumAccessory = FLOW_LOGIC.takeNumItemsFromStore(storage, accessory, num);
            if(tempNumAccessory != 0){
                difAccessory.put(accessory, tempNumAccessory);
                bouquetCost = FLOW_LOGIC
                        .roundTo2DecimalPlace(bouquetCost + accessory.getCost() * tempNumAccessory);
                presentAccessory = true;
                FLOW_LOGIC.removeZeroAmountFromStore(storage);
                return true;
            }
        } else if (storage.getStore().containsKey(accessory)) { // if accessory storage contain accessory
            int storageNum = FLOW_LOGIC.takeNumItemsFromStore(storage, accessory, num);
            FLOW_LOGIC.removeZeroAmountFromStore(storage);
            if(storageNum != 0){
                if(difAccessory.containsKey(accessory)){
                    int numBq = difAccessory.get(accessory);
                    difAccessory.put(accessory, numBq + num);
                    bouquetCost = FLOW_LOGIC.roundTo2DecimalPlace(bouquetCost + accessory.getCost() * num);
                    presentAccessory = true;
                    return true;
                }
                 else {
                    difAccessory.put(accessory, num);
                    bouquetCost = FLOW_LOGIC.roundTo2DecimalPlace(bouquetCost + accessory.getCost() * num);
                    presentAccessory = true;
                    return true;
                }
            } else {
                FLOW_VIEW.notSoManyItemMessage(accessory);
                return false;
            }
        } else {
            FLOW_VIEW.noSuchItemMessage(accessory);
            return false;
        }
        return false;
    }

    public boolean addFlowerToBouquet(Flower flower, FlowerStore storage, int num) {
        if(flower == null | storage == null | num ==0){
            FLOW_VIEW.nothingNowhereToAddMessage();
            return false;
        }
        if(!presentFlower){
            int tempNumFlower = FLOW_LOGIC.takeNumItemsFromStore(storage, flower, num);
            if(tempNumFlower != 0){
                difFlower.put(flower, tempNumFlower);
                bouquetCost = FLOW_LOGIC
                        .roundTo2DecimalPlace(bouquetCost + flower.getCostFlower() * tempNumFlower);
                presentFlower = true;
                FLOW_LOGIC.removeZeroAmountFromStore(storage);  // removes items from store with zero value
                return true;
            }
        } else if (storage.getStore().containsKey(flower)) {
            int storageNum = FLOW_LOGIC.takeNumItemsFromStore(storage, flower, num);
            FLOW_LOGIC.removeZeroAmountFromStore(storage);
            if(storageNum != 0){
                if(difFlower.containsKey(flower)){
                    int numBq = difFlower.get(flower);
                    difFlower.put(flower, numBq + num);
                    bouquetCost = FLOW_LOGIC
                            .roundTo2DecimalPlace(bouquetCost + flower.getCostFlower() * num);
                    presentAccessory = true;
                    return true;
                } else {
                    difFlower.put(flower, num);
                    bouquetCost = FLOW_LOGIC
                            .roundTo2DecimalPlace(bouquetCost + flower.getCostFlower() * num);
                    presentAccessory = true;
                    return true;
                }
            } else {
                FLOW_VIEW.notSoManyItemMessage(flower);
                return false;
            }
        } else {
            FLOW_VIEW.noSuchItemMessage(flower);
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bouquet [presentFlower = ");
                        sb.append(presentFlower).append(", presentAccessory = ")
                                .append(presentAccessory).append(", \ndifFlower {");
        Set<Map.Entry<Flower, Integer>> setFl = difFlower.entrySet();
        if (setFl.size() == 0) {
            sb.append("The set does not contains a flowers.};\n");
        } else {
            for (Map.Entry<Flower, Integer> me : setFl) {
                sb.append(me.getKey()).append(" - ").append(me.getValue()).append(",\n");
            }
            sb.replace(sb.length() - 2, sb.length(), "};\n");
        }
        sb.append("difAccessory{");
        Set<Map.Entry<Accessory, Integer>> setAc = difAccessory.entrySet();
        if(setAc.size() == 0){
            sb.append("The set does not contains an accessories.};]\n");
        } else {
            for (Map.Entry<Accessory, Integer> me : setAc) {
                sb.append(me.getKey()).append(" - ").append(me.getValue()).append(",\n");
            }
            sb.replace(sb.length() - 2, sb.length(), "};\n");
            sb.append("bouquetCost = ").append(bouquetCost).append("];\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bouquet bouquet = (Bouquet) o;
        return difFlower.equals(bouquet.difFlower)
                && difAccessory.equals(bouquet.difAccessory)
                && presentAccessory == presentAccessory
                && presentFlower == presentFlower
                && Double.doubleToLongBits(bouquetCost) == Double.doubleToLongBits(((Bouquet) o).bouquetCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(difFlower, difAccessory, presentAccessory, presentFlower, bouquetCost);
    }
}
