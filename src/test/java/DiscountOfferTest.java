import com.evereast.engineering.model.RequestParameters;
import org.junit.jupiter.api.Test;
import com.evereast.engineering.logic.DiscountOffer;

import static org.junit.jupiter.api.Assertions.*;

class DiscountOfferTest {

    DiscountOffer discountOffer = new DiscountOffer();

    @Test
    void testValidOffer_OFR001() {
        RequestParameters request = new RequestParameters("PKG1", 70, 30, "OFR001");

        double deliveryCost = 100 + (70 * 10) + (30 * 5); // 950
        double discount = discountOffer.calculateDiscount(request, deliveryCost);

        assertTrue(discount > 0, "Discount should be applied for OFR001");
    }

    @Test
    void testInvalidOfferCode() {
        RequestParameters request = new RequestParameters("PKG2", 10, 10, "INVALID");

        double deliveryCost = 100 + (10 * 10) + (10 * 5); // 250
        double discount = discountOffer.calculateDiscount(request, deliveryCost);

        assertEquals(0, discount, "Invalid offer should return 0 discount");
    }

    @Test
    void testNoOfferCode() {
        RequestParameters request = new RequestParameters("PKG3", 5, 5, "NA");

        double deliveryCost = 100 + (5 * 10) + (5 * 5); // 175
        double discount = discountOffer.calculateDiscount(request, deliveryCost);

        assertEquals(0, discount);
    }

    @Test
    void testBoundaryConditionWeight() {
        RequestParameters request = new RequestParameters("PKG4", 200, 50, "OFR002");

        double deliveryCost = 100 + (200 * 10) + (50 * 5);
        double discount = discountOffer.calculateDiscount(request, deliveryCost);

        assertTrue(discount >= 0);
    }
}
