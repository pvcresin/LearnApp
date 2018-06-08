package com.example.leica.learnapp;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        //ActionBarをGetしてTabModeをセット
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab( actionBar.newTab() .setText("First") .setTabListener(new TabListener<>(this, "tag1", TabFragment1.class )) );

        actionBar.addTab( actionBar.newTab() .setText("Second") .setTabListener(new TabListener<>(this, "tag2", TabFragment2.class)) );

        actionBar.addTab( actionBar.newTab() .setText("Third") .setTabListener(new TabListener<>(this, "tag3", TabFragment3.class)) );

    }
}



class TabListener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    //コンストラクタ
    public TabListener(Activity activity, String tag, Class<T> clz) {
        mActivity = activity;
        mTag = tag;
        mClass = clz;
        mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);
    }

    //タブが選択されたとき
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            FragmentManager fm = mActivity.getFragmentManager();
            fm.beginTransaction().add(R.id.container, mFragment, mTag).commit();

        } else {
            if (mFragment.isDetached()) {
                FragmentManager fm = mActivity.getFragmentManager();
                fm.beginTransaction().attach(mFragment).commit();
            }
        }
    }

    //タブの選択が解除されたとき
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            FragmentManager fm = mActivity.getFragmentManager();
            fm.beginTransaction().detach(mFragment).commit();
        }
    }

    //選択されたタブが選択されたとき
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {    }
}