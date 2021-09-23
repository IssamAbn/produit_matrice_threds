package produitMatrice;

import java.util.Random;
import java.util.Scanner;

public class produitMatrice extends Thread {
	private int ligne, colone, taille;
	private int[][] Aa = new int[100][100];
	private int[][] Bb = new int[100][100];
	private int[][] Rr = new int[100][100];

	public produitMatrice(int l1, int l2, int N, int[][] R, int[][] A, int[][] B) {
		this.ligne = l1;
		this.taille = N;
		this.colone = l2;
		this.Aa = A;
		this.Bb = B;
		this.Rr = R;
	}

	// Calcul du produit d'une seule case de la matrice resultat 
	public void run(){
		int k=0;
		for(int j=0; j<taille;j++) {
			this.Rr[this.ligne][this.colone]+=this.Aa[this.ligne][k]*this.Bb[j][this.colone];
			k++;
		}
	}

	public static void main(String[] args) {
	
    Scanner input = new Scanner(System.in);
	System.out.print("Entrez la dimension : ");
	int N = input.nextInt();
	Random r = new Random();
	
	 
	int[][] A = new int[N][N];
	int[][] B = new int[N][N];
	int[][] R = new int[N][N];
	 
	 
	//Remplissage des deux matrices par des valeurs aléatoires
	for (int i=0 ; i < A.length ; i++)
	for (int j=0 ; j < A[i].length ; j++){
		A[i][j] = r.nextInt(10) + 1;
		B[i][j] = r.nextInt(10) + 1;
	}
	 
	System.out.println("Matrix A : ");
	for (int i=0 ; i < A.length ; i++){
		System.out.println();
		for (int j=0 ; j < A[i].length ; j++){
			System.out.print(A[i][j]+" ");
		}
	}
	
	System.out.println();
	System.out.println();
	
	System.out.println("Matrice B : ");
	for(int i=0 ; i < B.length ; i++){
	System.out.println();
		for (int j=0 ; j < B[i].length ; j++){
		System.out.print(B[i][j]+" ");
		}
	}
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println("Le résultat est : ");
	System.out.println();

	// Calcul du produit de la matrice pour toutes lignes et colonnes
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			produitMatrice myThread = new produitMatrice(i, j, N, R, A, B);
			myThread.start();
		}
	}

	// Affichage du résultat de la matrice
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < B.length; j++) {
			System.out.print(+R[i][j] + " ");
		}
		System.out.println();
	}
	 
}
}

