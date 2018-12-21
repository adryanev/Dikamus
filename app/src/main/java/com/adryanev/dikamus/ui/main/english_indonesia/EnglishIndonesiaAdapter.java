package com.adryanev.dikamus.ui.main.english_indonesia;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;

import java.util.List;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 9:39 PM
 */
public class EnglishIndonesiaAdapter extends RecyclerView.Adapter<EnglishIndonesiaViewHolder> {

    Context context;
    List<EnglishIndonesia> data;
    public EnglishIndonesiaAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public EnglishIndonesiaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pencarian, viewGroup,false);

        return new EnglishIndonesiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishIndonesiaViewHolder englishIndonesiaViewHolder, int i) {
        if(data!=null){
            EnglishIndonesia item = data.get(i);
            englishIndonesiaViewHolder.item.setText(item.getKata());
        }


    }
    public void setData(List<EnglishIndonesia> data  ){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data !=null ? data.size() : 0;
    }
}
