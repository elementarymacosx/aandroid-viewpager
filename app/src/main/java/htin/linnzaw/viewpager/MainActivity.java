package htin.linnzaw.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tablayout;
    private ViewPager viewpager;
    private int[] tabicons = {R.drawable.apple, R.drawable.banana, R.drawable.grapes, R.drawable.orange};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = findViewById(R.id.viewpager);
        addTabs(viewpager);

        tablayout = findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewpager);
        setupTabIcons();
    }

    private void addTabs(ViewPager viewpager)
    {
        ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setupTabIcons()
    {
        Objects.requireNonNull(tablayout.getTabAt(0)).setIcon(tabicons[0]);
        Objects.requireNonNull(tablayout.getTabAt(1)).setIcon(tabicons[1]);
        Objects.requireNonNull(tablayout.getTabAt(2)).setIcon(tabicons[2]);
        Objects.requireNonNull(tablayout.getTabAt(3)).setIcon(tabicons[3]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        public ViewPagerAdapter(FragmentManager fragmentmanager)
        {
            super(fragmentmanager);
        }
        @NotNull
        @Override
        public Fragment getItem(int position)
        {
            return null;
        }

        @Override
        public int getCount()
        {
            return 1;
        }
    }
}
