package other;

public class TruncateSentence {
    //1816
    public String truncateSentence(String s, int k) {
        String[] ansArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<k;++i){
            if(i==k-1){
                sb.append(ansArray[i]);
            }else{
                sb.append(ansArray[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
