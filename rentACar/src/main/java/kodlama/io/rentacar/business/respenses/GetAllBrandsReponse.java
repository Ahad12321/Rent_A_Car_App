package kodlama.io.rentacar.business.respenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsReponse {
    private int id;
    private String name;
}
