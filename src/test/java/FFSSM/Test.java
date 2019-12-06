/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.util.Calendar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

/**
 *
 * @author mmarty01
 */
public class Test {
    Personne p;
	Club c;
	
	@Before
	public void setUp() {
		p = new Personne("1 61 03 34", "Bastide", "Rémi", null, null, null);
		c = new Club(null, "Biarritz", null);
	}
	
	@org.junit.Test
	public void testLicenceValide() {
		Calendar delivrance = Calendar.getInstance();
		Licence l = new Licence(p, "10", delivrance, 0, c);
                assertTrue( l.estValide(delivrance) );
                
                Calendar unMoisApres = (Calendar) delivrance.clone();
		unMoisApres.add(Calendar.MONTH, 1);             
		assertTrue( l.estValide(unMoisApres) );
                
		Calendar unAnApres = (Calendar) delivrance.clone();
		unAnApres.add(Calendar.YEAR, 1);             
		assertTrue( l.estValide(unAnApres) );
                
	}
	
	@org.junit.Test
	public void testLicenceInvalide() {
		Calendar delivrance = Calendar.getInstance();
		Licence l = new Licence(p, "10", delivrance, 0, c);
		Calendar d = (Calendar) delivrance.clone();
		d.add(Calendar.YEAR, 1);
		d.add(Calendar.DAY_OF_YEAR, 1);
		assertFalse( l.estValide(d) );
                Calendar d2 = (Calendar) delivrance.clone();
		d2.add(Calendar.DAY_OF_YEAR, -1);
		assertFalse( l.estValide(d2) );
	}
}

