/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

package Oef10;
import java.lang.*;

public class StudentWerknemer extends PartTimeWerknemer {
       
    public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt){
        
        super(voornaam, achternaam, wNummer, salaris, urenGewerkt);
        this.setRSZ(5);
    }    
}