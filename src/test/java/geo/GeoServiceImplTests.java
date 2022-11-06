package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GeoServiceImplTests {
    @Test
    public void byip(){
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp(GeoServiceImpl.LOCALHOST);
        Location expected = new Location(null, null, null, 0);
        Assertions.assertEquals(expected.getCountry(),result.getCountry());
        Assertions.assertEquals(expected.getBuiling(),result.getBuiling());
        Assertions.assertEquals(expected.getCity(),result.getCity());
        Assertions.assertEquals(expected.getStreet(),result.getStreet());
    }
}
