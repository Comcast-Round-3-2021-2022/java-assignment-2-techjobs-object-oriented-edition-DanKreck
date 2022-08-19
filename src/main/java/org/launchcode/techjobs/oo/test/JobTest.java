package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;
/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester",
                    new Employer("ACME"),
                    new Location("Desert"),
                    new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Greeter",
                new Employer("Walmart"),
                new Location("Philadelphia"),
                new PositionType("Customer Service"),
                new CoreCompetency("Friendly"));
        Job job2 = new Job("Greeter",
                new Employer("Walmart"),
                new Location("Philadelphia"),
                new PositionType("Customer Service"),
                new CoreCompetency("Friendly"));
        assertFalse(job1 == job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job jobOutput = new Job("Greeter",
                new Employer("Walmart"),
                new Location("Philadelphia"),
                new PositionType("Customer Service"),
                new CoreCompetency("Friendly"));
        int end = (jobOutput.toString().length() -1);

        assertEquals(jobOutput.toString().charAt(0),'\n');
        assertEquals(jobOutput.toString().charAt(end), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job formatTest = new Job("Greeter",
                new Employer("Walmart"),
                new Location("Philadelphia"),
                new PositionType("Customer Service"),
                new CoreCompetency("Friendly"));

        assertTrue(formatTest.toString().contains("ID:"));
        assertTrue(formatTest.toString().contains("Name:"));
        assertTrue(formatTest.toString().contains("Employer:"));
        assertTrue(formatTest.toString().contains("Location:"));
        assertTrue(formatTest.toString().contains("Position Type:"));
        assertTrue(formatTest.toString().contains("Core Competency:"));

        assertEquals(formatTest.getName(), "Greeter");
        assertEquals(formatTest.getEmployer().getValue(), "Walmart");
        assertEquals(formatTest.getLocation().getValue(), "Philadelphia");
        assertEquals(formatTest.getPositionType().getValue(), "Customer Service");
        assertEquals(formatTest.getCoreCompetency().getValue(), "Friendly");
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job testBlank = new Job("Greeter",
                new Employer("Walmart"),
                new Location(""),
                new PositionType("CustomerService"),
                new CoreCompetency("Friendly"));

        String correct = "\nID: " + testBlank.getId() +
                "\nName: " + testBlank.getName() +
                "\nEmployer: " + testBlank.getEmployer() +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + testBlank.getPositionType() +
                "\nCore Competency: " + testBlank.getCoreCompetency() + "\n";

        assertEquals(testBlank.toString(), correct);
    }
}
