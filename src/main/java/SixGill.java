import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.text.html.parser.*;

public class SixGill {
    public static void main(String[] args) throws IOException {


        try {



            BufferedReader buff=null;
            parseName(buff);

        }
        catch (ProtocolException e) {

                e.printStackTrace();

            }


    }


      public static void parseName( BufferedReader buff) throws IOException {


        TreeMap<String, Integer> map = new TreeMap<>();

        StringBuilder out =null;
          String currLine=null;
          String first=null;
          String last=null;
          Integer value;
          String prefix="Generate</button></div></form><hr><h2>";
          String postFix= "</h2>";
          HttpURLConnection conn;



          for (int i =0; i<100; ++i) {
              URL url = new URL("https://www.namefake.com");
              conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");
              buff= new BufferedReader(new InputStreamReader(conn.getInputStream()));
              currLine=null;
              out=new StringBuilder();


               while ((currLine = buff.readLine()) != null) {
                   out.append(currLine);

               }

               String subOut = out.substring(out.indexOf(prefix) + prefix.length(), out.indexOf(postFix));
               first = subOut.split(" ")[0];
               last = subOut.split(" ")[1];

               if ((value = map.get(first)) != null) {
                   map.put(first, ++value);
               } else {
                   map.put(first, 1);
               }

               if ((value = map.get(first)) != null) {
                   map.put(last, ++value);
               } else {
                   map.put(last, 1);
               }

               conn.disconnect();

              System.out.println(first + " " + last);

           }

    }

}
