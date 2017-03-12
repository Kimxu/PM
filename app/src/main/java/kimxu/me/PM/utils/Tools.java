package kimxu.me.PM.utils;

import android.content.Context;

/**
 * Created by kimxu on 2017/3/12.
 */

public class Tools {

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
