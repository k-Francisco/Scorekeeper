package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    public TextView mTeamName;
    String teamName;

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
        mTeamName.setText(teamName);

        return view;
    }

}
