package org.example.compactador.compactInterface;

import java.io.IOException;
import java.util.ArrayList;

public interface CompactadorInterface {
    public void compactTo(ArrayList<String> path) throws IOException;
}
