package pe.com.service.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_reclamo")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String codigoCliente;

    @NotNull
    private String codigoProducto;

    @NotNull
    private String motivo;

    @NotNull
    private String descripcion;

}
