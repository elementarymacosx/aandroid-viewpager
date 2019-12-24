package htin.linnzaw.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AppleFragment.OnFragmentInteractionListener,
        BananaFragment.OnFragmentInteractionListener, GrapesFragment.OnFragmentInteractionListener,
        OrangeFragment.OnFragmentInteractionListener
{
    private TabLayout tablayout;
    private final int[] tabicons = {R.drawable.apple, R.drawable.banana, R.drawable.grapes, R.drawable.orange};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpager = findViewById(R.id.viewpager);
        addTabs(viewpager);

        tablayout = findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewpager);
        setupTabIcons();
    }

    private void addTabs(ViewPager viewpager)
    {
        ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpageradapter.addFrag(new AppleFragment(), "APPLE");
        viewpageradapter.addFrag(new BananaFragment(), "BANANA");
        viewpageradapter.addFrag(new GrapesFragment(), "GRAPES");
        viewpageradapter.addFrag(new OrangeFragment(), "ORANGE");
        viewpager.setAdapter(viewpageradapter);
    }

    private void setupTabIcons()
    {
        Objects.requireNonNull(tablayout.getTabAt(0)).setIcon(tabicons[0]);
        Objects.requireNonNull(tablayout.getTabAt(1)).setIcon(tabicons[1]);
        Objects.requireNonNull(tablayout.getTabAt(2)).setIcon(tabicons[2]);
        Objects.requireNonNull(tablayout.getTabAt(3)).setIcon(tabicons[3]);
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {
        Log.e("URI", uri.toString());
    }


    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager fragmentmanager)
        {
            super(fragmentmanager);
        }

        @NotNull
        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        void addFrag(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }
}
