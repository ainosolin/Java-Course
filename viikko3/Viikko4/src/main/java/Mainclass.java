


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author asoli
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Luo ohjelma niin, että sinulla on pääluokka, jossa luot uuden
        I/O-olion, jolla on metodi readFile(), joka ottaa parametrikseen
        tiedostopolun.*/
        
        String pathName = System.getProperty( "user.dir" );
        Path path = Paths.get(pathName);
        
        ReadAndWriteIO lukija = new ReadAndWriteIO();
        // Tehtävä 1: lukija.ReadFile(path);
        // Tehtävä 2: 
        lukija.ReadAndWrite("asd.txt", "output.txt");
    }
    
}
