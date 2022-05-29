package other;

public class ValidateIPAddress {
    // 468
    public static String validIPAddress(String queryIP) {
        if( validIPV4(queryIP)){
            return "IPv4";
        }
        if( validIPV6(queryIP)){
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean validIPV4(String queryIP){
        String[] ips = queryIP.split("\\.");
        if( ips.length != 4){
            return false;
        }
        for(String item : ips){
            if("".equals(item)){
                return false;
            }
            if(item.charAt(0) == '0' && item.length() > 1){
                return false;
            }
            int value = 0;
            for(char c : item.toCharArray()){
                if( c >= '0' && c <= '9'){
                    value = value * 10 + (c - '0');
                }else{
                    return false;
                }
            }
            if(value < 0 || value > 255){
                return false;
            }
        }
        char temp = queryIP.charAt(queryIP.length()-1);
        if( temp >= '0' && temp <= '9'){
            return true;
        }
        return false;
    }

    private static boolean validIPV6(String queryIP){
        String[] ips = queryIP.split(":");
        if( ips.length != 8){
            return false;
        }
        for(String item : ips){
            if("".equals(item)){
                return false;
            }
            if(item.length() > 4){
                return false;
            }
            for(int i = 0 ;i<item.length();++i){
                if( (item.charAt(i) >= '0' && item.charAt(i) <='9') || (item.charAt(i)>='a' && item.charAt(i)<='f') ||(item.charAt(i)>='A'&& item.charAt(i)<='F')){
                    continue;
                }
                return false;
            }
        }
        char temp = queryIP.charAt(queryIP.length()-1);
        if( (temp >= '0' && temp <='9') || (temp >='a' && temp <='z') || (temp >='A'&& temp <='Z')){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:033:0:8A2E:0370:7334"));
    }
}
