package com.example.slave;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			//View view =LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main2, null);
			//setContentView(view);
			Field field;
			try {
				field = this.getClass().getSuperclass().getSuperclass().getDeclaredField("mResources");
				field.setAccessible(true);
				field.set(this, getApplication().getResources());
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    setContentView(R.layout.activity_main2);
		    findViewById(R.id.btn).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "I came from 插件~~", Toast.LENGTH_LONG).show();
			}});
		
	}
	

}
