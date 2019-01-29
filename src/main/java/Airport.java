import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanesList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanesList.add((PassengerPlane) plane);
            }
        }
        return passengerPlanesList;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanesList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanesList.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanesList;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanesList = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanesList.get(0);
        for (int i = 0; i < passengerPlanesList.size(); i++) {
            if (passengerPlanesList.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanesList.get(i);
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanesList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanesList = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanesList.size(); i++) {
            MilitaryPlane plane = militaryPlanesList.get(i);
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanesList.add(plane);
            }
        }
        return transportMilitaryPlanesList;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanesList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanesList = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanesList.size(); i++) {
            MilitaryPlane plane = militaryPlanesList.get(i);
            if (plane.getMilitaryType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanesList.add(plane);
            }
        }
        return bomberMilitaryPlanesList;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> ExperimentalPlanesList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                ExperimentalPlanesList.add((ExperimentalPlane) plane);
            }
        }
        return ExperimentalPlanesList;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     *
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
