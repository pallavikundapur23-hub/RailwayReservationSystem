package service;

import exceptions.InvalidTrainException;
import model.Train;
import java.util.ArrayList;
import java.util.List;

/** Provides train listing, lookup, and route-search operations. */
public class TrainService {
    private final List<Train> trains = new ArrayList<>();
    public TrainService() {
        trains.add(new Train(12627, "Karnataka Express", "Bengaluru", "Chennai", 2));
        trains.add(new Train(12028, "Shatabdi Express", "Bengaluru", "Chennai", 3));
        trains.add(new Train(16526, "Kanyakumari Express", "Bengaluru", "Kanyakumari", 4));
        trains.add(new Train(12608, "Lalbagh Express", "Bengaluru", "Chennai", 2));
        trains.add(new Train(12609, "Chennai Express", "Chennai", "Bengaluru", 3));
    }
    public List<Train> getAllTrains() { return new ArrayList<>(trains); }
    public Train findByNumber(int trainNumber) throws InvalidTrainException {
        for (Train train : trains) if (train.getTrainNumber() == trainNumber) return train;
        throw new InvalidTrainException("Train number " + trainNumber + " was not found.");
    }
    public List<Train> searchByRoute(String source, String destination) {
        List<Train> matches = new ArrayList<>();
        for (Train train : trains) if (train.getSource().equalsIgnoreCase(source.trim())
                && train.getDestination().equalsIgnoreCase(destination.trim())) matches.add(train);
        return matches;
    }
}
