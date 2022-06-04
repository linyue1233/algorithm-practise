package other;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        //929
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            boolean dotFlag = false;
            boolean plusFlag = false;
            StringBuilder prefix = new StringBuilder();
            StringBuilder sufix = new StringBuilder();
            char[] emailItem = email.toCharArray();
            for (int i = 0; i < emailItem.length; ++i) {
                if (dotFlag) {
                    sufix.append(emailItem[i]);
                } else {
                    if (emailItem[i] == '@') {
                        dotFlag = true;
                        continue;
                    } else if (plusFlag) {
                        continue;
                    } else if (emailItem[i] == '.') {
                        continue;
                    } else if (emailItem[i] == '+') {
                        plusFlag = true;
                    } else {
                        prefix.append(emailItem[i]);
                    }
                }
            }
            set.add(prefix.toString() + "@" + sufix.toString());
        }
        return set.size();
    }
}
