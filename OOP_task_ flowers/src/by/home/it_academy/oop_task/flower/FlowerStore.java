package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import by.home.it_academy.oop_task.flower_on_console.FlowerViewing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FlowerStore implements Storage{
    private final FlowerViewing FLOWER_VIEW = FlowerViewing.getFlowerViewing();
    private final FlowerLogic FLOWER_LOGIC = FlowerLogic.getFlowerLogic();
    private HashMap<Flower, Integer> flowerStore;   // key - flower,
                                                    // value - amount of flowers

//    Parameterless constructor
    public FlowerStore(){
        flowerStore = new HashMap<>();
    }

    public FlowerStore(Flower flower, int val){
        flowerStore = new HashMap<>();
        if(flower != null && val > 0){
            if(FLOWER_LOGIC.addItemToStore(this, flower, val)){
            }
        } else {
            FLOWER_VIEW.nonExistFlowCannotBeAddedMessage();
        }
    }

    public HashMap<Flower, Integer> getStore(){
        return flowerStore;
    }

    @Override
    public String toString(){
        Set<Map.Entry<Flower, Integer>> tempSet = flowerStore.entrySet();
        StringBuffer sb = new StringBuffer("flowerStore[");
        for(Map.Entry<Flower, Integer> me : tempSet){
            sb.append(me.getKey()).append(" - ").append(me.getValue()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("];");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerStore that = (FlowerStore) o;
        return Objects.equals(flowerStore, that.flowerStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerStore);
    }
}
