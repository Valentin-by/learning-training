import by.home.it_academy.oop_task.flower.*;
import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import by.home.it_academy.oop_task.flower_on_console.FlowerViewing;
import java.util.GregorianCalendar;

public class FlowerDemo {
    public static void main(String[] args) {
        FlowerViewing flow_view = FlowerViewing.getFlowerViewing();
        FlowerLogic flow_logic = FlowerLogic.getFlowerLogic();

        Wrapper wr10 = new Wrapper(ColorOfFlower.PURPLE, WrapperMaterial.FOIL, 3);

        GregorianCalendar date = new GregorianCalendar(2023, 3, 15);
        Flower fl1 = new Flower(NameOfFlower.ROSE, ColorOfFlower.PURPLE, 0.745, 2.456, date);
        Flower fl = new Flower();
        Flower fl2 = new Flower(NameOfFlower.CHAMOMILE, ColorOfFlower.PURPLE, 0.7,
                2,  new GregorianCalendar(2023, 5, 20));
        Flower fl3 = new Flower(NameOfFlower.PEONY, ColorOfFlower.PINK, 0.5,
                1.5,  new GregorianCalendar(2023, 6, 15));
        Flower fl4 = new Flower(NameOfFlower.TULIP, ColorOfFlower.YELLOW, 0.45,
                2.5,  new GregorianCalendar(2023, 7, 25));
        Wrapper wr = new Wrapper(ColorOfFlower.GREEN, WrapperMaterial.PAPER, 2.236);
        Wrapper wr1 = new Wrapper(ColorOfFlower.PURPLE, WrapperMaterial.FOIL, 3.5);

        FlowerStore flSt = new FlowerStore(fl, 2);
        flow_logic.addItemToStore(flSt, fl1, 5);
        flow_logic.addItemToStore(flSt, fl2, 5);
        flow_logic.addItemToStore(flSt, fl3, 8);
        flow_logic.addItemToStore(flSt, fl4, 10);

        Wrapper wr2 = new Wrapper(ColorOfFlower.ORANGE, WrapperMaterial.PAPER, 0.5);
        Ribbon rib1 = new Ribbon(ColorOfFlower.PURPLE, 1, 0.3);
        Ribbon rib2 = new Ribbon(ColorOfFlower.GREEN, 0.5, 0.2);
        Ribbon rib = new Ribbon(ColorOfFlower.WHITE, 1.5, 0.5);
        AccessoryStore acSt = new AccessoryStore(wr1, 3);
        flow_logic.addItemToStore(acSt, wr, 5);
        flow_logic.addItemToStore(acSt, wr2, 3);
        flow_logic.addItemToStore(acSt, rib1, 2);
        flow_logic.addItemToStore(acSt, rib, 4);
        flow_logic.addItemToStore(acSt, rib2, 5);
        System.out.println(flow_view.representItemStoreByVendorCode(flSt));
        System.out.println(flow_view.representItemStoreByVendorCode(acSt));
        Bouquet bq = new Bouquet();
        bq.addAccessoryToBouquet(wr10, acSt,1); //no such accessory in the store
        bq.addAccessoryToBouquet(wr1, acSt, 2);
        bq.addFlowerToBouquet(fl1, flSt, 3);
        bq.addFlowerToBouquet(fl1, flSt, 1);
        bq.addAccessoryToBouquet(rib1, acSt,2);
        bq.addFlowerToBouquet(fl, flSt, 1);
        bq.addFlowerToBouquet(fl2, flSt, 2);
        bq.addFlowerToBouquet(fl3, flSt, 1);

        flow_view.displayBouquet(bq);
        flow_view.displayFlowerInBouquetCorrespondLengthStem(bq, 0.6, 1.1);
        flow_view.displayFlowerBouquetSortByFresh(bq);
        flow_view.displayBouquet(bq);
        System.out.println(flow_view.representItemStoreByVendorCode(flSt));
        System.out.println(flow_view.representItemStoreByVendorCode(acSt));

    }
}