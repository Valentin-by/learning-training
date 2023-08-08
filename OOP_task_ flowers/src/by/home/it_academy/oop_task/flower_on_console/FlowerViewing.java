package by.home.it_academy.oop_task.flower_on_console;

import by.home.it_academy.oop_task.flower.*;
import by.home.it_academy.oop_task.flower.logic.FlowerFreshComparator;
import by.home.it_academy.oop_task.flower.logic.FlowerLogic;
import java.io.PrintWriter;
import java.util.*;

public class FlowerViewing {

        private static final FlowerViewing FLOWER_VIEW = new FlowerViewing();
        private static final FlowerLogic FLOW_LOGIC = FlowerLogic.getFlowerLogic();
        private FlowerViewing(){
        }
        public static FlowerViewing getFlowerViewing(){
            return FLOWER_VIEW;
        }

        PrintWriter pw = new PrintWriter(System.out, true);

//        displays a message to select the name of the flower
        public void chooseNeededParameterMessage(){
            pw.println("Enter an integer corresponding with parameter you want to choose:");
        }

//        displays the message to indicate the length of the stem flower
    public void enterStemLengthFlowerMessage(){
            pw.println("Enter the length of the stem flower: ");
    }

//      it displays a two-dimensional array, in the first column the value from enumeration,
//      in the second column an integer indicates the index of this element in the array
        public void displayTwoDimensionArray(String[][] arr){
            for(String[] ar : arr){
                for(int j = 0; j < ar.length; j++){
                    pw.print(ar[j]);
                    if(j == 0){
                        pw.print(" - ");
                    }
                }
                pw.println();
            }
            pw.println();
        }

//      displays an array of string with numbers corresponding each string of it array;
//      prompts to select the number corresponding to the desire string and enter it through console;
//      returns a positive integer received from console, otherwise returns -1
        public int choiceFromArrayIntByConsole(String[] arrFromEnum){
            Scanner sc = new Scanner(System.in);
            int tempInt = -1;
            boolean prov = false;
            try {
                do {
                    chooseNeededParameterMessage();
                    if (sc.hasNextInt()) {
                        tempInt = sc.nextInt();
                        if (tempInt < 0) {
                            negativeIntReceivedMessage();
                            prov = true;
                        } else {
                            if (!FlowerLogic.getFlowerLogic().checkCorrectReceivedInteger(
                                    arrFromEnum, tempInt)) {
                                receivedIntGreaterAmountEnumMessage();
                                prov = true;
                            } else {
                                prov = false;
                            }
                        }
                    } else {
                        sc.next();
                        prov = true;
                    }
                } while (prov);
            } catch (IllegalStateException ise){
                likelyScannerWasClosedMessage();
                Integer def = -1;
                assignedDefaultValueMessage(def);
                return -1;
            }
            return tempInt;
        }

//        displays a message: most likely scanner was closed
    public void likelyScannerWasClosedMessage(){
            pw.println("Something happened to the scanner, most likely it was closed.");
    }

//        get a String representation a date with console
    public String getStringDateWithConsole(){
        String stringDatePat = FLOW_LOGIC.getPatternForDate();
        String tempStr = "";
        boolean prov = false;
        try {
            Scanner sc = new Scanner(System.in);
            do {
                enterDateMessage();
                if (sc.hasNext(stringDatePat)) {
                    tempStr = sc.next(stringDatePat);
                    prov = false;
                } else {
                    sc.next();
                    prov = true;
                }
            } while(prov);
        } catch (IllegalStateException ise){
            likelyScannerWasClosedMessage();
            String def = FLOW_LOGIC.convertDateToString(new GregorianCalendar());
            assignedDefaultValueMessage(def);
            return def;
        }
        return tempStr;
    }

//    displays a message: it has been assigned a default value
    public <T> void assignedDefaultValueMessage(T val){
            pw.println("It has been assigned a default value: " + val + ".");
    }


//        displays message about receiving a negative integer
        void negativeIntReceivedMessage(){
            pw.println("A negative integer was received.");
        }

//        displays the message if the received integer exceeds the number of enums
        void receivedIntGreaterAmountEnumMessage(){
            pw.println("Received integer exceeds the amount of enumerations.");
        }

//        displays a message: enter the cost of the flower
    public void enterCostFlowerMessage(){
            pw.println("Enter a cost of the flower:");
    }

//        receive double value from console
    public double receiveDoubleFromConsole(double minValue){
            boolean prov = false;
            double tempDbl = 0;
            try {
                Scanner sc = new Scanner(System.in);
                do {
                    pw.println("Enter the number with absolute value greater or equal to " + minValue + ":");
                    if (sc.hasNextDouble()) {
                        tempDbl = Math.abs(sc.nextDouble());
                        if (tempDbl < minValue) {
                            pw.println("Entered number less " + minValue + ".");
                            prov = true;
                        } else {
                            prov = false;
                        }
                    } else {
                        sc.next();
                        prov = true;
                    }
                } while (prov);
            } catch (IllegalStateException ise){
                likelyScannerWasClosedMessage();
                assignedDefaultValueMessage(minValue);
                return minValue;
            }
            return tempDbl;
    }

//    displays the message: a non-existent flower cannot be added to the store
    public void nonExistFlowCannotBeAddedMessage(){
            pw.println("Non-exist flower cannot be added to the store.");
    }

//    displays a message: a non-existent flower cannot be deleted from store
    public void nonExistFlowCannotDeletedMessage(){
            pw.println("Non-existent flower cannot be deleted from store.");
    }

//    displays a message: there is no such flower in this store
    public void noSuchFlowerMessage(){
            pw.println("There is no such flower in this store.");
    }

//    displays the message: no such store
    public void noSuchStoreMessage(){
            pw.println("No such store.");
    }

//    displays a message: there are no such number of flowers in the store
    public void noSuchNumberFlowersInStore(StoreItem storeItem){
            pw.println("There are no so many of flowers " + storeItem.getCode()
                        + " in the store.");
    }

//    displays a message: enter a date of receiving a flore
    public void enterDateMessage(){
            pw.println("Enter the date (with this year or previous) of receiving a " +
                    "flower by format \"d(d).m(m).yyyy\" " +
                    "(month must be 1 less than necessary):");
    }

//    displays a message: flower was deleted from store
    public void flowerDeletedFromStoreMessage(){
            pw.println("Flower was deleted from the store.");
    }

//    displays the message: items with a zero amount removed from the store
    public void zeroAmountItemRemoveMessage(){
            pw.println("Items with zero quantity have removed from the store.");
        }

//    displays the message: cannot delete anything from a non-existent store
    public void cannotDeleteSomethingFromNonExistentMessage(){
            pw.println("Cannot delete anything from non-existent store.");
    }

//    displays a message: the store is empty, there is nothing to delete
    public void nothingToDeleteMessage(){
            pw.println("The store is empty, there is nothing to delete.");
    }

//    displays a message: flowers were not taken from the store
    public void flowerNotTakenFromStoreMessage(){
            pw.println("Flowers were not taken from the store.");
    }

//    displays a message: Flower was added to the store
    public void itemAddToStoreMessage(StoreItem stItem, int num){
            pw.println(num + " item(s) of " + stItem.getCode() + " was(were) added to the store.\n");
    }

//    displays the message: the flower store is empty
    public void emptyFlowerStoreMessage(){
            pw.println("The flower store is empty.");
    }

//    displays the message:'number' pieces of something were taken from the store
    public void numberTakenFromStoreMessage(StoreItem item, int num){
            pw.println(num + " piece(s) of " + item.getName()
                        + " were taken from the store.");
    }

//    displays the message: nothing or nowhere to add
    public void nothingNowhereToAddMessage(){
            pw.println("Nothing or nowhere to add.");
    }

//    displays the store of the items
    public String representItemStoreByVendorCode(Storage storage){
            if(storage == null){
                return "This storage does not exist (null).";
            }
        Set<Map.Entry<StoreItem, Integer>> set = storage.getStore().entrySet();
        StringBuilder sb = new StringBuilder("Storage:\n");
            if(set.size() == 0){
                sb.append("The storage is empty.\n");
            } else {
                for (Map.Entry<StoreItem, Integer> me : set) {
                    sb.append(me.getKey().getCode()).append(" - ")
                            .append(me.getValue()).append(" pcs\n");
                }
            }
            return sb.toString();
    }

//    displays a flowers from bouquet sorting by freshness
    public void displayFlowerBouquetSortByFresh(Bouquet bq){
            if(bq == null){
                pw.println("This bouquet does not exist (null).");
                return;
            }
            Flower[] flowArr = FLOW_LOGIC.sortedArrayFlowerInBouquet(bq, new FlowerFreshComparator());
            StringBuilder sb = new StringBuilder("Flowers from bouquet that sorted by freshness:\n");
            for(Flower fl : flowArr){
                sb.append(flowerByString(fl)).append("\n");
            }
            pw.println(sb);
    }

//    displays a bouquet
    public void displayBouquet(Bouquet bq){
           StringBuilder sb = new StringBuilder("Bouquet:\n");
           if(bq == null){
               sb.replace(sb.length() - 2, sb.length(), " does not exist (null).");
           } else {
               if (!bq.getPresentFlower()) {
                   sb.append("Bouquet does not contain a flowers.\n");
               } else {
                   sb.append("  Flower(s):\n");
                   Set<Map.Entry<Flower, Integer>> set = bq.getDifFlower().entrySet();
                   for (Map.Entry<Flower, Integer> me : set) {
                       sb.append("      ")
                               .append(me.getKey().getCode()).append(" - ")
                               .append(me.getValue()).append(" pcs\n");
                   }
               }
               if (!bq.getPresentAccessory()) {
                   sb.append("  Bouquet does not contain an accessories.");
               } else {
                   sb.append("  Accessory(s):\n");
                   Set<Map.Entry<Accessory, Integer>> set = bq.getDifAccessory().entrySet();
                   for (Map.Entry<Accessory, Integer> me : set) {
                       sb.append("      ")
                               .append(me.getKey().getCode()).append(" - ")
                               .append(me.getValue()).append(" pcs\n");
                   }
               }
               sb.append("bouquet cost - ").append(bq.getBouquetCost()).append("\n");
           }
           pw.println(sb.toString());
    }

//    displays a list of flowers from a bouquet with a stem length
//    corresponding to the min and max parameters
    public void displayFlowerInBouquetCorrespondLengthStem(Bouquet bq, double min, double max){
            if(bq == null){
                pw.println("Bouquet for sorting the flowers by the stem length does not exist (null)");
                return;
            }
           StringBuilder sb = new StringBuilder();
           sb.append("Flower(s) in bouquet with stem length greater  or equal ")
                .append(min).append(" and less or equal ").append(max).append(":");
           ArrayList<Flower> flowerList = FLOW_LOGIC.searchCorrespondStemInBouquet(bq, min, max);
           if(flowerList.size() == 0){
               sb.append(" not found.");
           } else {
               for(Flower fl : flowerList){
                   sb.append("\n").append(flowerByString(fl));
               }
           }
           sb.append("\n");
           pw.println(sb);
    }


//    displays the message: no such accessory in the store
    public void noSuchItemMessage(StoreItem item) {
            if(item == null){
                pw.println("Not such item in the store.");
                return;
            }
            StringBuilder sb = new StringBuilder("Not such item in the store: ");
            sb.append(item.getCode()).append("\n");
            pw.println(sb);
    }

//    displays the message: there are not so many accessories
    public void notSoManyItemMessage(StoreItem item) {
            if(item == null){
                pw.println("There is no such item: " + item.getClass().getSimpleName());
            }
            pw.println("There are not so many accessories " + item.getCode());
    }

//    represent a flower by string
    public String flowerByString(Flower flower){
            StringBuilder sb = new StringBuilder("Flower: ");
            sb.append(flower.getName()).append(", color - ").append(flower.getColorFlower())
                    .append(", length of stem - ").append(flower.getLengthStemOfFlower())
                    .append(", cost - ").append(flower.getCostFlower())
                    .append(", date - ").append(FLOW_LOGIC.convertDateToString(flower.getDateFlower()))
                    .append(", vendor code - ").append(flower.getCode()).append(";");
            return sb.toString();
    }
}
