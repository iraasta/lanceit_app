package com.lanceit.haito.lanceit.view.hub;

import android.view.View;

public class PageTransformer implements android.support.v4.view.ViewPager.PageTransformer
{

    private static final float MIN_ALPHA = 0.5F;
    private static final float MIN_SCALE = 0.85F;

    public PageTransformer()
    {
    }

    public void transformPage(View view, float f)
    {
        int i = view.getWidth();
        int j = view.getHeight();
        if (f < -1F)
        {
            view.setAlpha(0.0F);
            return;
        }
        if (f <= 1.0F)
        {
            float f1 = Math.max(0.85F, 1.0F - Math.abs(f));
            float f2 = ((float)j * (1.0F - f1)) / 2.0F;
            float f3 = ((float)i * (1.0F - f1)) / 2.0F;
            if (f < 0.0F)
            {
                view.setTranslationX(f3 - f2 / 2.0F);
            } else
            {
                view.setTranslationX(-f3 + f2 / 2.0F);
            }
            view.setScaleX(f1);
            view.setScaleY(f1);
            view.setAlpha(0.5F + 0.5F * ((f1 - 0.85F) / 0.15F));
            return;
        } else
        {
            view.setAlpha(0.0F);
            return;
        }
    }
}
