package by.home.it_academy.oop_task.flower.logic;

import by.home.it_academy.oop_task.flower.Flower;
import java.util.Comparator;

public interface FlowerComparator extends Comparator<Flower>{
    public int compare(Flower fl1, Flower fl2);
}
