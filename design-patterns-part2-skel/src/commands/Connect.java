package commands;

import diagram.DiagramCanvas;

public class Connect implements DrawCommand {
    
    private Integer idOne;
    private Integer idTwo;
    private DiagramCanvas diagramCanvas;
    
    public Connect(DiagramCanvas diagramCanvas, String idOne, String idTwo) {
        this.idOne = Integer.parseInt(idOne);
        this.idTwo = Integer.parseInt(idTwo);
        this.diagramCanvas = diagramCanvas;
    }
    
    @Override
    public void execute() {
        this.diagramCanvas.getComponent(idOne).connectTo(idTwo.toString());
        this.diagramCanvas.getComponent(idTwo).connectTo(idOne.toString());
    }

    @Override
    public void undo() {
        this.diagramCanvas.getComponent(idOne).removeConnection(idTwo.toString());
        this.diagramCanvas.getComponent(idTwo).removeConnection(idOne.toString());
    }

    @Override
    public void redo() {
        this.execute();
    }
    
    @Override
    public String toString() {
        return "Connect component " + idOne + " to component " + idTwo + "\n";
    }
    
}
