/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Utils {
    public static int getInt(String text){
        int result=0;
        boolean check=true;
        Scanner scanner = new Scanner(System.in);
        String tmp="";
        do{
            try {
                System.out.println(text);
                tmp=scanner.nextLine();
                if(!tmp.isEmpty()){
                    result=Integer.parseInt(tmp);
                    check=false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }while(check);
        return result;
    }
    
    public static int getInt(String text, int min, int max){
        int result=0;
        boolean check=true;
        Scanner scanner = new Scanner(System.in);
        String tmp="";
        do{
            try {
                System.out.println(text);
                tmp=scanner.nextLine();
                if(!tmp.isEmpty()){
                    result=Integer.parseInt(tmp);
                    check=false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }while(check || result<min || result>max);
        return result;
    }
    
    public static String getString(String text){
        String result="";
        Scanner scan= new Scanner(System.in);
        do{
            try {
                System.out.println(text);
                result=scan.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }while(result.isEmpty());
        return result;
    }
}
