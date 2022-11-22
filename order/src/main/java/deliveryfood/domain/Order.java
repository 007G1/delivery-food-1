package deliveryfood.domain;

import deliveryfood.domain.Orderplaced;
import deliveryfood.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String content;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String cost;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        deliveryfood.external.Pay pay = new deliveryfood.external.Pay();
        // mappings goes here
        OrderApplication.applicationContext.getBean(deliveryfood.external.PayService.class)
            .pay(pay);


        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
