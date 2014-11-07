/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getquantityvolume;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class WriteResult {
  private File file;

  public WriteResult(List<Volumen> volumen) {
    writeResults(volumen);
    
  }
  
  
  private  void writeResults(List<Volumen> volumen)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
	     file = new File("Outputs"+File.separator+"resultados.txt");
            fichero = new FileWriter(file, false);
	    
            pw = new PrintWriter(fichero);
 
	    for(Volumen vols : volumen){
	      
                pw.println(vols.toString());
	    }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
}

  public File getFile() {
    return file;
  }
  
}
