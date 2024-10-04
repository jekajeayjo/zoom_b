package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "languages", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LanguageEntity {

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
}
