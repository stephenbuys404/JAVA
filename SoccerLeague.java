import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//soccer.txt---------------------
//Liverpool 3, ManchesterUnited 3
//Tarantulas2 1, FCAwesome 0
//Lions 1, FCAwesome 1
//Tarantulas2 3, ManchesterUnited 1
//Lions 4, Grouches 0

class SoccerLeagueManager {
    private List<String> matches;
    private Map<String, Integer> teamPoints;

    public SoccerLeagueManager() {
        matches = new ArrayList<>();
        teamPoints = new TreeMap<>(); // Changed the HashMap to TreeMap
    }

    public void readMatchesFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                matches.add(line);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void calculatePoints() {
        for (String match : matches) {
            String[] parts = match.split(",");
            System.out.println('a');
            String team1 = parts[0].trim().split(" ")[0];
            System.out.println('b');
            String team2 = parts[1].trim().split(" ")[0];
            System.out.println('c');
            int score1 = Integer.parseInt(parts[0].trim().split(" ")[1]);
            System.out.println('d');
            int score2 = Integer.parseInt(parts[1].trim().split(" ")[1]);
            System.out.println('e');
            teamInit(team1);
            System.out.println('f');
            teamInit(team2);
            System.out.println('g');
            if (score1 > score2) {
                teamPoints.put(team1, teamPoints.get(team1) + 3);
            } else if (score1 < score2) {
                teamPoints.put(team2, teamPoints.get(team2) + 3);
            } else {
                teamPoints.put(team1, teamPoints.get(team1) + 1);
                teamPoints.put(team2, teamPoints.get(team2) + 1);
            }
            System.out.println('h');
        }
    }

    private void teamInit(String team) {
        teamPoints.putIfAbsent(team, 0);
    }

    public List<Map.Entry<String, Integer>> getSortedRanking() {
        List<Map.Entry<String, Integer>> sortedRanking = new ArrayList<>(teamPoints.entrySet());
        Collections.sort(sortedRanking, (o1, o2) -> {
            int pointsComparison = Integer.compare(o2.getValue(), o1.getValue());
            if (pointsComparison != 0) {
                return pointsComparison;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return sortedRanking;
    }
}

public class SoccerLeague{
    public static void main(String[] args) {
        SoccerLeagueManager leagueManager = new SoccerLeagueManager();
        System.out.println(1);
        leagueManager.readMatchesFromFile("soccer.txt");
        System.out.println(2);
        leagueManager.calculatePoints();
        System.out.println(3);
        List<Map.Entry<String, Integer>> sortedRanking = leagueManager.getSortedRanking();
        System.out.println(4);
        System.out.println("Soccer League Ranking:");
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedRanking) {
            System.out.println(rank + ". " + entry.getKey() + " " + entry.getValue());
            rank++;
        }
        System.out.println(5);
    }
}