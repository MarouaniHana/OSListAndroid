package com.example.oslist;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List <OSystem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        recyclerView=findViewById(R.id.recycler);
        list = new ArrayList <>();
        osystemStack();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void osystemStack() {
        list.add(new OSystem(R.drawable.android,"Android ","Plateforme de Google")) ;
        list.add(new OSystem(R.drawable.ios,"Iphone ","Plateforme de Apple")) ;
        list.add(new OSystem(R.drawable.windows,"WindowsPhone ","Plateforme de Microsoft")) ;
    }

}
