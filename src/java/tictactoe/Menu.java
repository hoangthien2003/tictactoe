/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Menu extends ArrayList<String> implements InterfaceMenu{

    @Override
    public void addChoice(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        return Utils.getInt("Input choice: ", 1, this.size());
    }
    
    @Override
    public void showMenu(){
        for(int i=0; i<this.size(); i++){
            System.out.println(this.get(i));
        }
    }
    
    @Override
    public boolean confirm(String text, String condition){
        boolean result=false;
        String confirm=Utils.getString(text);
        if(confirm.equalsIgnoreCase(condition)){
            result=true;
        }
        return result;
    }
}
