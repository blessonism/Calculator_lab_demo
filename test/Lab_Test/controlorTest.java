/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Lab_Test;

import Lab_Demo.controlor;
import Lab_Demo.SqlConnect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author z4638
 */
public class controlorTest {
    
    controlor ct = new controlor();
    SqlConnect con = new SqlConnect();

    @BeforeAll
    public static void BeforeAll() {
        System.out.println("This is sql connect");
    }
    public controlorTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testAdd() {
        int[] arr = con.findNum();
        assertEquals(23, ct.add(arr[0], arr[1]));
        
    }
    
}
