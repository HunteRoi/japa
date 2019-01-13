function swapActive(element){
    var active = document.getElementsByClassName("active")[0];
    if(active != null) active.classList.toggle("active");
    element.classList.toggle("active");
}