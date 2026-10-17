// ELi Labrador
// Minesweeper.java reads minefields, then prints each out again with hints.

import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int fieldNumber = 0;

        while (scanner.hasNextInt()) {

            // Number of rows and columns
            int countRows = scanner.nextInt();
            int countColumns = scanner.nextInt();
            

            // Field is 0x0 = End of input
            if (countRows == 0 && countColumns == 0) {
                break;
            }

            // Read each row into a grid...
            char[][] field = new char[countRows][];
            for (int row = 0; row < countRows; row++) {
                field[row] = scanner.next().toCharArray();
            }
            

            // Print a blank line between fields, but not before the first one
            fieldNumber++;
            if (fieldNumber > 1) {
                output.append("\n");
            }

            // This prints "Field #X:" then a new line
            output.append("Field #").append(fieldNumber).append(":\n");


            // In each row, replace safe square with mine count
            for (int row = 0; row < countRows; row++) {
                for (int column = 0; column < countColumns; column++) {
                    if (field[row][column] == '*') {
                        output.append('*');

                    } else {

                        int mineCount = countAdjacent(field, row, column);
                        output.append(mineCount);

                    }
                }
                output.append("\n");
            }
        }

        System.out.print(output);
    }

    // Counts the mines from each square around the focused square.
    private static int countAdjacent(char[][] field, int row, int column) {
        int mineCount = 0;

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {

                int neighborRow = row + rowOffset;
                int neighborColumn = column + columnOffset;

                boolean isInsideField = neighborRow >= 0
                        && neighborRow < field.length
                        && neighborColumn >= 0
                        && neighborColumn < field[neighborRow].length;

                if (isInsideField && field[neighborRow][neighborColumn] == '*') {
                    mineCount++;
                }
            }
        }

        return mineCount;

    }
}