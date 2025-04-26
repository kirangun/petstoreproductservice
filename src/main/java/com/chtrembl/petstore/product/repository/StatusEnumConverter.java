package com.chtrembl.petstore.product.repository;

import com.chtrembl.petstore.product.model.Product;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<Product.StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(Product.StatusEnum statusEnum) {
        if (statusEnum == null) {
            return null;
        }
        // Convert the enum to lowercase for database storage
        return statusEnum.name().toLowerCase();
    }

    @Override
    public Product.StatusEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Product.StatusEnum.valueOf(dbData.toUpperCase());
    }
}
