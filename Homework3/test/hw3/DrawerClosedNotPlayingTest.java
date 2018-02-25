package hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class DrawerClosedNotPlayingTest {
	
	@Test
	public void testGetInstance() {
		DrawerClosedNotPlaying drawerClosedNotPlaying1 = DrawerClosedNotPlaying.getInstance();
		assertNotNull("drawerClosedNotPlaying1 is null.", drawerClosedNotPlaying1);
		
		DrawerClosedNotPlaying drawerClosedNotPlaying2 = DrawerClosedNotPlaying.getInstance();
		assertNotNull("drawerClosedNotPlaying2 is null.", drawerClosedNotPlaying2);
		
		assertEquals("DrawerOpen violates singleton propertirs.", drawerClosedNotPlaying1, drawerClosedNotPlaying2);
	}

	@Test
	public void testOpenCloseButtonPushed() {
		DrawerClosedNotPlaying state = DrawerClosedNotPlaying.getInstance();
		state.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), DVDPlayer.getInstance().getState());
	}

	@Test
	public void testPlayButtonPushed() {
		DrawerClosedNotPlaying state = DrawerClosedNotPlaying.getInstance();
		state.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), DVDPlayer.getInstance().getState());
	}

	@Test
	public void testStopButtonPushed() {
		assertTrue(true);
	}

}
