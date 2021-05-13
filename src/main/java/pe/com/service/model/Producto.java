package pe.com.service.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoCliente;

    @NotNull
    @Column(unique = true)
    private String codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String tecnologia;

    @NotNull
    private Integer estado;

}
