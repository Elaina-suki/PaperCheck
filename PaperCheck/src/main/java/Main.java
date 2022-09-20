import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        String originalPath;
        String addPath;
        String ansPath;
        String[] originalArray = new String[500];
        String[] addArray = new String[500];

        Scanner in = new Scanner(System.in);
        System.out.println("请输入原文路径:");
        originalPath =  in.nextLine();
        originalArray = TxtToArray(originalPath);
        System.out.println("请输入查重论文路径:");
        addPath = in.nextLine();
        addArray = TxtToArray(addPath);
        System.out.println("请输入结果储存路径:");
        ansPath = in.nextLine();
        Papercheck.Papercheck(originalArray, addArray, ansPath);

    }



    private static String[] TxtToArray(String paperPath) {
        String[] sentenceArray = new String[2000];
        try {
            Reader reader = null;
            reader = new InputStreamReader(new FileInputStream(new File(paperPath)));
            int tempchar;
            int n = 0;
            String sentence = "";
            while ((tempchar = reader.read()) != -1) {
                switch (JudgeType.JudgeType(tempchar)) {
                    case 1:
                        if (sentence.equals("")) break;
                        if (sentence.length() > 5) sentenceArray[n++] = sentence;
                        sentence = "";
                        break;
                    case 2:
                        sentence = sentence + (char) (tempchar);
                    default:
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentenceArray;
    }
    
}
