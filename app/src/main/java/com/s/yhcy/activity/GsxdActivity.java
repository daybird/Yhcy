package com.s.yhcy.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.s.yhcy.R;
import com.s.yhcy.adapter.GsxdListAdapter;
import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.sql.GsxdDBHelper;

import java.util.ArrayList;
import java.util.List;

public class GsxdActivity extends MyAppCompatActivity {
    private List<Gsxd> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsxd);
        final ListView listView = (ListView) this.findViewById(R.id.gsxdList);
        SearchView searchView = (SearchView) this.findViewById(R.id.gsxdSearchView);

        GsxdDBHelper dbHelper = new GsxdDBHelper(this, GsxdDBHelper.DBFILE, null, 1);
        list = dbHelper.queryGsxd();
        GsxdListAdapter adapter = new GsxdListAdapter(this, list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Gsxd> newList = new ArrayList<Gsxd>();
                for (Gsxd gsxd : list) {
                    if (gsxd.getNeiRong().getContent().contains(newText))
                        newList.add(gsxd);
                }
                GsxdListAdapter newAdapter = new GsxdListAdapter(GsxdActivity.this, newList);
                newAdapter.setSearchText(newText);
                listView.setAdapter(newAdapter);
                return true;
            }
        });
    }
}
