package retrofit2;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @Description: java类作用描述
 * @Author: XGod
 * @CreateDate: 2020/6/18 10:26
 */
public abstract class OkHttpRxJavaCallAdapter<R, T> implements CallAdapter<R, T> {
    @Override
    public Type responseType() {
        return null;
    }

    @Override
    public final T adapt(Call<R> call) {
        Object[] args = null;
        if (call instanceof OkHttpCall) {
            OkHttpCall<R> okHttpCall = ((OkHttpCall<R>) call);
            try {
                //获取参数
                Field argsField = OkHttpCall.class.getDeclaredField("args");
                argsField.setAccessible(true);
                args = (Object[]) argsField.get(okHttpCall);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adapt(call, args);
    }

    public abstract T adapt(Call<R> call, @Nullable Object[] args);
}