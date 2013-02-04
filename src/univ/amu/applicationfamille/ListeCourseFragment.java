package univ.amu.applicationfamille;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListeCourseFragment extends Fragment {

	private ListView maListViewPerso;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
        maListViewPerso = (ListView) getActivity().findViewById(R.id.listviewperso);
 
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        HashMap<String, String> map;
 
        map = new HashMap<String, String>();
        map.put("titre", "Word");
        map.put("description", "Editeur de texte");
        //map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);
 
 
        map = new HashMap<String, String>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
        //map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Power Point");
        map.put("description", "Logiciel de pr�sentation");
        //map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier �lectronique");
        //map.put("img", String.valueOf(R.drawable.outlook));
        listItem.add(map);
 
        SimpleAdapter mSchedule = new SimpleAdapter (getActivity().getBaseContext(), listItem, R.layout.display_item,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        maListViewPerso.setAdapter(mSchedule);
        
        /*maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
			@Override
        	@SuppressWarnings("unchecked")
         	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				//on r�cup�re la HashMap contenant les infos de notre item (titre, description, img)
        		HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
        		//on cr�er une boite de dialogue
        		AlertDialog.Builder adb = new AlertDialog.Builder(Tutoriel5_Android.this);
        		//on attribut un titre � notre boite de dialogue
        		adb.setTitle("S�lection Item");
        		//on ins�re un message � notre boite de dialogue, et ici on affiche le titre de l'item cliqu�
        		adb.setMessage("Votre choix : "+map.get("titre"));
        		//on indique que l'on veut le bouton ok � notre boite de dialogue
        		adb.setPositiveButton("Ok", null);
        		//on affiche la boite de dialogue
        		adb.show();
        	}
         });*/
 
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_liste_courses, container, false);
	}
}