package hw3;

public class DrawerClosedNotPlaying implements State {

	private DrawerClosedNotPlaying() {
	}

	private static DrawerClosedNotPlaying instance = null;

	public static DrawerClosedNotPlaying getInstance() {

		if (instance == null) {
			instance = new DrawerClosedNotPlaying();
		}
		return instance;

	}

	public void openCloseButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("Already not playnig anything.");
	}

}
