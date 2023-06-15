package ChatRoomTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DomainCombiner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Server {
	private int port ;
	public static ArrayList<Socket> listSK ;

	public Server(int port) {
		this.port = port;
	}
	
//	public Server() {
//		// TODO Auto-generated constructor stub
//	}

	private void execute() throws IOException {
		ServerSocket server = new ServerSocket(port);
		WriteServer write = new WriteServer();
		write.start();
		System.out.println("Server is listening ...");
		while(true) {
			Socket socket = server.accept();
			System.out.println("Da ket noi voi "+socket);
			Server.listSK.add(socket);
			ReadServer read = new ReadServer(socket);
			read.start();
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		Server.listSK = new ArrayList<>();
		Server server = new Server(15797);
		server.execute();
	}

	
	

}
class ReadServer extends Thread{
	private Socket socket ;

	public ReadServer(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			
			dis = new DataInputStream(socket.getInputStream());
			while(true) {
				String sms = dis.readUTF();
				if(sms.contains("exit")) {
					Server.listSK.remove(socket);
					System.out.println("Da ngat ket noi voi : " +socket);
					dis.close();
					socket.close();
					continue; // ngắt kết nối 
				}
				for (Socket item : Server.listSK) {
					if(item.getPort() != socket.getPort()) {
						DataOutputStream dos = new DataOutputStream(item.getOutputStream());
						dos.writeUTF(sms);
					}	
				}
				System.out.println(sms);
				
			}
			
		} catch (Exception e) {
			try {
				socket.close();
			} catch (Exception e1) {
				System.out.println("Ngat ket noi voi Server");
				e1.printStackTrace();
			}
			
		}
	}
	
	
}
class WriteServer extends Thread{

	@Override
	public void run() {
		DataOutputStream dos = null ;
		Scanner sc = new Scanner(System.in);
		while(true) {
			String sms  = sc.nextLine();// đang đợi server nhập dữ liệu
			try {
				for (Socket item : Server.listSK) {
					dos = new DataOutputStream(item.getOutputStream());
					dos.writeUTF("Server : "+ sms);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}

