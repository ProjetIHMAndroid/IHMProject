package univ.amu.applicationfamille;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Bundle;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
	
	private AgendaFragment agendaFragment = new AgendaFragment();
	private RepasFragment repasFragment = new RepasFragment();
	private ListeCourseFragment listeCourseFragment = new ListeCourseFragment();

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
			new ArrayAdapter<String>(getActionBarThemedContextCompat(),
				android.R.layout.simple_list_item_1,
				android.R.id.text1, 
				new String[] {
					getString(R.string.title_agenda),
					getString(R.string.title_menu),
					getString(R.string.title_liste_course), 
				}
			),
			this
		);
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id){
		switch (position){
			case 0:// Agenda
				getSupportFragmentManager().beginTransaction().replace(R.id.container, this.agendaFragment).commit();
				return true;
			case 1:// Gestion des repas
				getSupportFragmentManager().beginTransaction().replace(R.id.container, this.repasFragment).commit();
				break;
			case 2:// Liste des courses
				getSupportFragmentManager().beginTransaction().replace(R.id.container, this.listeCourseFragment).commit();
				break;
			default:
				break;
		}
		
		return true;
	}

}
