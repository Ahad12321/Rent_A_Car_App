package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.requests.CreatModelRequest;
import kodlama.io.rentacar.business.respenses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreatModelRequest creatModelRequest);
}
