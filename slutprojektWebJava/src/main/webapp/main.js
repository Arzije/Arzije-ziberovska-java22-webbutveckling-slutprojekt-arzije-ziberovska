
const cookieContainer = document.querySelector(".cookie-container");
const acceptcookieBtn = document.querySelector(".button-accept");
const cancelcookieBtn = document.querySelector(".button-reject");
const isCookieAccepted = getCookie("accept");

cancelcookieBtn.addEventListener("click", () => {
	cookieContainer.classList.remove("active")
});

acceptcookieBtn.addEventListener("click", () => {
	cookieContainer.classList.remove("active");	
	document.cookie = "accept= ";
});
	
function getCookie (cName) {
	const name = cName + "=";
	const cDecoded = decodeURIComponent(document.cookie);
	const cArray = cDecoded.split("; ");
	let value;
	
	cArray.forEach(val =>{
		if(val.indexOf(name)===0)value = val.substring(name.length);
	})
	return value;
};

setTimeout(() => {
	cookieContainer.classList.add("active");
}, 1000);