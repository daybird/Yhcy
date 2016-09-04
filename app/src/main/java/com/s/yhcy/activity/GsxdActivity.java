package com.s.yhcy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.s.yhcy.R;
import com.s.yhcy.adapter.GsxdListAdapter;
import com.s.yhcy.dao.GsxdDao;

public class GsxdActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsxd);
        final ListView listView = (ListView) this.findViewById(R.id.gsxdList);
        SearchView searchView = (SearchView) this.findViewById(R.id.gsxdSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        GsxdListAdapter adapter = new GsxdListAdapter(this, GsxdDao.queryAll());
        listView.setAdapter(adapter);

    }
}
