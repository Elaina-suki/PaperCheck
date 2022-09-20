import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;



//用来进行句子对比的关键类Papercheck



public class Papercheck
{
    public static void Papercheck(String[] originalArray, String[] addArray, String ansPath) {
    //读取由上一个接口传下来的两个字符数组，一个为原文一个为抄袭
        double similarityPercentage = 0;
        double sentencePercentage;
        double wordNum = 0;
        //运用余弦相似度算法来比较两数组的相似度
        for (String doc1 : originalArray)
        {
            sentencePercentage = 0;
            if (doc1 == null) break;
            wordNum += doc1.length();
            for (String doc2 : addArray)
            {
                if (doc2 == null)
                    break;
                Map<Character, int[]> algMap = new HashMap<Character, int[]>();
                for (int i = 0; i < doc1.length(); i++)
                {
                    char d1 = doc1.charAt(i);
                    int[] fq = algMap.get(d1);
                    if (fq != null && fq.length == 2)
                    {
                        fq[0]++;
                    }
                    else
                    {
                        fq = new int[2];
                        fq[0] = 1;
                        fq[1] = 0;
                        algMap.put(d1, fq);
                    }
                }
                for (int i = 0; i < doc2.length(); i++)
                {
                    char d2 = doc2.charAt(i);
                    int[] fq = algMap.get(d2);
                    if (fq != null && fq.length == 2)
                    {
                        fq[1]++;
                    }
                    else
                    {
                        fq = new int[2];
                        fq[0] = 0;
                        fq[1] = 1;
                        algMap.put(d2, fq);
                    }
                }
                double sqdoc1 = 0;
                double sqdoc2 = 0;
                double denuminator = 0;
                for (Map.Entry entry : algMap.entrySet()) {
                    int[] c = (int[]) entry.getValue();
                    denuminator += c[0] * c[1];
                    sqdoc1 += c[0] * c[0];
                    sqdoc2 += c[1] * c[1];
                }
                double similarPercentage = denuminator / Math.sqrt(sqdoc1 * sqdoc2);
                //定义相似度
                if (similarPercentage > sentencePercentage)
                    sentencePercentage = similarPercentage;
            }
            similarityPercentage += (sentencePercentage * doc1.length());
        }
        similarityPercentage = similarityPercentage / wordNum * 100;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        df.format(similarityPercentage);
        System.out.println("论文查重率为" + similarityPercentage + "%");
        File file = new File(ansPath);
        try {
            Writer writer = new FileWriter(file,false);
            writer.write("论文查重率为" + similarityPercentage + "%");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
