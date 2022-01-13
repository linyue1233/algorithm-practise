import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    public static int getSum(int a, int b) {
        int temp;
        while(a != 0){
            // ^  wei yihuo, tongwei wei 0, butong wei 1
            temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

//010 010
//    011
    public static void main(String[] args) {
        getSum(2,3);
    }
}
