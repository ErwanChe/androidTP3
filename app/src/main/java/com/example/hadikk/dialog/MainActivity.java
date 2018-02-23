package com.example.hadikk.dialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView rcview;
    private NotesOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcview = findViewById(R.id.recyclerView);

        rcview.setAdapter(new NameAdapter(getLayoutInflater()));
        rcview.setLayoutManager(new LinearLayoutManager(this));


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialogview,null);
                builder.setView(dialogView);

                builder.setTitle("XAR TSAROTH");

                builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AlertDialog alertDialog = (AlertDialog) dialog;
                        EditText et =  alertDialog.findViewById(R.id.editText);
                        Log.d("OUI","J'ai cliqué OUI" + et.getText().toString());
                        NameAdapter nameAdapter = (NameAdapter) rcview.getAdapter();
                        nameAdapter.add(et.getText().toString());
                    }
                });

                builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("NON","J'ai cliqué NON");
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
