package demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import demo.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_products")
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "order")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    private String name;
    private double cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Order order;
}
