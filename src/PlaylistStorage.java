public class PlaylistStorage {
    private Track[] playlist = new Track[100];
    private int count = 0;
    public void storeTrack(Track trackObject) {
        playlist[count] = trackObject; // Adding class object into array
        count++;
    }
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println("Track " + (i + 1) + ": " + playlist[i].toString());
        }
    }
}
