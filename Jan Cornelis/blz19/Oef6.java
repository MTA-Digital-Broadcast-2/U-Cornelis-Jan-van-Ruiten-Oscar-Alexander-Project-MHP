/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

import java.lang.*;

public class Oef6{

	public static void main(String args[]){
		int getallenArray[]={12,34,56,78,123,234,99,88};
		int grootsteGetal = 0;

		for (int i=0; i < getallenArray.length; i++ ){
			
			if(getallenArray[i]>grootsteGetal){
				grootsteGetal = getallenArray[i];
			}
		}

		System.out.println(grootsteGetal);
	}

}