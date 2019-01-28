
import net.sf.json.JSONObject;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class client {



    public static void clientRun(String text, int port) {    //每次发送都创建一个新的线程

            //创建Socket对象
            new Thread(){

                @Override
                public void run() {

                    try {
                    super.run();
                    Socket socket = new Socket("localhost", port);

                    //根据输入输出流和服务端连接
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.print(text);
                    printWriter.flush();
                    socket.shutdownOutput();

                    InputStream inputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String temp = null;//临时变量
                        String result = "";
                    while ((temp = bufferedReader.readLine()) != null) {
                        result += temp;
                        System.out.println("客户端接收服务端发送信息：" + result);
                    }

                    //关闭相对应的资源
                    bufferedReader.close();
                    inputStream.close();
                    printWriter.close();
                    outputStream.close();
                    socket.close();

                } catch (UnknownHostException e) {
                        System.out.println("unknow error");

                } catch (IOException e) {
                        System.out.println("connect failed please try later");
                }


                }
            }.start();

    }


    static String mapCreateJson(String text,int width){  //将消息封装为JSON格式再发送
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("text",text);
        map.put("width",width);
        JSONObject jsonObject= JSONObject.fromObject(map);
        return jsonObject.toString();
    }
}