package com.newdev.order_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {
    public static void stubInventoryCall(String skuCode, int quantity, boolean inStock) {
        // This method would be used to stub the inventory service call
        // For example, using WireMock or a similar library to simulate the response
        // from the inventory service based on the skuCode and quantity.
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}
