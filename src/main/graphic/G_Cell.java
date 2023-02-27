package graphic;
import logic.*;

public class G_Cell {
    private Cell cell;

    public G_Cell(Cell cell){
        this.cell = cell;
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell = cell;
    }
}
