package kodlama.io.rentacar.business.concreates;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.requests.CreatModelRequest;
import kodlama.io.rentacar.business.respenses.GetAllModelsResponse;
import kodlama.io.rentacar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model>models=modelRepository.findAll();
        List<GetAllModelsResponse>modelsResponses=models.stream()
                .map(model -> this.modelMapperService.forResponse()
                .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreatModelRequest creatModelRequest) {
        Model model =this.modelMapperService.forRequests().map(creatModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
