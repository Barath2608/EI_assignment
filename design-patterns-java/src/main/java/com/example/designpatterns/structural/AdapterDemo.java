package com.example.designpatterns.structural;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.structural.adapter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(AdapterDemo.class);

    @Override
    public void run() {
        logger.info("--- Adapter Demo Start ---");
        OldPaymentGateway legacy = new OldPaymentGateway();
        PaymentAdapter adapter = new PaymentAdapter(legacy);
        PaymentAdapter.PaymentResult res = adapter.pay(new PaymentAdapter.PaymentRequest(100.0, "USD"));
        logger.info("Adapter result: success={}, txId={}", res.success, res.txId);
        logger.info("--- Adapter Demo End ---");
    }

    @Override
    public String getName() { return "Adapter (Structural)"; }
}
