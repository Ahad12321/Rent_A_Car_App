package kodlama.io.rentacar.webApi.controller;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.respenses.GetAllBrandsReponse;
import kodlama.io.rentacar.business.respenses.GetByIdBrandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping
    public List<GetAllBrandsReponse>getAll(){
        return brandService.getAll();
    }


    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid() CreateBrandRequest createBrandRequest){

        this.brandService.add(createBrandRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
