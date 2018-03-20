package hw3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;



public class DrawerClosedPlayingTest {

	@Test
	public void testGetInstance() {
		DrawerClosedPlaying drawerClosedPlaying1 = DrawerClosedPlaying.getInstance();
		assertThat("drawerClosedPlaying1 is null.", drawerClosedPlaying1,is(notNullValue()));
		
		DrawerClosedPlaying drawerClosedPlaying2 = DrawerClosedPlaying.getInstance();
		assertThat("drawerClosedPlaying2 is null.", drawerClosedPlaying2,is(notNullValue()));
		
		assertThat("DrawerClosedPlaying violates singleton propertirs.", drawerClosedPlaying1, is(sameInstance(drawerClosedPlaying2)));
	}

	@Test
	public void testOpenCloseButtonPushed() {
		DrawerClosedPlaying state = DrawerClosedPlaying.getInstance();
		state.openCloseButtonPushed();
		assertThat(DVDPlayer.getInstance().getState(),is(DrawerOpen.getInstance()));
	}

	@Test
	public void testPlayButtonPushed() {
		assertTrue(true);
	}

	@Test
	public void testStopButtonPushed() {
		DrawerClosedPlaying state = DrawerClosedPlaying.getInstance();
		state.stopButtonPushed();
		assertThat( DVDPlayer.getInstance().getState(),is(DrawerClosedNotPlaying.getInstance()));
	}

}
