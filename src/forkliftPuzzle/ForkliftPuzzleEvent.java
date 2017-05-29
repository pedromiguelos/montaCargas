package forkliftPuzzle;

import java.util.EventObject;

public class ForkliftPuzzleEvent extends EventObject {

    public ForkliftPuzzleEvent(ForklifttPuzzleState source) {
        super(source);
    }
}
