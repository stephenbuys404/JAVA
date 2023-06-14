package soccerleague;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SoccerLeague {

    public static void main(String[] args) {
        BufferedReader in = getReader("soccer.txt");

        Soccer soccer = readSoccer(in);
        if (soccer.player1score > soccer.player2score) {
            soccer.score1 = 3;
            soccer.score2 = 0;
        } else if (soccer.player1score < soccer.player2score) {
            soccer.score1 = 0;
            soccer.score2 = 3;
        } else {
            soccer.score1 = 1;
            soccer.score2 = 1;
        }
        Soccer[] all = {soccer};

        while (!"".equals(soccer.player1name)) {
            int max = all.length + 1;
            Soccer[] newall = new Soccer[max];

            for (int i = 0; i < max - 1; i++) {
                newall[i] = all[i];
            }
            soccer = readSoccer(in);
            if (soccer.player1score > soccer.player2score) {
                soccer.score1 = 3;
                soccer.score2 = 0;
            } else if (soccer.player1score < soccer.player2score) {
                soccer.score1 = 0;
                soccer.score2 = 3;
            } else {
                soccer.score1 = 1;
                soccer.score2 = 1;
            }
            newall[all.length] = soccer;

            all = new Soccer[max];
            for (int j = 0; j < max; j++) {
                all[j] = newall[j];
            }
        }

        int v = 0;               
        List[] sort = new List[all.length];

        for (int i = 0; i < all.length; i++) {
            String name = all[i].player1name;
            
            if (!Contains(name, sort)) {
                if (!"".equals(name)) {                    
                    sort[v] = new List(name, FindTotal(name, all));
                    v++;
                }
            }

            name = all[i].player2name;
            if (!Contains(name, sort)) {
                if (!"".equals(name)) {
                    sort[v] = new List(name, FindTotal(name, all));
                    v++;
                }
            }
        }

        int k = 0;
        List[] sorted = Sort(sort);

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != null) {
                k++;
                System.out.println(k + "." + sorted[i].name + " " + sorted[i].total);
            }
        }
    }

    private static List[] Sort(List[] a) {
        HashMap<String,Integer> mymap = new HashMap<String,Integer>();
        LinkedHashMap<String,Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            mymap.put(a[i].name,a[i].total);
        }
        for (Map.Entry<String, Integer> entry : mymap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list); 
        for (int num : list) {
            for (Entry<String, Integer> entry : mymap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        int pos=0;
        List[] b= new List[a.length];
        for (Map.Entry<String, Integer> e : sortedMap.entrySet()) {
            b[pos].total=e.getValue();
            b[pos].name=e.getKey();
        }        
        return b;
    }

    private static boolean Contains(String name, List[] all) {
        for (var l : all) {
            if (l != null && l.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static int FindTotal(String name, Soccer[] all) {
        int total = 0;
        for (Soccer all1 : all) {
            if (all1.player1name == null ? name == null : all1.player1name.equals(name)) {
                total += all1.score1;
            } else if (all1.player2name == null ? name == null : all1.player2name.equals(name)) {
                total += all1.score2;
            }
        }
        return total;
    }

    private static BufferedReader getReader(String name) {
        BufferedReader in = null;
        try {
            File file = new File(name);
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return in;
    }

    private static Soccer readSoccer(BufferedReader in) {
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        if (line == null) {
            return new Soccer("", 0, "", 0);
        } else {
            String[] data = line.split(", ");

            String player1 = data[0].substring(0, data[0].lastIndexOf(" "));
            int score1 = Integer.parseInt(data[0].substring(data[0].length() - 1));

            String player2 = data[1].substring(0, data[1].lastIndexOf(" "));
            int score2 = Integer.parseInt(data[1].substring(data[1].length() - 1));

            return new Soccer(player1, score1, player2, score2);
        }
    }

    private static class List {

        public String name;
        public int total;

        public List(String n, int t) {
            this.name = n;
            this.total = t;
        }
    }

    private static class Soccer {

        public String player1name;
        public int player1score;
        public String player2name;
        public int player2score;

        public int score1 = 0;
        public int score2 = 0;

        public Soccer(String p1, int s1, String p2, int s2) {
            this.player1name = p1;
            this.player1score = s1;
            this.player2name = p2;
            this.player2score = s2;
        }
    }
}