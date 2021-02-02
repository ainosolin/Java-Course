/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asoli
 */
public class ReadAndWriteIO {
    
    private String fName = "asd.txt";
    
    public void ReadFile(Path pname){
        try {
            Path path = Paths.get(fName);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line = "";
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}