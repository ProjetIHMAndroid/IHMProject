package univ.amu.applicationfamille;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class ListeCourseFragment extends ListFragment {

	/**
	 * Création de la liste des courses de facon staticp our le moment
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
 
        map = new HashMap<String, String>();
        map.put("titre", "Pizza");
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Coca");
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Fruits");
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Salade");
        listItem.add(map);
 
        SimpleAdapter myAdapter = new SimpleAdapter (getActivity().getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"titre"}, new int[] {R.id.titre});
 
       setListAdapter(myAdapter);
       
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_liste_courses, container, false);
	}
}
