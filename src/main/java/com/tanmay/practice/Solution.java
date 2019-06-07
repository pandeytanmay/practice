package com.tanmay.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {



    // Complete the countSpecialElements function below.
    static int countSpecialElements(List<List<Integer>> matrix) {
        int[] rowMaxArr = new int[matrix.size()];
        int[] rowMinArr = new int[matrix.size()];
        int[] columnMaxArr = new int[matrix.get(0).size()];
        int[] columnMinArr = new int[matrix.get(0).size()];
        int r = matrix.size();

        for(int i = 0; i < r; i++) {
            int c = matrix.get(i).size();
            int rowMin = Integer.MAX_VALUE;
            int rowMax = -1;
            int colMin = Integer.MAX_VALUE;
            int colMax = -1;
            for(int j = 0; j < c; j++ ) {
                if (j !=0)
                    if (matrix.get(i).get(j) == rowMax || matrix.get(i).get(j) == rowMin )
                        return -1;
                if (i != 0)
                    if (matrix.get(j).get(i) == colMax || matrix.get(j).get(i) == colMin)
                        return -1;
                if (matrix.get(i).get(j) > rowMax)
                    rowMax = matrix.get(i).get(j);
                if (matrix.get(i).get(j) < rowMin)
                    rowMin = matrix.get(i).get(j);
                if (matrix.get(j).get(i) > colMax)
                    colMax = matrix.get(i).get(j);
                if (matrix.get(j).get(i) < colMin)
                    colMin = matrix.get(i).get(j);
            }
            rowMinArr[i] = rowMin;
            rowMaxArr[i] = rowMax;
            columnMaxArr[i] = colMax;
            columnMinArr[i] = colMin;

        }
        int count = 0;
        for(int i = 0; i < r; i++) {
            int c = matrix.get(i).size();
            for(int j = 0; j < c; j++ ) {
                int elem = matrix.get(i).get(j);
                if ( elem == rowMaxArr[i]
                        || elem == rowMinArr[i]
                        || elem == columnMaxArr[j]
                        || elem == columnMinArr[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, matrixRows).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = countSpecialElements(matrix);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

