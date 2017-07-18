package tech.hyperdev.scorekeeper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    public ScoreFragment mTeam1;
    public ScoreFragment mTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeam1 = new ScoreFragment();
        mTeam2 = new ScoreFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, mTeam1)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container2, mTeam2)
                .commit();

    }
}
