package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DancingLinks {
    private static String sudo[][];
    private static int squareBoxes[][];
    private static List<HashSet<Integer>> unitList = new ArrayList<>();
    private static HashMap<Integer, List<Integer>> hs= new HashMap<>();
    private static void initialiseSudoku() {
        int num=0;
        for(int i=0; i<9 ; i++) {
            for(int j=0; j<9; j++) {
                squareBoxes[i][j] = num++;
            }
        }
    }
    private static void  showSudoku() {
        System.out.println("Show Sudoku");
        for(Map.Entry<Integer, List<Integer>> m : hs.entrySet()) {
            System.out.println(m.getKey() + ": " + m.getValue());
        }
    }

    private static HashSet<Integer> getAllPeers(int key) {
        HashSet<Integer> units = new HashSet<>();
        for(HashSet<Integer> hash : unitList) {
            if(hash.contains(key)) {
                units.addAll(hash);
            }
        }
        units.remove(key);
        return units;
    }

    private static void nakedTriplets() {
        for(HashSet<Integer> ll : unitList) {
            HashSet<List<Integer>> list = new HashSet<>();
            int count=0;
            for(Integer i : ll) {
                boolean yes= list.add(hs.get(i));
                if(!yes) {
                    count++;
                    System.out.println(yes+"   m, "+hs.get(i) + " : " + count);
                }
            }
        }
    }

    private static void createUnitList() {
        for(int i =0; i <9; i++) {
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            for(int j =0; j<9; j++) {
                rows.add(i*9+j);
                cols.add(j*9+i);
            }
            unitList.add(rows);
            unitList.add(cols);
        }

        for(int k = 0; k < 9; k++) {
            HashSet<Integer> boxes = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int t = k-k%3;
                    boxes.add(squareBoxes[i+3*t/3][j+k%3*3]);
                }
            }
            unitList.add(boxes);
           // System.out.println(boxes);

        }
       // System.out.println(unitList);
    }

    public static void main(String args[]) {
        sudo = new String[9][9];

        squareBoxes = new int[9][9];

        initialiseSudoku();
        createUnitList();

        Integer numbers[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        String sud = "4.....8.5.3..........7......2.....6.....8.4......1.......6.3.7.5..2.....1.4......";
        int count = 0;
        for(int i = 0; i<9; i++) {
            for(int j=0; j < 9; j++) {

                if(sud.charAt(count) == '.') {
                    hs.put(count, l);
                } else {
                    int num = Integer.parseInt(String.valueOf(sud.charAt(count)));
                    hs.put(count, Arrays.asList(num));
                }
                count++;
            }
        }
       // showSudoku();

        for(Map.Entry<Integer, List<Integer>> m : hs.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
            int key = m.getKey();
            List<Integer> value = m.getValue();
            if(value.size()==1) {
               HashSet<Integer> hashSet = getAllPeers(key);
                for(Integer i : hashSet) {
                    List<Integer> list = new ArrayList<>(hs.get(i));
                    list.remove(value.get(0));
                    hs.put(i, list);
                }
            }

        }

        showSudoku();
        nakedTriplets();


    }
}
