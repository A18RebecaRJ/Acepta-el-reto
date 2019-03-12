import java.util.*;

public class p501 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String tropa;

        while (s.hasNext()) {

            ArrayList<Integer> tropasDef = new ArrayList<Integer>();
            ArrayList<Integer> tropasAtt = new ArrayList<Integer>();

            for (int i = 0; i < 5; i++) tropasDef.add(s.nextInt());

            tropa = s.nextLine();
            tropa = tropa.replaceAll(" ", "");

            for (int i = 0; i < tropa.length(); i++) tropasAtt.add(Integer.parseInt("" + tropa.charAt(i)));

            

        }

    }

}
