package fourth;

import java.util.ArrayList;

public abstract class Album {
	ArrayList<Song> songs = new ArrayList<Song>();
	
	public abstract void addSong(Song song);
	
	public Song removeSong() {
		return songs.remove(0);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(Song song : songs) {
		   string.append(song.name + " | ");
		}
		
		return string.toString();
	}
}
