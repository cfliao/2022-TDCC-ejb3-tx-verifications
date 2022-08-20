package tdcc.product;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "productid")
    private String id;

    @Column(name = "category")
    private String categoryId;

    private String name;

    @Column(name = "descn")
    private String description;
}
