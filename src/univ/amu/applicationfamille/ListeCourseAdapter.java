package univ.amu.applicationfamille;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListeCourseAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public ListeCourseAdapter(Context context, String[] values) {
    super(context, R.layout.affichageitem, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.affichageitem, parent, false);
    TextView textView1 = (TextView) rowView.findViewById(R.id.titre);
    TextView textView2 = (TextView) rowView.findViewById(R.id.description);
    textView1.setText(values[position]);
    textView2.setText(values[position]);

    return rowView;
  }
} 
