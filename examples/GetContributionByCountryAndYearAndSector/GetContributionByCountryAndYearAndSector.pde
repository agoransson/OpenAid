import se.goransson.openaid.*;

OpenAid openaid;

void setup() {
  openaid = new OpenAid(this);
  openaid.getContributionByCountryAndYearAndSector(10, 1990, 2);
}

void draw() {
}

void openaid(String json){
  JSONArray arr = JSONArray.parse(json);
  println( arr );
}
