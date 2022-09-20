//用于txtArray类中运用的断句工具类JudgeType

public class JudgeType {
    public static int JudgeType(int tempchar)
    {
        if ((char) tempchar == ' ' || (char) tempchar == '，' || (char) tempchar == '\r' || (char) tempchar == '\t' ||
                (char) tempchar == '、' || (char) tempchar == '《' || (char) tempchar == '.' || (char) tempchar == '-'
                || (char) tempchar == '”' || (char) tempchar == '“' || (char) tempchar == '》' || (char) tempchar == '：'
                || (char) tempchar == '—' || (char) tempchar == '；')
            return 0;
        //通过标点符号来判断，有以上符号的不算句子结束
        else if ((char) tempchar == '。' || (char) tempchar == '!' || (char) tempchar == '？' || (char) tempchar == '\n'
                || (char) tempchar == ';' || (char) tempchar == '>')
            return 1;
        //通过标点符号判断，有以上符号的算句子结束，返回结果
        else return 2;
    }
}
