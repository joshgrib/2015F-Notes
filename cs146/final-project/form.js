var workers = {
    "template": ["Name",
        "Transformer type",
        "$/hr",
        "Description"],
    1: ["Optimus Prime",
        "Autobot",
        "$250/hr",
        "Optimus Prime is the largest, strongest and most courageous of all Autobots, he is also their leader. Feels his role is the protection of all life, including Earth-life. Good for leading people, reconnaissance, moving heavy items, fighting other giant robots."],
    2: ["Sentinel Prime",
        "Autobot",
        "$225/hr",
        "Optimus Prime's predecessor and mentor, the captain of the Ark and a former Autobot/Decepticon who transforms into a red and black Rosenbauer Panther airport crash tender fire truck. His intention to restore Cybertron to its former glory after the war drove him mad, causing him to go against his ideals and side with the Decepticons, eventually becoming as corrupt and vile as they where. He's a real people person and is best suited for customer service."],
    3: ["Bumblebee",
        "Autobot",
        "$200/hr",
        "Small, eager and brave, Bumblebee acts as a messenger and spy. Due to his small size, he dares to go where others can't and won't. He idolizes the bigger Autobots, especially Optimus Prime and Prowl, and strives to be accepted. He is the most energy efficient and has the best vision of all the Autobots. He can go underwater for reconnaissance and salvage missions. Although physically the weakest Autobot, his stealth more than compensates for this inadequacy."],
    4: ["Ratchet",
        "Autobot",
        "$275/hr",
        "The Autobots' medical officer who transforms into a search and rescue 2004 Hummer H2. Best suited for dangerous situations, perhaps as part of a convoy for a high-profile celebrity."],
    5: ["The Fallen",
        "Decepticon",
        "$300/hr",
        "He is capable of opening Space Bridges at will, and he also has the ability to wield telekinesis, and wields a metal spear as a melee weapon. He has a passion for destroying worlds, and is best suited for conquests and destruction."],
    6: ["Megatron",
        "Decepticon",
        "$150/hr",
        "The ruthless commander of the Decepticons, Megatron has does whatever he needs to to get revenge and power, often killing anyone who stands in his way. He is an avid gardener and interior designer. He always knows how to add subtle things to pull a room together"],
    7: ["Starscream",
        "Decepticon",
        "$300/hr",
        "Megatron's second-in-command who transforms into a Lockheed Martin F-22 Raptor jet. He is a powerful and technologically advanced air commander. He is also a well-known philosopher, and is great at talking to people and helping them get through their problems."],
    8: ["Barricade",
        "Decepticon",
        "$125/hr",
        "A Decepticon scout who transforms into a black Saleen S281 police car. Barricade can hold a second smaller transformer in a compartment on his chest. Due to his skill at impersonating authority he is good at getting into restricted areas. He's like the friend that knows the owners everywhere."]
};

function getFormData() {
    "use strict";
    var str = "<h3><b>Response</b></h3><br />";
    str += "First name: " + document.getElementById("firstname").value.trim() + "<br />";
    str += "Last name: " + document.getElementById("lastname").value.trim() + "<br />";
    str += "City: " + document.getElementById("city").value.trim() + "<br />";
    str += "State: " + document.getElementById("state").value + "<br />";
    str += "<hr /><b>Your perfect match is " +  workers["1"][0] + "</b><br />They are a " + workers["1"][1] + " and costs " + workers["1"][2] + ".<br />";
    str += "Description: " + workers["1"][3];
    document.getElementById("form_article").style.display = "none";
    return str;
}
function getHelp() {
    "use strict";
    var formData = getFormData();
    document.getElementById("response_article").innerHTML = formData;
}