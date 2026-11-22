package org.sid.inventoryservice.dto;

/**
 * un record c'est une classe qui contient des attribue
 * avec des getter et setter.
 *
 * **/

public record ProductRequestDTO (
     String id,
     String name,
     int quantity,
     int price,
     Long categoryId
) {}
