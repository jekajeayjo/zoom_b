package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "menu_item_size_language", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemSizeLanguageEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_size_id")
    private MenuItemSizeEntity menuItemSize;

    @Column(name = "language_id")
    private Long languageId;
}
