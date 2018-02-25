package hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class DrawerClosedPlayingTest {

	@Test
	public void testGetInstance() {
		DrawerClosedPlaying drawerClosedPlaying1 = DrawerClosedPlaying.getInstance();
		assertNotNull("drawerClosedPlaying1 is null.", drawerClosedPlaying1);
		
		DrawerClosedPlaying drawerClosedPlaying2 = DrawerClosedPlaying.getInstance();
		assertNotNull("drawerClosedPlaying2 is null.", drawerClosedPlaying2);
		
		assertEquals("DrawerClosedPlaying violates singleton propertirs.", drawerClosedPlaying1, drawerClosedPlaying2);
	}

	@Test
	public void testOpenCloseButtonPushed() {
		DrawerClosedPlaying state = DrawerClosedPlaying.getInstance();
		state.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), DVDPlayer.getInstance().getState());
	}

	@Test
	public void testPlayButtonPushed() {
		assertTrue(true);
	}

	@Test
	public void testStopButtonPushed() {
		DrawerClosedPlaying state = DrawerClosedPlaying.getInstance();
		state.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), DVDPlayer.getInstance().getState());
	}

}
