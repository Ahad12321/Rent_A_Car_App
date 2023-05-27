package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.respenses.GetAllBrandsReponse;
import kodlama.io.rentacar.business.respenses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsReponse>getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}














