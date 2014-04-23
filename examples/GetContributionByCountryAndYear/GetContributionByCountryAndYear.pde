import se.goransson.openaid.*;

OpenAid openaid;

void setup() {
  openaid = new OpenAid(this);
  openaid.getContributionByCountryAndYear(10, 1990);
}

void draw() {
}

void openaid(String json){
  JSONArray arr = JSONArray.parse(json);
  println( arr );
}
