package nj;

import java.util.*;

public class Cricket {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Input a string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> balls = new Stack<>();
        Integer totalRuns = 0;
        Integer extraRuns = 0;

        char[] ch = new char[str.length()];

        // Players
        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new Player(1, 0);
        Player player2 = new Player(2, 0);

        Boolean first = true;

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }

        for (int i = 0; i < ch.length; i++) {

            if (Character.isDigit(ch[i])) {
                balls.push(1);
                totalRuns += Character.getNumericValue(ch[i]);

                if (balls.size() > 6) {
                    first = !first;
                    System.out.println("In more than");
                }

                if (first) {
                    player1.setRuns(Character.getNumericValue(ch[i]));
                } else if (!first) {
                    player2.setRuns(Character.getNumericValue(ch[i]));
                }

                if (Character.getNumericValue(ch[i]) % 2 != 0) {
                    first = false;
                }
            }

            if (ch[i] == 'W') {
                balls.push(1);
                // System.out.println(ch[i] + "Wicket");
            }

            if (ch[i] == '.') {
                balls.push(1);
                // System.out.println(ch[i] + "Dot Ball");
            }

            if (ch[i] == 'b') {
                balls.push(1);
                totalRuns += 1;
                extraRuns += 1;
                // System.out.println(ch[i] + "Byes");
            }

            if (ch[i] == 'w') {
                totalRuns += 1;
                extraRuns += 1;
                // System.out.println(ch[i] + "Wide");
            }

            if (ch[i] == 'n') {
                totalRuns += 1;
                extraRuns += 1;
                // System.out.println(ch[i] + "No Ball");
            }
        }
        System.out.println("Last Score");
        System.out.println("Total Runs: " + totalRuns);
        System.out.println("Extra Runs: " + extraRuns);
        System.out.println("Total Balls: " + balls.size());
        System.out.println("Player 1 Runs: " + player1.getRuns());
        System.out.println("Player 2 Runs: " + player2.getRuns());
    }

}

class Player {
    public Integer pid;
    public Integer runs;

    Player(Integer id, Integer run) {
        this.pid = id;
        this.runs = run;
    }

    public void setRuns(Integer run) {
        this.runs += run;
    }

    public Integer getRuns() {
        return this.runs;
    }
}
