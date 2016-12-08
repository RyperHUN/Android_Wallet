package ryper.homeworkimprovement.Main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ryper on 2016. 12. 08..
 */
public class CategoryPagerManager extends FragmentPagerAdapter {
    private Context context;

    public CategoryPagerManager(FragmentManager fm, Context context) {
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
                ret = new TodoCategoryFragment().Init(context, "A");
                break;
            case 1:
                ret = new TodoCategoryFragment().Init(context, "B");
                break;
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch (position) {
            case 0:
                title = "kutya";
                break;
            case 1:
                title = "Masodik kutya";
//                title = context.getString(R.string.details);
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

