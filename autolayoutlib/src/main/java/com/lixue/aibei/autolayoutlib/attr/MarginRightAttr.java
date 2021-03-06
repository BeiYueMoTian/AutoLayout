/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/2/22.
 */
public class MarginRightAttr extends AutoAttr {
    public MarginRightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING_RIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)){
            return;
        }
        ViewGroup.MarginLayoutParams mp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        mp.rightMargin = val;
    }

    public static MarginRightAttr generate(int val, int baseFlag) {
        MarginRightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MarginRightAttr(val, Attrs.MARGIN_RIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MarginRightAttr(val, 0, Attrs.MARGIN_RIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MarginRightAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
