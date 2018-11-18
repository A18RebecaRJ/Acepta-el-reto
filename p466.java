import java.util.Scanner;
import java.math.BigInteger;

public class p466 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		BigInteger resultado;
		BigInteger digito;
		BigInteger potencia;
		int multiplicacion;
		String num1;
		String num2;
		int[] numero1;
		int[] numero2;
		int mayor;
		boolean llevar;
		int suma;
		int casos = s.nextInt(); 

		for(int i = 0; i < casos; i++) {

			num1    = s.next();
			num2    = s.next();
			
			resultado      = new BigInteger("0");
			digito		   = new BigInteger("1");
			potencia       = new BigInteger("0");
			multiplicacion = 0;
			llevar         = false;
			suma           = 0;


			if (num1.length() > num2.length()) {
				
				mayor = num1.length();
				
			} else {
				
				mayor = num2.length();
				
			}
			
			numero1 = new int[mayor];
			numero2 = new int[mayor];
			
			for(int j = 0; j < num1.length(); j++) numero1[j] = Integer.parseInt("" + num1.charAt(num1.length()-j-1));
			
			for(int j = 0; j < num2.length(); j++) numero2[j] = Integer.parseInt("" + num2.charAt(num2.length()-j-1));
			
			
			for(int j = 0; j < mayor; j++) {

				multiplicacion = 0;
				potencia       = new BigInteger("0");

				if(llevar) {
					multiplicacion += suma; //multiplicacion.add(BigInteger.valueOf(suma));
					llevar = false;
					suma = 0;
				}
				
				if(numero1[j] * numero2[j] >= 10 && j != mayor-1) {

					multiplicacion += numero1[j] * numero2[j] %10;
					suma = numero1[j] * numero2[j] / 10;
					llevar = true;
					
				} else {
					multiplicacion += numero1[j] * numero2[j] + suma;
				}
				
				potencia  = BigInteger.valueOf(multiplicacion).multiply(digito);
				digito    = digito.multiply(BigInteger.valueOf(10));
				resultado = resultado.add(potencia);
				

			}
			
			
			System.out.println(String.format("%0"+mayor+"d", resultado));

		}


	}

}
