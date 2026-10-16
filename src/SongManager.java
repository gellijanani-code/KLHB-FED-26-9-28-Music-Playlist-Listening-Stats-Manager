public class SongManager {
    public void addSong(String title, String artist, double duration, String genre) {
        System.out.println("Added: " + title + " | Genre: " + genre);
    }
    public void addSong(String title, String artist, double duration) {
        addSong(title, artist, duration, "General"); // Calls Method 1
    }
}