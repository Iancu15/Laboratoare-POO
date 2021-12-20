package fourth;

public class BadAlbum extends Album  {

	@Override
	public void addSong(Song song) {
		if(song.isPalindrom() && song.name.length() == 3) {
			songs.add(song);
		}
	}

}
