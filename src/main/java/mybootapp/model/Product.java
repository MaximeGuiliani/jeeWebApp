package mybootapp.model;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import mybootapp.web.Bye;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long number;

    @NotEmpty
    @Size(min = 1, message="{product.name}")
    // avant @Size(min = 1, message = "Le nom est obligatoire")
    @Basic
    private String name;


    @NotNull
    @Min(value = 1, message = "Le prix est trop bas")
    @Basic
    private Double price;

    @NotEmpty(message = "La description est obligatoire")
    @Size(min = 1, max = 100, message = "Entre 1 et 200 caractères")
    @Bye
    @Basic
    private String description;

    //@NotEmpty
    @Size(min = 1, message = "Le type doit être renseigné")
    @Basic
    private String type;

    @Valid
    @Embedded
    private ProductCode code;

}