import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
      System.out.println("Welcome to the lyrics checker!");
      System.out.println("What song do you want to fix? Choose a file: >couchpotato >dayone >hello >custom");
      Scanner sc = new Scanner(System.in);
      String filename = sc.nextLine();
      filename = filename + ".txt";
//reading things
      BufferedReader lyr = new BufferedReader(new FileReader(filename));
      BufferedReader wrds = new BufferedReader(new FileReader("taboowords.txt"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fixedlyrics.out")));
      

      int counter = 0; 
      int linecounter = 0;
      int cases = 0;

      while (lyr.readLine() != null) {
        linecounter++;
      }
      while (wrds.readLine() !=null) {
        cases++;
      }
      lyr = new BufferedReader(new FileReader(filename));
      


      // actual code
        for (int lyrnum = 0; lyrnum < linecounter; lyrnum++) {
          String line = lyr.readLine();
          String [] linearray = line.split(" ");
          wrds = new BufferedReader(new FileReader("taboowords.txt"));
          
          
          for (int i = 0; i < cases; i++) {
            String word=wrds.readLine();
            int len = word.length();
            
            String replacer="";
            for (int j =0; j < len; j++) {
              replacer = replacer + "*";
            }
            int numwords=linearray.length;
            for (int j = 0; j < numwords; j++) {
              if ((linearray[j].toUpperCase()).equals(word.toUpperCase())) {
                counter++;
                linearray[j] = replacer;
              }
            }
            line = String.join(" ", linearray);
            /*if (line.contains(word)) {
              String tempWord = word + " "; 
              line = line.replaceAll(tempWord, replacer + " ");
              tempWord = " " + word; 
              line = line.replaceAll(tempWord, " " + replacer);
            }*/
          }
          out.println(line);
        }
    
    System.out.println("Check the files for the fixed lyrics! " + counter + " words were removed.");
    System.out.println("Here's your lyrics:");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    out.close();
    wrds.close();
    lyr.close();

    BufferedReader br = new BufferedReader(new FileReader("fixedlyrics.out"));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
}
}
