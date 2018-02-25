package hw3;

public class DVDPlayer {

	private State state;
	private static DVDPlayer instance = null;

	private DVDPlayer() {
		state = DrawerClosedNotPlaying.getInstance();
	}
	
	public static DVDPlayer getInstance() {
		if (instance == null)
			instance = new DVDPlayer();
		return instance;

	}

	public void changeState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}

	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}

	public void playButtonPushed() {
		state.playButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void open() {
		System.out.println("Open DVDPlayer's Drawer.");
	}

	public void close() {
		System.out.println("Close DVDPlayer's Drawer.");
	}

	public void play() {
		System.out.println("Play DVD.");
	}

	public void stop() {
		System.out.println("Stop playing DVD.");
	}
}
