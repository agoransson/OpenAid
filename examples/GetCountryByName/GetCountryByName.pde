import se.goransson.openaid.*;

OpenAid openaid;

void setup() {
  openaid = new OpenAid(this);
  openaid.getCountryByName("Algeriet");
}

void draw() {
  
}

void openaid(String json){
  JSONArray arr = JSONArray.parse(json);
  println( arr );
}
