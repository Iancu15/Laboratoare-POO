package fourth;

public class ThrillerAlbum extends Album {

	@Override
	public void addSong(Song song) {
		if(song.composer.equals("Michael Jackson") && song.id % 2 == 0)
			songs.add(song);
	}

}
