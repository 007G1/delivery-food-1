package deliveryfood.domain;

import deliveryfood.domain.*;
import deliveryfood.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Startcook extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String status;

    public Startcook(Store aggregate){
        super(aggregate);
    }
    public Startcook(){
        super();
    }
}
