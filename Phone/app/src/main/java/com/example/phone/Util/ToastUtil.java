package com.example.phone.Util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast;

    public static void showMessage(Context context, String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        else  {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG); // 要加上显示时长 要不不显示
        }

        mToast.show();
    }
}
