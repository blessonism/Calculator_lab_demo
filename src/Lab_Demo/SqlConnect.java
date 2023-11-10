/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Lab_Demo;

import java.sql.*;
import static Lab_Demo.connect.DB_URL;
import static Lab_Demo.connect.JDBC_DRIVER;
import static Lab_Demo.connect.PASS;
import static Lab_Demo.connect.USER;
/**
 *
 * @author z4638
 */
public class SqlConnect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/calculator_test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String DB_URL = "jdbc:mysql://localhost/calculator_test";
    static final String USER = "root";
    static final String PASS = "123456";
    
    
    // 插入数据到database：calculator_test， table：calculatetest
    public void passSQL(int number1, int number2){
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");

           //STEP 4: Execute a query
           System.out.println("Inserting records into the table...");
           stmt = conn.createStatement();

           String sql = "INSERT INTO calculatetest (number1, number2) VALUES (" + number1 + "," + number2 + ")";
           
           stmt.executeUpdate(sql);
          
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
    
    // 提取dababase：database：calculator_test， table：calculatetest中的第一串数据
    public int[] findNum() {
        Connection conn = null;
        Statement stmt = null;
        int num1 = 0;
        int num2 = 0;
                
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("Connecting db...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println("Instantiate Statement object...");
            stmt = conn.createStatement();
            String sql = "SELECT number1, number2 FROM calculatetest";
            //sql = "INSERT INTO billing (BillID, ElderlyID, Date, Item, Amount, Status) VALUES (31, 1, 2023-11-21, test, 20.00, Paid)";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            num1  = rs.getInt("number1");
            num2  = rs.getInt("number2");
    
            // 输出数据
            System.out.print("number1: " + num1);
            System.out.print(", number2: " + num2);
            System.out.println("");
            controlor ct = new controlor();
            System.out.println("res : " + ct.add(num1, num2));

            
            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                int number1  = rs.getInt("number1");
//                int number2  = rs.getInt("number2");
//    
//                // 输出数据
//                System.out.print("number1: " + number1);
//                System.out.print(", number2: " + number2);
//                System.out.print("\n");
//            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("");
        System.out.println("Goodbye!");
        
        return new int[]{num1, num2};
    }
    
}
