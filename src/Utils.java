import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public Utils(){
    }

    public List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("Not find file");
            }
        }
        catch (Exception e)
        {
            System.out.println("Read error");
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Integer> SepareteStringIntoIntArrList(String str){
        ArrayList<Integer> arr = new ArrayList<>();
        String val = new String();
        for(int i =0;i<str.length();i++) {
            Character ch = str.charAt(i);
            if(!ch.equals(',') && !ch.equals('{') && !ch.equals('}')){
                val = val+ch;
            }
            if(ch.equals(',')){
                System.out.println(val);
                arr.add(Integer.parseInt(val));
                val = "";
            }
        }
        arr.add(Integer.parseInt(val));
        return arr;
    }
}