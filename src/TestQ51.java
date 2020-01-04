import java.util.ArrayList;
import java.util.Arrays;

public class TestQ51 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> testData=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr1=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> arr2=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> arr3=new ArrayList<>(Arrays.asList(2, 3, 5));
        testData.add(arr1);
        testData.add(arr2);
        testData.add(arr3);
        Question_5_1 q=new Question_5_1();
        q.setOrigin(testData);
        q.getNumPairs();
        q.sortStockEdges();

    }
}
