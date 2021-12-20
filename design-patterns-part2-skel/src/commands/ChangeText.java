package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ChangeText implements DrawCommand {

    private String newText;
    private String oldText;
    private int id;
    private DiagramCanvas diagramCanvas;
    
    public ChangeText(DiagramCanvas diagramCanvas, String id, String newText) {
        this.newText = newText;
        this.id = Integer.parseInt(id);
        this.diagramCanvas = diagramCanvas;
    }
    
    @Override
    public void execute() {
        DiagramComponent diagramComponent = this.diagramCanvas.getComponent(id);
        this.oldText = diagramComponent.getText();
        diagramComponent.setText(newText);
    }

    @Override
    public void undo() {
        this.diagramCanvas.getComponent(id).setText(oldText);
    }

    @Override
    public void redo() {
        this.diagramCanvas.getComponent(id).setText(newText);
    }
    
    @Override
    public String toString() {
        return "Change text from <<" + oldText + ">> to <<" + newText + ">> for component " + id 
                                                                                           + "\n";
    }
    
}
