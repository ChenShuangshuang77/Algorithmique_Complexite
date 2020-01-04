public class TestQ52 {
    public static void main(String[] args) {
        MatrixGraph m = new MatrixGraph(100);
        m.setEdge(1,3);
        m.setEdge(1,2);
        m.setEdge(3,8);
        m.setEdge(3,1);
        m.print();
        System.out.println(m.getDegree(1));
    }
}
