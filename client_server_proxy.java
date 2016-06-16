public class Packet{
	
	public String content;
	public String host;
	public int port;

	public Packet(String content, String host, int port){
		this.content = content;
		this.host = host;
		this.port = port;
	}
}

public class Client{
	public static void main(String args[]){
		Socket socket;
		String HOST = "www.proxy.com"
		int portNumber = 1888;

		Packet p = new Packet("Hello", "www.server.com",1777);
		

		socket = new Socket(HOST, portNumber);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		oos.writeObject(p);
		String response = (String) ois.readObject();
		System.out.println(response);

		ois.close();
		oos.close();
		socket.close();
	}
}
public class ProxyServer{
	ServerSocket CPsocket;
	int CSportNumber = 1888;

	CPsocket = new ServerSocket(CSportNumber);
	PCsocket = servSocket.accept();

	ObjectOutputStream coos = new ObjectOutputStream(c1Socket.getOutputStream());
	ObjectInputStream cois = new ObjectInputStream(c1Socket.getInputStream());

	Packet p = (Packet) cois.readObject();

	/////////////////////////
	Socket PSsocket;
	PSsocket =new Socket(p.host,p.port);

	ObjectInputStream sois = new ObjectInputStream(socket.getInputStream());
	ObjectOutputStream soos = new ObjectOutputStream(socket.getOutputStream());

	soos.writeObject(p);
	///////////////////
	String response = (String) sois.readObject();
	coos.writeObject(response);

}

public class Server{
	public static void main(String args[]){
		ServerSocket servSocket;
		Socket c1Socket;
		int portNumber = 1777;

		servSocket = new ServerSocket(portNumber);
		c1Socket = servSocket.accept();

		ObjectOutputStream oos = new ObjectOutputStream(c1Socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(c1Socket.getInputStream());

		Packet p = (Packet) ois.readObject();
		System.out.println(p.content);

		oos.writeObject("RECEIVED" + p.content);

		ois.close();
		oos.close();
		c1Socket.close();
		servSocket.close();
	}
}
