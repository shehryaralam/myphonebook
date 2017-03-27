package com.example.sharry.sharryphonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OPEN extends AppCompatActivity {
    private static int[] listview_images = {R.drawable.shape,R.drawable.shape1,R.drawable.shape2,R.drawable.shape3,R.drawable.shape4,R.drawable.shape5,R.drawable.shape6,R.drawable.shape7,R.drawable.shape8,R.drawable.shape9,R.drawable.shape10,R.drawable.shape11,R.drawable.shape12,R.drawable.shape13,R.drawable.shape14,R.drawable.shape15,R.drawable.shape16,R.drawable.shape17,R.drawable.shape18,R.drawable.shape19,R.drawable.shape20,R.drawable.shape21,R.drawable.shape22,R.drawable.shape23,R.drawable.shape24,R.drawable.shape25,R.drawable.shape26,R.drawable.shape27};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        TextView tv = ((TextView)findViewById(R.id.textView2));
        tv.setText(getIntent().getStringExtra("KEY_StringName"));
        TextView tv2 = ((TextView)findViewById(R.id.textView3));
        tv2.setText(getIntent().getStringExtra("KEY_StringName1"));
        TextView tv3 = ((TextView)findViewById(R.id.textView));
        tv3.setText(getIntent().getStringExtra("KEY_StringName2"));
        int ind=Integer.parseInt(getIntent().getStringExtra("KEY"));
        tv3.setBackgroundResource(listview_images[ind]);
        }
}
