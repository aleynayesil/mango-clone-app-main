package com.mango.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_basket")
public class Category extends AbstractIdEntity {

        @Column(name = "category_name")
        private String categoryName;

        @Enumerated(EnumType.STRING)
        private Categories categories;
}
