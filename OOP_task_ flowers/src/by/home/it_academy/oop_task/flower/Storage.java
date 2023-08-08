package by.home.it_academy.oop_task.flower;

import java.util.HashMap;

public interface Storage {
    public <T> HashMap<StoreItem, Integer> getStore();
}
