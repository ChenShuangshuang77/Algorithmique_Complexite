import java.sql.SQLOutput;
import java.util.*;

import static java.util.stream.Collectors.toMap;
import java.util.Collections;
import static java.util.Map.Entry.comparingByValue;

public class Question_5_1 {
    Utils utils = new Utils();
    Map<String,Integer> stockEdge=new HashMap<String, Integer>();
    Map<String,Integer> sortedEdge=new HashMap<String, Integer>();
    ArrayList<ArrayList<Integer>> origin=new ArrayList<ArrayList<Integer>>();
    MatrixGraph m = new MatrixGraph(100);
    Question_5_1(){
        origin=utils.data();

    }
    private static Comparator<Map.Entry> comparatorByValueDesc = (Map.Entry o1, Map.Entry o2) -> {
        if (o1.getValue() instanceof Comparable) {
            return ((Comparable) o2.getValue()).compareTo(o1.getValue());
        }
        throw new UnsupportedOperationException("值的类型尚未实现Comparable接口");
    };

    public void setOrigin(ArrayList<ArrayList<Integer>> data){
        this.origin=data;
    }
    public void getNumPairs(){
        for (ArrayList<Integer> x:origin) {
            for(Integer i:x){
                for(Integer j:x){
                    if(i!=j){
                        String key=i<j?""+i+j:""+j+i;
                        if(stockEdge.get(key)==null){
                            stockEdge.put(key,1);
                        }else if(i<j) {
                            stockEdge.put(key, stockEdge.get(key) + 1);
                        }
                    }
                }
            }

        }
        System.out.println(stockEdge.keySet());
        System.out.println(stockEdge.values());
    }
    public void sortStockEdges(){
        Map<String,Integer> tem=new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry :stockEdge.entrySet()){
            list.add(entry); //将map中的元素放入list中
        }
        list.sort(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();}
            //逆序（从大到小）排列，正序为“return o1.getValue()-o2.getValue”
        });
        for(Map.Entry<String, Integer> entry: list){
            tem.put(entry.getKey(),entry.getValue());
        }
        System.out.println(tem.keySet());
        System.out.println(tem.values());
    }

}
