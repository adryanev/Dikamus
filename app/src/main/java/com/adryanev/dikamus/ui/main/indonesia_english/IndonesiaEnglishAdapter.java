package com.adryanev.dikamus.ui.main.indonesia_english;

import androidx.lifecycle.LiveData;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import java.util.List;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 8:13 PM
 */
public class IndonesiaEnglishAdapter extends RecyclerView.Adapter<IndonesiaEnglishViewHolder> {

    Context context;
    List<IndonesiaEnglish> data;
    public IndonesiaEnglishAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public IndonesiaEnglishViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pencarian,viewGroup,false);
        return new IndonesiaEnglishViewHolder(view);
    }

    public void setData(List<IndonesiaEnglish> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull IndonesiaEnglishViewHolder indonesiaEnglishViewHolder, int i) {
        if(data!=null) {
            indonesiaEnglishViewHolder.item.setText(data.get(i).getKata());
        }
    }

    @Override
    public int getItemCount() {
        return data !=null ? data.size(): 0;
    }
}
