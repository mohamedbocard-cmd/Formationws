package org.sid.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 20,nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
