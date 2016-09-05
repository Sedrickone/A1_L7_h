package com.onegmail.sedrick.a1_l7_h.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.onegmail.sedrick.a1_l7_h.objects.Note;
import com.onegmail.sedrick.a1_l7_h.R;
import com.onegmail.sedrick.a1_l7_h.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private RVAdapter rvAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private List<Note> notes=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        notes=initNote();
        rvAdapter=new RVAdapter(notes);
        recyclerView.setAdapter(rvAdapter);



    }

    @Override
    protected void onResume() {
        super.onResume();
        rvAdapter=new RVAdapter(notes);
        recyclerView.setAdapter(rvAdapter);
    }

    private List <Note> initNote(){
        notes=new ArrayList<>();
        for (int i = 0; i <10; i++) {
            notes.add(new Note("MacBook Pro","Я очень хочу этот ноутбук, и я куплю его",R.drawable.apple));
            notes.add(new Note("Banana","Банан очень питательный, буду кушать его всегда",R.drawable.banana));
            notes.add(new Note("Dell","В принципе есть хорошая игровая машинка,Allienweir 18 ",R.drawable.dell));
        }

        return notes;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,1);
                break;
                  }
    return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data==null)return;
        String header=data.getStringExtra("header");
        String text=data.getStringExtra("text");
        int image=data.getIntExtra("img",R.drawable.add_layout_image_default);
        notes.add(new Note(header,text,image));
        }
}
