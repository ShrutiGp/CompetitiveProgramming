public class Corpus {

    static int findCorpusCount(String wordToBeFound, String wordToCompare,String[] strings) {
        int count = 0;
        for (int i = 0 ; i  < strings.length; i++) {
            String[] words = strings[i].split(" ");
            for(int j = 0 ; j < words.length; j++) {
                if(words[j].equals(wordToBeFound)) {
                    if(j+1 < words.length && words[j+1].equals(wordToCompare)) {
                        count++;
                    }
                    if(j+2 < words.length && words[j+2].equals(wordToCompare)) {
                        count++;
                    }
                    if(j-1 >= 0 && words[j-1].equals(wordToCompare)) {
                        count++;
                    }
                    if(j-2 >= 0 && words[j-2].equals(wordToCompare)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static void getArray(String findWord, String[] topWords, String[] strings) {
        int arr[] = new int[topWords.length];
        for(int j = 0 ; j < strings.length; j++) {
            String myString = strings[j];
            String[] words = myString.split(" ");
            for(int i )
        }
    }

    public static void main(String[] args) {
        String[] strings = {"ABC DEF IJK PQR", "PQR KLM OPQ", "LMN PQR XYZ ABC DEF PQR ABC"};
        String[] topWords = {"ABC", "PQR", "DEF"};

        for(int i = 0 ; i < topWords.length; i++) {
            getArray(topWords[i], topWords, strings);
        }

        int matrix[][] = new int[topWords.length][topWords.length];

        for(int i = 0 ; i < topWords.length; i++) {
            String wordToBeFound = topWords[i];
            for(int j = 0 ; j < topWords.length; j++) {
                String wordToCompare = topWords[j];
                if(i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = findCorpusCount(wordToBeFound, wordToCompare, strings);
                }
            }
        }

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
