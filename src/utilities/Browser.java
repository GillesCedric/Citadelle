package utilities;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser {

    public static void open(String url) {
    
        String myOS = System.getProperty("os.name").toLowerCase();

        try {
            if(Desktop.isDesktopSupported()) { // Probably Windows
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else { // Definitely Non-windows
                Runtime runtime = Runtime.getRuntime();
                if(myOS.contains("mac")) { // Apples
                    runtime.exec("open " + url);
                } 
                else if(myOS.contains("nix") || myOS.contains("nux")) { // Linux flavours 
                    runtime.exec("xdg-open " + url);
                }
                else 
                    OUT("Impossible d'ouvrir les régles sur votre système d'exploitation :( #SadFace");
            }
        }
        catch(IOException | URISyntaxException eek) {
            OUT("erreur : "+ eek.getMessage());
        }
    }

    private static void OUT(String str) {
        System.out.println(str);
    }
}
