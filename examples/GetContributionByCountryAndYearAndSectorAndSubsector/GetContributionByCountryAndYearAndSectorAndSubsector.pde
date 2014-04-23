import se.goransson.openaid.*;

OpenAid openaid;

void setup() {
  openaid = new OpenAid(this);
  openaid.getContributionByCountryAndYearAndSectorAndSubsector(10, 1990, 2, 43081);
}

void draw() {
}

void openaid(String json){
  JSONArray arr = JSONArray.parse(json);
  println( arr );
}
