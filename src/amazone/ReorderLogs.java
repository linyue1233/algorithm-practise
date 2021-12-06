package amazone;

import java.util.Arrays;

public class ReorderLogs {
    //937
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(logs1, logs2)->{
            // split into two array
            String[] splitlog1 = logs1.split(" ",2);
            String[] splitlog2 = logs2.split(" ",2);
            boolean aIsDigit = Character.isDigit(splitlog1[1].charAt(0));
            boolean bIsDigit = Character.isDigit(splitlog2[1].charAt(0));

            if(!aIsDigit && !bIsDigit){
                if(!splitlog1[1].equals(splitlog2[1])){
                    return splitlog1[1].compareTo(splitlog2[1]);
                }else{
                    return splitlog1[0].compareTo(splitlog2[0]);
                }
            }else if( aIsDigit && bIsDigit){
                return 0;
            }else if(!aIsDigit){
                // b is digit , letters must before digital
                return -1;
            }else{
                return 1;
            }
        });
        return logs;
    }
}
