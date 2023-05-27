package kodlama.io.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plate",unique = true)
    private String plate;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "state")
    private int state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
