package by.home.it_academy.oop_task.flower;

import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import by.home.it_academy.oop_task.flower_on_console.FlowerViewing;

import java.util.Objects;
import java.util.Set;

import java.util.HashMap;
import java.util.Map;

public class AccessoryStore implements Storage{
    private static final FlowerLogic FLOW_LOGIC = FlowerLogic.getFlowerLogic();
    private static final FlowerViewing FLOW_VIEW = FlowerViewing.getFlowerViewing();

    private HashMap<Accessory, Integer> accessoryStore;

//    parameterless constructor
    public AccessoryStore(){
        accessoryStore = new HashMap<>();
    }

    public AccessoryStore(Accessory accessory, int num){
        accessoryStore = new HashMap<>();
        if(accessory != null && num != 0){
            accessoryStore.put(accessory, num);
        }
    }

    public HashMap<Accessory, Integer> getStore(){
        return accessoryStore;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Accessory store[\n");
        Set<Map.Entry<Accessory, Integer>> set = accessoryStore.entrySet();
        for(Map.Entry<Accessory, Integer> me : set){
            sb.append(me.getKey()).append(" - ").append(me.getValue()).append(",\n");
        }
        sb.replace(sb.length() - 2, sb.length(), "];");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryStore that = (AccessoryStore) o;
        return accessoryStore.equals(that.accessoryStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessoryStore);
    }
}
