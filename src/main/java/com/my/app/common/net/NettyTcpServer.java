package com.my.app.common.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyTcpServer {

	public static void main(String[] args) {
		// 서버 스레드
		Runnable server = new Runnable() {
			@Override
			public void run() {
				try {
					// 서버 시작
					startServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		// 클라이언트 스레드
		Runnable client = new Runnable() {
			@Override
			public void run() {
				try {
					startClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		// 서버 스레드 시작
		new Thread(server).start();
		// 클라이언트 스레드 시작
		new Thread(client).start();
	}

	public static void startServer() throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress("localhost", 8090));

			serverBootstrap.childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new SimpleChannelInboundHandler<ByteBuf>() {
						@Override
						protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
							System.out.println("Got data: " + msg.toString(CharsetUtil.UTF_8));
						}
					});
				}
			});

			ChannelFuture channelFuture = serverBootstrap.bind().sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void startClient() throws IOException {
		InetSocketAddress address = new InetSocketAddress("localhost", 8090);
		SocketChannel socketChannel = SocketChannel.open(address);

		ByteBuffer buffer = ByteBuffer.wrap("Test".getBytes());
		socketChannel.write(buffer);
		buffer.clear();

		socketChannel.close();
	}

}
