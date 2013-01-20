   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;

   class TTAppletFrame extends Frame implements ActionListener {
      static Applet applet;
      static TTAppletFrame myself;
  

      public TTAppletFrame(String title, Applet app, int width, int height) {
         super(title);
         applet = app;
         myself = this;

     
         add("Center",applet);
         setSize(new Dimension(width,height));

         show();

         applet.init();
         applet.start();

         addWindowListener(
                             new WindowAdapter() {
                                public void windowClosing(WindowEvent e) {
                                   System.exit(0);
                                }

                                public void windowDeiconified(WindowEvent e) {
                                }

                                public void windowIconified(WindowEvent e) {
                                }
                             });
      }


      public void actionPerformed(ActionEvent e) {
      
      }
   }
