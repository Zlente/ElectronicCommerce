package com.bill.electroniccommerce.example;

import com.bill.cappu.activities.ProxyActivity;
import com.bill.cappu.delegates.CappuDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public CappuDelegate setRootDelegate() {
        return new ExampleDelegate();
        //
    }
}
