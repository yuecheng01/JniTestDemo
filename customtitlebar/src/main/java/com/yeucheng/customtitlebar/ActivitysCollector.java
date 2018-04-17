package com.yeucheng.customtitlebar;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class ActivitysCollector {
    private static List<Activity> mActivities = new LinkedList<>();

    public static void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        if (mActivities.contains(activity))
            mActivities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : mActivities
                ) {
            if (!activity.isFinishing())
                activity.finish();
        }
        mActivities.clear();
    }
}
