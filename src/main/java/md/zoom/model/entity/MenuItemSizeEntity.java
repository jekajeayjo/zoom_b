package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "menu_item_size", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemSizeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItemSize", cascade = CascadeType.ALL)
    private List<MenuItemSizeLanguageEntity> languages;
}
