package test.simple.com.nimbl3_vulong.presenter;

import java.util.List;

import test.simple.com.nimbl3_vulong.base.BaseInterface;
import test.simple.com.nimbl3_vulong.data.SurveyCard;

/**
 * Created by Admin on 8/20/2017.
 */

public interface IFragmentListener extends BaseInterface {

    void showLoadingView();

    void initIndicator(int i);

    void showSurveyList();

    void showErrorText();

    void initViewPager(List<SurveyCard> mListSurvey );
}
