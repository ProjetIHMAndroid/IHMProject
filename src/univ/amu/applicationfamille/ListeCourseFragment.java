package univ.amu.applicationfamille;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListeCourseFragment extends ListFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
 
        map = new HashMap<String, String>();
        map.put("titre", "Word");
        map.put("description", "Editeur de texte");
        listItem.add(map);
 
        /*map = new HashMap<String, String>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Power Point");
        map.put("description", "Logiciel de présentation");
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier électronique");
        listItem.add(map);*/
 
        SimpleAdapter myAdapter = new SimpleAdapter (getActivity().getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"titre", "description"}, new int[] {R.id.titre, R.id.description});
 
       setListAdapter(myAdapter);
       
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_liste_courses, container, false);
	}
}
