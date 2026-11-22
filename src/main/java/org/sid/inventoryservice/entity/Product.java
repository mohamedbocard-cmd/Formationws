package org.sid.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    private int price;
    @ManyToOne
    private Category category;
}
