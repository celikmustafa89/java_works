/**
 * Created by joker on 6/16/16.

 Implemenst a "proxy" echo server.
 A proxy server is a middle-man which gets the request and sends it to the remote server.
 Afterwards it reads the response and returns it back to the client.
 Proxy server simply sends the client back what it receives from the server.
 A sample code is given from the Client-Server Architecture without Proxy server.
 Change code of Client, Packet and implement Proxy. (no need to change Server)
 - Client must sent the destination address and Packet to the proxy so that it knows where the packet will be sent.*/
import java.net.*;
import java.io.*;
public class Server{
    public static void main(String args[]){
        ServerSocket servSocket = null;
        Socket c1Socket = null;
        int portNumber = 1777;

        try {
            servSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            c1Socket = servSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(c1Socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(c1Socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Packet p = null;
        try {
            p = (Packet) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(p.content);

        try {
            oos.writeObject("RECEIVED" + p.content);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            c1Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            servSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
