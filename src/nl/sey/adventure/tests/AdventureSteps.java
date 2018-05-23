package nl.sey.adventure.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.jbehave.core.annotations.*;
import nl.sey.adventure.Adventure;

public class AdventureSteps{
	
	Adventure adventure;
	
	@Given("an adventure is created")
	public void givenAnAdventureIsCreated(){
		adventure = new Adventure(); 
	}
	
	@When("I am at the start")
	public void whenIAmAtTheStart(){
		// already true 
	}
	
	@Then("the location name is 'rivier'")
	public void thenTheLocationNameIsrivier(){
		assertEquals("rivier", adventure.getLocatieNaam());
	}
}