package hw3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;



public class DrawerClosedNotPlayingTest {
	
	@Test
	public void testGetInstance() {
		DrawerClosedNotPlaying drawerClosedNotPlaying1 = DrawerClosedNotPlaying.getInstance();
		assertThat("drawerClosedNotPlaying1 is null.", drawerClosedNotPlaying1, is(notNullValue()));
		
		DrawerClosedNotPlaying drawerClosedNotPlaying2 = DrawerClosedNotPlaying.getInstance();
		assertThat("drawerClosedNotPlaying2 is null.", drawerClosedNotPlaying2, is(notNullValue()));
		
		assertThat("DrawerOpen violates singleton propertirs.", drawerClosedNotPlaying1, is (sameInstance ( drawerClosedNotPlaying2)));
	}

	@Test
	public void testOpenCloseButtonPushed() {
		DrawerClosedNotPlaying state = DrawerClosedNotPlaying.getInstance();
		state.openCloseButtonPushed();
		assertThat(DVDPlayer.getInstance().getState(),is(DrawerOpen.getInstance()));
	}

	@Test
	public void testPlayButtonPushed() {
		DrawerClosedNotPlaying state = DrawerClosedNotPlaying.getInstance();
		state.playButtonPushed();
		assertThat(DVDPlayer.getInstance().getState(), is(DrawerClosedPlaying.getInstance()));
	}

	@Test
	public void testStopButtonPushed() {
		assertTrue(true);
	}

}
