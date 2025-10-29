/*
WhitespaceAfter
tokens = RBRACK


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.whitespaceafter;

public class InputWhitespaceAfterRightBracket {
    int[]arrBad; // violation '']' is not followed by whitespace'
    int[] arrOk;
    int[][]matrixBad; // violation '']' is not followed by whitespace'
    int[][] matrixOk;
    int[][][]cubeBad; // violation '']' is not followed by whitespace'
    int[][][] cubeOk;
    void arrOperation() {
        int[] arr = {1};
        arr[0]++;
        arr[0] ++;
        arr[0] = arr[0]+ 1; // violation ''+' is not followed by whitespace'
        arr[0] = arr[0] + 1;
        arr[0]= 1; // violation ''=' is not followed by whitespace'
        arr[0] = 1;
    }
}
