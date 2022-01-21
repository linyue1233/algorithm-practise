package amazone;

public class RepeatedStringMatch {
    // 686
//    public int repeatedStringMatch(String a, String b) {
//        if(b.equals("")){
//            return 0;
//        }
//        boolean[]set = new boolean[26];
//        for (char ch : a.toCharArray()) {
//            set[ch - 'a'] = true;
//        }
//        for (char ch : b.toCharArray()) {
//            if(!set[ch - 'a']) {
//                return -1;
//            }
//        }
//        int times = (b.length()-1) / a.length() + 1;
//        StringBuilder sb = new StringBuilder(a.repeat(times));
//        for(int i = 0;i<3;++i){
//            if(sb.toString().contains(b)){
//                return times+i;
//            }
//            sb.append(a);
//        }
//        return -1;
//    }
}
