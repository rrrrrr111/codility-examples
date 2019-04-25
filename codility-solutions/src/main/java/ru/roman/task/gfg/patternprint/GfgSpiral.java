package ru.roman.task.gfg.patternprint;

/**
 *
 */
class GfgSpiral {
    public static void main(String[] args) {

        int size = 5;
        printSpiral(size);
    }

    private static void printSpiral(int size) {

        // Create r and c
        // to traverse rows and columns
        int r = 0, c = 0;

        int boundary = size - 1;
        int sizeLeft = size - 1;
        int flag = 1;

        // Variable to determine the movement
        // r = right, l = left, d = down, u = upper
        char move = 'r';

        // Array  for matrix
        int matrix[][] = new int[size][size];

        for (int i = 1; i < size * size + 1; i++) {

            // Assign the value
            matrix[r][c] = i;

            // switch-case to determine the next index
            switch (move) {

                // If right, go right
                case 'r':
                    c += 1;
                    break;

                // if left, go left
                case 'l':
                    c -= 1;
                    break;

                // if up, go up
                case 'u':
                    r -= 1;
                    break;

                // if down, go down
                case 'd':
                    r += 1;
                    break;
            }

            // Check if the matrix
            // has reached array boundary
            if (i == boundary) {

                // Add the left size for the next boundary
                boundary += sizeLeft;

                // If 2 rotations has been made,
                // decrease the size left by 1
                if (flag != 2) {

                    flag = 2;
                } else {

                    flag = 1;
                    sizeLeft -= 1;
                }

                // switch-case to rotate the movement
                switch (move) {

                    // if right, rotate to down
                    case 'r':
                        move = 'd';
                        break;

                    // if down, rotate to left
                    case 'd':
                        move = 'l';
                        break;

                    // if left, rotate to up
                    case 'l':
                        move = 'u';
                        break;

                    // if up, rotate to right
                    case 'u':
                        move = 'r';
                        break;
                }
            }
        }

        // Print the matrix
        for (r = 0; r < size; r++) {
            for (c = 0; c < size; c++) {
                int n = matrix[r][c];
                System.out.print((n < 10) ? n + "  " : n + " ");
            }
            System.out.println();
        }
    }
}
