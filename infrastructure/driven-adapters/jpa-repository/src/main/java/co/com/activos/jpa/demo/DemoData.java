package co.com.activos.jpa.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "demo")
@Entity
public class DemoData {
    @Id
    @Column(name = "id_demo")
    private String idDemo;
    @Column(name = "name_demo")
    private String name;

}

