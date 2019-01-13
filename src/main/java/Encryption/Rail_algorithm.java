package main.java.Encryption;

public class Rail_algorithm {

    //https://www.youtube.com/watch?v=cvCpYP-Cjnk&t=243s

    public Rail_algorithm(String text, int key, int position) {
        this.clearText=text;
        this.key=key;
        this.position=position;

        if(position>key)
        {
            position=key;
        }
    }


    int key;
    int position;
    String clearText = "";

    public String buildStringFromMatrix(char[][] matrix) {
        String result = "";

        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[row].length; col++)
            {
                if (matrix[row][col] != '\0')
                {
                    result += matrix[row][col];
                }
            }
        }

        return result;
    }

    public char[][] transpose(char[][] matrix) {
        char[][] result = new char[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[row].length; col++)
            {
                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }

    public String Cipher() {

        String result = "";

        char[][] matrix = new char[key][clearText.length()];

        int rowIncrement = 1;
        for (int row = 0, col = 0; col < matrix[row].length; col++) {

            if (row + rowIncrement == matrix.length || row + rowIncrement == -1)
            {
                rowIncrement *= -1;
            }

            matrix[row][col] = clearText.charAt(col);
            row += rowIncrement;
        }

        result = buildStringFromMatrix(matrix);

        return result;
    }

    public String Decipher() {

        String cipherText = Cipher();
        String result = "";

        char[][] matrix = new char[key][cipherText.length()];

        int rowIncrement = 1;
        int textIdx = 0;

        for (
                int selectedRow = 0;
                selectedRow < matrix.length;
                selectedRow++
        )
        {
            for (
                    int row = 0, col = 0;
                    col < matrix[row].length;
                    col++
            )
            {
                if (
                        row + rowIncrement == matrix.length ||
                                row + rowIncrement == -1
                )
                {
                    rowIncrement *= -1;
                }

                if (row == selectedRow) {

                    matrix[row][col] = cipherText.charAt(textIdx++);
                }

                row += rowIncrement;
            }
        }

        matrix = transpose(matrix);
        result = buildStringFromMatrix(matrix);

        return result;
    }


}
