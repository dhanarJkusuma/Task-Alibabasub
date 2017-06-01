package id.cerve.dhanarjkusuma.alibabasub.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Activity.DaftarFragment;
import id.cerve.dhanarjkusuma.alibabasub.Activity.MainActivity;
import id.cerve.dhanarjkusuma.alibabasub.Activity.OnGoingFragment;
import id.cerve.dhanarjkusuma.alibabasub.Activity.ReleaseFragment;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;

/**
 * Created by DhanarJKusuma on 6/11/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;



    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }


    @Override
    public Fragment getItem(int position) {



        if(position == 0)
        {
            ReleaseFragment releaseF = new ReleaseFragment();
            return releaseF;
        }
        else if (position == 1)
        {
            OnGoingFragment onG = new OnGoingFragment();
            return onG;
        }
        else
        {
            DaftarFragment dF = new DaftarFragment();
            return dF;
        }
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }



    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
