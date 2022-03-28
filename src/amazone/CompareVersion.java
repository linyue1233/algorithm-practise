package amazone;

public class CompareVersion {
    // 165
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int len1 = version1.length(), len2 = version2.length();
        while( i < len1 || j < len2){
            int a = 0, b = 0;
            while(i < len1 && version1.charAt(i) != '.'){
                int temp = version1.charAt(i) - '0';
                a = a * 10 + temp;
                i++;
            }
            while(j < len2 && version2.charAt(j) != '.'){
                int temp = version2.charAt(j) - '0';
                b = b * 10 + temp;
                j++;
            }
            if( a > b){
                return 1;
            }else if(a < b){
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
