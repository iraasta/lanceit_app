package com.iraasta.lanceit;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyViewPager extends ViewPager{

	public MyViewPager(Context context) {
		super(context);
		setListeners();
		// TODO Auto-generated constructor stub
	}
	public MyViewPager(Context context, AttributeSet attrs) {
		   super(context, attrs);
		   setListeners();
		}
	public void setListeners()
	{
		final MyViewPager self = this;
		this.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override	
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				 self.getParent().requestDisallowInterceptTouchEvent(true);
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
	     if (
	    		 (event.getX() / getWidth()  < 0.03 ||
	    		 event.getX() / getWidth()  > 0.97) &&
	    		 event.getAction() == MotionEvent.ACTION_DOWN
	    		 ) {
	    	 Log.v("Przezzlo","P");
	           return super.onTouchEvent(event);
	     }
	     else return false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	     if (
	    		 (event.getX() / getWidth()  < 0.03 ||
	    		 event.getX() / getWidth()  > 0.97) ||
	    		 event.getAction() != MotionEvent.ACTION_DOWN
	    		 ) {
	           return super.onTouchEvent(event);
	     }
	     else return false;
	}
	
	
}
