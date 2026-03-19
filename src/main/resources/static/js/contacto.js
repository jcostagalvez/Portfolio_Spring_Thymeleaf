(() => {
  const typedEl = document.getElementById("typed");
  const cursorEl = document.getElementById("cursor");

  const inputs = {
    name: document.getElementById("name"),
    email: document.getElementById("email"),
    message: document.getElementById("description")
  };

  // “Guion” inicial tipo terminal
  const script = [
    { text: "\nPROMPT> Enter EMAIL: ", delay: 22, focus: "email" },
    { text: "\nPROMPT> Enter MESSAGE: ", delay: 22, focus: "message" },
    { text: "\nREADY> Press SEND to transmit.\n", delay: 18 }
  ];

  const typeText = (text, speed = 25) =>
    new Promise(resolve => {
      let i = 0;
      const tick = () => {
        typedEl.textContent += text.charAt(i++);
        if (i <= text.length) setTimeout(tick, speed);
        else resolve();
      };
      tick();
    });

  let activeKey = null;

function setPromptForActiveField(key){
  activeKey = key;

  const full = typedEl.textContent;

  // Quitamos cualquier bloque anterior de campos
  const cut = full.replace(/\nNAME:.*\nEMAIL:.*\nMESSAGE:.*$/s, "");

  const block =
    "\nNAME: " + (inputs.name.value || "") +
    "\nEMAIL: " + (inputs.email.value || "") +
    "\nMESSAGE: " + (inputs.message.value || "");

  typedEl.textContent = cut + block;

  const screen = document.querySelector(".screen");
  screen.scrollTop = screen.scrollHeight;
}

  // Actualiza la “línea” con lo que el usuario va escribiendo
  Object.entries(inputs).forEach(([key, el]) => {
    el.addEventListener("focus", () => setPromptForActiveField(key));
    el.addEventListener("input", () => {
      if(activeKey === key) setPromptForActiveField(key);
    });
  });

  // Ejecuta la animación inicial
  (async function run() {
    // Evita que el usuario escriba durante el boot (opcional)
    Object.values(inputs).forEach(el => el.disabled = true);

    for (const step of script) {
      await typeText(step.text, step.delay ?? 22);
      if (step.focus) {
        // habilita el campo y enfoca
        Object.values(inputs).forEach(el => el.disabled = false);
        inputs[step.focus].focus();
        setPromptForActiveField(step.focus);
      }
    }

    // al final, deja todo habilitado
    Object.values(inputs).forEach(el => el.disabled = false);
  })();
})();