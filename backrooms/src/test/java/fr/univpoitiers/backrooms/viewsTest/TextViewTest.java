package fr.univpoitiers.backrooms.viewsTest;

import fr.univpoitiers.backrooms.view.TextView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private TextView textView;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        textView = new TextView();
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void testAppendText() {
        String text = "Hello, World!\n";
        textView.appendText(text);
        assertEquals(text, outContent.toString());
    }
}