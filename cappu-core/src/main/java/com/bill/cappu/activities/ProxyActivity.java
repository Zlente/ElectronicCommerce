package com.bill.cappu.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.bill.cappu.R;
import com.bill.cappu.delegates.CappuDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 实际应用
 */

public abstract class ProxyActivity extends SupportActivity {
    public abstract CappuDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    //初始化视图
    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container=new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        //第一次加载container
        if(savedInstanceState==null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    //因为是单Activity架构，但Activity退出后，整个应用也就退出了
    //所以此处做一些垃圾回收的工作
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
