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

		ListView listView = (ListView) getActivity().findViewById(R.id.mylist);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		  "Linux", "OS/2" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
		  android.R.layout.simple_list_item_1, android.R.id.text1, values);


		// Assign adapter to ListView
		listView.setAdapter(adapter);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_liste_courses, container, false);
	}
}