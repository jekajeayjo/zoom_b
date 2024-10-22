package md.zoom.model.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "menu_item_view", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemViewEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_item_id")
    private Long menuItemId;

    @Column(name = "image")
    private String image;

    @Column(name = "menu_item_size_id")
    private Long menItemSizeId;

    @Column(name = "menu_item_size_value")
    private String menuItemSizeValue;

    @Column(name = "menu_item_language_value")
    private String menuItemLanguageValue;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "price")
    private String price;

    @Column(name = "language_id")
    private String languageId;

    @Column(name = "language_value")
    private String languageValue;
}
