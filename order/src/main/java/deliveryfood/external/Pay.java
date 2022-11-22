package deliveryfood.external;

import lombok.Data;
import java.util.Date;
@Data
public class Pay {

    private Long id;
    private Integer cost;
    private String orderId;
    private String customerId;
}


