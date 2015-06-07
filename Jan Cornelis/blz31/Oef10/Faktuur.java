/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

package Oef10;
import java.lang.*;

public class Faktuur implements Betaalbaar{
    
    public int faktuurNr = 5;
    public int faktuurBedrag = 500;
    
    public Faktuur(){
        
    }
    
    @Override
    public void betaal(){
        System.out.println("Faktuur:" + this.faktuurNr + " ,Bedrag: " + this.faktuurBedrag + ".");
    }
}