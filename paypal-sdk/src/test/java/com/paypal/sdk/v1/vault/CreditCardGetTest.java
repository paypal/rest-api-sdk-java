package com.paypal.sdk.v1.vault;

import com.braintreepayments.http.HttpResponse;
import com.paypal.sdk.TestHarness;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class CreditCardGetTest extends TestHarness {

    @Test
    public void testCreditCardGetRequest() throws IOException {
        CreditCard createdCreditCard = CreditCardCreateTest.createCreditCard(client());

        CreditCardGetRequest request = new CreditCardGetRequest(createdCreditCard.id());

        HttpResponse<CreditCard> response = client().execute(request);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.result());
        CreditCard actualCreditCard = response.result();
        assertEquals(actualCreditCard.id(), createdCreditCard.id());
        assertEquals(actualCreditCard.firstName(), createdCreditCard.firstName());
        assertEquals(actualCreditCard.lastName(), createdCreditCard.lastName());
        assertEquals(actualCreditCard.billingAddress().city(), createdCreditCard.billingAddress().city());
    }
}