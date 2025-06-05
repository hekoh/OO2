package Clases;

import java.io.PrintWriter;

public class EchoServer extends SingleThreadTCPServer {
   
	@Override
    public void handleMessage(String message, PrintWriter out) {
        out.println(message);
    }

    public static void main(String[] args) {
        new EchoServer().startLoop(args);

    }
    
    public void CloseConenction() {
    	System.out.println("Gracias por conectarte con EchoServer!");
    }
    
    public boolean KeyWord(String line) {
    	return line.equalsIgnoreCase("adios");
    }

}