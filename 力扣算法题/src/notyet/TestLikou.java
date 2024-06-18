package notyet;

import org.junit.Test;

import java.util.List;

public class TestLikou {
    @Test
    public void test(){
        List<Integer> List1 = List.of(2);
        List<Integer> List2 = List.of(3,4);
        List<Integer> List3 = List.of(6,5,7);
        List<Integer> List4 = List.of(4,1,8,3);
        List MyList = List.of(List1,List2,List3,List4);
        new Solution120().minimumTotal(MyList);
    }

}
