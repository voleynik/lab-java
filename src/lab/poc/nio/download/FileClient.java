package lab.nio.download;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/*
Class FileClient - Initializes the interface and loads all components like table, 
label and button on the main window. This class is the main class of the application.  
   Fields:
title - Contains the content of the title label.
panel - Contains the swing components.
scrollpane - Contains the table component.
table - Contains the list of files.
model - Represents the default table model.
listButton - Creates the Get File List button.
downloadButton - Creates the Download File button.
fileName - Stores the file name.
filePath - Stores the file path.
thread - Creates a progress bar thread.
th - Creates a downloading thread.
fName - Stores the file name.
fExt - Stores the file extension.
fout - Contains the file output stream.
fchan - Contains the file channel.
Methods:
addWindowListener() - This method is called when an end user clicks the window close button to close the window.
actionPerformed() - This method is invoked when an end user selects any command from the menu bar.
display() - This method is called when an end user clicks the Get File List button to display the file list.
download() - This method is called when an end user clicks the Download File button to download the specific file.
main() - This method creates the main window of the application and displays it.
*/
public class FileClient extends JFrame implements ActionListener , Runnable
{
	private static final long serialVersionUID = 0;
		
/* Declares the object of the JLabel class. */
   JLabel title;
   /* Declares the object of the JPanel class. */
   JPanel panel;
   JPanel pan1;
   JPanel pan2;
   JPanel pan3;
   /* Declares the object of the JScrollPane class. */
   JScrollPane scrollpane;
   /* Declares the object of the JTable class. */
   JTable table;
   /* Create and initialize the object of the Vector class. */
   Vector vRow = new Vector();
   Vector vCol = new Vector();
   /* Declares the object of the DefaultTableModel class. */
   DefaultTableModel model;
   /* Declare the objects of the JButton class. */
   JButton listButton;
   JButton downloadButton;
   /* Declares the object of the GridBagLayout class. */
   GridBagLayout gbl;
   /* Declares the object of the GridBagConstraints class. */
    GridBagConstraints gbc; 
   static String str1, str2;
   /* Declares the objects of the String class. */
   String fileName;
   String filePath;
   Thread thread;
   Thread th;
   String fName;
   String fExt;
   String fname = null;
   String fpath = null;
   String path = null;
   static String ipAdd;
   /* Declares the object of the ProgressTest class. */
   public ProgressTest pt;
   /* Declares the object of the FileOutputStream class. */
   FileOutputStream fout;
   /* Declares the object of the FileChannel class. */
   FileChannel fchan;
   int count = 0;
   int filesize, fs; 
   int value;
   /* Declares the default constructor of the FileClient class. */
   public FileClient() 
   {
      try
      {
         /* Sets windows look and feel to the application. */
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch(Exception e){}
      /* Sets the size of the window. */
      setSize(470, 515);
      /* Sets the reliability of the progress dialog box to false. */
      setResizable(true);
      /* Sets the title of the progress dialog box. */
      setTitle("File Download Application");
      /* Initializes the object of the GridBagLayout class. */
      gbl = new GridBagLayout();
      /* Sets the Layout */
      getContentPane().setLayout(gbl);
      /* Creates an object of the GridBagConstraints class. */
      gbc = new GridBagConstraints();
      /* 
      Initializes the title label object and adds it to the 1,1,1,1 position with CENTER alignment. 
      */         
      gbc.gridx = 1;   
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      pan1 = new JPanel();
      pan1.setLayout(new BorderLayout());
      title = new JLabel(" File Download Application ");
      title.setFont(new Font("Verdana",Font.BOLD,20));
      pan1.add(title, BorderLayout.CENTER);
      getContentPane().add(pan1, gbc);
      /* 
      Initializes listButton and downloadButton, adds these buttons to the panel. Next, 
      adds it to the 1,2,1,1 position with CENTER alignment. 
      */  
      gbc.gridx = 1;   
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      pan2 = new JPanel();
      pan2.setLayout(new FlowLayout());
      listButton = new JButton("Get File List");
      listButton.addActionListener(this);
      pan2.add(listButton);
      downloadButton = new JButton("Download the File");
      downloadButton.setEnabled(false);
      downloadButton.addActionListener(this);
      pan2.add(downloadButton);
      getContentPane().add(pan2, gbc);
      /* 
      Initializes the table label object and adds it to the 1,3,1,1 position with CENTER alignment. 
      */      
      gbc.gridx = 1;   
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      pan3 = new JPanel();
      pan3.setLayout(new BorderLayout());
      /* 
      Adds the elements at the end of the column vector. 
      */
      vCol.addElement("S. No.");
      vCol.addElement("File Name");
      vCol.addElement("Size (Bytes)");
      /* Initializes the object of the DefaultTableModel class to create a table model. */
      model = new DefaultTableModel(vRow, vCol);
      /* Initializes the object of JTable */
      table = new JTable(model);
      /* Sets single selection on the table */
      table.setSelectionMode(0);
      /* 
      Creates instance of TableColumn class and set the width of the 0th column. 
      */
      int vColIndex = 0;
      TableColumn col = table.getColumnModel().getColumn(vColIndex);
      int width = 50;
      col.setPreferredWidth(width);
      /* 
      Creates instance of TableColumn class and set the width of the 1st column. 
      */
      vColIndex = 1;
      col = table.getColumnModel().getColumn(vColIndex);
      width = 300;
      col.setPreferredWidth(width);
      /* 
      Creates instance of TableColumn class and sets the width of the 2nd column. 
      */
      vColIndex = 2;
      col = table.getColumnModel().getColumn(vColIndex);
      width = 100;
      col.setPreferredWidth(width);
      scrollpane = new JScrollPane(table);
      pan3.add(scrollpane, BorderLayout.CENTER);
      getContentPane().add(pan3, gbc);
      /*
      addWindowListener - Contains a windowClosing() method.
      windowClosing: Closes the main window It is called when the end user 
      clicks the cancel button of the Window. 
      Parameter: we- Object of the WindowEvent class.
      Return Value: NA
      */
      addWindowListener(new WindowAdapter()
      {
      public void windowClosing(WindowEvent we)
         {
            System.exit(0);
         }
      });   
   }
   /*
   actionPerformed() - This method is called when the end user selects any menu item from the menu bar.
   Parameters:   ae - An ActionEvent object containing the details of the event.
   Return Value: NA
   */   
   public void actionPerformed(ActionEvent ae)
   {
      /*
      This is executed when end user clicks the Get File List button.
      */
      if(ae.getSource() == listButton)
         {
            /* Calls the display method. */
            display();
            /* Sets the caption of the listButton to "Refresh". */
            listButton.setText("Refresh");
            /* Enables the download button. */
            downloadButton.setEnabled(true);
      }
      /*  
      This is executed when end user clicks the Download File button.
      */
      else if(ae.getSource() == downloadButton)
      {
         int n = table.getSelectedRow();
         if ( n != -1)
         {
            /* Retrieves the value of specified column. */
            Object obj1 = table.getValueAt(n, 1);
            Object obj2 = table.getValueAt(n, 2);
            fname = (obj1).toString(); 
            fs = Integer.parseInt(obj2.toString()); 
            filesize = fs;
            /* Opens a Confirm dialog box. */
            value = JOptionPane.showConfirmDialog(null, "Are you sure you want to download the file?",
            "Confirm", JOptionPane.YES_NO_OPTION);
            if(value == 0)
            {
               count = 1;
               /* Initializes a new thread. */
               th = new Thread(this);
               /* Starts the thread. */
               th.start();
            }
            else if(value == 1)
            {         
            }            
         }
         else  
         {
            /* Opens the error messages. */
            JOptionPane.showMessageDialog(null, "You must select a file before downloading!", 
            "Message", JOptionPane.ERROR_MESSAGE); 
         }         
      }      
   }
   /*
   display() - This method is called when the end user clicks the List the 
   File button of the File Download Application window.
   Parameters:   NA 
   Return Value: NA
   */   
   public void display()
    {
      /* Creates and initialize the object of the vector class. */
      Vector vec = new Vector();
      /* Sets the number of rows in a table model to ZERO. */
      model.setRowCount(0);
      /* Creates the object of the FileInfo class. */
      FileInfo obj;
      try 
      {
         String str = "rmi://"+ipAdd+"/FServer";
         /* 
         Creates an instance of the FileRemote interface that looks up the remote 
         object from the specified location. 
         */
         FileRemote f = (FileRemote)Naming.lookup(str);
         /* 
         Calls the displayList() method that returns the list of files stored in the File server. 
         */
         vec = f.displayList();
         if((vec!=null) && (vec.size()>0))
         {
         for(int i=0; i<vec.size(); i++)
            {
               /* Initializes the vRow object of the Vector class. */
               vRow = new Vector();
               /* Retrieves the value from the ith location. */
               obj = (FileInfo)vec.elementAt(i);
               /* Adds the fileIndex at the end of the vector. */
               vRow.addElement(obj.fileIndex);
               /* Adds the fileName at the end of the vector. */
               vRow.addElement(obj.fileName);
               /* Adds the fileSize at the end of the vector. */
               vRow.addElement(obj.fileSize);
               /* Adds the row in the table model. */
               model.addRow(vRow);               
            }
         }
      }
      catch(Exception e)
      {
         System.out.println("Vector Error:" + e);
      }
   }
/*
download() - This method is called when the end user clicks the Download 
File button of the File Download Application window.
Parameters:   
fileName - Contains the name of the file.
filePath - Contains the path of the file.
Return Value: NA
*/      
public void download(String fileName, String filePath)
    {
      /* Declares the object of the ByteBuffer class. */
      ByteBuffer buff;
      long fsize;                  
      try 
      {
         String str = "rmi://"+ipAdd+"/FServer";
         /* 
         Creates an instance of the FileRemote interface that looks up the remote 
         object from the specified location. 
         */
         FileRemote f = (FileRemote)Naming.lookup(str);
         /* 
         Creates and initialize the object of the StringTokenizer class. 
         */
         StringTokenizer st = new StringTokenizer(fileName, ".");
         /* 
         Retrieves the value of the string before the delimiter "." 
         */
         fName = st.nextToken();
         /* 
         Retrieves the value of the string after the delimiter ".".
         */
         fExt = st.nextToken();
         path = filePath + "." + fExt;
         count = 2;
         /* Initializes the object of the Thread class. */
         thread = new Thread(this);
         /* Starts the thread. */
         thread.start();
         /* 
         Calls the downloadFile() method that returns the content of the file. 
         */
         byte[] data = f.downloadFile(fileName);
         try
         {
            /* Initializes the object of the FileOutputStream class. */
            fout = new FileOutputStream(path);
            /* Gets the channel from the output stream. */
            fchan = fout.getChannel();
            /* Allocates the size of the buffer. */
            buff = ByteBuffer.allocateDirect((int)(data.length));
            for(int i=0; i<data.length; i++)
            /* Reads the data from the byte array to the buffer. */
            buff.put(data[i]);
            /* Rewinds the buffer. */
            buff.rewind();
            /* Writes the buffer to the channel. */
            fchan.write(buff);
            /* Closes the channel. */
            fchan.close();
            /* Closes the output stream. */
            fout.close();         
            } 
         catch(Exception e) 
         {   
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
System.out.println("Error: " + e);
      }
   }
/*
run() - This method is called when the thread is started.
Parameters:   NA
Return Value: NA
*/      
   public void run()
   {
      if(count == 1)
      {
         try
         {
            /* Creates and initialize the object of the JFileChooser class. */
            JFileChooser jfc = new JFileChooser();
            /* Sets the selection mode of the file chooser. */
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            /* Displays the Save dialog box. */
            value = jfc.showSaveDialog(this); 
            if(value == JFileChooser.APPROVE_OPTION)
            {
               try
               {
                  /* Selects the file. */
                  File file = jfc.getSelectedFile();
                  /* Retrieves the file path. */
                  fpath = file.getAbsolutePath();
                  /* Calls the downlaod() method. */
                  download(fname, fpath);   
               }         
               catch(Exception e) 
               {
                  e.printStackTrace();
                  System.out.println("Error" + e);   
               }
            }
         }
         catch(Exception e)                
         {
            e.printStackTrace();
            System.out.println("Error" + e);   
         }      
      }
      else if(count == 2)
      {
         /* Initializes the object of ProgressTest class. */
         pt = new ProgressTest(filesize, path, th);
         /* Sets the title. */
         pt.setTitle("Download Complete.");
         /* Sets the label text. */
         pt.label.setText("Download Complete.");
         /* Sets the button caption. */
         pt.ok.setText(" OK ");
         /* Hides the progress bar. */
         pt.bar.setVisible(false);      
      }      
   }
   /*
   main() - This method creates the main window of the user interface and displays it.
   Parameters:
   args[] - Contains any command line arguments passed.
   Return Value: NA
   */   
   public static void main(String args[]) 
   {
     if(System.getSecurityManager() == null) {
       System.setSecurityManager(new RMISecurityManager());
     }
      ipAdd = args[0];
      /* 
      Creates and initializes the object of the FileClient class. 
      */
      FileClient fc = new FileClient();
      fc.setVisible(true);    
      }   
}