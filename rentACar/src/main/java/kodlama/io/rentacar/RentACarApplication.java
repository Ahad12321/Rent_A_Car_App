package kodlama.io.rentacar;

import kodlama.io.rentacar.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.rentacar.core.utilities.exceptions.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

    public static void main(String[] args) {

        SpringApplication.run(RentACarApplication.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessExceptions businessExceptions){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(businessExceptions.getMessage());

        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(methodArgumentNotValidException.getMessage());

        return problemDetails;
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
