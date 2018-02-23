package com.example.hadikk.dialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.jar.Attributes;

/**
 * Created by hadikk on 22/02/18.
 */

public class NameViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public NameViewHolder(View itemView)
    {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(String name)
    {
        textView.setText(name);
    }
}
