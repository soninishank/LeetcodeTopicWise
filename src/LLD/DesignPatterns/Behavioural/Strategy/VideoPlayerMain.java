package LLD.DesignPatterns.Behavioural.Strategy;

public class VideoPlayerMain {
    public static void main(String[] args) {
        VideoPlayer player = new TVVideoPlayer(new Phone(), new Resolution480p());
        player.display();
    }
}
