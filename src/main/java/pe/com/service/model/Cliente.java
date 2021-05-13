package pe.com.service.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String codigo;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @Transient
    private List<Producto> productos = new ArrayList<>();
}
