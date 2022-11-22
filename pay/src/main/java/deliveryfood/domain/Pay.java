package deliveryfood.domain;

import deliveryfood.domain.Payplaced;
import deliveryfood.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Pay_table")
@Data

public class Pay  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer cost;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        deliveryfood.external.Store store = new deliveryfood.external.Store();
        // mappings goes here
        PayApplication.applicationContext.getBean(deliveryfood.external.StoreService.class)
            .check(store);


        Payplaced payplaced = new Payplaced(this);
        payplaced.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = PayApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }






}
