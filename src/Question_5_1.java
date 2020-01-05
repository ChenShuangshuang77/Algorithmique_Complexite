import java.sql.SQLOutput;
import java.util.*;

import static java.util.stream.Collectors.toMap;
import java.util.Collections;
import static java.util.Map.Entry.comparingByValue;

public class Question_5_1 {
    Map<String,Integer> stockEdge=new HashMap<String, Integer>();
    Map<String,Integer> sortedEdge=new LinkedHashMap<String, Integer>();
    ArrayList<ArrayList<Integer>> origin=new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> connected=new ArrayList<ArrayList<Integer>>();
    MatrixGraph m = new MatrixGraph(100);


    public void setOrigin(ArrayList<ArrayList<Integer>> data){
        this.origin=data;
        this.connected=data;
    }
    public void getNumPairs(){
        for (ArrayList<Integer> x:origin) {
            for(Integer i:x){
                for(Integer j:x){
                    if(i<j){
                        String key=i<j?i+"_"+j:j+"_"+i;
                        if(stockEdge.get(key)==null){
                            stockEdge.put(key,1);
                        }else {
                            stockEdge.put(key, stockEdge.get(key) + 1);
                        }
                    }
                }
            }

        }
//        System.out.println(stockEdge.keySet());
//        System.out.println(stockEdge.values());
    }
    public void sortStockEdges(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry :stockEdge.entrySet()){
            list.add(entry);
        }
        list.sort(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();}
        });
        for(Map.Entry<String, Integer> entry: list){
            sortedEdge.put(entry.getKey(),entry.getValue());
        }
//        System.out.println(sortedEdge.keySet());
//        System.out.println(sortedEdge.values());
    }
    public void connectSub(){

        ArrayList<ArrayList<ArrayList<Integer>>> p=new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<origin.size();i++){
            ArrayList<ArrayList<Integer>> s=new ArrayList<ArrayList<Integer>>();
            p.add(s);

        }

        for(Map.Entry<String,Integer> x:sortedEdge.entrySet()){
//            String key=x.getKey();
            String[] ss=x.getKey().split("_");
            int i=Integer.parseInt(ss[0]);
            int j=Integer.parseInt(ss[1]);
            boolean added=false;

//            System.out.println("i="+i+ " j="+j);
            for(int q=0;q<origin.size();q++){
                boolean existed1=false;
//                System.out.println("for a sub set:"+origin.get(q));
                ArrayList<Integer> tem0=new ArrayList<Integer>();
                if(origin.get(q).contains(i)&&origin.get(q).contains(j)){
                    for(int y1=0;y1<p.get(q).size();y1++){
                        for(int y2=y1+1;y2<p.get(q).size();y2++){
                            if(p.get(q).get(y1).contains(i)&&p.get(q).get(y2).contains(j)){
                                p.get(q).get(y1).addAll(p.get(q).get(y2));
                                existed1=true;
                                p.get(q).remove(p.get(q).get(y2));
//                                System.out.println("merge"+p.get(q).get(y1));
                                added=true;

                            }
                            else if(p.get(q).get(y1).contains(j)&&p.get(q).get(y2).contains(i)){
                                p.get(q).get(y1).addAll(p.get(q).get(y2));
                                existed1=true;
                                p.get(q).remove(p.get(q).get(y2));
//                                System.out.println("merge"+p.get(q).get(y1));
                                added=true;

                            }
                        }
                    }
                    if(!existed1){
                        for(ArrayList<Integer> y:p.get(q)){
                            if(y.contains(i)&&!y.contains(j)){
                                y.add(j);
                                existed1=true;
//                                System.out.println("added"+j);
                                added=true;
                                break;

                            }else if(y.contains(j)&&!y.contains(i)){
                                y.add(i);
                                existed1=true;
//                                System.out.println("added"+i);
                                added=true;
                                break;
                            }else if(y.contains(i)&&y.contains(j)){
                                existed1=true;
                                break;

                            }

                        }

                    }

                    if(!existed1){
                        tem0.add(i);
                        tem0.add(j);
                        existed1=true;
                        added=true;
                        p.get(q).add(tem0);
//                        System.out.println("added"+i+j);
                    }
//                    System.out.println(p.get(q));


                }

            }
            if(added){
                m.setEdge(i,j,1);
            }


        }

    }
    public void printMatrix(){
        m.print();
    }
    public int getDegree(int i){
        return  m.getDegree(i);
    }
    public int getMaxDegree(){
        return  m.getMaxDegree();
    }
    public int getEdge(){
        return m.getEdge();
    }


}
