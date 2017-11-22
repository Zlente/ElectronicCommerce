package com.bill.electroniccommerce.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bill.cappu.delegates.CappuDelegate;

public class ExampleDelegate extends CappuDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
