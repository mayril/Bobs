package com.b304.bobs.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="allergy")
@Getter @Setter
<<<<<<< HEAD
@Builder
=======
>>>>>>> develop
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {
    @Id
<<<<<<< HEAD
    @Column(name="allergy_name")
    private Long allergy_name;

    @Column(name = "is_deleted")
    private boolean is_deleted;

    @Column(name="ingredient_id")
    private int ingredient_id;

    @ManyToOne
=======
    @Column(name="allergy_name",columnDefinition = "VARCHAR(10)", nullable = false)
    private String allergy_name;

    @Column(name = "is_deleted",columnDefinition = "BOOLEAN", nullable = false)
    private boolean is_deleted;

    @ManyToOne(fetch = FetchType.LAZY)
>>>>>>> develop
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "allergy")
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    @Builder
    public Allergy(String allergy_name, boolean is_deleted, User user) {
        this.allergy_name = allergy_name;
        this.is_deleted = is_deleted;
        this.user = user;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setAllergy(this);
    }
<<<<<<< HEAD
=======

>>>>>>> develop
}
