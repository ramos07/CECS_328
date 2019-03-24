
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramos
 */
public class Driver {
    public static void main(String[]args){
        double [] x = {1.34, 1.45, 2.56, 2.16, 5.12, 2.25};
        int n = 7;
        int probe=0;
        double [] h_x = new double[x.length];
        double [] index = new double[x.length];
        double [] H_x = new double[x.length];
        
        for(int i=0; i < x.length; i++){
            h_x[i] = Math.floor(x[i]) % n;
            index[i] = h_x[i] % n;
            H_x[i] = (index[i] + probe++) % n;
        }
        
        System.out.println(Arrays.toString(h_x));
        System.out.println(Arrays.toString(index));
        System.out.println(Arrays.toString(H_x));
    }
}
