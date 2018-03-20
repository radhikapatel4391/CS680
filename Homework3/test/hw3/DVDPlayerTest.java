package hw3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;




public class DVDPlayerTest {
	
	@Test
	public void testGetInstance() {
		System.out.println("DVDPlayer get instance testing.....");
		DVDPlayer dVDPlayer1 = DVDPlayer.getInstance();
		assertThat("dVDPlayer1 is null.", dVDPlayer1,is(notNullValue()));
		
		DVDPlayer dVDPlayer2 = DVDPlayer.getInstance();
		assertThat("dVDPlayer2 is null.", dVDPlayer2, is(notNullValue()));
		
		assertThat("DVDPlayer violates singleton propertirs.", dVDPlayer1, is(sameInstance(dVDPlayer2)));
	}
	@Test
	public void testChangeState() {
		System.out.println("DVDPlayer Change State testing");
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		assertThat(player.getState(),is(sameInstance(DrawerClosedNotPlaying.getInstance())));
	}
	@Test
	public void testGetState() {
		System.out.println("DVDPlayer get state testing.....");
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		State state = player.getState();
		assertThat(state,is(DrawerClosedNotPlaying.getInstance()));
		
	}

	@Test
	public void testopenCloseButtonPushed() {
		System.out.println("DVDPLayer Open Close Button testing");
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedNotPlaying.getInstance());
		player.openCloseButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerOpen.getInstance())));
		
		player.openCloseButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerClosedNotPlaying.getInstance())));
		
		player.changeState(DrawerClosedPlaying.getInstance());
		player.openCloseButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerOpen.getInstance())));
	}
	@Test
	public void testPlayButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedNotPlaying.getInstance());
		player.playButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerClosedPlaying.getInstance())));
		
		player.changeState(DrawerOpen.getInstance());
		player.playButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerClosedPlaying.getInstance())));	
		
	}
	@Test
	public void testStopButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedPlaying.getInstance());
		player.stopButtonPushed();
		assertThat(player.getState(),is(sameInstance(DrawerClosedNotPlaying.getInstance())));
		
		
		
	}

}
