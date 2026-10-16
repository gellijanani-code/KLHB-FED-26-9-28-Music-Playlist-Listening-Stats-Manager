class Music {
    protected String title;
    protected String artist;
    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public void displayInfo() {
        System.out.println("Title: " + title + " | Artist: " + artist);
    }
}

class Song extends Music {
    private String genre;
    public Song(String title, String artist, String genre) {
        super(title, artist); // Now correctly calls Music(title, artist)
        this.genre = genre;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}