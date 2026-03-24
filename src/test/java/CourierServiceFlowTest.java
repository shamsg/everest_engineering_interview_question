import com.evereast.engineering.logic.DiscountOffer;
import com.evereast.engineering.model.RequestParameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierServiceFlowTest {

    @Test
    void testFullFlowCalculation() {
        int baseCost = 100;

        RequestParameters request =
                new RequestParameters("PKG1", 10, 10, "NA");

        double deliveryCost = baseCost + (10 * 10) + (10 * 5);
        DiscountOffer discountOffer = new DiscountOffer();
        double discount = discountOffer.calculateDiscount(request, deliveryCost);
        double totalCost = deliveryCost - discount;

        assertEquals(250, deliveryCost);
        assertEquals(0, discount);
        assertEquals(250, totalCost);
    }
}
