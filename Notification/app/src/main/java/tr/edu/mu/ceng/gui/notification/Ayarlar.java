package tr.edu.mu.ceng.gui.notification;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Ayarlar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);
    }


    public boolean OnCreateOptionstionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.ayarlar:
                Intent i = new Intent(this,Preference.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(menuItem);

    }
}