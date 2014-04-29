/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package se.goransson.openaid;

import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing library or
 * tool. Make sure you rename this class as well as the name of the example
 * package 'template' to your own library or tool naming convention.
 * 
 * @example Hello
 * 
 *          (the tag @example followed by the name of an example included in
 *          folder 'examples' will automatically include the example in the
 *          javadoc.)
 * 
 */

public class OpenAid {

	// myParent is a reference to the parent sketch
	PApplet myParent;

	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public OpenAid(PApplet theParent) {
		myParent = theParent;
		welcome();
	}

	private void welcome() {
		System.out
				.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * Listar alla l�nder.
	 */
	public void getAllCountries() {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("country");
		// No parameters
		request.execute();
	}
	
	public void getAllCountries(String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("country");
		// No parameters
		request.execute();
	}

	/**
	 * H�mta data om ett s�rskilt samarbetsland.
	 * 
	 * @param name
	 *            Samarbetslandets namn
	 */
	public void getCountryByName(String name) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("name", name);
		request.execute();
	}
	
	public void getCountryByName(String name, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("name", name);
		request.execute();
	}

	/**
	 * H�mta data om ett s�rskilt samarbetsland.
	 * 
	 * @param id
	 *            Samarbetslandets id
	 */
	public void getCountryById(int id) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}
	
	public void getCountryById(int id, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}

	/**
	 * H�mta data om en enskild insats eller del av insats
	 * 
	 * @param id
	 *            Insatsens id
	 */
	public void getContributionById(int id) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}
	
	public void getContributionById(int id, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}

	/**
	 * Lista alla insatser f�r ett �r
	 * 
	 * @param year
	 *            Det �r som �r av intresse
	 */
	public void getTotalContributionsByYear(int year) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("year", Integer.toString(year));
		request.execute();
	}
	
	public void getTotalContributionsByYear(int year, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("country");
		// Parameters
		request.setAttribute("year", Integer.toString(year));
		request.execute();
	}

	/**
	 * Lista alla sektorer
	 */
	public void getAllSectors() {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("sector");
		// No parameters
		request.execute();
	}
	
	public void getAllSectors(String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("sector");
		// No parameters
		request.execute();
	}

	/**
	 * Visa data f�r en specifik sektor
	 * 
	 * @param id
	 *            Sektorns id
	 */
	public void getSubsectorById(int id) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("subsector");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}
	
	public void getSubsectorById(int id, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("subsector");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}

	/**
	 * 
	 * @param id
	 */
	public void getDeliveryChannelById(int id) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("delivery_channel");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}
	
	public void getDeliveryChannelById(int id, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("delivery_channel");
		// Parameters
		request.setAttribute("id", Integer.toString(id));
		request.execute();
	}

	public void getOfficialDac() {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("official_dac");
		// No parameters
		request.execute();
	}
	
	public void getOfficialDac(String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("official_dac");
		// No parameters
		request.execute();
	}

	public void getOfficialDacByYear(int year) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("official_dac");
		// Parameters
		request.setAttribute("year", Integer.toString(year));
		request.execute();
	}
	
	public void getOfficialDacByYear(int year, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("official_dac");
		// Parameters
		request.setAttribute("year", Integer.toString(year));
		request.execute();
	}
	
	public void getContributionByCountryAndYear(int id, int year) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		// Fire
		request.execute();
	}
	
	public void getContributionByCountryAndYear(int id, int year, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		// Fire
		request.execute();
	}
	
	public void getContributionByCountryAndYearAndSector(int id, int year, int sector) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		request.setAttribute("sector", Integer.toString(sector));
		// Fire
		request.execute();
	}
	
	public void getContributionByCountryAndYearAndSector(int id, int year, int sector, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		request.setAttribute("sector", Integer.toString(sector));
		// Fire
		request.execute();
	}
	
	public void getContributionByCountryAndYearAndSectorAndSubsector(int id, int year, int sector, int subsector) {
		OpenAidRequest request = new OpenAidRequest(myParent);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		request.setAttribute("sector", Integer.toString(sector));
		request.setAttribute("subsector", Integer.toString(subsector));
		// Fire
		request.execute();
	}
	
	public void getContributionByCountryAndYearAndSectorAndSubsector(int id, int year, int sector, int subsector, String callback) {
		OpenAidRequest request = new OpenAidRequest(myParent, callback);
		// Path
		request.setModel("contribution");
		// Parameters
		request.setAttribute("country", Integer.toString(id));
		request.setAttribute("year", Integer.toString(year));
		request.setAttribute("sector", Integer.toString(sector));
		request.setAttribute("subsector", Integer.toString(subsector));
		// Fire
		request.execute();
	}
}
