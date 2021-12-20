package main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "1", "3");
        client.executeAction("connect", "4", "0");
        client.executeAction("connect", "4", "1");
        client.executeAction("connect", "4", "2");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        testDraw(client);
        // 100 -> 100%
        client.executeAction("resize", "0", "100");
        client.executeAction("resize", "1", "50");
        client.executeAction("resize", "2", "200");
        client.executeAction("resize", "3", "20");
        client.executeAction("resize", "4", "0");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        testDraw(client);
        testCommands(client, "0", "praz", "GREEN", "15");
        testCommands(client, "1", "ceapa", "YELLOW", "100");
        testCommands(client, "2", "rosie", "RED", "0");
        testCommands(client, "3", "ceapa rosie", "RED", "320");
        testCommands(client, "4", "pepene", "GREEN", "44");
        
        client.executeAction("draw rectangle");
        testCommands(client, "5", "praz", "GREEN", "120");
        
        client.executeAction("connect", "5", "1");
        client.executeAction("connect", "2", "3");
        client.executeAction("connect", "1", "4");
        client.showDiagram();
    }
    
    private static void testCommands(Client client, String id, String text, String color, 
                                                                        String resizePercentage) {
        client.executeAction("change color", id, color);
        client.executeAction("change text", id, text);
        client.executeAction("resize", id, resizePercentage);
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        testAllCommands(client);
        for (int i = 0; i < 100; i++) {
            client.undo();
            client.redo();
        }
        // ar trb sa fie la fel
        client.showDiagram();
        
        for (int i = 0; i < 4; i++) {
            client.undo();
        }
        // ar trebui sa scape de ultimele 4 modificari(toate connected si un resize)
        client.showDiagram();
        
        for (int i = 0; i < 10; i++) {
            client.redo();
        }
        // ar trebui sa fie ca la inceput ca redo-urile in plus nu fac nimic
        client.showDiagram();
        
        for (int i = 0; i < 7; i++) {
            client.undo();
        }
        // ar trebui sa scape de ultimele 7 modificari(toate connected si de 5)
        client.showDiagram();
        
        for (int i = 0; i < 100; i++) {
            client.undo();
        }
        // ar trebui sa fie goala
        client.showDiagram();
        
        for (int i = 0; i < 1000; i++) {
            client.redo();
        }
        // ar trebui sa fie ca la inceput
        client.showDiagram();
    }
}
