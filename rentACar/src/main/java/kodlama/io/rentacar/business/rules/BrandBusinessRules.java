package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private final BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){
            throw new BusinessExceptions("Brand name already exists");
        }
    }
}
