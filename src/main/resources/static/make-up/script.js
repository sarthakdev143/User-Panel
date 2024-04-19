// Switch Light Mode And Dark Mode
const icon = document.querySelector(".icons");
const sun = document.querySelector(".sun");
const moon = document.querySelector(".moon");
var root = document.documentElement;

let darkMode = false;

icon.addEventListener("click", () => {
    if (darkMode == false) {
        darkMode = true;
        sun.style.display = "none";
        moon.style.display = "block";
        root.style.setProperty('--darkBg', '#fff');
        root.style.setProperty('--background-color2', '#f5f5f5');
        root.style.setProperty('--body-text-color', '#000');
        root.style.setProperty('--darkBg2', '#ddd');
    } else {
        darkMode = false;
        sun.style.display = "block";
        moon.style.display = "none";
        root.style.setProperty('--darkBg', '#121212');
        root.style.setProperty('--background-color2', '#222222');
        root.style.setProperty('--body-text-color', '#f5f5f5');
        root.style.setProperty('--darkBg2', '#2D2D2D');
    }
})

// Edit Profile Section
const profileEditingPanel = document.querySelector("#profile-editing-ui-div");
function showProfileEditingPanel() {
    profileEditingPanel.style.transform = "translate(-50%, -50%)";
    profileEditingPanel.style.width = "80%";
    profileEditingPanel.style.height = "90%";
    profileEditingPanel.style.opacity = 1;
}

function hideProfileEditingPanel() {
    profileEditingPanel.style.transform = "translate(-50%, 70%)";
    profileEditingPanel.style.width = "70%";
    profileEditingPanel.style.height = "80%";
    profileEditingPanel.style.opacity = 0;
}

