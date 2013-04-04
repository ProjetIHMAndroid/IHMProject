package univ.amu.applicationfamille;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class AgendaFragment extends Fragment {
	
	/**
	 * Calendrier
	 */
	public Calendar month;
	
	/**
	 * Adapter du calendrier
	 */
	public CalendarAdapter adapter;
	
	/**
	 * handler
	 */
	public Handler handler;
	
	/**
	 * Liste des items stocké
	 */
	public ArrayList<String> items;
	
	/**
	 * Fonction appeler lors de la création de l'activité
	 */
	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	    month = Calendar.getInstance();
	    
	    items = new ArrayList<String>();
	    adapter = new CalendarAdapter(getActivity().getBaseContext(), month);
	    
	    GridView gridview = (GridView) getActivity().findViewById(R.id.gridview);
	    gridview.setAdapter(adapter);
	    
	    handler = new Handler();
	    handler.post(calendarUpdater);
	    
	    TextView title  = (TextView) findViewById(R.id.title);
	    title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	    
	    TextView previous  = (TextView) findViewById(R.id.previous);
	    previous.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(month.get(Calendar.MONTH)== month.getActualMinimum(Calendar.MONTH)) {				
					month.set((month.get(Calendar.YEAR)-1),month.getActualMaximum(Calendar.MONTH),1);
				} else {
					month.set(Calendar.MONTH,month.get(Calendar.MONTH)-1);
				}
				refreshCalendar();
			}
		});
	    
	    TextView next  = (TextView) findViewById(R.id.next);
	    next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(month.get(Calendar.MONTH)== month.getActualMaximum(Calendar.MONTH)) {				
					month.set((month.get(Calendar.YEAR)+1),month.getActualMinimum(Calendar.MONTH),1);
				} else {
					month.set(Calendar.MONTH,month.get(Calendar.MONTH)+1);
				}
				refreshCalendar();
			}
		});
	    
		gridview.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		    	TextView date = (TextView)v.findViewById(R.id.date);
		        if(date instanceof TextView && !date.getText().equals("")) {
		        	//Action au click sur un item de l'agenda => c'est à dire 
		        	//rien pour le moment dans l'attente d'
		        	
		        	Context context = getActivity().getApplicationContext();
		        	CharSequence text = "Ceci est une date du calendrier!";
		        	int duration = Toast.LENGTH_SHORT;

		        	Toast toast = Toast.makeText(context, text, duration);
		        	toast.show();
		        }
		        
		    }
		});
	}
	
	/**
	 * Propriété de la class permetant de mettre à jour le calendrier
	 */
	public Runnable calendarUpdater = new Runnable(){
		@Override
		public void run(){
			items.clear();
			// On remplie de valeur fictive TODO implémenter class pour récupérer de vrais données
			for(int i=0;i<31;i++){
				Random r = new Random();
				if(r.nextInt(10)>6){
					items.add(Integer.toString(i));
				}
			}
			adapter.setItems(items);
			adapter.notifyDataSetChanged();
		}
	};
	
	/**
	 * Action executer lors de la création d'un intent
	 * @param intent
	 */
	public void onNewIntent(Intent intent) {
		String date = intent.getStringExtra("date");
		String[] dateArr = date.split("-"); // le format est yyyy-mm-dd
		month.set(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
	}
	
	/**
	 * Fonction permetant de mettre à jour le calendrier
	 */
	public void refreshCalendar()
	{
		TextView title  = (TextView) findViewById(R.id.title);
		
		adapter.refreshDays();
		adapter.notifyDataSetChanged();				
		handler.post(calendarUpdater); // génère des données aléatoires				
		
		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	}
	
	/**
	 * Retourne une view dont l'id est passé en paramètre
	 * @param int object
	 * @return View
	 */
	private View findViewById(int objet) {
		return getActivity().findViewById(objet);
	}
	
	/**
	 * Fonction executer lors de la création de la view
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_agenda, container, false);
	}
}
