package work.azhu.springbootnetty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author Azhu
 * @Date 2019/11/12 17:25
 * @Description
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ... 收数据逻辑省略
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        // 回复数据到客户端
        System.out.println(new Date() + ": 服务端回复客户端");

        ByteBuf out = getByteBuf(ctx);
        byte[] bytes ="Netty服务器通知: 已收到消息".getBytes(Charset.forName("utf-8"));
        out.writeBytes(bytes);
        ctx.channel().writeAndFlush(out);
    }

    /**
     * 注册时调用方法
     * @param ctx
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx){
        //拿到注册通道缓冲区
        ByteBuf out=getByteBuf(ctx);
        System.out.println("有个用户注册到Netty服务器");
        byte[] bytes="-------欢迎注册到Netty服务器-----".getBytes(Charset.forName("utf-8"));
        out.writeBytes(bytes);
        // 写队列并刷新 缓冲区
        ctx.channel().writeAndFlush(out);
    }
    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes =("ByteBuf方法默认填充缓存区时间"+new Date()).getBytes(Charset.forName("utf-8"));

        ByteBuf buffer = ctx.alloc().buffer();

        buffer.writeBytes(bytes);

        return buffer;

    }
}