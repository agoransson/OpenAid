package se.goransson.openaid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import processing.core.PApplet;

/**
 * Requesthanterare for Openaid webservice API'et.
 * 
 * Foljer modell-attribut schemat som ar presenterat pa http://openaid.se/api/.
 * 
 * @author ksango
 * 
 */
public class OpenAidRequest implements Runnable {

	private PApplet parent;
	private Method callback;
	private Thread runner;

	private static final String HOST = "api.openaid.se";
	private static final String PATH = "/api/v1/";

	private static String model = "";

	private static HashMap<String, String> attributes = new HashMap<String, String>();

	public OpenAidRequest(PApplet parent) {
		this(parent, "openaid");
	}

	public OpenAidRequest(PApplet parent, String method) {
		this.parent = parent;
//		parent.registerDispose(this);
		parent.registerMethod("dispose", this);
		try {
			callback = parent.getClass().getMethod(method,
					new Class[] { String.class });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Satt den nuvarande modellen.
	 * 
	 * Foljande modeller finns: contribution, country, sector, subsector,
	 * delivery_channel, partner_organization, document
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		OpenAidRequest.model = model;
	}

	/**
	 * Satt ett attribut for en modell.</br></br>
	 * 
	 * Foljande attribut finns for respektive modell:</br>(attribut i fetstil
	 * kan anvandas som begransning i anrop)</br></br>
	 * 
	 * contribution: id, <b>year</b>, <b>title</b>, description,
	 * <b>extending_agency, years, documents, outcome, outcome_total, name,
	 * name_eng, name_swe, start_year, end_year, <b>country</b>, <b>sector</b>,
	 * <b>subsector</b>, <b>delivery_channel</b>, <b>partner_organization</b>,
	 * <b>plus</b></br></br>
	 * 
	 * country: id, <b>name</b>, name_eng, name_swe, region, contributions, iso,
	 * population, hdi, corruption_rank, corruption_score, country_code,
	 * outcome_total, outcome, documents, <b>year</b>,
	 * <b>by_sector</b></br></br>
	 * 
	 * sector: <b>id</b>, <b>name</b>, name_swe, name_eng, crsid, outcome,
	 * contributions, subsectors, documents, country, delivery_channel,
	 * <b>year</b></br></br>
	 * 
	 * subsector: <b>id</b>, <b>name</b>, name_swe, name_eng, description,
	 * sector, subsector, contributions, outcome_total, outcome, documents,
	 * <b>year</b></br></br>
	 * 
	 * delivery_channel: <b>id</b>, <b>name</b>, name_swe, name_eng, name_swe,
	 * outcome _row, plus, contributions, <b>by_sector</b>,
	 * <b>year</b></br></br>
	 * 
	 * partner_organization: <b>id</b>, <b>name</b>, name_swe, name_eng,
	 * contributions, documents, <b>delivery_channel</b>, <b>year</b></br></br>
	 * 
	 * document: <b>id</b>, <b>title</b>, type, url
	 * 
	 * @param key
	 *            attributets namn
	 * @param value
	 *            attributets varde
	 */
	public void setAttribute(String key, String value) {
		attributes.put(key, value);
	}

	public void execute() {
		runner = new Thread(this);
		runner.start();
	}

	public void stop() {
		runner = null;
	}

	public void dispose() {
//		stop();
		PApplet.println("Calling dispose.");
	}

	@Override
	public void run() {
		String json = null;
		try {
			json = doGet();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (json == null) {
			// Issue warning?
		} else {
			// Clean response
			json = json.replace(" ", "");
			json = json.replace("\n", "");
			json = json.replace("\t", "");

			try {
				callback.invoke(parent, json);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
	}

	private String doGet() throws URISyntaxException, IOException {
		// Construct the GET
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost(HOST).setPath(PATH + model);

		Iterator<Entry<String, String>> it = attributes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pairs = (Map.Entry<String, String>) it
					.next();
			builder.addParameter(pairs.getKey(), pairs.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}

		URI uri = builder.build();
		HttpGet request = new HttpGet(uri);

		// Construct the HttpClient that will send the GET request
//		HttpClient client = new DefaultHttpClient(); // This is now deprecated
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpResponse response = client.execute(request);

		// Buffer for svaret
		StringBuffer sb = new StringBuffer();

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}

		return sb.toString();
	}
}
