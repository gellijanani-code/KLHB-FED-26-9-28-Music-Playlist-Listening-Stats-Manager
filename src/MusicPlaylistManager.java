
import java.util.Scanner;
class MediaTrack {
    protected String title;
    protected String artist;
    protected double durationMinutes;
    public MediaTrack(String title, String artist, double durationMinutes) {
        this.title = title;
        this.artist = artist;
        this.durationMinutes = durationMinutes;
    }

    public void displayDetails() {
        System.out.println("Title: " + title + " | Artist: " + artist
                + " | Duration: " + durationMinutes + " mins");
    }
}

// Derived class
class Song extends MediaTrack {
    private String genre;

    public Song(String title, String artist, double durationMinutes, String genre) {
        super(title, artist, durationMinutes);
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + title
                + " | Artist: " + artist
                + " | Duration: " + durationMinutes + " mins"
                + " | Genre: " + genre);
    }
}
public class MusicPlaylistManager {
    private static Song[] playlist = new Song[50];
    private static int totalSongs = 0;
    public static void addSong(String title, String artist,
            double duration, String genre) {
        if (totalSongs < playlist.length) {
            playlist[totalSongs] =
                    new Song(title, artist, duration, genre);
            totalSongs++;
            System.out.println("Song added successfully!");
        } else {
            System.out.println("Playlist is full!");
        }
    }
    public static void addSong(String title, String artist, double duration) {
        addSong(title, artist, duration, "General");
    }
    public static void showPlaylist() {
        if (totalSongs == 0) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("\n--- Current Playlist ---");
        for (int i = 0; i < totalSongs; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].displayDetails();
        }
    }

    // Listening statistics
    public static void printStats() {
        if (totalSongs == 0) {
            System.out.println("No songs available!");
            return;
        }
        double totalDuration = 0;
        Song longestTrack = playlist[0];
        for (int i = 0; i < totalSongs; i++) {
            totalDuration += playlist[i].durationMinutes;

            if (playlist[i].durationMinutes
                    > longestTrack.durationMinutes) {
                longestTrack = playlist[i];
            }
        }
        System.out.println("\n--- Listening Statistics ---");
        System.out.println("Total Songs: " + totalSongs);
        System.out.println("Total Playtime: " + totalDuration + " minutes");
        System.out.print("Longest Song: ");
        longestTrack.displayDetails();
    }

    // Search song
    public static void searchSong(String query) {
        boolean found = false;

        for (int i = 0; i < totalSongs; i++) {
            if (playlist[i].title.toLowerCase().trim()
                    .contains(query.toLowerCase().trim())) {
                playlist[i].displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching song found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        addSong("Shape of You", "Ed Sheeran", 3.53, "Pop");
        addSong("Hotel California", "Eagles", 6.30, "Rock");

        do {
            System.out.println("\n=== MUSIC PLAYLIST MANAGER ===");
            System.out.println("1. Add New Song");
            System.out.println("2. Display All Songs");
            System.out.println("3. Listening Statistics");
            System.out.println("4. Search Song");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Enter song title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter artist: ");
                        String artist = sc.nextLine();

                        System.out.print("Enter duration in minutes: ");
                        double duration =
                                Double.parseDouble(sc.nextLine().trim());

                        System.out.print("Enter genre (or press Enter): ");
                        String genre = sc.nextLine().trim();

                        if (genre.isEmpty()) {
                            addSong(title, artist, duration);
                        } else {
                            addSong(title, artist, duration, genre);
                        }
                        break;

                    case 2:
                        showPlaylist();
                        break;

                    case 3:
                        printStats();
                        break;

                    case 4:
                        System.out.print("Enter song title to search: ");
                        searchSong(sc.nextLine());
                        break;

                    case 5:
                        System.out.println("Thank you! Exiting...");
                        break;

                    default:
                        System.out.println("Enter a number from 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (choice != 5);

        sc.close();
    }
}
