/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

import java.lang.*;

public class Oef2{
    
	public static void main(String args[]){
   		int dag = 1;

        while( dag < 29){
            for (int i = 1; i < 8; i++){

                switch (i){
			  case 1:
                		System.out.println(dag + "zondag");
                        break;
                    case 2: 
				System.out.println(dag + "maandag");
                        break;
                    case 3: 
				System.out.println(dag + "dinsdag");
                        break;
                    case 4: 
				System.out.println(dag + "woensdag");
                        break;
                    case 5: 
				System.out.println(dag + "donderdag");
                        break;
                    case 6: 
				System.out.println(dag + "vrijdag");
                        break;
                    case 7: 
				System.out.println(dag + "zaterdag");
                        break;
                }
                
                dag ++;
               	System.out.println();
            }	
        }
	}
}