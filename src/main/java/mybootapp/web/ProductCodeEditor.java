package mybootapp.web;

import java.beans.PropertyEditorSupport;

import mybootapp.model.ProductCode;

class ProductCodeEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Object o = this.getValue();
        if (o instanceof ProductCode) {
            ProductCode c = (ProductCode) o;
            return c.getBase() + "" + c.getNumber();
        }
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            String base = text.substring(0, 1);
            int number = Integer.parseInt(text.substring(1));
            ProductCode c = new ProductCode(base, number);
            super.setValue(c);
        } catch (Exception e) {
            throw new IllegalArgumentException("Bad code format");
        }
    }

}