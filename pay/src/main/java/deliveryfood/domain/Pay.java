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


        Payplaced payplaced = new Payplaced(this);
        payplaced.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = PayApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }






}
