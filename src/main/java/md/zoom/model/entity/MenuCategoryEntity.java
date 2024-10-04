package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "menu_category", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuCategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @Column(name = "image")
    private String image;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuCategoryId", cascade = CascadeType.ALL)
    private List<MenuCategoryLanguageEntity> languages;
}
