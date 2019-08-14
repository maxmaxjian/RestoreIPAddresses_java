import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private String input;
    private List<String> expected;
    private Solution soln = new Solution1();

    public SolutionTest(String input, List<String> output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
//                {"25525511135", Arrays.asList("255.255.11.135", "255.255.111.35")},
//                {"0000", Arrays.asList("0.0.0.0")},
                {"010010", Arrays.asList("0.10.0.10", "0.100.1.0")}
        });
    }

    @Test
    public void testRestore() {
        assertEquals(expected, soln.restoreIpAddresses(input));
    }

}