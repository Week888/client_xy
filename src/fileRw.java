
import java.io.*;
import java.util.Scanner;

public class fileRw {
    public static String name= null;
    public static String text= null;



        public static String readFile(String name) {
            StringBuilder line = new StringBuilder();
            String pathname = ".\\file\\"+name+".txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
            try (FileReader reader = new FileReader(pathname);
                 BufferedReader br = new BufferedReader(reader)) {
                String temp;
                //网友推荐更加简洁的写法
                while ((temp = br.readLine()) != null) {
                    // 一次读入一行数据
                    line.append(temp);
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            return line.toString();
        }

        /**
         * 写入TXT文件
         */
        public static void writeFile(String name,String content) {
            try {
                File writeName = new File(".\\file\\"+name+"Output.txt"); // 相对路径，如果没有则要建立
                writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
                try (FileWriter writer = new FileWriter(writeName);
                     BufferedWriter out = new BufferedWriter(writer))
                {
                    out.write(content);
                    out.flush(); // 把缓存区内容压入文件
                    System.out.println("已经写入指定文件"+writeName.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




