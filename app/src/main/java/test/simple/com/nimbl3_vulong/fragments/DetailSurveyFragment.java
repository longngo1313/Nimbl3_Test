package test.simple.com.nimbl3_vulong.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import test.simple.com.nimbl3_vulong.R;
import test.simple.com.nimbl3_vulong.adapter.QuestionListAdapter;
import test.simple.com.nimbl3_vulong.data.Question;
import test.simple.com.nimbl3_vulong.data.SurveyCard;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSurveyFragment extends Fragment {


    /**
     * Key for Data input to fragment
     */
    private static final String DETAIL_DATA = "detail_data";

    /**
     * Key for Title survey input to fragment
     */
    private static final String DETAIL_TITLE = "detail_title";


    private static final String TAG = "DetailSurveyFragment";

    private TextView mTextData;

    private RecyclerView mListQuestion;

    public static DetailSurveyFragment newInstance(SurveyCard data, String title) {
        DetailSurveyFragment myFragment = new DetailSurveyFragment();

        if(data != null){
            Bundle args = new Bundle();
            args.putParcelableArrayList(DETAIL_DATA, data.getListQuestion());
            args.putString(DETAIL_TITLE, title);
            myFragment.setArguments(args);
        }
        return myFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_detail_survey2, container, false);
        mTextData = (TextView) view.findViewById(R.id.survey_data);
        mListQuestion = (RecyclerView) view.findViewById(R.id.question_list_view);

        ArrayList<Question> data = getArguments().getParcelableArrayList(DETAIL_DATA);

        String title = getArguments().getString(DETAIL_TITLE);

        if(data!=null && !data.isEmpty()){
            data.remove(0);
            data.remove(data.size()-1);
        }
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(data, getActivity());

        if(mListQuestion!=null){
            mListQuestion.setAdapter(questionListAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mListQuestion.setLayoutManager(layoutManager);
            mListQuestion.setItemAnimator(new DefaultItemAnimator());
        }

        if(title!=null && !title.isEmpty()){
            mTextData.setText(getString(R.string.survey_string) + title);
        }

        //Set to not allow swipe action to under view
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return view;
    }

}
