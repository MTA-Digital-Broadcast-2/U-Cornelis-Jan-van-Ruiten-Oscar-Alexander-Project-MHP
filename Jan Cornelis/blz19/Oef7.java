/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

import java.lang.*;

public class Oef7{

	public static void main(String arg[]){

		int array1[] = {12,34,56,78,123,234,99,88};

		int array2[];
		array2 = new int[array1.length];

		for(int i = 0; i < array1.length; i++){

			int x = array1[0];

			for(int j = 0; j < array1.length; j++){
				if(array1[j] > x){
					x = array1[j];
				}
			}

			array2[i] = x;

			for (int j = 0; j < array1.length; j++){
				if(array1[j] == x){
					array1[j] = 0;
				}
			}
		}

		for(int i = 0; i < array2.length; i++){
			System.out.println(array2[i]);
		}
	}
}