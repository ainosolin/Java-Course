/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 *
 * @author asoli
 */
public class ReadAndWriteIO {
    
    private String fName = "asd.txt";
    private String oFName = "output.txt";
    private String zName = "zipinput.zip";
    
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
                if (line.length()< 30 & line.trim().length()>0 && line.contains("V") == true | line.contains("v") ==true){
                /*}
                if (line.contains("V") == true | line.contains("v") ==true){*/
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
    
    /* ideana siis olisi avata zip zipinputstreamilla ja sitten ottaa sieltä
    zipentry jonka avulla saat tietää entyn koon jotta voit luoda oikean
    kokoisen bufferin minne voit zipinputstreamista lukea sen osion sit 
    vaan muutat bufferissa olevat bytet stringiksi jonka tulostat.  */

    public void Zipper(String zName, Path path){
        try {
            String pathName = path.toString()+"\\"+zName;
            // System.out.println(pathName);
            File zipFile = new File(pathName);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry entry = null;
            while ( (entry = zis.getNextEntry()) != null ) {
                       
                // Pass the inputstream object to reader.

                InputStreamReader inputtiLukija = new InputStreamReader(zis);

                // Create a BufferedReader to read contents of inputLukija.

                BufferedReader lukija = new BufferedReader(inputtiLukija);

                String s = null;
                while((s = lukija.readLine())!= null){
                    System.out.println(s);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    /*
    public void Zipper(String zName, Path path){
        try {
            // Getting the directory of Zipfile & concatenating with filename.
            String pathName = path.toString()+"\\"+zName;
            System.out.println(pathName);
            
            // Establish Java ZipFile instance to use ZipFile class.
            // I.e. point out where the Zip file is located.
            
            ZipFile zipFile = new ZipFile(pathName);
            
            // Getting the .txt-file inside the Zip.
            
            ZipEntry zipEntry = zipFile.getEntry("testi.txt");
             
            // Make inputstream object of txt-file.
            
            InputStream txtTiedosto = zipFile.getInputStream(zipEntry);
            
            // Pass the inputstream object to reader.
            
            InputStreamReader inputtiLukija = new InputStreamReader(txtTiedosto);
            
            // Create a BufferedReader to read contents of inputLukija.
            
            BufferedReader lukija = new BufferedReader(inputtiLukija);

            String s = null;
            while((s = lukija.readLine())!= null){
                System.out.println(s);
            }

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadAndWriteIO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    
