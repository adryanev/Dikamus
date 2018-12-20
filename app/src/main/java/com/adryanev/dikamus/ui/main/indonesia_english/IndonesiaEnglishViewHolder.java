package com.adryanev.dikamus.ui.main.indonesia_english;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.adryanev.dikamus.R;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 8:14 PM
 */
public class IndonesiaEnglishViewHolder extends RecyclerView.ViewHolder {

    TextView item;
    public IndonesiaEnglishViewHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.text_cari);

    }
}
