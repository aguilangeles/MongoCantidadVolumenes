/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getquantityvolume;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class VolumenesList {

  private final List<Volumen> volumenes = new ArrayList<>();

  public VolumenesList() {
    getListOfVolumenes();

  }

  private List<Volumen> getListOfVolumenes() {
    FileInputStream fis = null;
    try
    {
      File path = new File("Input"+File.separator+"input.txt");
      fis = new FileInputStream(path.getAbsolutePath());
      BufferedReader br = new BufferedReader(new InputStreamReader(fis));
      String line = null;
      while ((line = br.readLine()) != null)
      {
	volumenes.add(new Volumen(line, 0));
      }
      br.close();
    } catch (FileNotFoundException ex)
    {
      Logger.getLogger(VolumenesList.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex)
    {
      Logger.getLogger(VolumenesList.class.getName()).log(Level.SEVERE, null, ex);
    } finally
    {
      try
      {
	fis.close();
      } catch (IOException ex)
      {
	Logger.getLogger(VolumenesList.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return volumenes;
  }

  public List<Volumen> getVolumenes() {
    return volumenes;
  }

}
