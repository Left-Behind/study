package work.azhu.springbootnetty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import work.azhu.springbootnetty.server.FirstServerHandler;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/11 20:53
 **/
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                // 1.指定线程模型
                .group(bossGroup, workerGroup)
                // 2.指定 io 类型为 NIO
                .channel(NioServerSocketChannel.class)
                // 3.io 处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                });

        serverBootstrap.bind(8001);
    }
}
