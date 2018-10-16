import java.util.Scanner;

public class p101 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int[][] matriz = new int[2000][2000];
		int n;
		int nFilas;
		int nColumnas;
		int nDiagonal;
		int nDiagonalInv;
		int aux;
		boolean diabolico;
		boolean esoterico;
		boolean nNatural;
		int CM;
		int CM2;
		int esquinas;
		int centro;
		int centroLados;
		int cuadrado;

		n = s.nextInt();

		while(n != 0) {

			nFilas = 0;
			nColumnas = 0;
			nDiagonal = 0;
			nDiagonalInv = 0;
			esquinas = 0;
			centro = 0;
			centroLados = 0;
			esoterico = false;
			nNatural = true;
			diabolico = true;

			// Creación de la matriz
			for(int i = 0; i < n; i++) {

				for(int j = 0; j < n; j++) {

					matriz[i][j] = s.nextInt();

				}

			}  


						// COMPROBACION NUMERO DIABOLICO

			// Comprobacion suma diagonal
			for(int i = 0; i < n; i++) {


				nDiagonal += matriz[i][i];

			}


			// Comprobacion Suma diagonal invertida
			for(int i = n-1; i >= 0; i--) {

				aux = (n-1) - i;

				nDiagonalInv += matriz[aux][i];

			}


			// Comprobacion suma filas y columnas
			for(int i = 0; i < n; i++) {

				nFilas = 0;
				nColumnas = 0;

				
				for(int j = 0; j < n; j++) {

					nFilas += matriz[i][j];	
					nColumnas += matriz[j][i];

				}



				if(nFilas == nColumnas && nColumnas == nDiagonal && nDiagonal == nDiagonalInv) {

					diabolico = true;

				} else {

					diabolico = false;
					break;

				}


			} 



			if(diabolico) {

				CM = nFilas;

				CM2 = (4 * CM) / n; 

				esquinas += matriz[0][0];
				esquinas += matriz[0][n-1];
				esquinas += matriz[n-1][0];
				esquinas += matriz[n-1][n-1];

				cuadrado = n * n;
				for(int i = 0; i < n; i++) {

					for(int j = 0; j < n; j++) {

						if(matriz[i][j] > cuadrado || matriz[i][j] < 1) {
							nNatural = false;
						}

					}

				}

				if(esquinas == CM2 && nNatural) {
					
					if(n %2 != 0) {

						aux = n / 2;

						centro = 4 * matriz[aux][aux];

						centroLados += matriz[0][aux];
						centroLados += matriz[aux][0];
						centroLados += matriz[aux][n-1];
						centroLados += matriz[(n-1)][aux];

						if(centro == CM2 && centroLados == CM2) {
							esoterico = true;
						}

					} else if(n %2 == 0) {

						aux = n / 2;

						centro += matriz[aux-1][aux-1];
						centro += matriz[aux-1][aux];
						centro += matriz[aux][aux-1];
						centro += matriz[aux][aux];


						centroLados += matriz[0][aux-1];
						centroLados += matriz[0][aux];
						centroLados += matriz[aux-1][0];
						centroLados += matriz[aux][0];
						centroLados += matriz[aux-1][n-1];
						centroLados += matriz[aux][n-1];
						centroLados += matriz[n-1][aux-1];
						centroLados += matriz[n-1][aux];

						if(centro == CM2 && centroLados == (2 * CM2)) {
							esoterico = true;
						}

					}

				}

			}


			if(diabolico && esoterico) {
				System.out.println("ESOTERICO");
			}
			else if(diabolico) {
				System.out.println("DIABOLICO");
			}
			else {
				System.out.println("NO");
			}


			n = s.nextInt();

		}


		s.close();
	}

}