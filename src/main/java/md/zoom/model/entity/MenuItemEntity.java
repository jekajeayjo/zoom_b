package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "menu_item", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "menu_category_id")
    private Long menuCategoryId;

    @Column(name = "value")
    private String value;

    @Column(name = "image")
    private String image;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "menu_item_size_id")
    private Long menuItemSizeId;

    @Column(name = "price")
    private Double price;

    @Column(name = "size")
    private Double size;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItemId", cascade = CascadeType.ALL)
    private List<MenuItemLanguageEntity> languages;
}
