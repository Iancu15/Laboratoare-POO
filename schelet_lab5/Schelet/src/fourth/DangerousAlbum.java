package fourth;

public class DangerousAlbum extends Album {

	@Override
	public void addSong(Song song) {
		if (song.isPrime())
			songs.add(song);
	}

}
