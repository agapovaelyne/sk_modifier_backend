package com.example.Modifier.entity;

import com.example.Modifier.model.JsonObj;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

import java.io.Serializable;
import java.util.NoSuchElementException;


@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sk_example_table")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
        ,
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class SkObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "jsonb")
    @Column(name = "obj", columnDefinition = "jsonb")
    @Getter
    @Setter
    private JsonObj jsonObj;

    public int increaseCurrent(int value) throws NoSuchElementException {
        return jsonObj.getCurrent().getAndAdd(value);
    }

}
