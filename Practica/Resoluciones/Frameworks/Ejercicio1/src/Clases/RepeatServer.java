package Clases;

import java.io.PrintWriter;

public class RepeatServer extends SingleThreadTCPServer {			/////////////////////// !!!! ESTA MAL !!!! //////////////////////////
	private int RepeatTimes;
	private String Separation;
	
	
	
	public RepeatServer(int times, String Separation) {
		this.RepeatTimes = times;
		this.Separation = Separation;
	}
	
	public RepeatServer(int times) {
		this.RepeatTimes = times;
		this.Separation = " ";
	}
	
	
	@Override
    public void handleMessage(String message, PrintWriter out) {
			out.println(new String(new char[RepeatTimes]).replace("\0", message + Separation));
    }
	
    public static void main(String[] args) {
		String[] aux = new String[1];
		aux[0] = "7";					//puerto por defecto
    	if(args.length < 3)
    		throw new RuntimeException("Wrong number of arguments");
    	if(!args[2].isEmpty()) {
    		new RepeatServer(Integer.parseInt(args[1]),args[2]).startLoop(aux);;
    	}
    	else
    		new RepeatServer(Integer.parseInt(args[1])).startLoop(args);
    }
    
    public void CloseConenction() {
    	System.out.println("Gracias por conectarte con RepeatServer!");
    }
    
    public boolean KeyWord(String line) {
    	return line.equalsIgnoreCase("adios");
    }

}
