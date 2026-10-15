/*
*@Author-Blake Bouvier
**/

import java.util.Scanner;

public class mineSweeper_BB {


    static StringBuilder input = new StringBuilder();

    static int rows;
    static int cols;

    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();

        rows =  Integer.parseInt(temp.charAt(0)+"");
        cols = Integer.parseInt(temp.charAt(2)+"");

        temp = sc.nextLine();
        while (!temp.contains("0 0")) {
            input.append(temp);
            input.append('\n');
            temp = sc.nextLine();
        }


        char t;
        for(int i = 0; i < input.length(); i++) {

            t=input.charAt(i);
            if(t=='\n' && i<input.length()-2){
                output.append('\n');
            }

            if (t == '*') {
                output.append(t);
            } else if (t == '.') {
                output.append(getMineCount(i));
            }

        }
        System.out.println(output.toString());

    }

    private static int getMineCount(int index){
        int mineCount = 0;

        int left = (index-1);
        int right = (index+1);
        int up = (index-(cols+1));
        int down = (index+(cols+1));
        int[] adjacentSpaces = {up-1,up,up+1,left,right,down-1,down,down+1};


        for(int i: adjacentSpaces){
            if(i<0 || i>=input.length()){

            } else if(input.charAt(i)=='*'){
                mineCount++;
            }

        }
        return mineCount;
    }



}

