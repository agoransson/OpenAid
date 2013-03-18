import se.goransson.openaid.*;

void setup() {
    OpenAidRequest request = new OpenAidRequest(this);
    
    // Sätt modellen (enl: http://openaid.se/api/)
    
    // Välj "contribution" som modell
    request.setModel("contribution");
    
    // Välj året 2008
    request.setAttribute("year", "2008");
    
    // Välj endast "offentlig sektor" (10000)
    request.setAttribute("delivery_channel", "10000");
    
    // Välj endast "Humanitärt bistånd"
    request.setAttribute("sector", "6");
    
    // Välj "Irak" (id: 120)
    request.setAttribute("country", "120");
    
    // Skicka frågan
    request.execute();
}

void draw() {
}

void openaid(String json){
  JSONArray arr = JSONArray.parse(json);
  println( arr );
}
