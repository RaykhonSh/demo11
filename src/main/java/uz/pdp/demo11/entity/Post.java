package uz.pdp.demo11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.demo11.entity.abs.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    private String title;

    @ManyToOne
    private Attachment cover;

    @ManyToOne
    private Attachment audio;

    @ManyToOne
    private Attachment video;
}
