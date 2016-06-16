
import java.net.*;
import java.io.*;

public class Client{
	public static void main(String args[]){
		Socket socket = null;
		int portNumber = 1777;
		Packet p = new Packet("Hello");
		String HOST = "www.server.com";

		try {
			socket = new Socket(HOST, portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String response = null;
		try {
			response = (String) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(response);

		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
