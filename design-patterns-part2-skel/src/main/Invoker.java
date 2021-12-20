package main;

import commands.*;

import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {
    
    private LinkedList<DrawCommand> usedCommands;
    private LinkedList<DrawCommand> undoedCommands;
    
    public Invoker() {
        this.restart();
    }
    
    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
        // golesc istoric de comenzi
        this.usedCommands = new LinkedList<DrawCommand>();
        this.undoedCommands = new LinkedList<DrawCommand>();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        command.execute();
        this.usedCommands.add(command);
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        if (this.usedCommands.isEmpty()) {
            return;
        }
        
        DrawCommand command = this.usedCommands.removeLast();
        command.undo();
        this.undoedCommands.add(command);
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        if (this.undoedCommands.isEmpty()) {
            return;
        }
        
        DrawCommand command = this.undoedCommands.removeLast();
        command.redo();
        this.usedCommands.add(command);
    }
    
}
