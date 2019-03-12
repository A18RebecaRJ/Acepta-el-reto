import java.util.*;

public class p507 { 

  
  
  
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int nFamiliares = s.nextInt();
        int pesoMax = s.nextInt();
        int temp;
        ArrayList<Integer> familiares;

        while (true) {

            if (nFamiliares == 0 && pesoMax == 0) break;

            familiares = new ArrayList<Integer>();
            int parejas = 0;

            for (int i = 0; i < nFamiliares; i++) {
              temp = s.nextInt();
              if (temp < pesoMax) familiares.add(temp);
            }

            Collections.sort(familiares);
            
            int n = familiares.size();
            for (int i = n-1; i >= 0; i--) {
              for (int j = i-1; j >= 0; j--) {
                if (familiares.get(i) + familiares.get(j) <= pesoMax) {
                  parejas += n-j;
                  break;
                } 
              }
            }

            System.out.println( parejas );

            nFamiliares = s.nextInt();
            pesoMax = s.nextInt();
        }

    }
	
}
