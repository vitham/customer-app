package com.vit.customerapp.ui.feature.menu.notifications.appointment_give_feedback;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.vit.customerapp.R;
import com.vit.customerapp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AppointmentGiveFeedbackActivity extends BaseActivity {


    public static void moveAppointmentGiveFeedbackActivity(Activity activity) {
        Intent intent = new Intent(activity, AppointmentGiveFeedbackActivity.class);
        activity.startActivity(intent);
    }

    @BindView(R.id.image_star1)
    ImageView mImageStar1;

    @BindView(R.id.image_star2)
    ImageView mImageStar2;

    @BindView(R.id.image_star3)
    ImageView mImageStar3;

    @BindView(R.id.image_star4)
    ImageView mImageStar4;

    @BindView(R.id.image_star5)
    ImageView mImageStar5;


    private List<ImageView> mStarsList;

    @Override
    protected void initView() {

        mStarsList = new ArrayList<ImageView>() {{
           add(mImageStar1);
           add(mImageStar2);
           add(mImageStar3);
           add(mImageStar4);
           add(mImageStar5);
        }};
    }

    @Override
    protected int getLayoutId() {
        return R.layout.appointment_give_feedback_activity;
    }

    @Override
    protected int getTitleToolbarId() {
        return R.string.give_feedback;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.skip_menu, menu);
        return true;
    }

    @Override
    public void initActionBar() {
        super.initActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @OnClick({R.id.image_star1, R.id.image_star2, R.id.image_star3, R.id.image_star4, R.id.image_star5})
    void onClickStar(View v) {
        int starRating = 0;

        switch (v.getId()) {
            case R.id.image_star1:
                starRating = 1;
                break;
            case R.id.image_star2:
                starRating = 2;
                break;
            case R.id.image_star3:
                starRating = 3;
                break;
            case R.id.image_star4:
                starRating = 4;
                break;
            case R.id.image_star5:
                starRating = 5;
                break;
        }

        for (int i = 0; i < mStarsList.size(); i++) {
            if (i < starRating) mStarsList.get(i).setSelected(true);
            else  mStarsList.get(i).setSelected(false);
        }
    }
}
