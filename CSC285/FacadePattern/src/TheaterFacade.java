public class TheaterFacade {

    private CDPlayer cdPlayer;
    private PopCornPopper popCornPopper;
    private Amplifier amplifier;

    public TheaterFacade() {
        cdPlayer = new CDPlayer();
        popCornPopper = new PopCornPopper();
        amplifier = new Amplifier();
    }

    public void turnEverythingOn() {
        cdPlayer.turnOn();
    }

    public void turnEverythingOff() {}

    public void watchMovie() {

    }
}
