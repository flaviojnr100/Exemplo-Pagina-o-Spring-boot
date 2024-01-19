package com.ms.paginacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public double price;
    public String url;
    public boolean availability;

}
