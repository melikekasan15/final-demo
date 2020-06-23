package tr.edu.mu.ceng.gui.notification;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Preference extends PreferenceActivity{
    private Object CheckBoxPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefence);
        load_setting();

    }
    private  void load_setting(){
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean chk_night = sp.getBoolean("NIGHT",false);
        if (chk_night){
            getListView().setBackgroundColor(Color.parseColor("#222222"));
        }else {
            getListView().setBackgroundColor(Color.parseColor("#ffffff"));
        }

        CheckBoxPreference chk_night_instant = (CheckBoxPreference)findPreference("NIGHT");
        chk_night_instant.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefence, Object obj) {

                boolean yes =(boolean)obj;
                if (yes){
                    getListView().setBackgroundColor(Color.parseColor("#222222"));
                }else {
                    getListView().setBackgroundColor(Color.parseColor("#ffffff"));
                }

                return true;
            }
        });

        ListPreference lp = (ListPreference)findPreference("ORIENTATION");
        String  orienn = sp.getString("ORIENTATION","false");
        if ("1".equals(orienn)){
            setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_BEHIND));
        }
        else if("2".equals(orienn)){
            setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_PORTRAIT));
        }
        else if ("3".equals(orienn)){
            setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
        }
        lp.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefence, Object obj) {

                String items =(String)obj;
                if (prefence.getKey().equals("ORIENTTATION")){

                }
                   switch (items){
                       case "1":
                           setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_BEHIND));
                           break;
                       case "2":
                           setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_PORTRAIT));
                           break;
                       case "3":
                           setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
                           break;


                   }


                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        load_setting();
        super.onResume();
    }
}
