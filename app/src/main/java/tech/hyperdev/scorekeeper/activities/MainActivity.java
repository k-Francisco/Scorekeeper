package tech.hyperdev.scorekeeper.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    public ScoreFragment mTeam1;
    public ScoreFragment mTeam2;
    int mTheme;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();

        if(prefs.getInt("Theme", 0) != 0 && savedInstanceState != null){
            mTheme = prefs.getInt("Theme", 0);
        }
        setTheme(mTheme);
        setContentView(R.layout.activity_main);

        mTeam1 = new ScoreFragment(getString(R.string.team_name_1));
        mTeam2 = new ScoreFragment(getString(R.string.team_name_2));

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, mTeam1)
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container2, mTeam2)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if(prefs.getInt("Theme", 0) == R.style.AppTheme){
            inflater.inflate(R.menu.night_menu, menu);
        }
        else {
            inflater.inflate(R.menu.day_menu, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.dayMode:
                if(prefs.getInt("Theme", 0) == R.style.AppTheme){
                    mTheme = R.style.CustomTheme;
                    editor.putInt("Theme", mTheme);
                    editor.apply();
                    recreate();
                }
                else{
                    mTheme = R.style.AppTheme;
                    editor.putInt("Theme", mTheme);
                    editor.apply();
                    recreate();
                }
                return  true;

            default: return true;
        }
    }
}
