import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String text = null;
    private static int width = 0;

    public static void main(String[] args) {


        while (true) {
            System.out.println("正在初始化");

            try {
                input();
            } catch (NumberFormatException e) {
                System.out.println("error: width must be an integer");
                return;
            }
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);
            client.clientRun(client.mapCreateJson(text,width),1001);

        }


    }

    public static void input() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
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
        Pattern pattern = Pattern.compile("^[A-Za-z ]+$");
        Matcher m = pattern.matcher(text);
        return m.matches();
    }
}
