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
        originalArray = TxtToArray.TxtToArray(originalPath);
        System.out.println("请输入查重论文路径:");
        addPath = in.nextLine();
        addArray = TxtToArray.TxtToArray(addPath);
        System.out.println("请输入结果储存路径:");
        ansPath = in.nextLine();
        Papercheck.Papercheck(originalArray, addArray, ansPath);

    }





}
