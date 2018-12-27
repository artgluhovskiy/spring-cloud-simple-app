package org.art.web.micro.vo;

import lombok.Data;

@Data
public class ProductInventoryResponse {
    private String productCode;
    private int availableQuantity;
}
