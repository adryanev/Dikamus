package com.adryanev.dikamus.ui.main.english_indonesia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.ui.terjemahan.TerjemahanActivity;
import com.adryanev.dikamus.utils.ItemClickSupport;

import java.util.List;

import timber.log.Timber;

public class EnglishIndonesiaFragment extends Fragment {

    private EnglishIndonesiaViewModel mViewModel;

    SearchView searchView;
    RecyclerView recyclerView;
    EnglishIndonesiaAdapter adapter;
    public static EnglishIndonesiaFragment newInstance() {
        return new EnglishIndonesiaFragment();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        searchView.setOnQueryTextListener(queryTextListener);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
       inflater.inflate(R.menu.search_menu, menu);
       MenuItem item = menu.findItem(R.id.action_search);
       SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
       if(item != null){
           searchView = (SearchView) item.getActionView();
       }
       if(searchView != null){
           searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
           searchView.setQueryHint("English to Indonesia");
           searchView.setOnQueryTextListener(queryTextListener);

       }
    }
    private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Timber.d("Query Search: %s",query);
            getDataFromDb(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            Timber.d("Query Text: %s",newText );
            getDataFromDb(newText);
            return true;
        }


    };
    private void getDataFromDb(String newText) {
        newText = newText+"%";
        Timber.d("NewText: %s",newText);
        mViewModel.search(newText).observe(this.getViewLifecycleOwner(), new Observer<List<EnglishIndonesia>>() {
            @Override
            public void onChanged(List<EnglishIndonesia> englishIndonesias) {
                adapter.setData(englishIndonesias);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.english_indonesia_fragment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("English-Indonesia");
        recyclerView = v.findViewById(R.id.ei_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EnglishIndonesiaAdapter(getContext());
        recyclerView.setAdapter(adapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View view) {
                Timber.d("data clicked: %s",adapter.data.get(position));
                Intent i = new Intent(getActivity(), TerjemahanActivity.class);
                i.putExtra("type","en-in");
                i.putExtra("data",adapter.data.get(position));
                startActivity(i);

            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EnglishIndonesiaViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
