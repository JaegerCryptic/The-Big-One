
package edu.view.ui.util;

public class GenericComboItem {

    private int key;
    private String value;

    
    public GenericComboItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(key) + " - " + this.value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

