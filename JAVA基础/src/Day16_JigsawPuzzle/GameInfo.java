package Day16_JigsawPuzzle;

import java.io.Serial;
import java.io.Serializable;

public class GameInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 7497887490544158029L;
    private int[][] data;
    private int x,y;
    private String path;
    private int step;
    public GameInfo() {
    }
    public GameInfo(int[][] data, int x, int y, String path, int step) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.path = path;
        this.step = step;
    }
    public int[][] getData() {
        return data;
    }
    public void setData(int[][] data) {
        this.data = data;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getStep() {
        return step;
    }
    public void setStep(int step) {
        this.step = step;
    }
    public String toString() {
        return "GameInfo{data = " + data + ", x = " + x + ", y = " + y + ", path = " + path + ", step = " + step + "}";
    }
}
