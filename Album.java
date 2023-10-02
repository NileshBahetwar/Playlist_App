import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song>songs;

    public Album() {

    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs=new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // find song
    public boolean findSong(String title){
        for(Song song : this.songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    // add songs to album
    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            Song song=new Song(title,duration);
            this.songs.add(song);
            return "Song has been added added to album successfully!!";
        }
        return "Song already exists.";
    }

   // add to playlist from album
   public String addToPlaylistFromAlbum(String title,LinkedList<Song>playlist){
        for(Song song : this.songs){
            if(song.getTitle().equals(title)){
                playlist.add(song);
                return "song has been added in the playlist successfully...!!!";
            }
        }
        return "song doesn't exist in the album";
   }

    /**
     * Polymorphism - method overloading
     * @param songNo
     * @param playlist
     * @return
     */
   public String addToPlaylistFromAlbum(int songNo,LinkedList<Song>playlist){
        int index=songNo-1;  // we know idx starts from 0 but user don't know
        if(index>=0 && index<this.songs.size()){
           playlist.add(this.songs.get(index));
           return "song has been added in the playlist successfully...!!!";
        }
        return "Incorrect song number.";
   }
}
