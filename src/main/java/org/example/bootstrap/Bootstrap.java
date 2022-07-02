package org.example.bootstrap;

import org.example.model.Score;

import java.io.*;

public class Bootstrap {
    public void initialize() throws IOException {

        File input = new File("highScores.txt");
        if (!input.exists()) {
            FileOutputStream fos
                    = new FileOutputStream("highScores.txt");
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);
            oos.writeObject(new Score("Syd", 100));
            oos.writeObject(new Score("Roger", 200));
            oos.writeObject(new Score("David", 300));
            oos.writeObject(new Score("Nick", 400));
            oos.writeObject(new Score("Rick", 500));
            oos.close();
        }
    }
}
