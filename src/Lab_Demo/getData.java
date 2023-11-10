/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab_Demo;

import Lab_Demo.SqlConnect;
import java.util.Scanner;

/**
 *
 * @author z4638
 */
public class getData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        controlor control = new controlor();
        SqlConnect sqlConnect = new SqlConnect();
             
//        int number1 = sc.nextInt();
//        int number2 = sc.nextInt();
//   
//        int res = control.add(number1, number2);
//        sqlConnect.passSQL(number1, number2);

        sqlConnect.findNum();
        
        
        
    }
    
   
}
