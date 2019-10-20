package com.devilian.settings.preferences;

import android.content.Context;
import android.content.om.IOverlayManager;
import android.content.om.OverlayInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.settings.R;
import com.android.settings.Utils;

public class CardviewPreference_04 extends Preference {

    private final View.OnClickListener mClickListener = v -> performClick(v);

    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;

    public CardviewPreference_04(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Preference);

        mAllowDividerAbove = TypedArrayUtils.getBoolean(a, R.styleable.Preference_allowDividerAbove,
                R.styleable.Preference_allowDividerAbove, false);
        mAllowDividerBelow = TypedArrayUtils.getBoolean(a, R.styleable.Preference_allowDividerBelow,
                R.styleable.Preference_allowDividerBelow, false);
        a.recycle();

        setLayoutResource(R.layout.preference_cardview_04);
    }

    public CardviewPreference_04(Context context, View view) {
        super(context);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        holder.itemView.setOnClickListener(mClickListener);

        final boolean selectable = isSelectable();
        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
        holder.setDividerAllowedAbove(mAllowDividerAbove);
        holder.setDividerAllowedBelow(mAllowDividerBelow);
    }
}

