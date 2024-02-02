package org.example;

public class Templater {
    final TemplateCatalog catalog;

    public Templater() {
        catalog = null;
    }

    public Templater(TemplateCatalog catalog) {
        this.catalog = catalog;
    }

    public String applyEmptyTemplate(final String templateString) {
        return templateString.toLowerCase();
    }

    public String applySimpyTemplate(final int templateId) {
        return catalog.getTemplateById(templateId);
    }

    public String applySafeTemplate(final int templateId) throws TemplaterException {
        throw new TemplaterException();
    }
}
