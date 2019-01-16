package main.java.Encryption;

public class Rail_algorithm {

    //https://www.youtube.com/watch?v=cvCpYP-Cjnk&t=243s

    public Rail_algorithm(String text, int key, int position) {
        this.clearText=text;
        this.key=key;
        this.position=position -1;

    }


    int key;
    int position;
    String clearText = "";

    public String buildStringFromMatrix(char[][] matrix) {
        String result = "";

        for (int row = 0; row < matrix.length; row++)                                   //row = 0;
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


    public void ShowArray(char[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
            //    System.out.print(matrix[i][j] + "[" + i + "][" + j + "]   ");
              System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }

    }

    public char[][] transpose(char[][] matrix) {
        char[][] result = new char[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++)                               // row = 0
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
        for (int row = position, col = 0; col < matrix[row].length; col++) {   // int row = 0; !!!!!!!!!!!!!!!!!!!!!!!!!!

            if (row + rowIncrement == matrix.length || row + rowIncrement == -1)
            {
                rowIncrement *= -1;
            }

            matrix[row][col] = clearText.charAt(col);
            row += rowIncrement;
        }

        result = buildStringFromMatrix(matrix);

        //ShowArray(matrix);

        return result;
    }

    public String Decipher(String cipherText) {

        String result = "";

        char[][] matrix = new char[key][cipherText.length()];

        int rowIncrement = 1;
        int textIdx = 0;

        for(int i=0, j=position; i<cipherText.length(); i++)
        {
            matrix[j][i]='0';
            if ( j + rowIncrement == key || j + rowIncrement == -1 )
            {
                rowIncrement *= -1;
            }
            j+=rowIncrement;
        }



        for(int i=0 ;i<key;i++)
        {
            for(int j=0;j<cipherText.length();j++)
            {
                if(matrix[i][j]=='0')
                {
                   matrix[i][j]= cipherText.charAt(textIdx++);
                }
            }
        }



        //ShowArray(matrix);


        matrix = transpose(matrix);
        result = buildStringFromMatrix(matrix);

        return result;
    }


}
