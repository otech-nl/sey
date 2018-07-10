package nl.sey.adventure.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.jbehave.core.annotations.*;
import nl.sey.adventure.Adventure;
import nl.sey.adventure.Locatie;

public class AdventureSteps{
	
	Adventure adventure;
	Locatie locatie;
	
	@Given("an adventure is created")
	public void givenAnAdventureIsCreated(){
		adventure = new Adventure(); 
	}
	
	@When("I am at the start")
	public void whenIAmAtTheStart(){
		locatie = adventure.getLocatie();
	}
	
	@Then("the location name is 'rivier'")
	public void thenTheLocationNameIsrivier(){
		assertEquals("rivier", locatie.getNaam());
	}
	
	@When("I am at location 'top'")

	public void whenIAmAtLocationtop(){
		locatie = Locatie.zoekOpNaam("top");
	}
	
	@Then("I can go to 'w'")

	public void thenICanGoTow(){
		Locatie nieuw = locatie.gaNaar('w');
		assertNotNull(nieuw, "top heeft geen w");
	}	
	
	@When("I am at location 'berg'")

	public void whenIAmAtLocationberg(){
		locatie = Locatie.zoekOpNaam("berg");
	}
	@When("I go to 'o'")
	
	public void whenIGoToo(){
		Locatie nieuw = locatie.gaNaar('o');
		assertNotNull(nieuw, "berg heeft geen o"+adventure+nieuw+locatie);
		locatie = nieuw;
	}
	
	@Then("the loction name is 'top'")
	public void thenTheLoctionNameIstop(){
		assertEquals("top", locatie.getNaam());
	}
}