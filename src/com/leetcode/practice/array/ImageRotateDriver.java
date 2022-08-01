package com.leetcode.practice.array;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 01.08.2022
 *
 * Problem Name : Rotate Image
 * Question link : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 *
 * Problem description : Rotate a given matrix of size (n * n) - 90Deg (clock-wise)
 *
 */
public class ImageRotateDriver {
    public static void main(String[] args) {

        ImageRotator imageRotator = new ImageRotator();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; //Test case #1
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}; //Test case #
//        int[][] matrix = {{}}; //Test case #
//        int[][] matrix = {{}}; //Test case #
//        int[][] matrix = {{}}; //Test case #
        imageRotator.rotate(matrix);
        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(" " + element + " "));
            System.out.println();
        });
    }
}

class ImageRotator {
    public void rotate(int[][] matrix) {

        findTranspose(matrix);
        swapColumns(matrix);

    }

    private void swapColumns(int[][] matrix) {
        int row = 0;
        int startColumn = 0;
        int endColumn = matrix.length - 1;
        while(row < matrix.length){
            if(startColumn < endColumn){
                int temp = matrix[row][startColumn];
                matrix[row][startColumn] = matrix[row][endColumn];
                matrix[row][endColumn] = temp;
                startColumn++;
                endColumn--;
                continue;
            }
            row++;
            startColumn = 0;
            endColumn = matrix.length - 1;
        }
    }

    private void findTranspose(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++){
            for(int column = row + 1; column < (matrix.length); column++){
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
    }
}