package com.example.boyzz.melody_player;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.boyzz.melody_player.tabs_fragments.Albums;
import com.example.boyzz.melody_player.tabs_fragments.Artists;
import com.example.boyzz.melody_player.tabs_fragments.Folders;
import com.example.boyzz.melody_player.tabs_fragments.Playlists;
import com.example.boyzz.melody_player.tabs_fragments.Songs;

public class MainActivity extends AppCompatActivity
{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    Songs s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Songs(),"Songs");
        adapter.addFragment(new Albums(),"Albums");
        adapter.addFragment(new Artists(),"Artists");
        adapter.addFragment(new Playlists(),"Playlist");
        adapter.addFragment(new Folders(),"Folders");

        s = (Songs)adapter.getFragment(viewPager.getCurrentItem());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem searchitem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) searchitem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //s.search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //s.search(newText);
                return false;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}