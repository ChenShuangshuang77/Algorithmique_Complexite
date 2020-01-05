import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestQ52 {
    public static void main(String[] args) {
        Utils u = new Utils();
        //System.out.println(u.numberFind("1-2-3","-"));
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        ArrayList<Integer> i1 = new ArrayList<>(){{add(1);add(7);add(4);add(3);}};
        ArrayList<Integer> i2 = new ArrayList<>(){{add(1);add(7);add(9);add(3);}};
        ArrayList<Integer> i3 = new ArrayList<>(){{add(4);add(6);add(10);add(11);}};
        ArrayList<Integer> i4 = new ArrayList<>(){{add(8);add(13);add(14);add(15);}};
        sets.add(i1);
        sets.add(i2);
        sets.add(i3);
        sets.add(i4);
        Question_5_2 q = new Question_5_2(sets,1,1);
        q.drawGraph();
        System.out.println(sets);
        System.out.println(q.getNumberChain());
        q.getGraph().print();
        //System.out.println(q.getFirstVertexOfString("12-"));

        /*MatrixGraph g = new MatrixGraph(100);
        g.setEdge(1,2);
        g.setEdge(1,3);

        g.setEdge(1,3);
        g.setEdge(1,5);
        g.setEdge(1,4);
        g.setEdge(1,6);
        g.setEdge(1,7);
        g.setEdge(3,2);
        g.setEdge(3,8);
        g.setEdge(3,9);
        g.setEdge(3,10);
        g.setEdge(3,11);
        //g.setEdge(3,12);
        System.out.println(g.calculateDegreeMax());
        System.out.println(g.calculateNumberEdge());*/

    }
}
