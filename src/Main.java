import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String text = null;
    private static int width = 0;
    private static String name = null;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){
            System.out.println("please enter file name!  (tips: the workspace is .\\file\\,and you need not to enter .txt)");
            System.out.println("you can enter 'test' to begin a test");
            System.out.println("if you want to enter text manually,please enter 'manual' ");
            String temp=null;
            temp = in.nextLine();
            if (temp.equals("manual")) break;
            else {
                name= temp;
                text= fileRw.readFile(name);
                if (!isInvalidChar(text)){  //判断文本文件是否符合格式
                    System.out.println("error text format \n ");
                    continue;
                }
                else {
                    System.out.println("please enter width ");
                    width = Integer.parseInt(in.nextLine());
                    client.clientRun(client.mapCreateJson(text,width),1001);

                }
            }

            try {    //暂停一段时间等待响应
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        while (true) {
            System.out.println("正在初始化");

            try {
                input();
            } catch (NumberFormatException e) {
                System.out.println("error: width must be an integer");
                return;
            }

            //通过四个端口发送出去进行测试
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);

            try {
                //暂停一段时间等待响应
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }

    public static void input() throws NumberFormatException {

        System.out.println("please enter text");
        text = in.nextLine();
        while (!isInvalidChar(text)) {
            System.out.println("error format");
            System.out.println("please reenter text");
            text = in.nextLine();
        }
        System.out.println("please enter width");
        width = Integer.parseInt(in.nextLine());
    }

    private static boolean isInvalidChar(String text) {
        if (text == " "||text== "")return false;
        Pattern pattern = Pattern.compile("^[A-Za-z ]+$");
        Matcher m = pattern.matcher(text);
        return m.matches();
    }
}
