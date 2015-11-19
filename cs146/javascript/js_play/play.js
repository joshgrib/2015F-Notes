function is_numeric(val){
    return !isNaN(val);
}
function who_is_older(your_age){
    if(your_age < 20){
        return "I am older than you.";
    }
    if(your_age > 20){
        return "You are older than I.";
    }
    return "We are the same age.";
}
function log_to_page(message){
    var node = document.createElement("p");
    var textnode = document.createTextNode(message);
    node.appendChild(textnode);
    document.body.appendChild(node);
}
function swap(array, a, b){
  var temp = array[a];
  array[a] = array[b];
  array[b] = temp;
}
function selectionSort(array){
  for(var i=0; i<array.length-1; i++){
    var minIndex = i;
    for(var j=i+1; j<array.length; j++){
      if(array[j] < array[minIndex]){
        minIndex = j;
      }
    }
    if(minIndex!==i){
      swap(array, minIndex, i);
    }
  }
}