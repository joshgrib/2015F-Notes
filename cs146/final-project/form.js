function getFormData() {
  "use strict";
  var str = "<h3><b>Response</b></h3><br />";
  str += "First name: " + document.getElementById("firstname").value.trim() + "<br />";
  str += "Last name: " + document.getElementById("lastname").value.trim() + "<br />";
  str += "City: " + document.getElementById("city").value.trim() + "<br />";
  str += "State: " + document.getElementById("state").value.trim() + "<br />";
  document.getElementById("form_article").style.display = "none";
  return str;
}
function getHelp() {
  "use strict";
  var formData = getFormData();
  document.getElementById("response_article").innerHTML = formData;
}