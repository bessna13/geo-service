package sender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.StartsWith;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import javax.management.ConstructorParameters;
import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTests {

    @Test
    public void sendRussian (){
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> ipAdress = new HashMap<>();
        ipAdress.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        Assertions.assertEquals("Добро пожаловать", messageSender.send(ipAdress));


        }

    @Test
    public void sendUSA (){
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn (new Location("New York", Country.USA, null,  0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> ipAdress = new HashMap<>();
        ipAdress.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.0.32.22");

        Assertions.assertEquals("Welcome", messageSender.send(ipAdress));


    }








    }


