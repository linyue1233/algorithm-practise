import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    // store Anagrams
    final Integer[] primes;
    Map<Character, Integer> letterTable = new HashMap<Character, Integer>();
    Map<Long, ArrayList<String>> anagramTable = new HashMap<Long, ArrayList<String>>();

    public Anagrams() {
        // initialize the array
        primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        buildLetterTable();
    }

    // receive the name of a text file containing words
    public void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while((strLine=br.readLine()) != null) {
            this.addWord(strLine);
        }
        br.close();
    }

    // build letterTable according primes
    private void buildLetterTable(){
        char[] letterArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int i = 0;
        for (Character c: letterArray ) {
            letterTable.put(c, primes[i++]);
        }
    }

    /**
     *
     * @param s the string to compute
     * @return the computed hashcode
     */
    private Long myHashCode(String s) {
        char[] letter = s.toCharArray();
        long result = 1L;
        for(char c : letter) {
            result = result*(letterTable.get(c));
        }
        return result;
    }

    /**
     * compute the hash code, store it in the table
     * @param s needed to encode
     */
    private void addWord(String s){
        Long ans = myHashCode(s);
        if(anagramTable.containsKey(ans)){
            ArrayList<String> list = anagramTable.get(ans);
            list.add(s);
            anagramTable.put(ans,list);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            anagramTable.put(ans, list);
        }
    }

    /**
     *
     * @return return  the entries in the  anagramTable  that have the largest number of anagrams.
     */
    private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
        ArrayList<Map.Entry<Long, ArrayList<String>>> result = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
            if (entry.getValue().size() > maxCount) {
                maxCount = entry.getValue().size();
            }
        }
        for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
            if (entry.getValue().size() == maxCount) {
                result.add(entry);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams ();
        final long startTime = System.nanoTime();
        try {
            a.processFile("src/words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime/1000000000);
        System.out.println("Time: "+ seconds);
        System.out.println("List of max anagrams: "+ maxEntries);
        System.out.println("Length  of  list  of  max  anagrams: " + maxEntries.get(0).getValue().size());

    }

}
