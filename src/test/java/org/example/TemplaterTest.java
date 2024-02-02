package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TemplaterTest {
    final static String emptyTemplate = "Hello everybody!";

    final static int simpleTemplate = 1;
    final static String simpleTemplateBody = "Test simple template!";

    final static int undefinedTemplate = 0;

    private static String getTestStartTime() {
        return String.valueOf(
                System.currentTimeMillis()
        );
    }

    /*@BeforeClass
    public void beforeWholeClassTest() {
        System.out.println("Test [class] has been started at " +
                getTestStartTime() +
                " (in unix-time)");
    }*/

    @Before
    public void beforeTestTemplate() {
        System.out.println("Test has been started at " +
                getTestStartTime() +
                " (in unix-time)");
    }

    @After
    public void afterTestTemplate() {
        System.out.println("Test has been finished at " +
                getTestStartTime() +
                " (in unix-time)");
    }

    @Test
    public void testEmptyTemplateSimpleGood() throws Exception {
        //  Given
        Templater templater = new Templater();

        //  When
        String result = templater.applyEmptyTemplate(emptyTemplate);

        //  Then
        String expected = emptyTemplate.toLowerCase();
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyTemplateSimpleBad() throws Exception {
        //  Given
        Templater templater = new Templater();

        //  When
        String result = templater.applyEmptyTemplate(emptyTemplate);

        //  Then
        String expected = emptyTemplate.toLowerCase();
        if (expected.equals(result))
            throw new Exception("Mismatch expected and result!!!");
    }

    @Test
    @Ignore
    public void testSimpleTemplateBadWhileNoiAssertion() {
        //  Given
        TemplateCatalog catalog = mock(TemplateCatalog.class);

        Templater templater = new Templater(catalog);
        when(catalog.getTemplateById(anyInt())).thenReturn(simpleTemplateBody);

        assertNotEquals(
                simpleTemplateBody,
                templater.applySimpyTemplate(simpleTemplate));
    }

    @Test
    public void testSafeTemplateTemplaterExceptionCheck() {
        //  Given
        Templater templater = new Templater();

        // When & Then
        assertThrows(TemplaterException.class, () -> templater.applySafeTemplate(undefinedTemplate));
    }
}
