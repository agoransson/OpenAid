import se.goransson.openaid.*;

OpenAid openaid;

void setup() {
  openaid = new OpenAid(this);
  openaid.getOfficialDacByYear(2000);
}

void draw() {
}

void openaid(String json){
  JSONObject obj = JSONObject.parse(json);
  println( obj );
}
