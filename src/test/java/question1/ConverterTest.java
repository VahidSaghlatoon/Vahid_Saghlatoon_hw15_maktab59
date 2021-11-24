package question1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    private static Converter converter;

    @BeforeAll
    public static void startup() {
        converter = new Converter();
    }

    @Test
    public void input_is_null() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertStringToInteger(null));
    }

    @Test
    public void input_is_empty_string() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertStringToInteger(""));
    }

    @Test
    public void input_contain_character_is_not_digit() {
        Integer result = converter.convertStringToInteger("5a# s9");
        assertNull(result);
    }

    @Test
    public void input_out_of_bound() {
        // bound is -32767 to 32767
        Integer result = converter.convertStringToInteger("32768");
        assertNull(result);
    }

    @Test
    public void input_is_ok() {
        Integer result = converter.convertStringToInteger("2518");
        assertNotNull(result);
        System.out.println(result);
    }
}