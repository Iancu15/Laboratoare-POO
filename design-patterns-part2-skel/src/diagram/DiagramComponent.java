package diagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a diagram object, currently just a rectangle with text and color that can be connected to other components.
 */
public class DiagramComponent {
    private String text = "text";
    private String color = "WHITE";
    private int height = 40;
    private int width = 100;

    @Override
    public String toString() {
        return "[" +
                "text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", connectedComponents=" + connectedComponents +
                ']' + "\n";
    }

    private List<String> connectedComponents = new ArrayList<>();

    public String getText() {
        return text;
    }
    
    /**
     * Dau return la diagrama curenta pentru a putea face un chain de comenzi setters
     * @param text
     * @return  diagrama curenta
     */
    public DiagramComponent setText(String text) {
        this.text = text;
        return this;
    }

    public String getColor() {
        return color;
    }

    public DiagramComponent setColor(String color) {
        this.color = color;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public DiagramComponent setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public DiagramComponent setWidth(int width) {
        this.width = width;
        return this;
    }

    public void connectTo(String componentId) {
        connectedComponents.add(componentId);
    }

    public void removeConnection(String componentId) {
        connectedComponents.remove(componentId);
    }
}
