package com.plane.missyou.plane;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.plane.missyou.plane.constant.Constant;
import com.plane.missyou.plane.utils.DataGenerator;
import com.plane.missyou.plane.view.activity.AboutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.main_tablelayout)
    TabLayout mTabLayout;
    @BindView(R.id.main_container)
    FrameLayout mianViewPager;

    private Fragment []mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragments = DataGenerator.getFraments();
        initTableLayout();
    }

    private void initTableLayout() {

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
                setTabLayoutStatus(tab.getPosition());
                // Chagen tab status

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0, tabsCount = DataGenerator.mTabs.length; i < tabsCount; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }
    }

    public void setTabLayoutStatus(int position) {
        for (int i = 0, tabCount = mTabLayout.getTabCount(); i < tabCount; i++) {
            View view = mTabLayout.getTabAt(i).getCustomView();
            ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
            TextView text = (TextView) view.findViewById(R.id.tab_content_text);
            if(i == position) {
                icon.setImageResource(DataGenerator.mTabPesRessed[i]);
                text.setTextColor(getResources().getColor(android.R.color.black));
            } else {
                icon.setImageResource(DataGenerator.mTabs[i]);
                text.setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
        }
    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case Constant.TYPE_PLANE_HOME:
                fragment = mFragments[0];
                break;
            case Constant.TYPE_PLANE_SHARE:
                fragment = mFragments[1];
                break;
            case Constant.TYPE_PLANE_MESSAGE:
                fragment = mFragments[2];
                break;
            case Constant.TYPE_PLANE_UESRINFO:
                fragment = mFragments[3];
                break;
        }
        if (null != fragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_about_author) {
            startActivity(new Intent(this, AboutActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_plane) {
            // Handle the camera action
            onTabItemSelected(Constant.TYPE_PLANE_SHARE);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            onTabItemSelected(Constant.TYPE_PLANE_MESSAGE);
        } else if (id == R.id.nav_share) {
            onTabItemSelected(Constant.TYPE_PLANE_SHARE);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
