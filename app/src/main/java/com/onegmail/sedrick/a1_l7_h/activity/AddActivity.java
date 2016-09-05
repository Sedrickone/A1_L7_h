package com.onegmail.sedrick.a1_l7_h.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.onegmail.sedrick.a1_l7_h.R;

/**
 * Created by ОБИ on 04.09.2016.
 */
public class AddActivity extends AppCompatActivity {

    Button btn_ok;
    Button btn_cancel;
    TextView txt_header;
    TextView txt_text;
    ImageView image;
    int image_rec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        btn_ok=(Button)findViewById(R.id.add_layout_btn_ok);
        btn_cancel=(Button)findViewById(R.id.add_layout_btn_cancel);

        txt_header=(TextView)findViewById(R.id.add_layout_header_text);
        txt_text=(TextView)findViewById(R.id.add_layout_text_edit);

        image=(ImageView)findViewById(R.id.add_layout_image);
    }

    public void add_layout_click(View view) {
        Intent  intent;
        switch (view.getId()){
            case R.id.add_layout_btn_ok:
                intent=new Intent();
                intent.putExtra("header",txt_header.getText().toString());
                intent.putExtra("text",txt_text.getText().toString());
                intent.putExtra("img",image_rec);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.add_layout_btn_cancel:
                Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
                finish();
                break;}
    }

    public void setImg(View view) {
        int temp=R.drawable.add_layout_image_default;
        switch (view.getId()){
            case R.id.add_layout_img_1:
                temp=R.drawable.apple;
                break;
            case R.id.add_layout_img_2:
                temp=R.drawable.dell;
                break;
            case R.id.add_layout_img_3:
                temp=R.drawable.banana;
                break;
            case R.id.add_layout_img_4:
                temp=R.drawable.hamburger;
                break;
        }
        image.setImageResource(temp);
        image_rec=temp;
    }
}
