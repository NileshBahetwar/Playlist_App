import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album arijitSingh = new Album("Arijit's album","love-mushUps");
        Album honeySing = new Album("honey's album","rap-Songs");

        arijitSingh.addSongToAlbum("mareez-e-ishq",4.51);
        arijitSingh.addSongToAlbum("tum hi ho",4.22);
        arijitSingh.addSongToAlbum("mai tera boyfriend",3.45);

        honeySing.addSongToAlbum("blue eyes",3.49);
        honeySing.addSongToAlbum("Brown Rang",3.43);
        honeySing.addSongToAlbum("Love Dose",4.06);

        LinkedList<Song>favorites=new LinkedList<>();
        System.out.println("from Arijit's singh's album");
        System.out.println(arijitSingh.addToPlaylistFromAlbum("mareez-e-ishq",favorites));
        System.out.println(arijitSingh.addToPlaylistFromAlbum(7,favorites));
        System.out.println(arijitSingh.addToPlaylistFromAlbum("apna bana le",favorites));
        System.out.println(arijitSingh.addToPlaylistFromAlbum("tum hi ho",favorites));
        System.out.println(arijitSingh.addToPlaylistFromAlbum(3,favorites));

        System.out.println("from Honey singh's album");
        System.out.println(honeySing.addToPlaylistFromAlbum("Love Dose",favorites));
        System.out.println(honeySing.addToPlaylistFromAlbum("blue eyes",favorites));
        System.out.println(honeySing.addToPlaylistFromAlbum("Dheere Dheere se",favorites));
        System.out.println(honeySing.addToPlaylistFromAlbum(2,favorites));
        System.out.println(honeySing.addToPlaylistFromAlbum(4,favorites));


        play(favorites);
    }

    private static void play(LinkedList<Song> favorites) {
        if(favorites.size()==0){
            System.out.println("Your Playlist is empty.");
            return;
        }

        ListIterator<Song>itr=favorites.listIterator();
        System.out.println("Now Playing: "+itr.next());

        Scanner sc=new Scanner(System.in);
        printMenu();

        boolean quit=false;
        boolean wasNext=true;
        boolean pressNext=true;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){

                case 1 :
                    printMenu();
                    break;
                case 2 :
                    if(wasNext==false){
                        itr.next();
                        wasNext=true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You are at the end of your playlist.");
                    }
                    else{
                        System.out.println("Currently playing song: " + itr.next());
                        wasNext=true;
                    }

                    break;
                case 3 :
                    if(wasNext==true){
                        itr.previous();
                        wasNext=false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are at start of your playlist.");
                    }
                    else{
                        System.out.println("currently playing song: " + itr.previous());
                        wasNext=false;
                    }

                    break;
                case 4 :
//                    if(pressNext==true){
//                        if(!itr.hasPrevious()){
//                            System.out.println("you are at start of playlist");
//                            System.out.println("currently playing song: " + itr.next());
//                        }
//                        else {
//                            System.out.println("currently playing song: " + itr.previous());
//                            pressNext = false;
//                        }
//                    }
//                    else{
//                        if(!itr.hasNext()){
//                            System.out.println("you are at end of playlist");
//                            System.out.println("currently playing song: " + itr.previous());
//                        }
//                        System.out.println("currently playing song: "+itr.next());
//                        pressNext=true;
//                    }
                    if(wasNext==true){
                        System.out.println("currently playing song: " + itr.previous());
                        wasNext=false;
                    }
                    else{
                        System.out.println("currently playing song: "+itr.next());
                        wasNext=true;
                    }
                    break;
                case 5 :

                    break;
                case 6 :
                    printAllSongs(favorites);
                    break;
                case 7 :
                    quit=true;
                    break;
                default:
                    System.out.println("You have entered wrong choice please select correct choice");
            }
        }
    }

    private static void printAllSongs(LinkedList<Song> favorites) {
        for(Song song : favorites){
            System.out.println(song);
        }
    }

    private static void printMenu() {
        System.out.println("1. Show the menu again.");
        System.out.println("2. Play next song.");
        System.out.println("3. play previous song.");
        System.out.println("4. Play current song again.");
        System.out.println("5. Delete current song from playlist.");
        System.out.println("6. Print all the song in Playlist.");;
        System.out.println("7. Quit Application.");
    }
}