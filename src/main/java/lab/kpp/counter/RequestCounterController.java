package lab.kpp.counter;


import lab.kpp.counter.RequestCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestCounterController {
    @GetMapping("/counter")
    public String getCounter(){
        RequestCounter counter = new RequestCounter();
        return "counter = " + counter.getCount();
    }
}