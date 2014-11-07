/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getquantityvolume;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetQuantityVolume {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    //lee los datos de conexion y genera un dbCollection
    System.out.println("leyendo...");
    ReadPropertiesForMongo readAndConect = new ReadPropertiesForMongo();
    
    System.out.println("..."+readAndConect.getFile().getAbsolutePath());
    DBCollection datosVisu = readAndConect.getCollection();
    //lee los nombres de los volumenes y los guarda en una lista
    System.out.println("leyendo volumenes");
    VolumenesList volumenes = new VolumenesList();
// al iterar la lista...
    for (Volumen vol : volumenes.getVolumenes())
    {
      //busca en mongo la coincidencia de volumen
      BasicDBObject query = new BasicDBObject("filePath", new BasicDBObject("$regex", vol.getNombre()));
      DBCursor cursor = datosVisu.find(query);
      //... y setea la cantidad
      vol.setCantidad(cursor.count());
      System.out.println("volumen: "+vol.getNombre()+"\t cantidad: "+vol.getCantidad());
    }
    readAndConect.close();
    //Escribe los resultados en un txt
    System.out.println("Escribiendo...");
    WriteResult writeResult = new WriteResult(volumenes.getVolumenes());
    System.out.println("Finalizó el proceso.");
    System.out.println("Resultados disponibles en"+"\n"+writeResult.getFile().getAbsolutePath());
  }
  
}
