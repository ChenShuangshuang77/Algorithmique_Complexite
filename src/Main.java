public class Main {
    public static void main(String[] args) {

//        Question_6 question_6 = new Question_6(10,20);
//        question_6.create();

        Utils utils = new Utils();
        String str = utils.readTxtFileIntoStringArrList(".//output.txt").get(0);
        System.out.println(str);
        System.out.println(utils.SepareteStringIntoIntArrList(str));
    }
}
