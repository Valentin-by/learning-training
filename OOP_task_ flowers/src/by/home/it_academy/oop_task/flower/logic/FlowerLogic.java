package by.home.it_academy.oop_task.flower.logic;

import by.home.it_academy.oop_task.flower.*;
import by.home.it_academy.oop_task.flower_on_console.FlowerViewing;

import java.util.*;

public class FlowerLogic {
    private static final FlowerLogic FLOW_LOGIC = new FlowerLogic();
    private static final FlowerViewing FLOWER_VIEW = FlowerViewing.getFlowerViewing();

    private FlowerLogic(){
    }
    public static FlowerLogic getFlowerLogic(){
        return FLOW_LOGIC;
    }

//    returns a two-dimensional array with two columns: in the first
//    values from received array, and second column contains
//    the ordinal number of this element in the array
    public String[][] correspondEnumByNum(String[] fromEnum){
        String[][] corAr;
        if(fromEnum == null){
            corAr =  new String[0][0];
            return corAr;
        }
        corAr = new String [fromEnum.length][2];
        int i = 0;
            for(String frmEnm : fromEnum){
               corAr[i][0] = frmEnm;
               corAr[i][1] = String.valueOf(i);
               i++;
            }
        return corAr;
    }


//  check the correctness of the received integer (does it match to length of array)
    public boolean checkCorrectReceivedInteger(String[] arrFomEnum, int receivedInt){
        return (receivedInt >= 0 && arrFomEnum.length > receivedInt);
    }

//    rounds received double value to 2 decimal places
    public double roundTo2DecimalPlace(double dblForRound){
        Formatter fmt = new Formatter();
        String tempStr = fmt.format("%.2f", dblForRound).toString();
        return Double.parseDouble(tempStr);
    }

//    get current year with transformation in string
    public int currentYearInt(){
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }

//    return string pattern for receiving date in form "dd.mm.yyyy" from console for
//    current year or year before it
    public String getPatternForDate(){
        int year = FlowerLogic.getFlowerLogic().currentYearInt();
        int yearBefore = year - 1;
        StringBuilder sbForPat = new StringBuilder(String.valueOf(year));
        sbForPat.append("|").append(yearBefore);
        return "(0?[1-9]|1[0-9]|2[0-9]|3[0-1])\\.(0?[0-9]|1[0-1])\\.(" + sbForPat
                + ")";
    }

//    concatenate two strings and one double value into one string
    public String concat2StringDoubleDateIntoString(String strA, String strB, double dbl, GregorianCalendar calendar){
        StringBuilder sb = new StringBuilder(strA);
        if(calendar == null){
            calendar = new GregorianCalendar();
        }
        String dateString = concatDayMonthYearIntoString(calendar);
        sb.append("-").append(strB).append("-").append(dbl).append("-").append(dateString);
        return sb.toString();
    }



//    concatenates 3 string and double value into string
    public String concat3StringDoubleIntoString(String pref, String str1, String str2, double d){
        StringBuilder sb = new StringBuilder(pref);
        sb.append("-").append(str1).append("-").append(str2).append("-").append(d);
        return sb.toString();
    }

//    concatenates day, month and year from calendar into one string without spaces
    String concatDayMonthYearIntoString(GregorianCalendar calendar){
        Formatter fmt = new Formatter();
        if(calendar == null){
            calendar = new GregorianCalendar();
        }
        fmt.format("%1$td%1$tm%1$tY", calendar);
        return fmt.toString();
    }

//    converts date (day, month, years) in string
    public String convertDateToString(Calendar calendar) {
        if(calendar == null){
            calendar = new GregorianCalendar();
        }
        Formatter fmt = new Formatter();
        fmt.format("%1$td.%1$tm.%1$tY", calendar);
        return fmt.toString();
    }


//    removes the item from the store and returns true, otherwise - returns false
    public boolean delItemFromStore(Storage storage, StoreItem item){
        if(storage == null){
            FLOWER_VIEW.cannotDeleteSomethingFromNonExistentMessage();
            return false;
        }
        if(item == null){
            FLOWER_VIEW.nonExistFlowCannotDeletedMessage();
            return false;
        }
        if(storage.getStore().size() == 0){
            FLOWER_VIEW.nothingToDeleteMessage();
            return false;
        }
        if(storage.getStore().remove(item) != null){
            FLOWER_VIEW.flowerDeletedFromStoreMessage();
            return true;
        } else {
            FLOWER_VIEW.noSuchItemMessage(item);
            return false;
        }
    }

