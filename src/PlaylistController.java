public class PlaylistController {
    public void processMenu(int choice, double duration) {
        switch (choice) {
            case 1:
                if (duration > 4.0) {
                    System.out.println("Long Track");
                } else {
                    System.out.println("Standard Track");
                }
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
    public void loopExamples(int songCount) {
        for (int i = 0; i < songCount; i++) {
            System.out.println("Track Index: " + i);
        }
        int choice = 0;
        do {
            System.out.println("Menu running...");
        } while (choice != 0);
    }
}