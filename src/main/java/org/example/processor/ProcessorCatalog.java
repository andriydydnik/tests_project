package org.example.processor;

import org.example.TemplateCatalog;

public class ProcessorCatalog {
    private final TemplateCatalog originCatalog;

    public ProcessorCatalog(final TemplateCatalog originCatalog) {
        this.originCatalog = originCatalog;
    }

    public int getTypeOfCatalog(final int id) {
        if (id == -1)
            return Integer.MIN_VALUE;

        return
                Integer.parseInt(
                        originCatalog.getTemplateById(id));
    }

    public int getTypeOfCatalog2(final int id) {
        if (id == -1)
            return Integer.MIN_VALUE;

        addStr("1", "2");

        return
                Integer.parseInt(
                        originCatalog.getTemplateById(id));
    }

    public String getTypeOfCatalog3(final int id) {
        if (id == -1)
            return "";

        String result = addStr(String.valueOf(id), "2");

        return
                result;
    }

    public String addStr(String a, String b) {
        return a + b;
    }
}
