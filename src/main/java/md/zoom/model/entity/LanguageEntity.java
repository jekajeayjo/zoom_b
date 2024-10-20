package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "languages", schema = "public")
@Data


@ToString
public class LanguageEntity {
    public LanguageEntity() {
    }

    public LanguageEntity(Long id) {
        this.id = id;
    }

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
