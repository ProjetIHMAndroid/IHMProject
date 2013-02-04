package univ.amu.applicationfamille;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListeCourseFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView liste = (ListView) getActivity().findViewById(R.id.liste_course);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				  "Linux", "OS/2" };

				// Define a new Adapter
				// First parameter - Context
				// Second parameter - Layout for the row
				// Third parameter - ID of the TextView to which the data is written
				// Forth - the Array of data

				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				  android.R.layout.simple_list_item_1, android.R.id.text1, values);


				// Assign adapter to ListView
				liste.setAdapter(adapter);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_repas, container, false);
	}
}
