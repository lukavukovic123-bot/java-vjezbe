package com.udg.edu;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		Scanner u = new Scanner(System.in);
	
		
		int N, N1;
		System.out.print("Unesi N: ");
		N = u.nextInt();
		
		System.out.printf("|%d|= %d.",N, Math.abs(N));
		
		
		N1 = N;
		
		if (N < 0)
			N = -N;
		System.out.printf("|%d|= %d.",N1, N);
		
		u.close();
	}
}