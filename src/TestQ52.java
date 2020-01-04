import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestQ52 {
    public static void main(String[] args) {
        Utils u = new Utils();
        //System.out.println(u.numberFind("1-2-3","-"));
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        ArrayList<Integer> i1 = new ArrayList<>(){{add(1);add(7);add(4);add(3);}};
        ArrayList<Integer> i2 = new ArrayList<>(){{add(11);add(7);add(9);add(3);}};
        ArrayList<Integer> i3 = new ArrayList<>(){{add(4);add(6);add(99);add(31);}};
        ArrayList<Integer> i4 = new ArrayList<>(){{add(14);add(37);add(46);add(37);}};
        sets.add(i1);
        sets.add(i2);
        sets.add(i3);
        sets.add(i4);
        Question_5_2 q = new Question_5_2(sets,1,1);
        q.sortSets();
        System.out.println(sets);

    }
}
