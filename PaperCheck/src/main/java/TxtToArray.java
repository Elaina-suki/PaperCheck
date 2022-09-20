import java.io.*;

public class TxtToArray {
    public static String[] TxtToArray(String paperPath) {
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
