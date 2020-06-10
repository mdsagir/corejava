package collection;
import java.util.*;

public class Test {
    public static void main(String[] args) {

    LineChartCache lineChartCache = new LineChartCache("5D", "S00001");
    LineChartCache lineChartCache1 = new LineChartCache("5D", "S00001");

        String cache = cache(lineChartCache);
        System.out.println();

    }

    public static String cache(LineChartCache lineChartCache) {
        Map<LineChartCache,String> map=new HashMap<>();
        if (map.get(lineChartCache)==null) {
            System.out.println("RECEIVING");
            map.put(lineChartCache,"5D,DATA");
        }
        return map.get(lineChartCache);
    }


    private static Map<String, Double> getPeerCompanyList(Map<String, Double> doubleMap, String input) {

        if (doubleMap.size() <= 5) {
           // doubleMap.remove(input);
            return doubleMap;
        }

        Map<String, Double> updatedMap = new LinkedHashMap<>();
        Set<String> strings = doubleMap.keySet();
        List<String> stringList = new ArrayList<>(strings);
        int size = stringList.size();
        int index = stringList.indexOf(input);

        if (doubleMap.size() >= 5) {

            if (index == 0) {
                for (int i = index; i <= 4; i++) {
                    updatedMap.put(stringList.get(i), doubleMap.get(stringList.get(i)));
                }
            }
            if (index == 1) {
                for (int i = 0; i <= 4; i++) {
                    updatedMap.put(stringList.get(i), doubleMap.get(stringList.get(i)));
                }
            }

            if (!(index == 0 || index == 1) && index <= (size - 3)) {
                for (int i = index - 2; i <= index + 2; i++) {
                    try {
                        updatedMap.put(stringList.get(i), doubleMap.get(stringList.get(i)));
                    } catch (Exception exception) {
                        System.out.println("data not foung for ric =" + input + " error = " + exception.getMessage());
                    }
                }
            }

            if (index == (size - 2)) {
                for (int i = index - 3; i <= index + 1; i++) {
                    updatedMap.put(stringList.get(i), doubleMap.get(stringList.get(i)));
                }
            }
            if (index == (size - 1)) {
                for (int i = index - 4; i <= index; i++) {
                    updatedMap.put(stringList.get(i), doubleMap.get(stringList.get(i)));
                }
            }
        }
       // updatedMap.remove(input);
        return updatedMap;
    }
}
