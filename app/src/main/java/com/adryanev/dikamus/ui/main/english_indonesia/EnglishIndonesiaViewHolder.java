package com.adryanev.dikamus.ui.main.english_indonesia;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.adryanev.dikamus.R;
import com.google.android.material.card.MaterialCardView;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 9:39 PM
 */
class EnglishIndonesiaViewHolder extends RecyclerView.ViewHolder {
    MaterialCardView cardView;
    TextView item;
    public EnglishIndonesiaViewHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.text_cari);
        cardView = itemView.findViewById(R.id.card_cari);
    }
}