    //    trys to take the specified number of flowers from the store:
    //    if that number is less or equal to the number of flowers in the store -
    //    returns number of taken flowers (that number subtracts from store),
    //    otherwise - return 0
    public int takeNumItemsFromStore(Storage storage, StoreItem storeItem, int num){
        if(storage == null){
            FLOWER_VIEW.cannotDeleteSomethingFromNonExistentMessage();
            return 0;
        }
        if(storeItem == null){
            FLOWER_VIEW.nonExistFlowCannotDeletedMessage();
            return 0;
        }
        if(num <= 0){
            FLOWER_VIEW.nothingToDeleteMessage();
            return 0;
        }
        if(storage.getStore().containsKey(storeItem)){
            int tempInt = (int)storage.getStore().get(storeItem);
            if(tempInt == 0){
                FLOWER_VIEW.noSuchItemMessage(storeItem);
                return 0;
            }
            int flowResidue = tempInt - num;
            if(flowResidue >= 0){
                storage.getStore().put(storeItem, flowResidue);
                FLOWER_VIEW.numberTakenFromStoreMessage(storeItem, num);
                return num;
            } else {
                FLOWER_VIEW.noSuchNumberFlowersInStore(storeItem);
                return 0;
            }
        } else {
            FLOWER_VIEW.noSuchItemMessage(storeItem);
            return 0;
        }
    }

    //    removes from (hashMap) store (<T> keys) from the store if their value (Integer value) is 0
    //    return a number of removed items
    public <T> int  removeZeroAmountFromStore(Storage store){
        if(store == null){
            FLOWER_VIEW.noSuchStoreMessage();
            return 0;
        }
        int counter = 0;
        HashMap<StoreItem, Integer> storage = store.getStore();
        Set<Map.Entry<StoreItem, Integer>> tempSet = storage.entrySet();
        Iterator iterator = tempSet.iterator();
        while(iterator.hasNext()){
            Map.Entry<T, Integer> me = (Map.Entry<T, Integer>)iterator.next();
            if(me.getValue().equals(0)){
                iterator.remove();
                counter++;
                FLOWER_VIEW.zeroAmountItemRemoveMessage();
            }
        }
        return counter;
    }

    //  adding flower to the store
    public boolean addItemToStore(Storage storage, StoreItem item, int num) {
        if (item == null | storage == null | num <= 0) {
            return false;
        }
        HashMap<StoreItem, Integer> itemStore = storage.getStore();
        if (itemStore.size() == 0 | !itemStore.containsKey(item)) {
            itemStore.put(item, num);
            FLOWER_VIEW.itemAddToStoreMessage(item, num);
            return true;
        }
        Integer tempNum = itemStore.get(item);
        itemStore.put(item, tempNum + num);
        FLOWER_VIEW.itemAddToStoreMessage(item, tempNum + num);
        return true;
    }

//    search the flower with the length of the stem in the bouquet
//    according to the minimum and maximum parameters
//    if the length of the returned list = 0 - no match found, otherwise - it returns list of flower
    public ArrayList<Flower> searchCorrespondStemInBouquet(Bouquet bq, double min, double max){
        ArrayList<Flower> flowerList = new ArrayList();
        if(bq == null){
            return flowerList;
        }
        Map<Flower, Integer> flowerBq = bq.getDifFlower();
        int num = flowerBq.size();
        if(num == 0){
            return flowerList;
        } else {
            Set<Map.Entry<Flower, Integer>> set = flowerBq.entrySet();
            for(Map.Entry<Flower, Integer> me : set){
                Flower tempFlow = me.getKey();
                if(tempFlow.getLengthStemOfFlower() >= min && tempFlow.getLengthStemOfFlower() <= max){
                    flowerList.add(tempFlow);
                }
            }
        }
        return flowerList;
    }


//    sort flowers in the bouquet
public Flower[] sortedArrayFlowerInBouquet(Bouquet bq, FlowerComparator comparator){
    Flower[]  flowerArr;
        if(bq == null){
            flowerArr = new Flower[0];
            return flowerArr;
        }
    TreeMap<Flower, Integer> tempMap = new TreeMap<>(comparator);
    HashMap<Flower, Integer> bqMap= bq.getDifFlower();
    flowerArr = new Flower[bqMap.size()];
    tempMap.putAll(bqMap);
    flowerArr  = tempMap.keySet().toArray(flowerArr);
    return flowerArr;
    }
}

