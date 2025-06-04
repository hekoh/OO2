package Clases;

import java.util.List;
import java.util.ArrayList;

public class MediaPlayer {
	private List<Media> media;
	
	
	public MediaPlayer() {
		this.media = new ArrayList<Media>();
	}
	
	public void Play() {
		media.stream().forEach(media -> media.Play());
	}
}
