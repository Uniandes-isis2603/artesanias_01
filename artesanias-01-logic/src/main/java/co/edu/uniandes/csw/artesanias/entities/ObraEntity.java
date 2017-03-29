/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artesanias.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

/**
 *
 * @author da.cortes11
 */
@Entity
public class ObraEntity extends BaseEntity implements Serializable
{
    //Atributos
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String nombre;

private int rating;

private String material;

private String tecnica;



//asociaciones
// TODO: implementar la relación en la entidad ComentarioEntity
//Asociacion con los comentarios
@OneToMany (mappedBy="obra", cascade= CascadeType.ALL, orphanRemoval = true)
private List<ComentarioEntity> comentarios= new ArrayList<>();

// TODO: incluir la relación ManyToOne en FotoEntity
//Asociacion con las fotods
@OneToMany(mappedBy="obra", cascade= CascadeType.ALL, orphanRemoval = true)
private List<FotoEntity> fotos= new ArrayList<>();

@ManyToOne
private UsuarioEntity usuario = new UsuarioEntity();

// TODO: No es claro por que un artesano solo tiene una única obra
//       Si tiene una relación OneToMany, el contrario no debería ser ManyToOne
//one to one
@OneToOne
private UsuarioEntity artesano;

//metodos setters y getters

   public int getId() {
        return id;
   }

   public void setId(int id) {
       this.id = id;
   }

    public String getNombre() {
        return nombre;
    }

      public void setNombre(String nombre) {
          this.nombre = nombre; 
      }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
    
    // TODO: implementar getComentarios y setComentarios
    // TODO: implementar getFotos y setFotos
    
}
