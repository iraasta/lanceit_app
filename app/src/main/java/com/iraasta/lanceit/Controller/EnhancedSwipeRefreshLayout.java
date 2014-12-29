package com.iraasta.lanceit.Controller;

import de.timroes.swipetodismiss.SwipeDismissList;
import de.timroes.swipetodismiss.SwipeDismissList.OnSwipe;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

public class EnhancedSwipeRefreshLayout extends SwipeRefreshLayout {

    private SwipeDismissList lv;
    private boolean disableSwipeToRefresh;

    public EnhancedSwipeRefreshLayout(Context context) {
        super(context);
    }

    public EnhancedSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEnhancedListViewChild(SwipeDismissList v){
        this.lv = v;
        lv.setOnSwipe(new OnSwipe() {
			
			@Override
			public void swipeStart() {
				disableSwipeToRefresh = true;
				
			}
			
			@Override
			public void swipeEnd() {
				disableSwipeToRefresh = false;
			}
		});
    }

    @Override
    public boolean canChildScrollUp(){
        // If we return TRUE from here, swipe to refresh is disabled.
        // If it's not disabled, we fall back to whatever super has to say.
        return disableSwipeToRefresh || super.canChildScrollUp();
    }
}