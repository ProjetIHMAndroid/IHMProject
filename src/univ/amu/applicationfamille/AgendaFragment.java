package univ.amu.applicationfamille;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

public class AgendaFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Date d = new Date();
		//CalendarView calendarAffichage = (CalendarView) findViewById(R.id.calendrier);
		//Calendar calendrier = Calendar.getInstance();
		//calendarAffichage.setAdapter();
		
		//CalendarContact c = CalendarContract.;
		//calendar.setShowWeekNumber(true);
		//calendar.setVerticalFadingEdgeEnabled(true);
	}
	
	private View findViewById(int calendrier) {
		return getActivity().findViewById(calendrier);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_agenda, container, false);
	}
}
