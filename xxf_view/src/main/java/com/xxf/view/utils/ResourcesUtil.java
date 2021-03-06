package com.xxf.view.utils;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import com.xxf.arch.XXF;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @Description 资源文件工具类
 */
public class ResourcesUtil {

    private static Context getContext() {
        return XXF.getApplication();
    }

    public static String getString(@StringRes int resId) {
        return getContext().getString(resId);
    }

    public static String getString(@StringRes int resId, Object... formatArgs) {
        return getContext().getString(resId, formatArgs);
    }

    public static Drawable getDrawable(@DrawableRes int resId) {
        return ContextCompat.getDrawable(getContext(), resId);
    }

    @ColorInt
    public static int getColor(@ColorRes int resId) {
        return ContextCompat.getColor(getContext(), resId);
    }

}
