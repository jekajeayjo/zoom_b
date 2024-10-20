package md.zoom.model.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "menu_category_view", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuCategoryViewEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_category_id")
    private Long menuCategoryId;

    @Column(name = "value")
    private String value;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "language_name")
    private String languageName;


}
