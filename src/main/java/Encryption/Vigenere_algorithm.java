package main.java.Encryption;

import java.util.stream.IntStream;

public class Vigenere_algorithm {

    private static String clearText;
    private static String keyword;
    char[] alphabet;
    char[][] tabulaRecta;

        public Vigenere_algorithm(String keyword, String clearText)
        {
            this.keyword=keyword;
            this.clearText=clearText;


            alphabet = alphabet = new MyCharStream().concat(IntStream.range('a', 'z' + 1)).toArray();

            tabulaRecta = new char['z' - 'a' + 1][];
            for (int i = 0; i < tabulaRecta.length; i++) {

                tabulaRecta[i] = alphabet.clone();
                shift(alphabet);
            }
        }





    private static class MyCharStream {

        private IntStream stream;

        public MyCharStream() {
            stream = IntStream.range(0, 0);
        }

        public MyCharStream concat(IntStream s) {

            this.stream = IntStream.concat(this.stream, s);
            return this;
        }

        public MyCharStream concat(int[] s) {

            return this.concat(IntStream.of(s));
        }

        public MyCharStream concat(char[] s) {

            int[] sInt = new int[s.length];
            for (int i = 0; i < s.length; i++) {

                sInt[i] = s[i];
            }

            return this.concat(sInt);
        }

        public char[] toArray() {

            char[] result = null;

            int[] intArray = this.stream.toArray();

            result = new char[intArray.length];
            for (int i = 0; i < intArray.length; i++) {

                result[i] = (char)intArray[i];
            }

            return result;
        }
    }


    private static void shift(char[] alphabet) {

        char first = alphabet[0];

        for (int i = 0; i < alphabet.length - 1; i++) {

            alphabet[i] = alphabet[i + 1];
        }

        alphabet[alphabet.length - 1] = first;
    }


    private static String growToTextSize(int length, String textKey) {

        String result = textKey;

        int idx = 0;
        while (result.length() < length) {

            result += textKey.charAt(idx++);

            if (idx >= textKey.length()) {

                idx = 0;
            }
        }
        return result;
    }

    private static char[][] transposeMatrix(char[][] matrix) {

        char[][] result = new char[matrix[0].length][];

        for (int i = 0; i < result.length; i++) {

            result[i] = new char[matrix.length];
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }

    private static int indexOf(char[] array, char toFind) {

        int result = -1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == toFind) {

                result = i;
                break;
            }
        }

        return result;
    }

    public String DecipherOpposite(String cipherText)
    {
        String result = "";
        cipherText = cipherText.toLowerCase();
        keyword = growToTextSize(cipherText.length(), keyword);
        char newKey[] = new char[keyword.length()];

        tabulaRecta = transposeMatrix(tabulaRecta);

        for(int i=0;i<keyword.length();i++)
        {
            newKey[i]= (char)((((26-(keyword.charAt(i)))%26)*(-1))+97);
        }



        return CipherOpposite(new String(newKey), cipherText);
    }

    public String CipherOpposite(String key, String textToDecipher) {
        String result = "";
        key.toLowerCase();
        for (int i = 0; i < textToDecipher.length(); i++) {

            int row = textToDecipher.charAt(i) - 'a';
            int col = key.charAt(i) - 'a';

            result += tabulaRecta[row][col];
        }

        return result;
    }

    public String CipherAutoKey() {
        String result = "";
        keyword += clearText.substring(0,clearText.length()-1);

        for (int i = 0; i < clearText.length(); i++) {

            int row = clearText.charAt(i) - 'a';
            int col = keyword.charAt(i) - 'a';

            result += tabulaRecta[row][col];

        }

        return result;
    }

    public String DecipherAutoKey(String cipherText) {
        String result = "";
        cipherText = cipherText.toLowerCase();
        tabulaRecta = transposeMatrix(tabulaRecta);

        for (int i = 0; i < cipherText.length(); i++) {
            char toshow = keyword.charAt(i);
            int row = keyword.charAt(i) - 'a';
            int col = indexOf(tabulaRecta[row], cipherText.charAt(i));

            result += tabulaRecta[0][col];
            keyword += Character.toString(tabulaRecta[0][col]);
        }

        return result;
    }

    public String Cipher() {
        String result = "";

        keyword = growToTextSize(clearText.length(), keyword);

        for (int i = 0; i < clearText.length(); i++) {

            int row = clearText.charAt(i) - 'a';
            int col = keyword.charAt(i) - 'a';

            result += tabulaRecta[row][col];
        }

        return result;
    }

    public String Decipher(String cipherText)
    {
        String result = "";
        cipherText = cipherText.toLowerCase();
        keyword = growToTextSize(cipherText.length(), keyword);
        tabulaRecta = transposeMatrix(tabulaRecta);

        for (int i = 0; i < cipherText.length(); i++) {
            char toshow = keyword.charAt(i);
            int row = keyword.charAt(i) - 'a';
            int col = indexOf(tabulaRecta[row], cipherText.charAt(i));

            result += tabulaRecta[0][col];
        }

        return result;
    }
















}
