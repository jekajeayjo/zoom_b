package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "menu_item_language", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItemLanguageEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "menu_item_id")
    private Long menuItemId;

    @Column(name = "value")
    private String value;

    @Column(name = "language_id")
    private Long languageId;
}
