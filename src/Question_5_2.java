import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Question_5_2 {
    ArrayList<ArrayList<Integer>> sets;
    HashMap<String,Integer> numberChain;
    ArrayList<Integer> verticesOfChain;
    int delta;
    int k;
    int degre;
    int numberTotalEdges;
    MatrixGraph graph;
    int p;
    int t;

    public Question_5_2(ArrayList<ArrayList<Integer>> sets, int delta, int k){
        this.sets = sets;
        this.numberChain = new HashMap<>();
        this.delta = delta;
        this.k = k;
        this.sets = sets;
        this.degre = 0;
        this.numberTotalEdges = 0;
        this.graph = new MatrixGraph(100);
        this.t = sets.size();
        this.p = sets.get(0).size();
        this.verticesOfChain = new ArrayList<>();
        sortSets();
    }

    ///sort all the sets from the smallest vertex to the biggest one
    public void sortSets(){
        for(ArrayList<Integer> s : sets){
            Collections.sort(s);
        }
    }

    public void run(){

    }

    public void drawGraph(){
        initialNumberChain();
        String twoV = findMaxNumberChain(1);
        while(!twoV.equals("0")){
            verticesOfChain.add(getFirstVertexOfString(twoV));
            verticesOfChain.add(getLastVertexOfString(twoV));
            graph.setEdge(verticesOfChain.get(0),verticesOfChain.get(1),1);
            numberChain.put(twoV,0);
            verticesOfChain.clear();
            twoV = findMaxNumberChain(1);
        }
    }

    //store the total number of a pair of vertex occurred in the sets
    public void initialNumberChain(){
        for(ArrayList<Integer> s : sets){
            for(int i = 0;i < s.size();i++){
                for(int j = i + 1;j < s.size();j++){
                    String vertex = s.get(i)+"-"+s.get(j);
                    if (numberChain.get(vertex) == null){
                        numberChain.put(vertex,1);
                    }
                    else{
                        numberChain.put(vertex,numberChain.get(vertex) + 1);
                    }
                }
            }
        }
    }

    //find the chain with x+1 vertices(x is the number of "-" in the key) who has the biggest number
    public String findMaxNumberChain(int x){
        Utils u = new Utils();
        int maxNumber = 0;
        String key = "";
        for (String s : numberChain.keySet()) {
            if (u.numberFind(s,"-") == x){
                if(maxNumber < numberChain.get(s)){
                    maxNumber = numberChain.get(s);
                    key = s;
                }
            }
        }
        if (maxNumber == 0){
            return "0";
        }
        return key;
    }

    public int getFirstVertexOfString(String s){
        String toInt = "";
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if (ch == '-')
                break;
            toInt = toInt + ch;
        }
        return Integer.parseInt(toInt);
    }

    public int getLastVertexOfString(String s){
        String toInt = "";
        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);
            if (ch == '-')
                break;
            toInt = ch + toInt;
        }
        return Integer.parseInt(toInt);
    }


    public MatrixGraph getGraph(){return graph;}

    public HashMap<String,Integer> getNumberChain(){return numberChain;}

}
