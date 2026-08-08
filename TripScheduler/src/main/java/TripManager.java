import java.util.ArrayList;

public class TripManager implements TripSubject {

    private static final TripManager INSTANCE = new TripManager();
    private final ArrayList<TripObserver> observers = new ArrayList<>();
    private Trip currentTrip;

    private TripManager(){}

    public static TripManager getInstance(){
        if(INSTANCE == null){
            return new TripManager();
        }
        return INSTANCE;
    }


    @Override
    public void addObserver(TripObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(TripObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(TripObserver o : observers){
            o.update(currentTrip);
        }
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
        notifyObservers();
    }
}
