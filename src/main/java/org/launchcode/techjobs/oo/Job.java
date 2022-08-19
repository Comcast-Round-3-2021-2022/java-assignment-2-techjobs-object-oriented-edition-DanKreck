package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String notAvail = "Data not available";
        String nameCheck = name == "" ? notAvail : name;
        String empCheck = employer.getValue() == "" ? notAvail : employer.getValue();
        String locCheck = location.getValue() == "" ? notAvail : location.getValue();
        String posCheck = positionType.getValue() == "" ? notAvail : positionType.getValue();
        String coreCheck = coreCompetency.getValue() == "" ? notAvail : coreCompetency.getValue();

        if(nameCheck != notAvail || empCheck != notAvail || locCheck != notAvail || posCheck != notAvail || coreCheck != notAvail) {
            return "\nID: " + id +
                    "\nName: " + nameCheck +
                    "\nEmployer: " + empCheck +
                    "\nLocation: " + locCheck +
                    "\nPosition Type: " + posCheck +
                    "\nCore Competency: " + coreCheck + "\n";
        }else {
            return "OOPS! This job does not seem to exist.";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);
    }
    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}

    public Employer getEmployer() {return employer;}
    public void setEmployer(Employer employer) {this.employer = employer;}

    public PositionType getPositionType() {return positionType;}
    public void setPositionType(PositionType positionType) {this.positionType = positionType;}

    public CoreCompetency getCoreCompetency() {return coreCompetency;}
    public void setCoreCompetency(CoreCompetency coreCompetency) {this.coreCompetency = coreCompetency;}

}
