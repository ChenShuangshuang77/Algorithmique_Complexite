import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Question_6  {
    private int p;
    private int t;
    public Question_6(int p,int t){
        this.p = p;
        this.t = t;
    }

    public ArrayList<ArrayList<Integer>> create(){
        ArrayList<ArrayList<Integer>> arrayLists= new ArrayList<>();
        try {
            File writename = new File("./output.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for(int i=0; i<t; i++){
                ArrayList<Integer> arr = new ArrayList<>();
                for(int j=0; j<p; j++){
                    int val = new Random().nextInt(100) +1;
                    if(arr.contains(val)) {
                        j--;
                    }else {
                        arr.add(val);
                    }
                }
                out.write(arr.toString() + "\n");
                arrayLists.add(arr);
            }
            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return arrayLists;
    }
}
