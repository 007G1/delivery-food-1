package deliveryfood.external;

import lombok.Data;
import java.util.Date;
@Data
public class Store {

    private Long id;
    private String orderId;
    private String customerId;
    private String status;
}


