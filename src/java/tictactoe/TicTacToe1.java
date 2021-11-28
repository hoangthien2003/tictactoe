/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class TicTacToe1 extends InterfaceTictactoe {

    public static void main(String[] args) {
        Menu playerTurn = new Menu();
        //turn 1: X (1st), 0: O (2nd)
        //matrix value: nothing - 2; X - 3; O - 5
        // 0 1 2
        // 3 4 5
        // 6 7 8
        playerTurn.add("1. Player first.");
        playerTurn.add("2. Computer first.");
        playerTurn.add("3. Exit.");
        playerTurn.showMenu();
        int matrix[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int player, computer;
        int winFlag;
    //~turn => 1: X win, 0: O win, 2: draw
        int choice = playerTurn.getChoice();
        switch (choice) {
            case 1:
                player = 1;
                computer = 0;
                break;
            case 2:
                player = 0;
                computer = 1;
                break;
            case 3:
                break;
        }
    }
//day la cac function van hanh(chua hoan thien)
//gio minh can lam cac function hien thi

    public static void changeStatus(int[] matrix, int position, int turn) {
        if (turn == 1) {
            matrix[position] = 3;
        } else {
            matrix[position] = 5;
        }
    }

    public static int checkMove(int[] matrix, int turn) {
        int check = 0, position = -1, i;
        if (turn == 1) {
            check = 18;
        } else if (turn == 0) {
            check = 50;
        }
        //row
        i = 0;
        while (i < 9) {
            if (matrix[i] * matrix[i + 1] * matrix[i + 2] == check) {
                if (matrix[i] == 2) {
                    position = i;
                } else if (matrix[i + 1] == 2) {
                    position = i + 1;
                } else {
                    position = i + 2;
                }
                break;
            }
            i += 3;
        }
        //column
        i = 0;
        while (i < 3) {
            if (matrix[i] * matrix[i + 3] * matrix[i + 6] == check) {
                if (matrix[i] == 2) {
                    position = i;
                } else if (matrix[i + 3] == 2) {
                    position = i + 3;
                } else {
                    position = i + 6;
                }
                break;
            }
            i++;
        }
        //diagonal
        if (matrix[0] * matrix[4] * matrix[8] == check) {
            if (matrix[0] == 2) {
                position = 0;
            } else if (matrix[4] == 2) {
                position = 4;
            } else {
                position = 8;
            }
        }
        if (matrix[2] * matrix[4] * matrix[6] == check) {
            if (matrix[2] == 2) {
                position = 2;
            } else if (matrix[4] == 2) {
                position = 4;
            } else {
                position = 6;
            }
        }
        return position;
    }

    public static void createRandomMove(int[] matrix, int computer) {
        Random rand = new Random();
        int position;
        boolean check = true;
        do {
            position = rand.nextInt(9);
            if (matrix[position] == 2) {
                changeStatus(matrix, position, computer);
                check = false;
            }
        } while (check);
    }

    public static int createOptimalMove(int[] matrix, int computer, int player) {
        int position = -1;
        if (checkMove(matrix, computer) != -1) {
            position = checkMove(matrix, computer);
            //cho flag khi biet thang nua
            changeStatus(matrix, position, computer);
        } else if (checkMove(matrix, player) != -1) {
            position = checkMove(matrix, player);
            changeStatus(matrix, position, player);
        } else {
            createRandomMove(matrix, computer);
        }
        return position;
    }
    
    public static boolean checkDraw(int[] matrix){
        boolean check=true;
        for(int i: matrix){
            if(i==2){
                check=false;
                break;
            }
        }
        return check;
    }

    public static int playerTurn(int[] matrix, int player) {
        int position, winFlag=-1;
        boolean check = true;
        do {
            position = Utils.getInt("Input position [0-8]: ", 0, 8);
            if (matrix[position] == 2) {
                if(checkMove(matrix, position)==position){
                    winFlag=player;
                }
                changeStatus(matrix, position, player);
                check = false;
            }
        } while (check);
        return winFlag;
    }
    //chưa có trường hợp hòa
    
//hien thi
    public static void drawBoard(int[] matrix){
        for(int i=0; i<9; i++){
            switch (matrix[i]) {
                case 2:
                    System.out.println("  |");
                    break;
                case 3:
                    System.out.println("X |");
                    break;
                default:
                    System.out.println("O |");
                    break;
            }
            if((i+1)%3==0){
                System.out.println("_________");
            }
        }
    }
}
