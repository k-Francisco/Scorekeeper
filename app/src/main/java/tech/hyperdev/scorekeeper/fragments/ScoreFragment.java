package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    public TextView mTeamName, mScore;
    ImageButton mPlus, mMinus;
    String teamName;
    int teamScore=0;

    public ScoreFragment() {
        // Required empty public constructor
    }
    public ScoreFragment(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        mTeamName = (TextView) view.findViewById(R.id.tvTeamName);

        mScore = (TextView) view.findViewById(R.id.textView2);
        mPlus = (ImageButton) view.findViewById(R.id.btnPlus);
        mMinus = (ImageButton) view.findViewById(R.id.btnMinus);

        if(savedInstanceState != null)
        {
            teamScore = savedInstanceState.getInt("TeamScore");
            mScore.setText(Integer.toString(teamScore));
            teamName = savedInstanceState.getString("TeamName");
        }
        mTeamName.setText(teamName);


        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamScore++;
                mScore.setText(Integer.toString(teamScore));
            }
        });

        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamScore--;
                mScore.setText(Integer.toString(teamScore));
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TeamScore", teamScore);
        outState.putString("TeamName", teamName);
    }
}
