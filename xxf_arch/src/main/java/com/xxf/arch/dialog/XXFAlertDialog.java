package com.xxf.arch.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.xxf.arch.widget.progresshud.ProgressHUDProvider;

import java.io.Serializable;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @Description
 */
public abstract class XXFAlertDialog<R extends Serializable>
        extends AlertDialog
        implements ProgressHUDProvider, IResultDialog<R> {

    private OnDialogClickListener<R> onDialogClickListener;

    protected XXFAlertDialog(@NonNull Context context, @Nullable OnDialogClickListener<R> onDialogClickListener) {
        super(context);
        this.onDialogClickListener = onDialogClickListener;
    }

    protected XXFAlertDialog(@NonNull Context context, int themeResId, @Nullable OnDialogClickListener<R> onDialogClickListener) {
        super(context, themeResId);
        this.onDialogClickListener = onDialogClickListener;
    }

    protected XXFAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, @Nullable OnDialogClickListener<R> onDialogClickListener) {
        super(context, cancelable, cancelListener);
        this.onDialogClickListener = onDialogClickListener;
    }

    @Deprecated
    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Deprecated
    @Override
    public void cancel() {
        super.cancel();
    }

    /**
     * 分发确认结果
     *
     * @param confirmResult
     * @return
     */
    @Override
    public final void confirm(R confirmResult) {
        if (onDialogClickListener != null) {
            if (!onDialogClickListener.onConfirm(this, confirmResult)) {
                dismiss();
            }
        } else {
            dismiss();
        }
    }

    /**
     * 分发取消结果
     *
     * @param cancelResult
     * @return
     */
    @Override
    public final void cancel(R cancelResult) {
        if (onDialogClickListener != null) {
            if (!onDialogClickListener.onCancel(this, cancelResult)) {
                cancel();
            }
        } else {
            cancel();
        }
    }


}
