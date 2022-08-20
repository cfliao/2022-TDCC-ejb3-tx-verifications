package tdcc.category;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "catid")
    private String categoryId;

    private String name;
    @Column(name = "descn")
    private String description;
}

