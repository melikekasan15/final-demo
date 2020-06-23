package tr.edu.mu.ceng.gui.notification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private CardView bildirim,bolge,ekle,gecmis,ayarlar,havadurumu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bildirim =(CardView)findViewById(R.id.bildirim);
        bolge =(CardView)findViewById(R.id.bölge);
        ekle =(CardView)findViewById(R.id.ekle);
        gecmis =(CardView)findViewById(R.id.geçmiş);
        ayarlar =(CardView)findViewById(R.id.ayarlar);
        havadurumu=(CardView)findViewById(R.id.havadurumu);
        // add click Listener to the cards
        bildirim.setOnClickListener(this);
        bolge.setOnClickListener(this);
        ekle.setOnClickListener(this);
        gecmis.setOnClickListener(this);
        ayarlar.setOnClickListener(this);
        havadurumu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.bildirim : i = new Intent(this,MainActivity.class);startActivity(i);break;
            case R.id.bölge : i = new Intent(this,Adapter.class);startActivity(i);break;
            case R.id.ekle : i = new Intent(this,Ekle.class);startActivity(i);break;
            case R.id.geçmiş : i = new Intent(this,Gecmis.class);startActivity(i);break;
            case R.id.ayarlar : i = new Intent(this,Preference.class);startActivity(i);break;
            case R.id.havadurumu : i = new Intent(this,HavaDurumu.class);startActivity(i);break;
            default:break;
        }


    }
}
