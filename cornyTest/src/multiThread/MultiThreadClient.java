package multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadClient {
    public static String localhost = "219.223.239.39";
    public static void main(String[] args) {
        int numTasks = 3;
        
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < numTasks; i++) {
            exec.execute(createTask(i));
            try{
            	Thread.sleep(10000);
            }catch(InterruptedException e){
            	e.printStackTrace();
            }
        }

    }

    // 定义一个简单的任务
    private static Runnable createTask(final int taskID) {
        return new Runnable() {
            private Socket socket = null;
            private int port=8821;

            public void run() {
                System.out.println("Task " + taskID + ":start");
                try {                    
                    socket = new Socket(localhost, port);
                    // 发送关闭命令
                    OutputStream socketOut = socket.getOutputStream();
                    socketOut.write("check state\r\n".getBytes());

                    // 接收服务器的反馈
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    String msg = null;
                    while ((msg = br.readLine()) != null)
                        System.out.println(Thread.currentThread().toString()+msg);
                } catch (IOException e) {                    
                    e.printStackTrace();
                }
            }

        };
    }
}
