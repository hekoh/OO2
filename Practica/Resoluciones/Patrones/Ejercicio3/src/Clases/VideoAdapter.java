package Clases;

public class VideoAdapter implements Media{
	private VideoStream stream;
	
	public void Play() {		//Patron Adapter
		stream.reproduce();
	}
}
