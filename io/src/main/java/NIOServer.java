import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/*
* NioSocket首先要创建ServerSocketChannel,然后注册Selector,接下来就可以用Selector接收请求并处理了
* 注册完之后的Selector可以通过select方法来等待请求,select方法有一个Long类型的参数,表示最长等待时间,当接收到请求后Selector调用selectedKeys方法返回SelectionKey的集合
* SelectionKey保存了处理当前请求的Channel和Selector
* NIO中服务端的处理过程可以分为5步:
* 创建ServerSocketChannel并设置相应参数
* 创建Selector并注册到ServerSocketChannel上
* 调用Selector的select方法等待请求
* Selector接收到请求后使用selectedKeys返回SelectionKey集合
* 使用SelectionKey获取到Channel、Selector和操作类型并进行具体操作
* */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //创建ServerSocketChannel,监听8080端口,ServerSocketChannel可以使用自己的静态工厂方法open创建
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //注册选择器,可以通过其静态工厂方法open创建,创建后通过register方法注册到ServerSocketChannel上
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //创建处理器
        Handler handler = new Handler(1024);
        while(true) {
            //等待请求,每次等待阻塞3s,超过3s后线程继续向下运行,如果传入0或者不传参数将一直阻塞
            if(selector.select(3000) == 0) {
                System.out.println("等待请求超时");
                continue;
            }
            System.out.println("处理请求");
            //获取待处理的SelectionKey
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while(keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                try {
                    //接收到连接请求时
                    if(key.isAcceptable()) {
                        handler.handleAccept(key);
                    }
                    //读数据
                    if(key.isReadable()) {
                        handler.handleRead(key);
                    }
                } catch (IOException e) {
                    keyIterator.remove();
                    continue;
                }
                //处理完后,从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIterator.remove();
            }
        }
    }

    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {}

        public Handler(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        public Handler(String localCharset) {
            this.localCharset = localCharset;
        }

        public Handler(int bufferSize, String localCharset) {
            if(bufferSize > 0)
                this.bufferSize = bufferSize;
            if(localCharset != null)
                this.localCharset = localCharset;
        }

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead(SelectionKey key) throws IOException {
            //获取channel
            SocketChannel socketChannel = (SocketChannel)key.channel();
            //获取buffer并重置
            ByteBuffer byteBuffer = (ByteBuffer)key.attachment();
            byteBuffer.clear();
            //没有读到内容则关闭
            if(socketChannel.read(byteBuffer) == -1) {
                socketChannel.close();
            }else {
                //将buffer转换为读状态
                byteBuffer.flip();
                //将buffer中接收到的值按localCharset格式编码后保存到receivedString
                String receivedString = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                System.out.println("received from client:" + receivedString);

                //返回数据给客户端
                String sendString = "received data:" + receivedString;
                byteBuffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                socketChannel.write(byteBuffer);
                //关闭Socket
                socketChannel.close();
            }
        }
    }
}


