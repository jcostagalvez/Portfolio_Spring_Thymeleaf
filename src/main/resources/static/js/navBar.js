function closeNav(){
    const btn = document.getElementById("menuBtn");
    const ul = document.getElementById("navList");
    const container = document.getElementById("navContainer");
    const open = btn.classList.toggle("is-open");
    const openUl = ul.classList.toggle("isopen");
    const openContainer = container.classList.toggle("is-open");
    btn.setAttribute("aria-expanded", String(open));
    btn.setAttribute("aria-label", open ? "Cerrar menú" : "Abrir menú");
}

function isActive(){

}