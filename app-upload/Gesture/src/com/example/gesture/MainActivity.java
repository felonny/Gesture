package com.example.gesture;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private ImageView img;
    private GestureDetector myGestureDetector;
    class myGestureListener extends SimpleOnGestureListener{
    	@Override
    	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
    			float velocityY) {
    		// TODO Auto-generated method stub
    		if(e1.getX()-e2.getX()>50){
    			Toast.makeText(MainActivity.this, "From right to left", Toast.LENGTH_LONG);
    		}else if(e2.getX()-e1.getX()>50){
    			Toast.makeText(MainActivity.this, "From left to right", Toast.LENGTH_LONG);
    		}
    		return super.onFling(e1, e2, velocityX, velocityY);
    	}
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) findViewById(R.id.imageView1);
		myGestureDetector = new GestureDetector(new myGestureListener());
		img.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				myGestureDetector.onTouchEvent(event);
				return true;
			}
		});
	}

	
}
