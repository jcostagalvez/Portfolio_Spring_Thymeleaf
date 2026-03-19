document.querySelectorAll(".caseWrap").forEach((wrap) => {

    function toggleCase(){
        const isOpen = wrap.classList.toggle("open");
        wrap.setAttribute("aria-expanded", String(isOpen));
    }

    wrap.addEventListener("click", toggleCase);

    wrap.addEventListener("keydown", (e)=>{
        if(e.key === "Enter" || e.key === " ") {
            e.preventDefault();
            toggleCase();
        }
    });

});

function focusBriefcase(briefCaseEl){
    const container = document.querySelector(".briefCasescontainer");

    // si ya está enfocado -> cerrar
    if (briefCaseEl.classList.contains("is-focused")) {
        closeFocus();
        return;
    }

    // quitar foco a otros y resetear sus transforms
    document.querySelectorAll(".briefCase").forEach(bc => {
        bc.classList.remove("is-focused");
        const w = bc.querySelector(".caseWrap");
        if (w) {
            w.style.setProperty("--tx", "0px");
            w.style.setProperty("--ty", "0px");
            w.classList.remove("open");
            w.setAttribute("aria-expanded","false");
        }
    });

    container.classList.add("has-focus");
    briefCaseEl.classList.add("is-focused");

    const wrap = briefCaseEl.querySelector(".caseWrap");
    if (!wrap) return;

    // abrir el maletín
    wrap.classList.add("open");
    wrap.setAttribute("aria-expanded","true");

    // calcular desplazamiento al centro del viewport
    const rect = wrap.getBoundingClientRect();
    const centerX = rect.left + rect.width / 2;
    const centerY = rect.top + rect.height / 2;

    const targetX = window.innerWidth / 2;
    const targetY = window.innerHeight / 2;

    const dx = targetX - centerX;
    const dy = targetY - centerY;

    wrap.style.setProperty("--tx", `${dx}px`);
    wrap.style.setProperty("--ty", `${dy}px`);

    // opcional: subir un pelín más (si quieres, resta algo a dy)
    // wrap.style.setProperty("--ty", `${dy - 10}px`);
}

function closeFocus(){
    const container = document.querySelector(".briefCasescontainer");
    container.classList.remove("has-focus");

    document.querySelectorAll(".briefCase").forEach(bc => {
        bc.classList.remove("is-focused");
        const wrap = bc.querySelector(".caseWrap");
        if (wrap) {
            wrap.style.setProperty("--tx", "0px");
            wrap.style.setProperty("--ty", "0px");
            wrap.classList.remove("open");
            wrap.setAttribute("aria-expanded","false");
        }
    });
}



