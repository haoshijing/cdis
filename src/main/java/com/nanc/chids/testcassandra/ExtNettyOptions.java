package com.nanc.chids.testcassandra;

import com.datastax.driver.core.NettyOptions;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import java.nio.channels.Pipe;


public class ExtNettyOptions extends NettyOptions {
    @Override
    public void afterChannelInitialized(SocketChannel socketChannel)  throws Exception {
        ChannelPipeline channelPipeline =  socketChannel.pipeline();
        System.out.println("socketChannel = [" + socketChannel + "]");
    }
}
