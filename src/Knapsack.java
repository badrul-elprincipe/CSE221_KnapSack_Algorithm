/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1320100069
 */
public class Knapsack {
        public int knapsack(Weight[] a, int num, int max){
        
        int[][] v = new int[num][max];
        for (int i = 0; i < num; i++) 
        {
            v[i][0] = 0;
        }
        for (int i = 0; i < max; i++)
        {
            v[0][i] = 0;
        }
        for (int i = 1; i < num; i++) 
        {
            for (int j = 1; j < max; j++)
            {
                if (a[i].we <= j) 
                {
                    if (a[i].va + v[i - 1][j - a[i].we] > v[i - 1][j])
                    {
                        v[i][j] = a[i].va + v[i - 1][j - a[i].we];
                    } 
                    else 
                    {
                        v[i][j] = v[i - 1][j];
                    }
                } 
                else 
                {
                    v[i][j] = v[i - 1][j];
                }
            }
        }


        element(v, a, num - 1, max - 1);
        return v[num - 1][max - 1];

    }

    public void element(int[][] a, Weight[] b, int c, int d) 
    {
        int i = c;
        int j = d;
        int[] x = new int[c + 1];
        while (i > 0 && j > 0)
        {

            if (a[i][j] != a[i - 1][j]) 
            {
                x[i] = i;
                j = j - b[i].we;
                i = i - 1;
            } 
            else
            {
                i = i - 1;
            }
        }
        
        
        System.out.println("Knapsack Table");
        for (int u = 0; u < c+1; u++)
        {
            for (int v = 0; v < d+1; v++) 
            {
                System.out.print(a[u][v] + "    ");
            }
            System.out.println();
            
        }
        System.out.print("Selected Items : ");
        
        for(int k = 0; k < c+1; k++)
        {
            if (x[k] != 0)
            {
                System.out.print(k + " ");
            }
        }
        System.out.println();
 
    }
}
