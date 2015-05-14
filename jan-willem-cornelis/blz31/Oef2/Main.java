/**
* Deze klassen is een Java programma
* @author Jan Willem Cornelis
* @version 1.0
*/

package Oef2;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        
        Werknemer w1 = new Werknemer("Voornaam1", "Achternaam1", 1, 1000.0f);
        Werknemer w2 = new Werknemer("Voornaam2", "Achternaam2", 2, 2000.0f);
        Werknemer w3 = new Werknemer("Voornaam3", "Achternaam3", 3, 3000.0f);
        Werknemer w4 = new Werknemer("voornaam4", "Achternaam4", 4, 4000.0f);

        w1.salarisVerhogen(10);
        w2.salarisVerhogen(10);

        System.out.println(w1.voornaam + "krijgt "  + w1.getSalaris());
        System.out.println(w2.voornaam + "krijgt "  + w2.getSalaris());
        System.out.println(w3.voornaam + "krijgt "  + w3.getSalaris());
        System.out.println(w4.voornaam + "krijgt "  + w4.getSalaris());
    }
}