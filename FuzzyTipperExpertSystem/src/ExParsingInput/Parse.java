/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExParsingInput;
//package url.checker;
import static java.lang.Integer.parseInt;
        import java.util.Scanner;

        public class Parse 
        {
            
//          static String[] s = new String[10];  
             static int s;
            
            
//          static String s;
//          static String result[];

          public static void GetInput(String s)
          {
            int i;

////            for(i=0;i<3;i++)
////            {
////              if (s.startsWith("-url="))
////                result[0] = s.substring(5, s.length());
////              else if (s.startsWith("-time="))
////                result[1] = s.substring(6, s.length());
////              else if (s.startsWith("-email="))
////                result[2] = s.substring(7, s.length());
////              else
////                System.out.println("You didn't give any input.");
////            }
              System.out.println("Results");
               System.out.println(parseInt(s)*2);
          }
        }
