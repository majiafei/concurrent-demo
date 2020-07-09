package cn.e3mall.demo_1214.threadpool;

import java.util.*;

public class Main {
   /* public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        for (int i = 0; i < input.length - 1; i++) {
            int tem = input[0];
            if (input[i] > input[i +1]) {
                input[i] = input[i + 1];
                input[i + 1] = tem;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (set.size() == k) {
                break;
            }
            set.add(input[i]);
        }
        return new ArrayList<>(set);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            int k = Integer.parseInt(in.nextLine());
            int[] input = spliteLine(line);
            ArrayList<Integer> res = GetLeastNumbers_Solution(input, k);
            System.out.println(res);
        }

    }

    private static int[] spliteLine(String line) {
        String[] numStrArray = line.split(",");
        int[] numArray = new int[numStrArray.length];
        for (int i = 0; i < numStrArray.length; i++) {
            numArray[i] = Integer.valueOf(numStrArray[i]);
        }

        return numArray;
    }*/

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(sort(line));
        }


    }

    private static String sort(String line) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = line.toCharArray();
        Integer count = null;
        String key = null;
        for (int i = 0; i < chars.length;i++) {
            key = String.valueOf(chars[i]);
            count = map.get(key);
            if (count == null) {
                count = 0;
            }
            count = count + 1;
            map.put(key, count);
        }

        Map<Integer, List<String>> listMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() < o2.intValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            List<String> list = listMap.get(value);
            if (list == null) {
                list = new ArrayList<>();
                listMap.put(value, list);
            }
            list.add(entry.getKey());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry :listMap.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1) {
                for (int i = 0; i < entry.getKey(); i++) {
                    stringBuilder.append(value.get(0));
                }
            } else if (value.size() > 1) {
                Collections.sort(value);
                for (int i = 0; i < value.size(); i++) {
                    for (int j = 0; j < entry.getKey(); j++) {
                        stringBuilder.append(value.get(i));
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

}
