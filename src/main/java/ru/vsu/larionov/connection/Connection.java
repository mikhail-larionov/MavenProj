package ru.vsu.larionov.connection;

import java.io.*;
import java.net.Socket;

public class Connection {
    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }
    public String receive() throws IOException {
        return dataInputStream.readUTF();
    }
    public void send(String string) throws IOException {
        synchronized (this.dataOutputStream) {
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
        }
    }

}





//package ru.vsu.larionov.connection;
//
//import ru.vsu.larionov.DTO;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class Connection {
//    private final Socket socket;
//    private final ObjectOutputStream objectOutputStream;
//    private final ObjectInputStream objectInputStream;
//    public Connection(Socket socket) throws IOException {
//        this.socket = socket;
//
////        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
////        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
//    }
//    public ArrayList<DTO> receive() throws IOException, ClassNotFoundException {
//        return (ArrayList<DTO>) objectInputStream.readObject();
//    }
//    public void send(DTO dto) throws IOException {
//        synchronized (this.objectOutputStream) {
//            objectOutputStream.writeObject(dto);
//            objectOutputStream.writeObject(dto);
//        }
//    }
//
//}
