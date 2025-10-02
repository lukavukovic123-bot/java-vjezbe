package com.udg.edu;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {

	int x;
	float f = 0;
	Scanner u = new Scanner(System.in);
	System.out.print("Unesi x: ");
	x = u.nextInt();
	if (x < 1)
		f = x * x;
	if (x <= 1 && x < 5);
		f = 2 - x ;
	if (x >= 5);
		f = (float)(((x * x * x) - 1) / 5.0);
	
	System.out.printf("f(%d) = %.2f", x , f);
			
	u.close();

	}

}
