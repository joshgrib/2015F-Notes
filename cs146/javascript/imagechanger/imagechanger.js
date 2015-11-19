var imageArray = ['images/greenflash.jpg',
                  'images/oculus.jpg',
                  'images/paintedcanyon.jpg',
                  'images/totality.jpg'];
var imageIndex = 0;

function nextImage(element) {
    var image = document.getElementById(element);
    imageIndex = (imageIndex + 1) % imageArray.length;
    image.src = imageArray[imageIndex];
}

// window.onload is fired when the entire page loads, including its
// content (images, css, scripts, etc.)
// It must be assigned a function.
window.onload = function() {
    // setInterval returns a number, representing the ID value of the
    // timer that is set. It cannot be directly assigned to
    // window.onload.
    setInterval(nextImage, 5000, "changing_image");
}
