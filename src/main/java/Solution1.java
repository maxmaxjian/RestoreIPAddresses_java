import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public List<String> restoreIpAddresses(String s) {

        return split(s, 0, 4);
    }

    private List<String> split(String s, int start, int group) {
        if (s.length()-start > group*3 || s.length()-start < group) {
            return Collections.EMPTY_LIST;
        } else if (group == 1) {
            if (s.charAt(start) == '0') {
                if (start == s.length()-1) {
                    return Arrays.asList(s.substring(start));
                } else {
                    return Collections.EMPTY_LIST;
                }
            } else if (Integer.valueOf(s.substring(start)) >= 0 && Integer.valueOf(s.substring(start)) <= 255) {
                return Arrays.asList(s.substring(start));
            } else {
                return Collections.EMPTY_LIST;
            }
        } else {
            List<String> result = new ArrayList<>();
            if (s.charAt(start) == '0') {
                List<String> next = split(s, start+1, group-1);
                for (String nx : next) {
                    result.add(new StringBuilder("0").append(".").append(nx).toString());
                }
            } else {
                for (int i = 1; i <= 3 && i + start <= s.length(); i++) {
                    String subs = s.substring(start, start + i);
                    if (Integer.valueOf(subs) >= 0 && Integer.valueOf(subs) <= 255) {
                        List<String> next = split(s, start + i, group - 1);
                        for (String nx : next) {
                            result.add(new StringBuilder(subs).append(".").append(nx).toString());
                        }
                    }
                }
            }
            return result;
        }
    }
}
