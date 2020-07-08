package com.xxf.arch.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import io.reactivex.functions.BiConsumer;

/**
 * @author xuanyouwu@163.com
 * @version 2.3.1
 * @Description 支持返回值的AlertDialogFragment
 * @date createTime：2018/9/7
 */

public class XXFResultAlertDialogFragment<R> extends XXFAlertDialogFragment implements IResultDialogFragment<R> {

    private BiConsumer<DialogFragment, R> dialogFragmentConsumer;

    public XXFResultAlertDialogFragment(@Nullable BiConsumer<DialogFragment, R> dialogFragmentConsumer) {
        this.dialogFragmentConsumer = dialogFragmentConsumer;
    }

    /**
     * t提供默认的构造方法
     */
    public XXFResultAlertDialogFragment() {
    }

    @Override
    public final void setDialogFragmentConsumer(@Nullable BiConsumer<DialogFragment, R> consumer) {
        this.dialogFragmentConsumer = consumer;
    }

    @Override
    public final void setResult(R r) {
        if (dialogFragmentConsumer != null) {
            try {
                dialogFragmentConsumer.accept(this, r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dismiss();
        }
    }
}
