package hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class DVDPlayerTest {
	
	@Test
	public void testGetInstance() {
		System.out.println("DVDPlayer get instance testing.....");
		DVDPlayer dVDPlayer1 = DVDPlayer.getInstance();
		assertNotNull("dVDPlayer1 is null.", dVDPlayer1);
		
		DVDPlayer dVDPlayer2 = DVDPlayer.getInstance();
		assertNotNull("dVDPlayer2 is null.", dVDPlayer2);
		
		assertEquals("DVDPlayer violates singleton propertirs.", dVDPlayer1, dVDPlayer2);
	}
	@Test
	public void testChangeState() {
		System.out.println("DVDPlayer Change State testing");
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		assertEquals(DrawerClosedNotPlaying.getInstance(),player.getState());
	}
	@Test
	public void testGetState() {
		System.out.println("DVDPlayer get state testing.....");
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		State state = player.getState();
		assertEquals(DrawerClosedNotPlaying.getInstance(), state);
		
	}

	@Test
	public void testopenCloseButtonPushed() {
		System.out.println("DVDPLayer Open Close Button testing");
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedNotPlaying.getInstance());
		player.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), player.getState());
		
		player.openCloseButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), player.getState());
		
		player.changeState(DrawerClosedPlaying.getInstance());
		player.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), player.getState());
	}
	@Test
	public void testPlayButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedNotPlaying.getInstance());
		player.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), player.getState());
		
		player.changeState(DrawerOpen.getInstance());
		player.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), player.getState());	
		
	}
	@Test
	public void testStopButtonPushed() {
		DVDPlayer player = DVDPlayer.getInstance();
		
		player.changeState(DrawerClosedPlaying.getInstance());
		player.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), player.getState());
		
		
		
	}

}
