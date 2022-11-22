package deliveryfood.domain;

import deliveryfood.domain.*;
import deliveryfood.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Payplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String cost;

    public Payplaced(Pay aggregate){
        super(aggregate);
    }
    public Payplaced(){
        super();
    }
}
