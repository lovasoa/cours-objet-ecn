/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

 
 // Ajoutez les import necessaires
public class GUIBoard extends JFrame { 
    
    // Largeur et hauteur du plateau de Jeu
    private int largeur;
    private int hauteur;
    
    // Menu
    private JMenuBar        jMenuBar;
    private JMenu           jMenuFile;
    private JMenuItem       jFileNew;
    private JMenuItem       jFileOpen;
    private JMenuItem       jFileSave;
    private JMenuItem       jFileReset;
    private JMenuItem       jFileExit;
    private JMenu           jMenuAbout;
    private JMenuItem       jAboutInfo;
    
    // Panel pour contenir les boutons
    private JPanel          jPanelBoutons;
    private JToggleButton   jPlateau[][];
    private Icon iconWall;
   
    // Panel pour contenir le texte + bouton reset
    private JPanel          jPanelTexte;
    private JScrollPane     jScrollPane;
    private JTextArea       jZoneTexte;
    private JButton         jResetTextButton;
    
    // Play/Pause bouton
    private JButton         jPlayButton;
    private JButton         jStopButton;
    private JPanel          jPanelPlayStop;
    
   
    // Constructeur
    public GUIBoard(int l, int h) {
        this.largeur = l;
        this.hauteur = h;
        
        // Creation de la GUI
        initGUIComponents();
    }
    
    public void initGUIComponents(){

      // Creating the frame and the layout
      JFrame maFrame = new JFrame();
      maFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      maFrame.setTitle("SIROP");
      maFrame.setMaximumSize(new java.awt.Dimension(1600, 1200));
      maFrame.setMinimumSize(new java.awt.Dimension(320, 240));
      maFrame.setPreferredSize(new java.awt.Dimension(640, 480));
      // apres avoir choisi les tailles de la fenetre et son titre
      maFrame.getContentPane().setLayout(new BorderLayout());
      
        // Adding the menu
        jMenuBar = new javax.swing.JMenuBar();
        jMenuBar.setMinimumSize(new java.awt.Dimension(320, 22));
        jMenuBar.setSize(new java.awt.Dimension(320, 20));
              
        // Menu
        jMenuFile = new JMenu("File");
        // Menu new
        jFileNew = new JMenuItem("New");
        // Menu open 
        jFileOpen = new JMenuItem("Open");
        // Menu save 
        jFileSave = new JMenuItem("Save");
        // Menu reset 
        jFileReset = new JMenuItem("Reset");
        // Menu exit
        jFileExit = new JMenuItem("Exit");        
              
        // Menu a propos
        jMenuAbout = new JMenu("About");
        jAboutInfo = new JMenuItem("Info");
        
        // Adding menu items to the menu
        jMenuFile.add(jFileNew);
        jMenuFile.add(jFileOpen);
        jMenuFile.add(jFileSave);
        jMenuFile.add(jFileReset);
        jMenuFile.add(jFileExit);
              
        jMenuAbout.add(jAboutInfo);
        
        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuAbout);
      
        // Ajout du menu a la JFrame
        setJMenuBar(jMenuBar);
        
        // On cree un panel qui va stocker les boutons de notre plateau de jeu
        jPanelBoutons = new JPanel(new GridLayout(this.largeur,this.hauteur));
        // Creating the board
        jPlateau = new JToggleButton[this.largeur][this.hauteur];
      
        
        
        // On cree l'ensemble des boutons (JToggleButton)
        for(int i =0;i<largeur;i++) {
            for(int j=0;j<hauteur;j++) {
              // Creation du bouton en [i,j]
                  jPlateau[i][j] = new JToggleButton();
                  jPlateau[i][j].setEnabled(false);
                  jPlateau[i][j].setMaximumSize(new java.awt.Dimension(100, 100));
                  jPlateau[i][j].setMinimumSize(new java.awt.Dimension(10, 10));
                  jPlateau[i][j].setPreferredSize(new java.awt.Dimension(40, 40));
                  jPlateau[i][j].setIcon(iconWall.createImageIcon("/resources/wall-128.png", "IconWall"));
                
                  // Ajout du bouton nouvellement cree
                  jPanelBoutons.add(jPlateau[i][j],i,j);
            }
        }
        // ajout du panel a la JFrame (une GUIBoard est une JFrame)
        maFrame.getContentPane().add(jPanelBoutons, BorderLayout.CENTER);
        
