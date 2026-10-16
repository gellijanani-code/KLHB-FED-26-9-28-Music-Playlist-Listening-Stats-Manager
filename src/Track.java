
public class Track {
    private String title;
    private double durationMinutes;
    private boolean isFavorite;
    public Track(String title, double durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.isFavorite = false;
    }
    public static void main(String[] args) {
        // Object Creation (Instantiating the Track class)
        Track myTrack = new Track("Shape of You", 3.53);
        System.out.println("Song Created: " + myTrack.title);
    }
}

