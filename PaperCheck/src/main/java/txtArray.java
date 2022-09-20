import java.io.*;


//用于由路径读出文档的工具类txtArray

public class txtArray {
    public static String[] txtToArray(String paperPath) {
        String[] sentenceArray = new String[2000];
        //创建一个string类型管理将要写入的文档
        try {
            Reader reader = null;
            reader = new InputStreamReader(new FileInputStream(new File(paperPath)));
            //调用Reader类，将字节的输入转换为字符的输入流，从命令行接受原文储存路径
            int tempchar;
            int n = 0;
            String sentence = "";
            //对读取的文件分句
            while ((tempchar = reader.read()) != -1) {
                switch (JudgeType.JudgeType(tempchar)) {
                    //调用JudgeType中的断句方法，，将转化为字符串的文件断句
                    case 1:
                        if (sentence.equals("")) break;
                        if (sentence.length() > 5) sentenceArray[n++] = sentence;
                        //分句后，将句子放入sentenceArray中
                        sentence = "";
                        break;
                    case 2:
                        sentence = sentence + (char) (tempchar);
                        //句子未结束
                    default:
                        break;
                }
            }
            reader.close();
            //关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentenceArray;
        //返回接口
    }
}
