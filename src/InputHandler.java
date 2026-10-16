import java.util.Scanner;
public class InputHandler {
    public void readSongDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Song Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Song Duration (mins): ");
        double duration = Double.parseDouble(scanner.nextLine());
    }
}

