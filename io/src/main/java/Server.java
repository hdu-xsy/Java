import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
* 创建ServerSocket
* 调用创建出来的ServerSocket的accept方法进行监听,accept方法是阻塞方法,调用accept方法后程序会停下来等待连接请求,在接收到请求之前程序将不会往下走,接收到请求后返回一个Socket
* 使用accept方法返回的Socket与客户端进行通信
* */
public class Server {

    public static void main(String args[]) {
        try {
            //创建一个ServerSocket监听8080端口
            ServerSocket serverSocket = new ServerSocket(8080);
            //等待请求
            Socket socket = serverSocket.accept();
            //接收到请求后使用socket进行通信,创建BufferdReader用于读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("received from client:" + line);
            //创建PrintWriter,用于发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.print("received data" + line);
            pw.flush();
            //关闭资源
            pw.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
