import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Question_6  {
    private int p;
    private int t;
    public Question_6(int p,int t){
        this.p = p;
        this.t = t;
    }

    public void create(){
        StringBuilder builder=new StringBuilder();
        for(int i=0; i<t; i++){
            builder.append("{");
            for(int j=0; j<p-1; j++){
                int val = new Random().nextInt(100) +1;
                builder.append(val + ",");
            }
            int val = new Random().nextInt(100) +1;
            builder.append(val + "}\n");
        }
        System.out.print(builder);

        try {
            File writename = new File("./output.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(builder.toString());
            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
