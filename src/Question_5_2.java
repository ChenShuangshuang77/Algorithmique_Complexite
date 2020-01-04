import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Question_5_2 {
    ArrayList<ArrayList<Integer>> sets;
    HashMap<String,Integer> numberChain;
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
        sortSets();
    }

    ///sort all the sets from the smallest vertex to the biggest one
    public void sortSets(){
        for(ArrayList<Integer> s : sets){
            Collections.sort(s);
        }
    }

    public void drawGraph(){

    }











}
