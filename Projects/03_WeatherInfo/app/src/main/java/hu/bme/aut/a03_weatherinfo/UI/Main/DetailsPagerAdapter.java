package hu.bme.aut.a03_weatherinfo.UI.Main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.bme.aut.a03_weatherinfo.R;

/**
 * Created by Ryper on 2016. 10. 20..
 */
public class DetailsPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public DetailsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // Ez a függvény csak egyszer hívódik meg, nem fog feleslegesen sok
// ugyanolyan Fragment-et létrehozni!
    @Override
    public Fragment getItem(int position) {
        Fragment ret = null;
        switch (position) {
            case 0:
                ret = new DetailsMainFragment();
                break;
            case 1:
                ret = new DetailsMoreFragment();
                break;
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch (position) {
            case 0:
                title = context.getString(R.string.main);
                break;
            case 1:
                title = context.getString(R.string.details);
                break;
            default:
                title = "";
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
