package kodlama.io.rentacar.webApi.controller;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.requests.CreatModelRequest;
import kodlama.io.rentacar.business.respenses.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@RequiredArgsConstructor
public class ModelsController {
    private final ModelService modelService;
    @GetMapping
    public List<GetAllModelsResponse>getAll(){
        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid() CreatModelRequest creatModelRequest){

        this.modelService.add(creatModelRequest);
    }
}
