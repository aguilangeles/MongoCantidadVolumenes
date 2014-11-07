/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getquantityvolume;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ReadPropertiesForMongo {
  private File file;

  public ReadPropertiesForMongo() {
    readproperties();
  }

  private String host;
  private int port;
  private Mongo mongo;

  private void readproperties() {
    try
    {
      file = new File("Input"+File.separator+"mongo.properties");
      FileInputStream in = null;
      Properties pr = new Properties();
      in = new FileInputStream(file.getAbsolutePath());
      try
      {
	pr.load(in);
      } catch (IOException ex)
      {
	Logger.getLogger(ReadPropertiesForMongo.class.getName()).log(Level.SEVERE, null, ex);
      }
      host = pr.getProperty("host");
      port = Integer.parseInt(pr.getProperty("port"));
    } catch (FileNotFoundException ex)
    {
      Logger.getLogger(ReadPropertiesForMongo.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public DBCollection getCollection() {
    DBCollection datosvisu = null;
    try
    {
      mongo = new Mongo(host, port);
      System.out.println("conectado a  " +mongo.getAddress());
      DB db = mongo.getDB("DBVisualizador");
      datosvisu = db.getCollection("DatosVisu");
    } catch (UnknownHostException ex)
    {
      Logger.getLogger(ReadPropertiesForMongo.class.getName()).log(Level.SEVERE, null, ex);
    }
    return datosvisu;
  }

  public void close() {
    mongo.close();
  }

  public File getFile() {
    return file;
  }
  
}
