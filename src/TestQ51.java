import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class TestQ51 {
    public static void main(String[] args) {
        Question_6 q6=new Question_6(20,10);
        try {
            File writename = new File("./5_1.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));

        for(int delta=10;delta<25;delta++){
            for(int k=100;k<200;k+=10){
                int success=0;
                for (int time = 0; time < 1000; time++) {
                    ArrayList<ArrayList<Integer>> testData = new ArrayList<ArrayList<Integer>>();
                    testData=q6.create();

                    Question_5_1 q = new Question_5_1();
                    q.setOrigin(testData);
                    q.getNumPairs();
                    q.sortStockEdges();
                    q.connectSub();
//                    q.printMatrix();
                    if(q.getMaxDegree()<=delta&&q.getEdge()<=k){
                        success+=1;
                    }


                }
                System.out.println("delta="+delta+";k="+k+";success="+success);
                out.write("delta="+delta+";k="+k+";success="+success+"\n");
            }

        }


            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
