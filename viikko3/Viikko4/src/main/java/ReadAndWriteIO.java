/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    private String oFName = "output.txt";
    
    // Tehtävä 1:
    
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
    
    // Tehtävä 2:
    
    public void ReadAndWrite(String fName, String oFName){
        try {
            Path path = Paths.get(fName);
            Path path2 = Paths.get(oFName);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path2);
            String line = "";
            while((line=bufferedReader.readLine())!=null){
                if (line.length()< 30 & line.trim().length()>0){
                    bufferedWriter.write(line+"\n");
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}