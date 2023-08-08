package by.home.it_academy.oop_task.flower.logic;

import by.home.it_academy.oop_task.flower.Flower;

public class FlowerFreshComparator implements FlowerComparator{
    public int compare(Flower fl1, Flower fl2){
        return fl2.getDateFlower().compareTo(fl1.getDateFlower());
    }
}
