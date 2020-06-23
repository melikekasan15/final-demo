package tr.edu.mu.ceng.gui.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private String[] Ozellik;
    private LayoutInflater inflater;
    private String[] sBolge;
    private String[] sOzellik;
    private ViewGroup viewGroup;

    Adapter(Context context, String[] bolgeler, String[] Bolge) {
        this.inflater = LayoutInflater.from(context);
        this.sBolge = Bolge;
        this.sOzellik = Ozellik;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        boolean attachToRoot;
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        String bolge =sBolge[i];
        String ozellik =sOzellik[i];
        ViewHolder viewHolder = null;
        viewHolder.bolge.setText(bolge);
        viewHolder.bolgeozellik.setText(ozellik);


    }

    @Override
    public int getItemCount() {
        return sBolge.length;
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        TextView bolge,bolgeozellik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bolge = itemView.findViewById(R.id.bolge);
            bolgeozellik = itemView.findViewById(R.id.bolgeozellik);


        }
    }
}
