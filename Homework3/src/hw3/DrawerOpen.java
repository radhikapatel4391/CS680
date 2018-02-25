package hw3;

import java.util.Objects;

public class DrawerOpen implements State {

	private static DrawerOpen instance = null;

	private DrawerOpen() {

	}

	public static DrawerOpen getInstance() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new DrawerOpen();
			return instance;
		}
	}

	public void openCloseButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}

	public void playButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("Do Nothing as DVDPlayer is open you pushed stop.");
	}
}
