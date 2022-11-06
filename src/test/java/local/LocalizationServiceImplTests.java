package local;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceImplTests {
    @Test
    public void local(){
        LocalizationServiceImpl  localizationService = new LocalizationServiceImpl();
       String result = localizationService.locale(Country.RUSSIA);

       String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, result);


    }
}
