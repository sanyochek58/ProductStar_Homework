public interface TripSubject {
    void addObserver(TripObserver o);
    void removeObserver(TripObserver o);
    void notifyObservers();
}
