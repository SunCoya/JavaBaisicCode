package notyet;
import org.junit.Test;
import solved.Solution994;

public class TestLikou {
    @Test
    public void test(){
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        Solution994 solution = new Solution994();
        solution.orangesRotting(arr);
    }

}
