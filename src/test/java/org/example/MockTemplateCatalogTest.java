package org.example;

import org.example.processor.ProcessorCatalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class MockTemplateCatalogTest {

    @Mock
    TemplateCatalog templateCatalog;

    @InjectMocks
    ProcessorCatalog pc;

    @Test
    public void testPCCorrectType() {
        Mockito.when(templateCatalog.getTemplateById(anyInt())).thenReturn("2");

        assertEquals(2, pc.getTypeOfCatalog(2));

        Mockito.verify(templateCatalog, times(1)).getTemplateById(anyInt());
    }

    @Test
    public void testPCInvalidVValue() {
        Mockito.when(templateCatalog.getTemplateById(anyInt())).thenReturn("2");

        assertEquals(2, pc.getTypeOfCatalog(-1));

        Mockito.verify(templateCatalog, times(1)).getTemplateById(anyInt());
    }
}
