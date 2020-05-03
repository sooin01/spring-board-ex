package com.my.app.common.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class BasicTcpServer {

	public static void main(String[] args) throws InterruptedException {
		Runnable sr = new Runnable() {
			@Override
			public void run() {
				try {
					startServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Runnable cr = new Runnable() {
			@Override
			public void run() {
				try {
					startClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread st = new Thread(sr);
		st.start();
		Thread ct = new Thread(cr);
		ct.start();
	}

	public static void startServer() throws IOException {
		InetSocketAddress address = new InetSocketAddress("localhost", 8090);
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(address);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		System.out.println("Server started..");

		while (true) {
			int select = selector.select();
			if (select == 0) {
				break;
			}

			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while (keys.hasNext()) {
				SelectionKey key = keys.next();
				keys.remove();
				System.out.println("Server valid: " + key.isValid() + ", key: " + key.readyOps());

				if (key.isValid()) {
					if (key.isAcceptable()) {
						accept(selector, key);
					} else if (key.isReadable()) {
						read(key);
					}
				}
			}
		}

		System.out.println("Server close.");
		selector.close();
		serverSocketChannel.close();
	}

	private static void accept(Selector selector, SelectionKey key) throws IOException {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		Socket socket = socketChannel.socket();
		SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
		System.out.println("Connected to: " + remoteSocketAddress);

		socketChannel.register(selector, SelectionKey.OP_READ);
	}

	private static void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(8192);
		int read = channel.read(buffer);

		if (read == -1) {
			Socket socket = channel.socket();
			SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
			System.out.println("Connected closed by client: " + remoteSocketAddress);
			channel.close();
			key.cancel();
		} else {
			byte[] b = new byte[read];
			System.arraycopy(buffer.array(), 0, b, 0, read);
			System.out.println("Got data: " + new String(b));
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
