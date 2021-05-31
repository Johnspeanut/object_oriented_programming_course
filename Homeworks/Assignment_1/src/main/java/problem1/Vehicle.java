package problem1;

/**
* Vehicle class represents an vehicle that has unique Vehicle Identification Number(VIN), and corresponding license plate.
* */
public class Vehicle {
    private int vin;
    private String licensePlate;
    Owner owner;

    /**
    * Constructor that creates a new vehicle object with the specified vIN and license plate.
    * @param vin - VIN of the new Vehicle object.
    * @param licensePlate - license plate of the new Vehicle.
    * @param owner - owner of the new Vehicle.
    * */
    public Vehicle(int vin, String licensePlate, Owner owner){
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
    * Returns the VIN of the Vehicle.
    * @return the VIN of the Vehicle.
    * */
    public int getVin(){
        return this.vin;
    }

    /**
    * Returns the licensePlate of the Vehicle.
    * @return the licensePlate of the Vehicle.
    * */
    public String getLicensePlate(){
        return this.licensePlate;
    }

    /**
    * Return the owner of the Vehicle.
    * @return the owner of the vehicle.
    * */
    public Owner getOwner(){
        return this.owner;
    }

    /**
    * Sets the VIN of the Vehicle.
     * @param vin - Set VIN of the Vehicle object to this value.
    */
    public void setVin(int vin){
        this.vin = vin;
    }

    /**
    * Sets the licensePlate of the Vehicle.
     * @param licensePlate - Set licence plate of the Vehicle object to this value.
    * */
    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    /**
    * Sets the owner of the Vehicle.
     * @param owner - Set this Vehicle object to the new owner.
    * */
    public void setOwner(Owner owner){
        this.owner = owner;
    }
}
