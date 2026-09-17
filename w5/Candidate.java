import java.util.Arrays;
import java.util.Scanner;

class Candidate {
    private int candidateId;
    private String name;
    private int aptitude;
    private int technical;
    private int communication;

    public Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class TopKCandidates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int apt = sc.nextInt();
            int tech = sc.nextInt();
            int comm = sc.nextInt();
            candidates[i] = new Candidate(id, name, apt, tech, comm);
        }

        // Sort: higher total score first; if tie, smaller candidate ID first
        Arrays.sort(candidates, (a, b) -> {
            int scoreA = a.getTotalScore();
            int scoreB = b.getTotalScore();
            if (scoreA != scoreB) {
                return scoreB - scoreA; // descending by score
            }
            return a.getCandidateId() - b.getCandidateId(); // ascending by ID
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(candidates[i].getCandidateId()).append(" ")
              .append(candidates[i].getName()).append(" ")
              .append(candidates[i].getTotalScore()).append("\n");
        }

        System.out.print(sb);
    }
}