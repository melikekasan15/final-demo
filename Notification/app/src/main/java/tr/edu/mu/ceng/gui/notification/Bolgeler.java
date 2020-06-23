package tr.edu.mu.ceng.gui.notification;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Bolgeler extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolgeler);

        String[] bolgeler = getResources().getStringArray(R.array.bolgeler);
        String[] ozellik = getResources().getStringArray(R.array.Bolge_ozellik);

        recyclerView = findViewById(R.id.bolgeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,bolgeler,ozellik);
        recyclerView.setAdapter(adapter);
    }
}