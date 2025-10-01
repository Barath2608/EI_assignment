package com.example.designpatterns.structural.adapter;

public class OldPaymentGateway {
    // legacy signature: cents, currency code
    public PaymentResponse makePayment(int amountInCents, String currencyCode) {
        if (amountInCents <= 0) throw new IllegalArgumentException("Invalid amount");
        return new PaymentResponse(true, "TX" + System.currentTimeMillis());
    }

    public static class PaymentResponse {
        public final boolean success;
        public final String txId;
        public PaymentResponse(boolean success, String txId) { this.success = success; this.txId = txId; }
    }
}
