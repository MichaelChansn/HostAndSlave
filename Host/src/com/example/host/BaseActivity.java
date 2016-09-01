package com.example.host;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity{
	
	protected  AssetManager mAssetManager;//��Դ������  
	protected  Resources mResources;//��Դ  
	protected  Theme mTheme;//����  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	protected void loadResources(String dexPath) {  
        try {  
            AssetManager assetManager = AssetManager.class.newInstance();  
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);  
            addAssetPath.invoke(assetManager, dexPath);  
            mAssetManager = assetManager;  
        } catch (Exception e) {  
        	Log.i("inject", "loadResource error:"+Log.getStackTraceString(e));
            e.printStackTrace();  
        }  
        Resources superRes = super.getResources();  
        superRes.getDisplayMetrics();  
        superRes.getConfiguration();  
        mResources = new Resources(mAssetManager, superRes.getDisplayMetrics(),superRes.getConfiguration());  
        mTheme = mResources.newTheme();  
        mTheme.setTo(super.getTheme());
        replaceContextResources(getApplicationContext());
    }  
	private void replaceContextResources(Context context) {

		try {
			Field field = context.getClass().getSuperclass().getDeclaredField("mBase");
			field.setAccessible(true);
			Log.i("demo", "contextImpl:" + (field.get(context)).getClass().getName());
			Field field2 = ((field.get(context)).getClass()).getDeclaredField("mResources");
			field2.setAccessible(true);
			field2.set(field.get(context), mResources);
			
			Field field3 = context.getClass().getDeclaredField("mLoadedApk");
			field3.setAccessible(true);
			Log.i("demo", "contextImpl:" + (field3.get(context)).getClass().getName());
			Field field4 = ((field3.get(context)).getClass()).getDeclaredField("mResources");
			field4.setAccessible(true);
			field4.set(field3.get(context), mResources);
			
			System.out.println("debug:repalceResources succ");
		} catch (Exception e) {
			System.out.println("debug:repalceResources error");
			e.printStackTrace();
		}
	}
//	@Override  
//	public AssetManager getAssets() {  
//	    return mAssetManager == null ? super.getAssets() : mAssetManager;  
//	}  
//	
//	@Override  
//	public Resources getResources() {  
//	    return mResources == null ? super.getResources() : mResources;  
//	}  
//	
//	
//	@Override  
//	public Theme getTheme() {  
//	    return mTheme == null ? super.getTheme() : mTheme;  
//	} 

}
