
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramos
 */
public class Test {
    
    public static void main(String[]args)
    {
        int value = 0;
        int modulo = 0;
        
        while(value > 0)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Value: ");
            value = in.nextInt();
            
            modulo = value % 10;
        }
                    
            System.out.println(modulo);
            
    }
    
}
