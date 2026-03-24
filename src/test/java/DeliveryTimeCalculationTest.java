import com.evereast.engineering.logic.DeliveryTimeCalculation;
import com.evereast.engineering.model.PackageDetails;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTimeCalculationTest {

    @Test
    void testSinglePackageDelivery() {
        List<PackageDetails> packages = new ArrayList<>();

        packages.add(new PackageDetails("PKG1", 50, 100, 0, 750));

        DeliveryTimeCalculation calc = new DeliveryTimeCalculation();

        assertDoesNotThrow(() ->
                calc.calculateDeliveryTime(packages, 1, 50, 200)
        );
    }

    @Test
    void testMultiplePackagesWithinWeight() {
        List<PackageDetails> packages = new ArrayList<>();

        packages.add(new PackageDetails("PKG1", 50, 30, 0, 500));
        packages.add(new PackageDetails("PKG2", 70, 40, 0, 700));

        DeliveryTimeCalculation calc = new DeliveryTimeCalculation();

        assertDoesNotThrow(() ->
                calc.calculateDeliveryTime(packages, 2, 60, 200)
        );
    }

    @Test
    void testExceedMaxWeight() {
        List<PackageDetails> packages = new ArrayList<>();

        packages.add(new PackageDetails("PKG1", 300, 50, 0, 1000)); // exceeds max weight

        DeliveryTimeCalculation calc = new DeliveryTimeCalculation();

        assertDoesNotThrow(() ->
                calc.calculateDeliveryTime(packages, 1, 60, 200)
        );
    }
}
