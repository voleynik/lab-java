package lab.nio.download;
/* Imports java.util package class. */
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/*
class ProgressTest - Creates a Download Status dialog box that indicates how much data is downloaded from the server.
Fields:
label - Contains the content of title label.
ok - Creates an OK button.
size - Contains the size of the file.
path - Contains the path where the end user wants to save the file.
th - Contains the instance of the downloading thread.
Method:
performTask() - This method is called when the ProgressBar is painted.
actionPerformed() - This method is invoked when the end user clicks the OK or Cancel button.
*/
public class ProgressTest extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 0;
   /* Declares the objects of the JLabel class. */
   JLabel label;
   JLabel label_1;
   JLabel label_2;
   /* Declares the object of the JButton class. */
   JButton ok;
   /* Declares the object of the JProgressbar class. */
   JProgressBar bar;
   /* Declares the object of the GridBagLayout class. */
   GridBagLayout gbl;
   /* Declare the object of the GridBagConstraints class. */
   GridBagConstraints gbc;
   /* Declares the objects of the string class. */
   String str;
   String path;
   /* Declares and initialize the size as integer. */
   int size = 100;
   /* Declares the object of the Thread class. */
   Thread th;
   int n = 0;
   /*
   ProgressTest() - This is the default constructor of the ProgressTest class.
   Parameter:
   size - Represents the file size. 
   path - Represents the file path where the end user saves the file.
   th - Represents the instance of the Thread class.
   */
   public ProgressTest(int size, String path, Thread th)
   {
      this.size = size;
      this.path = path;
      this.th = th;
      /* Sets the size of the Download Status dialog box. */
      setSize(270, 150);
      /* Sets the visibility of the Download Status dialog box. */
      setVisible(true);
      /* 
      Sets the reliability of the Download Status dialog box to false. 
      */
      setResizable(false);
      /* Sets the title of the Download Status dialog box. */
      setTitle("Download Status");
      /* Initializes the object of the G   ridBagLayout class. */
      gbl = new GridBagLayout();
      /* Sets the Layout. */
      getContentPane().setLayout(gbl);
      /* Creates an object of the GridBagConstraints class. */
      gbc = new GridBagConstraints();
      /* 
      Initializes the label object and add it to the 1,1,1,1 position with WEST alignment. 
      */
      gbc.gridx = 1;   
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.WEST;
      label = new JLabel(" File is downloading");
      getContentPane().add(label, gbc);
      /* 
      Initializes a blank label object and add it to the 1,2,1,1 position with WEST alignment. 
      */
      gbc.gridx = 1;   
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.WEST;
      label_1 = new JLabel(" ");
      getContentPane().add(label_1, gbc);
      /* 
      Initializes an object of the JprogressBar class and adds it to the 1,3,1,1 position with CENTER alignment. 
      */
      gbc.gridx = 1;   
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      bar = new JProgressBar();
      /* Sets the size of the progress bar. */
      bar.setPreferredSize(new Dimension(225, 20));
      bar.setMinimum( 0 );
      bar.setMaximum( size );
      bar.setValue( 0 );
      bar.setBorderPainted(true);
      bar.setStringPainted(true); 
      getContentPane().add(bar, gbc);
      /* 
      Initializes a blank label object and adds it to the 1,4,1,1 position with WEST alignment. 
      */
      gbc.gridx = 1;   
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.WEST;
      label_2 = new JLabel(" ");
      getContentPane().add(label_2, gbc);
      /* 
      Initializes an object of the Button class and adds it to the 1,5,1,1 position with CENTER alignment. 
      */
      gbc.gridx = 1;   
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      ok = new JButton(" Cancel ");
      ok.addActionListener(this);
      getContentPane().add(ok, gbc);   
      n = 100;
      /* 
      Starts the progress bar until the file is downloaded. 
      */ 
      for( int iCtr = 1; iCtr < size+1; iCtr +=n )
      {
         /* 
         Calls the performTask() method to insert a time delay. 
         */
         performTask( iCtr );
         /* Updates the progress indicator and label. */
         label.setText( "Downloading "+ iCtr + " bytes of " + size + " bytes.");
         /* Creates an object of the Rectangle class that gets the label bound. */
         Rectangle labelRect = label.getBounds();
         labelRect.x = 0;
         labelRect.y = 0;
         /* Paints the label. */
         label.paintImmediately( labelRect );
         /* Sets the value to the progress bar. */
         bar.setValue( iCtr );
         /* 
         Creates an object of the Rectangle class that gets the progress bar bound. 
         */
         Rectangle progressRect = bar.getBounds();
         progressRect.x = 0;
         progressRect.y = 0;
         /* Paints the progress bar. */   
         bar.paintImmediately( progressRect );
      }
   }
   /*
   performTask() - This method provides a time delay for the progress bar creating loop. 
   Paramter: ictr
   Return Value: NA
   */
   public void performTask( int iCtr )
   {
      Random random = new Random( iCtr );
      for( int i = 0; i < random.nextFloat() * 1000; i++ )
      {
         /* Runs the loop */
      }
   }
   /*
   actionPerformed() - This method is invoked when the end user clicks the button.
   Parameter: ae - an ActionEvent object containing the details of the event.
   Returns Value: NA
   */
   public void actionPerformed(ActionEvent ae)
   {
      String arg = (String)ae.getActionCommand();
      if(arg.equals(" Cancel "))
      {
         try
         {
            /* Creates instance of the File class. */
            File f = new File(path);
            /* Performs deletion until the file is deleted. */
            while(f.delete())
            {
               /* Delete the file. */
               f.delete(); 
            }
            /* Hides the Download Status dialog box. */
            this.setVisible(false);
         }
         catch(Exception e)
         {
            System.out.println("Error in I/O");
         }          
      }
      else if(arg.equals(" OK "))
      {
         /* Hides the Download Status dialog box. */
         this.setVisible(false);
      }
   }   
}