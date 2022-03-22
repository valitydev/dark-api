package dev.vality.dark.api.converter;

import dev.vality.swag.dark_api.model.InvoiceCart;
import dev.vality.swag.dark_api.model.InvoiceLine;

import java.util.List;
import java.util.stream.Collectors;

public class HelperUtils {

    static InvoiceCart getCart(dev.vality.damsel.domain.InvoiceCart cart) {
        if (cart == null) {
            return null;
        }
        InvoiceCart invoiceCart = new InvoiceCart();
        List<InvoiceLine> invoiceLines = cart.lines.stream()
                .map(invoiceLine -> new InvoiceLine()
                        .cost(invoiceLine.price.amount * invoiceLine.quantity)
                        .price(invoiceLine.price.amount)
                        .quantity((long) invoiceLine.quantity)
                        .product(invoiceLine.product)
                )
                .collect(Collectors.toList());
        invoiceCart.addAll(invoiceLines);
        return invoiceCart;
    }

}
