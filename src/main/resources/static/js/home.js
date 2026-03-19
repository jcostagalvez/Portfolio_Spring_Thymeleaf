const scene = document.querySelector(".threedcontainer");
const photo = document.querySelector(".imagen");


scene.addEventListener("mousemove", (e) => {
    const rect = scene.getBoundingClientRect();
    const x = (e.clientX - rect.left) / rect.width;
    const y = (e.clientY - rect.top) / rect.height;
    const offsety = (x - 0.5) * 3;
    const offsetx = (y - 0.5) * 6;
    photo.style.transform = `perspective(40px) rotatey(${offsety}deg)`;
});

