public class JudgeType {
    public static int JudgeType(int tempchar) {
        if ((char) tempchar == ' ' || (char) tempchar == '，' || (char) tempchar == '\r' || (char) tempchar == '\t' ||
                (char) tempchar == '、' || (char) tempchar == '《' || (char) tempchar == '.' || (char) tempchar == '-'
                || (char) tempchar == '”' || (char) tempchar == '“' || (char) tempchar == '》' || (char) tempchar == '：'
                || (char) tempchar == '—' || (char) tempchar == '；')
            return 0;   //忽略
        else if ((char) tempchar == '。' || (char) tempchar == '!' || (char) tempchar == '？' || (char) tempchar == '\n'
                || (char) tempchar == ';' || (char) tempchar == '>')
            return 1;   //判定为句子
        else return 2;
    }
}
