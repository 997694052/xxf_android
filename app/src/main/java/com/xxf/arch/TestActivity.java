package com.xxf.arch;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xxf.arch.activity.XXFActivity;
import com.xxf.arch.annotation.BindVM;
import com.xxf.arch.annotation.BindView;
import com.xxf.arch.databinding.ActivityTestBinding;
import com.xxf.arch.viewmodel.XXFViewModel;

import java.util.Arrays;

/**
 * @author youxuan  E-mail:youxuan@icourt.cc
 * @version 2.3.1
 * @Description
 * @Company Beijing icourt
 * @date createTime：2018/9/9
 */
@BindView(R.layout.activity_test)
@BindVM(XXFViewModel.class)
public class TestActivity extends XXFActivity {
    BaseFragmentAdapter baseFragmentAdapter;
    ActivityTestBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getBinding();
        baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager());
        binding.pager.setAdapter(baseFragmentAdapter);
        baseFragmentAdapter.bindData(true, Arrays.asList(new TestFragment(), new TestFragment(), new TestFragment()));
    }
}
