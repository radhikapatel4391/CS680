package hw3;

public class DrawerClosedPlaying implements State {

	private DrawerClosedPlaying() {
	}

	private static DrawerClosedPlaying instance = null;

	public static DrawerClosedPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedPlaying();
		return instance;

	}

	public void openCloseButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.stop();
		player.open();
		player.changeState(DrawerOpen.getInstance());

	}

	public void playButtonPushed() {
		System.out.println("Alredy Playing.");

	}

	public void stopButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
}
