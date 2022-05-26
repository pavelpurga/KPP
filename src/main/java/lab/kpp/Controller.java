package lab.kpp;



import lab.kpp.counter.RequestCounterThread;
import lab.kpp.exception.DataRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private CalculationService states;
    private RequestCounterThread counterThread;

    @Autowired
    public void setter(CalculationService newService){
        this.states = newService;
    }

    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    private static final String template1 = "The words %s have %d symbols %c\n";

    @GetMapping("/Data")
    public String get(@RequestParam(value = "words") String words,
                      @RequestParam(value = "symbol") char symbols)throws DataRequestException{
        counterThread = new RequestCounterThread();
        DataClass gr = new DataClass(words,symbols);
        return String.format(template,gr.getWords(),states.calc(gr),gr.getSymbol());
    }
    @PostMapping("/Data")
    public ResponseEntity<?> post1(@RequestBody List<DataClass> list){
        List<Integer> res = new ArrayList<>();
        List<String> res_output = new ArrayList<>();
        list.forEach((element)->{
            res_output.add(String.format(template1,element.getWords(),states.calc(element),element.getSymbol()));
            res.add(states.calc(element));
        });

        long sizeOfRequest = states.calcSize(res);
        long offten = states.mostRecurring(res);
        int MAX = states.findMax(res);
        int MIN = states.findMin(res);
        return new ResponseEntity<>(res_output + "\nSize = " + sizeOfRequest + "\nMax = "+MAX + "\nMin = "+ MIN+"\nOfften = "+ offten, HttpStatus.OK);
    }

}