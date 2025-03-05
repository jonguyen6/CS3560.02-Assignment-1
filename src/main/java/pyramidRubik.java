import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

enum Color{RED, GREEN, BLUE, YELLOW}

class Face {
    private Color[] tiles;
    public Face(Color[] tiles) {
        tiles = new Color[9];               // 9 tiles on each side, so 9 colors total per face
        Arrays.fill(tiles,Color.RED);       // Using Arrays.fill to fill up "one face with one color"
        Arrays.fill(tiles,Color.GREEN);     // Each Array represents one face
        Arrays.fill(tiles,Color.BLUE);
        Arrays.fill(tiles,Color.YELLOW);
    }
    public Color[] getTiles() {
        return tiles;                       // getter for tiles
    }
}

public class pyramidRubik {
    private Face[] faces;

    public pyramidRubik(Face[] faces) {
        this.faces = faces;     // setter for faces
        initializeFaces();      // loading in all colors onto all tiles of each face
        initializeEdges();
    }

    public Face[] getFaces() {
        return faces;           // faces getter
    }

    // setting up each face by giving each a color
    private void initializeFaces() {
        Color[] color = new Color[9];               // 9 tiles per face. therefore 9 (total) colors per face
        for (int i = 0; i < faces.length; i++) {
            faces[i] = new Face(color);
        }
    }

    private void initializeEdges() {
        // these are basically the tips of the pyramid rubik
        // hence why there are 4 pieces
        int[][] adjacentFaces = {
                {0, 3}, // Face 0 shares an edge with face 3
                {1, 2}, // Face 1 shares an edge with face 2
                {1, 3}, // Face 1 shares an edge with face 3
                {2, 3}  // Face 2 shares an edge with face 3
        };

        // these are the edges of the pyramid rubik
        // hence why there are 6 pieces
        int[][] edgeIndices = {
                {5, 3}, // Edge between face 0 and 1
                {7, 1}, // Edge between face 0 and 2
                {3, 5}, // Edge between face 0 and 3
                {1, 7}, // Edge between face 1 and 2
                {7, 1}, // Edge between face 1 and 3
                {5, 3}  // Edge between face 2 and 3
        };

        // this for-loop's is basically to set up the rest of the tiles
        for (int i = 0; i < adjacentFaces.length; i++) {
            int faceA = adjacentFaces[i][0];
            int faceB = adjacentFaces[i][1];
            int tileA = edgeIndices[i][0];
            int tileB = edgeIndices[i][1];
        }
    }

    public boolean validateCube() {
        // These are the rules used to make sure that a valid "pyramid rubik's" has actually been successfully created.
        for (Face face : faces) {                  // using a for-loop to traverse through all faces of the pyramid
            if (face.getTiles().length != 9) {     // if there aren't 9 tiles on each face
                return false;                      // return false immediately because rule for defining a pyramid rubik's has been broken
            }
        }

        Map<Color, Integer> colorCount = new HashMap<>();     // hash map for all the colors
        for (Color color : Color.values()) {
            colorCount.put(color, 0);                         // assigning a color to a value in the map
        }

        for (Face face : faces) {                                   // for each face in "faces"
            for (Color tile : face.getTiles()) {                    // for each tile on each face
                colorCount.put(tile, colorCount.get(tile) + 1);     // we give it a color
            }
        }

        // this is basically just making sure that there are 9 colors total on each face
        // in other words, each face's tiles have a color assigned to it
        for (int count : colorCount.values()) {
            if (count != 9) {       // if there aren't 9 tiles with colors
                return false;       // return false immediately because rule for defining a pyramid rubik's has been broken
            }
        }

        // if the code gets here, it means that all rules have been passed
        // therefore, the pyramid rubik generated is valid. so the program returns "true".
        return true;
    }
}
