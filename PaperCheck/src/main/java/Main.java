import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        String originalPath;
        //原文路径
        String addPath;
        //论文查重路径
        String ansPath;
        //结果存储路径

        String[] originalArray = new String[500];
        //由读出工具类得到路径而读出的原文档
        String[] addArray = new String[500];
        //由读出工具类得到路径而读出的抄袭文档

        Scanner in = new Scanner(System.in);

        originalPath =  in.next();
        originalArray = txtArray.txtToArray(originalPath);
        //用读出工具类读出文档，并且返回数组

        addPath = in.next();
        //用读出工具类读出文档
        addArray = txtArray.txtToArray(addPath);

        ansPath = in.next();
        Papercheck.Papercheck(originalArray, addArray, ansPath);
        //用Papercheck类分析比较出文档的查重率并且录入文档中

    }





}
