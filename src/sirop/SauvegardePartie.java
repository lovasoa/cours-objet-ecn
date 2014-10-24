/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamTokenizer;
import java.util.Formatter;
import java.util.StringTokenizer;

/**
 *
 * @author olojkine
 */
public class SauvegardePartie {
  public SauvegardePartie (PlateauJeu plateau) throws IOException {
    File fichier = new File("/home/olojkine/plateaujeu.txt");
    if (!fichier.exists()) fichier.createNewFile();
    FileOutputStream os = new FileOutputStream(fichier);
    ObjectOutputStream oos =  new TextOutputStream(os) ;
    plateau.writeObject(oos);
    
    PlateauJeu nvPlateau = new PlateauJeu(0,0);
    FileInputStream is = new FileInputStream(fichier);
    ObjectInputStream ois =  new TextInputStream(is) ;
    nvPlateau.readObject(ois);
    System.out.println(nvPlateau);
    nvPlateau.tourDeJeu();
  }
}

class TextOutputStream extends ObjectOutputStream {
  private OutputStream out;
  
  public TextOutputStream(OutputStream out) throws IOException {
    this.out = out;
  }

  @Override
  public void writeChar(int val) throws IOException {
    out.write(val);
  }

  
  @Override
  public void writeChars(String str) throws IOException {
    out.write(str.getBytes());
  }
  
  /**
   * Writes a word
   * @param str the word
   * @throws IOException 
   */
  @Override
  public void writeUTF(String str) throws IOException {
    out.write(str.getBytes("UTF-8"));
    out.write(' ');
  }

  @Override
  public void writeInt(int val) throws IOException {
    this.writeChars(Integer.toString(val)+' ');
  }
}

class TextInputStream extends ObjectInputStream {
  private StreamTokenizer st;
  
  public TextInputStream(InputStream in) throws IOException {
    this.st = new StreamTokenizer(new InputStreamReader(in));
    this.setSyntax();
  }
  
  private void setSyntax() {
    this.st.wordChars('a', 'Z');
    this.st.wordChars('_', '_');
    this.st.whitespaceChars(' ', ' ');
    this.st.whitespaceChars('\t', '\t');
    this.st.parseNumbers();
  }

  /**
   * Read a word
   */
  @Override
  public String readUTF() throws IOException {
    if (st.nextToken() == StreamTokenizer.TT_WORD){
      return st.sval;
    } else {
       throw new IOException("readUTF called, but no string to read");
    }
  }

  @Override
  public int readInt() throws IOException {
    if (st.nextToken() == StreamTokenizer.TT_NUMBER){
      return (int) st.nval;
    } else {
       throw new IOException("readInt called, but no number to read");
    }
  }
}