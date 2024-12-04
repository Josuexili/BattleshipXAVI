package Battleship;

import java.util.Scanner;
import java.util.Random;
//Hola que tal.
public class Battleship {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		Random al = new Random();
		int filaVaixell1 = al.nextInt(5);
        int columnaVaixell1 = al.nextInt(5);
        int filaVaixell2 = al.nextInt(5);
        int columnaVaixell2 = al.nextInt(5);
		if (filaVaixell1 == filaVaixell2 && columnaVaixell1 == columnaVaixell2) {
			filaVaixell2 = al.nextInt(5);		        
	        columnaVaixell2 = al.nextInt(5);			
		}
        String entrada;
        int columna;
        int fila; 
        int comptador = 0;
        int vaixell = 2;
		char[][] matriu = new char [5][5];	
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matriu[i][j] = '*';
			}
		}
		do {

            System.out.print("Introdueix les coordenades de A1 a E5 (ex: A1, B2): ");
            entrada = in.nextLine().toUpperCase();
	        columna = entrada.charAt(0) - 'A'; // A -> 0, B -> 1, C -> 2, D -> 3, E -> 4
            fila = Character.getNumericValue(entrada.charAt(1)) - 1;
            if ((fila == filaVaixell1 && columna == columnaVaixell1) || (fila == filaVaixell2 && columna == columnaVaixell2)) {
            	System.out.println(entrada + " = TOCAT I ENFONSAT");
            	matriu[fila][columna] = 'V';
            	vaixell--;
            	comptador++;
            }
			if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                System.out.println("Coordenades no vàlides. Prova de nou.");
            } else if ((fila != filaVaixell1 || columna != columnaVaixell1) && (fila != filaVaixell2 || columna != columnaVaixell2)){
            	matriu[fila][columna] = 'A';
            	System.out.println(entrada + " = AIGUA");
	            comptador++;
            } 
			System.out.printf("%11S%n", "A B C D E");
			for (int i = 0; i < 5; i++) {
				System.out.print(i+1);
				for (int j = 0; j < 5; j++) {
					System.out.printf("%2c", matriu[i][j]);
					if (j == 4) {			
						System.out.println("");
					}
				}	
			}           	            
        } while (vaixell > 0) ;		
        System.out.println("ENHORABONA HAS TROBAT ELS VAIXELLS EN " + comptador + " JUGADES");
	}
}
