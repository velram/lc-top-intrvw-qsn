package com.leetcode.practice.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vel
 * @date 04.08.2022
 *
 * Problem URL : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 * Problem name : Valid sudoku
 *
 */
public class ValidSudokuDriver {
    public static void main(String[] args) {

        char[][] board = {
                             {'8','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}
        };


        ValidSudokuFinder validSudokuFinder = new ValidSudokuFinder();
        System.out.println("isValid sudoku : " + validSudokuFinder.isValidSudoku(board));

    }
}

class ValidSudokuFinder {
    public boolean isValidSudoku(char[][] board) {

        Set sudokuValueSeen = new HashSet();

        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                char currentValue = board[row][column];
                if('.' != currentValue){
                    if(!sudokuValueSeen.add(currentValue + " in row " + row) ||
                       !sudokuValueSeen.add(currentValue + " in column " + column) ||
                       !sudokuValueSeen.add(currentValue + " in block " + (row / 3) + "-" + (column / 3))){

                        return false;
                    }
                }
            }
        }

        return true;
    }
}