        // Play/Pause button
        jPlayButton = new JButton("Play");
        jStopButton = new JButton("Stop");
        // Adding the "Play"/Stop" buttons
        jPanelPlayStop = new JPanel(new FlowLayout());
        jPanelPlayStop.add(jPlayButton);
        jPanelPlayStop.add(jStopButton);
        maFrame.getContentPane().add(jPanelPlayStop, BorderLayout.SOUTH);
        // gestion du bouton Play/Pause
        jPlayButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                String playButtonText = jPlayButton.getText();
              switch (playButtonText) {
                case "Play":
                  jPlayButton.setText("Pause");
                  break;
                case "Pause":
                  jPlayButton.setText("Play");
                  break;
              }
            }
        });
        jStopButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
   
        
        // Un panneau permettant de gerer le defilement
        // et gestion des tailles minimales et preferees
        jScrollPane = new JScrollPane();
        jScrollPane.setMinimumSize(new java.awt.Dimension(300, 140));
        jScrollPane.setPreferredSize(new java.awt.Dimension(200, 100));

        // Text Area
        jZoneTexte = new JTextArea();
        jZoneTexte.setText("Test\textbackslash n de texte dans \textbackslash n la zone de texte !");
  
        // Ajout de la zone de texte dans le scroll pane
        jScrollPane.setViewportView(jZoneTexte);


        // Reset bouton        
        jResetTextButton = new JButton("Clear Text");
        jResetTextButton.setFocusable(false);
        jResetTextButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                String playButtonText = jPlayButton.getText();
                if (playButtonText.equals("Clear Text")){
                    jZoneTexte.setText("");}
            }
        });
        
                
        // Ajout scroll pane/textarea
        jPanelTexte = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // Ajout du scroll pane
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        jPanelTexte.add(jScrollPane, c);
        
        // Ajout du bouton
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.2;
        jPanelTexte.add(jResetTextButton,c);
        
        
        // Ajout the panel for the texte
        maFrame.getContentPane().add(jPanelTexte, BorderLayout.EAST);
        
        pack();
<<<<<<< Updated upstream
        
    }        
}
=======

    }        
    
        //Afficher les elements
        public void displayGameElement(Point2D pos, Icon iconElement, String textIcon, String textZoneTexte) {
          // Appication de l'icone 
            jPlateau[pos.getX()][pos.getY()].setIcon(iconElement.getIcon());
            jPlateau[pos.getX()][pos.getY()].setDisabledIcon(iconElement.getIcon());
            jPlateau[pos.getX()][pos.getY()].setText(textIcon);
            jPlateau[pos.getX()][pos.getY()].setVerticalTextPosition(SwingConstants.CENTER);
            jPlateau[pos.getX()][pos.getY()].setHorizontalTextPosition(SwingConstants.CENTER);
          // Affichage dans le text area
            jZoneTexte.append(textZoneTexte+"\n");
        }

        
}


/*
// dans une methode de gestion d'evenements
// l'instruction suivante est complexe, plus d'informations sur Internet sur le site d'Oracle
JFileChooser chooser = new JFileChooser(this.getClass().getClassLoader().getResource("").getPath());
// filtre permettant de limiter les fichiers montres par le file chooser
FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files", "txt");
chooser.setFileFilter(filter);
int returnVal = chooser.showOpenDialog(null);
// si l'utilisateur a clique sur OK
if (returnVal == JFileChooser.APPROVE_OPTION) {
  // attention aux exceptions
  try {
    String fileN = chooser.getSelectedFile().getName();
    System.out.println("You chose to open this file: "+fileN);
    // chargement du fichier ?
  } catch (FileNotFoundException ex) {
    Logger.getLogger(ReactionMenuFile.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IOException ex) {
    Logger.getLogger(ReactionMenuFile.class.getName()).log(Level.SEVERE, null, ex);
  } catch (InterruptedException ex) {
    Logger.getLogger(ReactionMenuFile.class.getName()).log(Level.SEVERE, null, ex);                    
  }  
}

  private void initGUIComponents() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

*/
>>>>>>> Stashed changes
