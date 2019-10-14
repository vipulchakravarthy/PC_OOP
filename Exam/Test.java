

import java.io.*;
import java.util.*;
class Test{
	 public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Network.txt"));
        StringBuffer sb = new StringBuffer();
        while(scan.hasNext()) {
            sb.append(scan.nextLine() + ";");
        }
        String s = sb.toString();
        s = s.substring(0, sb.length()-1);
        int count = 0;
        SocialNetwork network = new SocialNetwork();
        network.createDataStructure(s);
      }
}
