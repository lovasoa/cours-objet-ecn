/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.net.URL;

/**
 *
 * @author zhaoshuli
 */
public class Icon {
  private final String resourcePath = "/resources/";
  private String iconName;
  private ImageIcon icon;

  
  /**
   * Retourne une ImageIcon, ou null si le chemin fourni est invalide
   *
   * @param path : chemin complet de l'image utilisee dans l'icone : nom du repertoire + nom du fichier
   * @param description : une description textuelle de notre future icone
   * @return un objet de type ImageIcon correspondant a l'image dont le chemin est fourni en premier parametre
   */
  public Icon (String path, String name) {
    URL imgURL;
    ImageIcon res = null;
    imgURL = Icon.class.getClass().getResource(path);
    if (imgURL != null) {
      res = new ImageIcon(imgURL, name);
      // on redimensionne l'image pour qu'elle fasse 40x40 pixels
      // ATTENTION A CES CONSTANTES !!!!! 
      Image newimg = res.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_FAST);
      res = new ImageIcon( newimg );
    } else {
      System.err.println("Couldn't find file: " + path);
   }
   this.icon = res;
   this.setIconName(name);
  }
  
  public void setIconName(String name){
    iconName=name;
  }
  
  public String getIconName(){
    return iconName;}
  
  public ImageIcon getIcon(){
    return icon;
  }
  
  
}
