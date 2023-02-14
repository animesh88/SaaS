   package postingSoa;

   import java.io.IOException;
   import java.io.OutputStream;
   import java.io.PrintStream;

   import javax.swing.JTextArea;

   /**
10   * Simple way to "print" to a JTextArea; just say
11   * PrintStream out = new PrintStream(new TextAreaOutputStream(myTextArea));
12   * Then out.println() et all will all appear in the TextArea.
13   * Source: http://javacook.darwinsys.com/new_recipes/14.9betterTextToTextArea.jsp
14   */
  public final class TextAreaOutputStream extends OutputStream {

      private final JTextArea textArea;
      // private final StringBuilder sb = new StringBuilder();

      /**
21       * @param textArea area where to write
22       * @example
23       * <pre name="test">
24       * #import java.io.*;
25       * #import javax.swing.*;
26       *   JTextArea text = new JTextArea();
27       *   PrintStream tw = new PrintStream(new TextAreaOutputStream(text));
28       *   tw.print("Hello");
29       *   tw.print(" ");
30       *   tw.print("world!");
31       *   tw.flush();
32       *   text.getText() === "Hello world!";
33       *   text.setText("");
34       *   tw.println("Hello");
35       *   tw.println("world!");
36       *   text.getText() =R= "Hello\\r?\\nworld!\\r?\\n";
37       * </pre>
38       */
      public TextAreaOutputStream(@SuppressWarnings("hiding") final JTextArea textArea) {
          this.textArea = textArea;
      }



      @Override
      public void write(int b) throws IOException {
          /*
47          if (b == '\r')
48              return;
49
50          if (b == '\n') {
51              textArea.append(sb.toString()+"\n");
52              sb.setLength(0);
53              return;
54          }
55
56          sb.append((char)b);
57           */
          //textArea.append(Character.toString((char)b));
          write(new byte[] {(byte) b}, 0, 1);
     }

     @Override
      public void write(byte b[], int off, int len) throws IOException {
         textArea.append(new String(b, off, len));
      }


      /**
      * Factory method for creating a PrintStream to print to selected TextArea
      * @param textArea area where to print
       * @return created PrintStream ready to print to TextArea
       * @example
       * <pre name="test">
74       * #import java.io.*;
75       * #import javax.swing.*;
76       *   JTextArea text = new JTextArea();
77       *   PrintStream tw = TextAreaOutputStream.getTextPrintStream(text);
78       *   tw.print("Hyvää"); // skandit toimi
79       *   tw.print(" ");
80       *   tw.print("päivää!");
81       *   text.getText() === "Hyvää päivää!";
82       *   text.setText("");
83       *   tw.print("ä");
84       *   text.getText() === "ä";
85       * </pre>
86       */
      public static PrintStream getTextPrintStream(JTextArea textArea) {
          return new PrintStream(new TextAreaOutputStream(textArea)); //,true,"ISO-8859-1");
      }

  }
