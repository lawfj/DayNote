package prjpro.com.daynote.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import prjpro.com.daynote.R;

public class Toast {
	private static long lastShowTime = 0;
	
	public static void show(Context context, String msg) {
		if (TextUtils.isEmpty(msg)) {
			return;
		}
		long time = System.currentTimeMillis();
		long timeD = time - lastShowTime;
		if (0 < timeD && timeD < 3000) {
			return;
		}
		lastShowTime = time;
		
		TextView txt = new TextView(context);
		txt.setLayoutParams(new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		txt.setCompoundDrawablePadding(5);
		Drawable drawable = context.getResources().getDrawable(R.drawable.ic_toast);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		txt.setCompoundDrawables(drawable, null, null, null);
		txt.setTextColor(Color.parseColor("#000000"));
		txt.setBackgroundResource(R.drawable.ic_toast_bg);
		txt.setPadding(12, 10, 12, 10);
		txt.setText(msg);

		android.widget.Toast toast = new android.widget.Toast(context);
		toast.setView(txt);
		toast.setDuration(android.widget.Toast.LENGTH_SHORT);
		toast.show();
	}
}
