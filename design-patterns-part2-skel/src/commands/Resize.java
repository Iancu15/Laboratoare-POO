package commands;

import java.util.ArrayList;
import java.util.List;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class Resize implements DrawCommand {

    private List<Integer> newDimensions;
    private List<Integer> oldDimensions;
    private float percentage;
    private int id;
    private DiagramCanvas diagramCanvas;
    
    public Resize(DiagramCanvas diagramCanvas, String id, String percentage) {
        this.percentage = (float) Integer.parseInt(percentage)/100;
        this.id = Integer.parseInt(id);
        this.diagramCanvas = diagramCanvas;
        this.newDimensions = new ArrayList<Integer>();
        this.oldDimensions = new ArrayList<Integer>();
    }
    
    @Override
    public void execute() {
        DiagramComponent diagramComponent = this.diagramCanvas.getComponent(id);
        this.oldDimensions.add(diagramComponent.getWidth());
        this.oldDimensions.add(diagramComponent.getHeight());
        
        // rotunjesc pentru ca width si height sunt int si nu vreau sa umblu cu float
        this.newDimensions.add(Math.round(diagramComponent.getWidth() * percentage));
        this.newDimensions.add(Math.round(diagramComponent.getHeight() * percentage));
        diagramComponent.setWidth(newDimensions.get(0)).setHeight(newDimensions.get(1));
    }

    @Override
    public void undo() {
        this.diagramCanvas.getComponent(id).setWidth(oldDimensions.get(0))
                                           .setHeight(oldDimensions.get(1));
    }

    @Override
    public void redo() {
        this.diagramCanvas.getComponent(id).setWidth(newDimensions.get(0))
                                           .setHeight(newDimensions.get(1));
    }
    
    @Override
    public String toString() {
        return "Change dimensions from " + oldDimensions + " to " + newDimensions + 
                                                                    " for component " + id + "\n";
    }
}
