/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author 1320100069
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Weight[] v;
        int element;
        int max_weight;
        Knapsack kp = new Knapsack();
        try 
        {
            BufferedReader br = null;

            String sCurrentLine;

            br = new BufferedReader(new FileReader("knapsack.txt"));
            Scanner k = new Scanner(br);
            element = Integer.parseInt(k.nextLine());
            max_weight = Integer.parseInt(k.nextLine());

            v = new Weight[element + 1];
            v[0] = new Weight(0, 0);

            for (int i = 1; i < v.length; i++) 
            {

                sCurrentLine = k.nextLine();
                StringTokenizer token = new StringTokenizer(sCurrentLine, " ");
                while (token.hasMoreTokens())
                {
                    int a = Integer.parseInt(token.nextToken());
                    int b = Integer.parseInt(token.nextToken());
                    v[i] = new Weight(a, b);

                }
            }
            System.out.println("Total Benefit : "+kp.knapsack(v, element+1, max_weight+1));

        } 
        catch (IOException e) 
        {
            System.out.println("File not found");
        }
    }
    
    
}
