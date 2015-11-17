var imageArray = ["greenflash.jpg",
                  "oculus.jpg",
                  "paintedcanyon.jpg",
                  "totality.jpg"];
var imageIndex = 0;
function nextImage(element){
    var image = document.getElementById(element);
    imageIndex = (imageIndex + 1) % imageArray.length;
    image.src = imageArray[imageIndex];
}

window.onload = setInterval(function(){
    //function to be executed
    nextImage("changing_image");}, 
    3000);//every 3 seconds