package com.example.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		FontSliderBar sliderBar = (FontSliderBar) findViewById(R.id.sliderbar);  
		sliderBar.setTickCount(4,new String[]{"小","中","大","特大"}).setBarLineWide(3).setTickHeight(20).setBarLineColor(Color.GRAY)  
		    .setTextColor(Color.BLACK).setTextPadding(40).setTextSize(40)  
		    .setThumbRadius(40).setThumbColorNormal(Color.WHITE).setThumbColorPressed(Color.BLACK) 
		    .setThumbColorCircle(Color.LTGRAY).setThumbIndex(1).showShadow(true)
		    .withAnimation(true).apply();  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
